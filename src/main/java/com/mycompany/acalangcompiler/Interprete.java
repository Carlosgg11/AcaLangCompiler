/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acalangcompiler;

import java.util.HashMap;

public class Interprete extends AcaLangBaseVisitor<Object> {
    
    // Nuestra Memoria RAM virtual
    private HashMap<String, Object> memoria = new HashMap<>();

    // 1. Declaración y Asignación
    @Override
    public Object visitDeclaracion(AcaLangParser.DeclaracionContext ctx) {
        String nombreVar = ctx.ID().getText();
        if (ctx.expresion() != null) {
            Object valor = visit(ctx.expresion());
            memoria.put(nombreVar, valor);
        }
        return null;
    }

    // 2. Instrucción imprimir
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
        if (memoria.containsKey(nombreVar)) {
            return memoria.get(nombreVar);
        }
        return 0; // Valor por defecto si no existe
    }

    // 4. Matemáticas: Suma y Resta (Soporta Decimales y Textos)
    @Override
    public Object visitSuma(AcaLangParser.SumaContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        // REGLA 1: Si alguno es String, concatenamos textos
        if (izq instanceof String || der instanceof String) {
            if (operador.equals("+")) {
                return String.valueOf(izq) + String.valueOf(der);
            }
        }

        // REGLA 2: Si ambos son números (Enteros o Decimales)
        if (izq instanceof Number && der instanceof Number) {
            double n1 = ((Number) izq).doubleValue();
            double n2 = ((Number) der).doubleValue();

            double res = operador.equals("+") ? n1 + n2 : n1 - n2;

            // Si el resultado no tiene decimales (ej. 20.0), lo devolvemos como entero
            return (res % 1 == 0) ? (int) res : res;
        }

        return 0; 
    }

    // 5. Matemáticas: Multiplicación y División
    @Override
    public Object visitMultiplicacion(AcaLangParser.MultiplicacionContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        if (izq instanceof Number && der instanceof Number) {
            double n1 = ((Number) izq).doubleValue();
            double n2 = ((Number) der).doubleValue();

            double res = operador.equals("*") ? n1 * n2 : n1 / n2;

            return (res % 1 == 0) ? (int) res : res;
        }
        return 0;
    }
    
    // 6. Operadores Relacionales (Comparaciones)
    @Override
    public Object visitComparacion(AcaLangParser.ComparacionContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        // 1. Si estamos comparando números (Enteros o Decimales)
        if (izq instanceof Number && der instanceof Number) {
            double n1 = ((Number) izq).doubleValue();
            double n2 = ((Number) der).doubleValue();

            switch (operador) {
                case ">": return n1 > n2;
                case "<": return n1 < n2;
                case ">=": return n1 >= n2;
                case "<=": return n1 <= n2;
                case "==": return n1 == n2;
                case "!=": return n1 != n2;
            }
        }

        // 2. Si estamos comparando textos u otras cosas (Solo soportan == y !=)
        if (operador.equals("==")) {
            return izq.equals(der);
        }
        if (operador.equals("!=")) {
            return !izq.equals(der);
        }

        return false;
    }
    
    // 7. Condicional SI / SINO
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
}
