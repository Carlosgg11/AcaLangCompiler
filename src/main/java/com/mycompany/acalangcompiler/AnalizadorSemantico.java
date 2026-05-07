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
            System.err.println("Error Semantico: Intentas usar '" + nombreVar + "' pero no ha sido declarada.");
        }
        return super.visitAsignacion(ctx);
    }
    
    @Override
    public Object visitSiCondicional(AcaLangParser.SiCondicionalContext ctx) {
        System.out.println("Semantico: Analizando estructura SI...");
    
        // Verificamos si existe el bloque 'sino' (es el segundo bloque de 'programa' en la regla)
        if (ctx.programa().size() > 1) {
            System.out.println("Semantico: Se detecto un bloque SINO asociado.");
        }
    
        return super.visitSiCondicional(ctx);
    }
    
    // --- 1. EVALUAR TIPOS BÁSICOS ---
    @Override
    public String visitEntero(AcaLangParser.EnteroContext ctx) { return "ent"; }

    @Override
    public String visitCadena(AcaLangParser.CadenaContext ctx) { return "cad"; }

    @Override
    public String visitDecimal(AcaLangParser.DecimalContext ctx) { return "dec"; }

    @Override
    public String visitBooleano(AcaLangParser.BooleanoContext ctx) { return "bol"; }

    // --- 2. EVALUAR VARIABLES ---
    @Override
    public String visitVariable(AcaLangParser.VariableContext ctx) {
        String nombreVar = ctx.ID().getText();
        if (!tablaSimbolos.containsKey(nombreVar)) {
            System.err.println("Error Semantico: Variable '" + nombreVar + "' no declarada.");
            return "error"; 
        }
        return tablaSimbolos.get(nombreVar); 
    }

    // --- 3. VALIDAR LA DECLARACIÓN ---
    @Override
    public Object visitDeclaracion(AcaLangParser.DeclaracionContext ctx) {
        String nombreVar = ctx.ID().getText();
        String tipoDeclarado = ctx.tipo().getText();

        if (!tablaSimbolos.containsKey(nombreVar)) {
            tablaSimbolos.put(nombreVar, tipoDeclarado);
        } else {
            System.err.println("Error Semantico: La variable '" + nombreVar + "' ya existe.");
        }

        if (ctx.expresion() != null) {
            String tipoExpresion = (String) visit(ctx.expresion());
            
            if (tipoExpresion.equals("error")) {
                // Silencio, ya se reportó el error abajo
            } else if (!tipoDeclarado.equals(tipoExpresion)) {
                System.err.println("Error de Tipo: No puedes asignar un valor '" + tipoExpresion + 
                                   "' a la variable '" + nombreVar + "' que es de tipo '" + tipoDeclarado + "'.");
            } else {
                System.out.println("Semantico: Asignacion correcta para '" + nombreVar + "' (" + tipoDeclarado + ").");
            }
        }
        return null;
    }
    
    // --- 4. VALIDAR SUMA (Lógica corregida para Semántico) ---
    @Override
    public String visitSuma(AcaLangParser.SumaContext ctx) {
        String izq = (String) visit(ctx.expresion(0));
        String der = (String) visit(ctx.expresion(1));
        String op = ctx.getChild(1).getText();

        if (izq.equals("error") || der.equals("error")) return "error";

        // 1. Regla de Cadenas
        if (izq.equals("cad") || der.equals("cad")) {
            if (op.equals("+")) return "cad";
            else {
                System.err.println("Error de Tipo: No puedes usar '" + op + "' con una cadena.");
                return "error";
            }
        }

        // 2. Regla de Decimales
        if (izq.equals("dec") || der.equals("dec")) {
             return "dec";
        }

        // 3. Regla de Enteros
        if (izq.equals("ent") && der.equals("ent")) {
             return "ent";
        }

        System.err.println("Error de Tipo: Operacion invalida entre '" + izq + "' y '" + der + "'.");
        return "error";
    }
    
    // --- 5. VALIDAR MULTIPLICACIÓN (Lógica mejorada) ---
    @Override
    public String visitMultiplicacion(AcaLangParser.MultiplicacionContext ctx) {
        String tipoIzq = (String) visit(ctx.expresion(0));
        String tipoDer = (String) visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        // Si son números, la operación es válida (si hay algún decimal, resulta en decimal)
        if ((tipoIzq.equals("ent") || tipoIzq.equals("dec")) && 
            (tipoDer.equals("ent") || tipoDer.equals("dec"))) {
            
            if (tipoIzq.equals("dec") || tipoDer.equals("dec")) {
                return "dec";
            }
            return "ent";
        }

        System.err.println("Error de Tipo: No puedes usar el operador '" + operador + 
                           "' entre un '" + tipoIzq + "' y un '" + tipoDer + "'.");
        return "error";
    }
    
    @Override
    public String visitComparacion(AcaLangParser.ComparacionContext ctx) {
        String tipoIzq = (String) visit(ctx.expresion(0));
        String tipoDer = (String) visit(ctx.expresion(1));

        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        // Permitimos comparar enteros con decimales
        boolean ambosNumeros = (tipoIzq.equals("ent") || tipoIzq.equals("dec")) && 
                               (tipoDer.equals("ent") || tipoDer.equals("dec"));

        if (!tipoIzq.equals(tipoDer) && !ambosNumeros) {
            System.err.println("Error de Logica: No puedes comparar un '" + tipoIzq + "' con un '" + tipoDer + "'.");
            return "error";
        }
        
        return "bol";
    }
    
    @Override
    public Object visitMientras(AcaLangParser.MientrasContext ctx) {
        String tipoCondicion = (String) visit(ctx.expresion());

        if (tipoCondicion.equals("error")) return "error";

        if (!tipoCondicion.equals("bol")) {
            System.err.println("Error de Logica: La condición del ciclo 'mientras' debe ser un 'bol', pero recibi un '" + tipoCondicion + "'.");
            return "error";
        }

        visit(ctx.programa());
        return null;
    }
}