/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acalangcompiler;

import java.util.HashMap;

public class AnalizadorSemantico extends AcaLangBaseVisitor<Object> {
    
    // Nuestra Tabla de Símbolos: guarda (Nombre de variable, Tipo)
    private HashMap<String, String> tablaSimbolos = new HashMap<>();

    // Regla: Cuando el compilador vea una asignación (x = 20;)
    @Override
    public Object visitAsignacion(AcaLangParser.AsignacionContext ctx) {
        String nombreVar = ctx.ID().getText();
        
        if (!tablaSimbolos.containsKey(nombreVar)) {
            System.err.println("Error Semántico: Intentas usar '" + nombreVar + "' pero no ha sido declarada.");
        }
        return super.visitAsignacion(ctx);
    }
    
    @Override
    public Object visitSiCondicional(AcaLangParser.SiCondicionalContext ctx) {
        System.out.println("Semántico: Analizando estructura SI...");
    
        // Verificamos si existe el bloque 'sino' (es el segundo bloque de 'programa' en la regla)
        if (ctx.programa().size() > 1) {
            System.out.println("Semántico: Se detectó un bloque SINO asociado.");
        }
    
        return super.visitSiCondicional(ctx);
    }
    
    // --- 1. EVALUAR TIPOS BÁSICOS ---
    @Override
    public Object visitEntero(AcaLangParser.EnteroContext ctx) { return "ent"; }

    @Override
    public Object visitCadena(AcaLangParser.CadenaContext ctx) { return "cad"; }

    @Override
    public Object visitDecimal(AcaLangParser.DecimalContext ctx) { return "dec"; }

    @Override
    public Object visitBooleano(AcaLangParser.BooleanoContext ctx) { return "bol"; }

    // --- 2. EVALUAR VARIABLES ---
    @Override
    public Object visitVariable(AcaLangParser.VariableContext ctx) {
        String nombreVar = ctx.ID().getText();
        if (!tablaSimbolos.containsKey(nombreVar)) {
            System.err.println("Error Semántico: Variable '" + nombreVar + "' no declarada.");
            return "error"; // Retornamos "error" para evitar que el programa colapse
        }
        // Si existe, retornamos el tipo con el que fue guardada
        return tablaSimbolos.get(nombreVar); 
    }

    // --- 3. VALIDAR LA DECLARACIÓN ---
    @Override
    public Object visitDeclaracion(AcaLangParser.DeclaracionContext ctx) {
        String nombreVar = ctx.ID().getText();
        String tipoDeclarado = ctx.tipo().getText();

        // 1. Guardar en la tabla de símbolos
        if (!tablaSimbolos.containsKey(nombreVar)) {
            tablaSimbolos.put(nombreVar, tipoDeclarado);
        } else {
            System.err.println("Error Semántico: La variable '" + nombreVar + "' ya existe.");
        }

        // 2. Si tiene una asignación (ej. ent x = 10;)
        if (ctx.expresion() != null) {
            String tipoExpresion = (String) visit(ctx.expresion());
            
            if (tipoExpresion.equals("error")) {
                // Si viene un error de la suma/multiplicación, lo ignoramos y NO felicitamos
            } else if (!tipoDeclarado.equals(tipoExpresion)) {
                System.err.println("Error de Tipo: No puedes asignar un valor '" + tipoExpresion + 
                                   "' a la variable '" + nombreVar + "' que es de tipo '" + tipoDeclarado + "'.");
            } else {
                System.out.println("Semántico: Asignación correcta para '" + nombreVar + "' (" + tipoDeclarado + ").");
            }
        }
        return null;
    }
    
    @Override
    public Object visitSuma(AcaLangParser.SumaContext ctx) {
        // Evaluamos el lado izquierdo y el derecho de la operación
        String tipoIzq = (String) visit(ctx.expresion(0));
        String tipoDer = (String) visit(ctx.expresion(1));

        // Si alguno ya dio error antes, cortamos aquí
        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        // Regla: Solo podemos operar enteros con enteros, o decimales con decimales
        if (tipoIzq.equals("ent") && tipoDer.equals("ent")) {
            return "ent";
        } else if (tipoIzq.equals("dec") && tipoDer.equals("dec")) {
            return "dec";
        } else {
            // Extraemos el símbolo exacto que escribió el usuario (+ o -)
            String operador = ctx.getChild(1).getText();
            
            System.err.println("Error de Tipo: No puedes usar el operador '" + operador + 
                               "' entre un '" + tipoIzq + "' y un '" + tipoDer + "'.");
            return "error";
        }
    }
    
    @Override
    public Object visitMultiplicacion(AcaLangParser.MultiplicacionContext ctx) {
        // Evaluamos el lado izquierdo y derecho
        String tipoIzq = (String) visit(ctx.expresion(0));
        String tipoDer = (String) visit(ctx.expresion(1));

        // Si ya hay un error previo, lo dejamos pasar para no saturar la consola
        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        // Reglas: Solo matemática entre los mismos tipos numéricos
        if (tipoIzq.equals("ent") && tipoDer.equals("ent")) {
            return "ent";
        } else if (tipoIzq.equals("dec") && tipoDer.equals("dec")) {
            return "dec";
        } else {
            // ctx.getChild(1) nos da exactamente el símbolo que usó el usuario (* o /)
            String operador = ctx.getChild(1).getText();
            System.err.println("Error de Tipo: No puedes usar el operador '" + operador + 
                               "' entre un '" + tipoIzq + "' y un '" + tipoDer + "'.");
            return "error";
        }
    }
    
    @Override
    public Object visitComparacion(AcaLangParser.ComparacionContext ctx) {
        String tipoIzq = (String) visit(ctx.expresion(0));
        String tipoDer = (String) visit(ctx.expresion(1));

        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        if (!tipoIzq.equals(tipoDer)) {
            System.err.println("Error de Lógica: No puedes comparar un '" + tipoIzq + "' con un '" + tipoDer + "'.");
            return "error";
        }
        
        // Si todo está bien, una comparación siempre devuelve un tipo 'bol' (booleano)
        return "bol";
    }
    
    @Override
    public Object visitMientras(AcaLangParser.MientrasContext ctx) {
        // 1. Evaluamos qué tipo de dato nos da la condición entre los paréntesis
        String tipoCondicion = (String) visit(ctx.expresion());

        // 2. Si hubo un error previo en la expresión, lo dejamos pasar sin hacer más ruido
        if (tipoCondicion.equals("error")) return "error";

        // 3. Validamos que la condición sea estrictamente booleana ('bol')
        if (!tipoCondicion.equals("bol")) {
            System.err.println("Error de Lógica: La condición del ciclo 'mientras' debe ser un 'bol' (booleano), pero recibí un '" + tipoCondicion + "'.");
            return "error";
        }

        // 4. Si la condición está correcta, mandamos a validar todo el código que está dentro de las llaves { }
        visit(ctx.programa());

        return null;
    }
}