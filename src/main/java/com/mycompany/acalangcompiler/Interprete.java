/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acalangcompiler;

import java.util.HashMap;

public class Interprete extends AcaLangBaseVisitor<Object> {
    
    // Esta será nuestra "Memoria RAM". Aquí guardaremos el VALOR real de cada variable.
    private HashMap<String, Object> memoria = new HashMap<>();

    // 1. Cuando declaramos o asignamos variables
    @Override
    public Object visitDeclaracion(AcaLangParser.DeclaracionContext ctx) {
        String nombreVar = ctx.ID().getText();
        if (ctx.expresion() != null) {
            // Evaluamos la expresión para obtener el valor real y lo guardamos
            Object valor = visit(ctx.expresion());
            memoria.put(nombreVar, valor);
        }
        return null;
    }

    // 2. La instrucción 'imprimir'
    @Override
    public Object visitImprimir(AcaLangParser.ImprimirContext ctx) {
        Object valor = visit(ctx.expresion());
        // Imprimimos el resultado con un prefijo para distinguirlo
        System.out.println(">> " + valor); 
        return null;
    }

    // 3. Evaluar Literales y Variables
    @Override
    public Object visitEntero(AcaLangParser.EnteroContext ctx) {
        // Convertimos el texto a un número entero real de Java
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitVariable(AcaLangParser.VariableContext ctx) {
        // Buscamos el valor en nuestra memoria
        return memoria.get(ctx.getText());
    }

    // 4. Evaluar Matemáticas (Suma y Resta de Enteros)
    @Override
    public Object visitSuma(AcaLangParser.SumaContext ctx) {
        Object izq = visit(ctx.expresion(0));
        Object der = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();

        // Como el semántico ya validó que son compatibles, calculamos con confianza
        if (izq instanceof Integer && der instanceof Integer) {
            if (operador.equals("+")) return (Integer) izq + (Integer) der;
            if (operador.equals("-")) return (Integer) izq - (Integer) der;
        }
        return 0; 
    }
}
