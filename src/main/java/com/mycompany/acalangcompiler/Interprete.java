/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acalangcompiler;

import java.util.HashMap;

public class Interprete extends AcaLangBaseVisitor<Object> {
    
    // Nuestra Memoria RAM virtual
    public HashMap<String, Object> memoria = new HashMap<>();
    
    // Msource AnalizadorAcaLangCompiétodo para limpiar la memoria antes de cada "Play"
    public void limpiarMemoria() {
        memoria.clear();
    }
    
    // Uso de parentesis
    @Override
    public Object visitParentesis(AcaLangParser.ParentesisContext ctx) {
        // IMPORTANTE: visitamos la expresión que está ENTRE los paréntesis
        return visit(ctx.expresion()); 
    }

    // Declaración y Asignación
    @Override
    public Object visitDeclaracion(AcaLangParser.DeclaracionContext ctx) {
        String nombreVar = ctx.ID().getText();
        if (ctx.expresion() != null) {
            Object valor = visit(ctx.expresion());
            memoria.put(nombreVar, valor);
        }
        return null;
    }
    
    // Asignación de variables (Actualizar valores)
   @Override
    public Object visitAsignacion(AcaLangParser.AsignacionContext ctx) {
        String nombreVar = ctx.ID().getText();
    
        // 1. Verificar si la variable existe en memoria antes de asignar
        if (!memoria.containsKey(nombreVar)) {
            throw new RuntimeException("ERROR SEMANTICO: La variable '" + nombreVar + "' no ha sido declarada.");
        }

        Object nuevoValor = visit(ctx.expresion());
        Object valorAnterior = memoria.get(nombreVar);

        // 2. Validación de tipos (Opcional, pero recomendada para ver el ROJO)
        // Si la variable ya tenía un número y ahora le quieres meter un String (como en tu prueba)
        if (valorAnterior instanceof Number && nuevoValor instanceof String) {
            throw new RuntimeException("ERROR DE TIPOS: No se puede asignar una CADENA a la variable numerica '" + nombreVar + "'.");
        }

        memoria.put(nombreVar, nuevoValor); 
        return null;
    }

    // Instrucción imprimir
    @Override
    public Object visitImprimir(AcaLangParser.ImprimirContext ctx) {
        Object valor = visit(ctx.expresion());
        System.out.println(">> " + valor); 
        return null;
    }

    // 3. Literales (Enteros, Decimales y Cadenas)
    @Override
    public Object visitEntero(AcaLangParser.EnteroContext ctx) {
        return Integer.parseInt(ctx.getText());
    }
    
    @Override
    public Object visitDecimal(AcaLangParser.DecimalContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    @Override
    public Object visitCadena(AcaLangParser.CadenaContext ctx) {
        String texto = ctx.getText();
        // Quitamos las comillas iniciales y finales: "Hola" -> Hola
        return texto.substring(1, texto.length() - 1);
    }

    @Override
    public Object visitVariable(AcaLangParser.VariableContext ctx) {
        String nombreVar = ctx.ID().getText();
    
        // Si la variable existe en nuestra "RAM" (HashMap)
        if (memoria.containsKey(nombreVar)) {
            return memoria.get(nombreVar);
        }
    
        // ¡Aquí está la magia del rojo! 
        // En lugar de retornar 0, lanzamos un error que detiene todo.
        throw new RuntimeException("ERROR SEMANTICO: La variable '" + nombreVar + "' no ha sido definida.");
    }

    // Matemáticas: Suma y Resta (Soporta Decimales y Textos)
    @Override
    public Object visitSuma(AcaLangParser.SumaContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
    
        // Protección: Si algo falló arriba y llega nulo, lanzamos el error en ROJO
        if (izq == null || der == null) {
            throw new RuntimeException("ERROR: Se intentó operar con un valor nulo. Revisa los paréntesis o variables.");
        }

        String operador = ctx.getChild(1).getText();

        // REGLA 1: Operaciones Numéricas
        if (izq instanceof Number && der instanceof Number) {
            double n1 = ((Number) izq).doubleValue();
            double n2 = ((Number) der).doubleValue();
            double res = operador.equals("+") ? n1 + n2 : n1 - n2;
            return (res % 1 == 0) ? (int) res : res;
        }

        // REGLA 2: Concatenación Universal (Maneja Cadenas, Booleanos, etc.)
        if (operador.equals("+")) {
            // String.valueOf convierte automáticamente true -> "true", 10 -> "10", etc.
            return String.valueOf(izq) + String.valueOf(der);
        }

        // Si intenta restar un texto o booleano, lanzamos error
        throw new RuntimeException("ERROR: No se puede realizar la operación '" + operador + "' con estos tipos de datos.");
    }
    
    @Override
    public Object visitMultiplicacion(AcaLangParser.MultiplicacionContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
    
        if (izq == null || der == null) {
            throw new RuntimeException("ERROR: Operación matemática con valor nulo.");
        }

        String operador = ctx.getChild(1).getText();

        if (izq instanceof Number && der instanceof Number) {
            double n1 = ((Number) izq).doubleValue();
            double n2 = ((Number) der).doubleValue();

            // Validación extra: División por cero
            if (operador.equals("/") && n2 == 0) {
                throw new RuntimeException("ERROR: División por cero.");
            }

            double res = operador.equals("*") ? n1 * n2 : n1 / n2;
            return (res % 1 == 0) ? (int) res : res;
        }
    
        throw new RuntimeException("ERROR: Solo se pueden multiplicar o dividir números.");
    }
    
    // 6. Operadores Relacionales (Comparaciones)
    @Override
    public Object visitComparacion(AcaLangParser.ComparacionContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
        
        // --- PROTECCIÓN ANTI-NULL ---
        if (izq == null || der == null) {
            String parteFaltante = (izq == null) ? "izquierda" : "derecha";
            throw new RuntimeException("ERROR: El valor de la " + parteFaltante + " en la comparación es nulo. ¿Faltará el método visitParentesis?");
        }

        String operador = ctx.op.getText();

        if (izq instanceof Number && der instanceof Number) {
            double n1 = ((Number) izq).doubleValue();
            double n2 = ((Number) der).doubleValue();

            switch (operador) {
                case ">":  return n1 > n2;
                case "<":  return n1 < n2;
                case ">=": return n1 >= n2;
                case "<=": return n1 <= n2;
                case "==": return n1 == n2;
                case "!=": return n1 != n2;
            }
        }

        // Comparación para cadenas o booleanos
        if (operador.equals("==")) return izq.equals(der);
        if (operador.equals("!=")) return !izq.equals(der);

        return false;
    }
    
    //Condicional SI / SINO
    @Override
    public Object visitSiCondicional(AcaLangParser.SiCondicionalContext ctx) {
        // 1. Evaluamos la condición (nos devolverá un true o false gracias a visitComparacion)
        Object condicion = visit(ctx.expresion());

        // 2. Comprobamos si la condición es verdadera
        if (condicion instanceof Boolean && (Boolean) condicion) {
            // Si es true, ejecutamos todo lo que está en el primer bloque { }
            visit(ctx.programa(0));
        } else {
            // Si es false, verificamos si el usuario escribió un 'sino'
            // (Si hay más de un bloque 'programa', significa que sí hay un 'sino')
            if (ctx.programa().size() > 1) {
                // Ejecutamos todo lo que está en el segundo bloque { }
                visit(ctx.programa(1));
            }
        }
        
        return null;
    }
    
    //Ciclo MIENTRAS
    @Override
    public Object visitMientras(AcaLangParser.MientrasContext ctx) {
        // Un ciclo 'mientras' se repite continuamente evaluando la condición
        while (true) {
            // Evaluamos la condición en CADA iteración
            Object condicion = visit(ctx.expresion());
            
            // Si la condición es false (o no es booleana), rompemos el ciclo para que no sea infinito
            if (!(condicion instanceof Boolean) || !(Boolean) condicion) {
                break;
            }
            
            // Si la condición fue true, ejecutamos todo el bloque de código { }
            visit(ctx.programa());
        }
        
        return null;
    }
}
