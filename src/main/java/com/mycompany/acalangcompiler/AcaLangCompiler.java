/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.acalangcompiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class AcaLangCompiler {
    public static void main(String[] args) {
        try {
            
            String input = "ent nota = 85; " +
               "si (nota >= 61) { " +
               "    imprimir(\"Felicidades, aprobaste el curso\"); " +
               "} sino { " +
               "    imprimir(\"Lo siento, debes repetir\"); " +
               "} " +
               "ent otraNota = 50; " +
               "si (otraNota >= 61) { " +
               "    imprimir(\"Felicidades, aprobaste el curso\"); " +
               "} sino { " +
               "    imprimir(\"Lo siento, debes repetir\"); " +
               "}";

            System.out.println("--- Iniciando Compilación ---");

            // 1. Fase Léxica y Sintáctica
            AcaLangLexer lexer = new AcaLangLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AcaLangParser parser = new AcaLangParser(tokens);
            ParseTree tree = parser.programa();

            // 2. Fase Semántica (El guardia de seguridad)
            AnalizadorSemantico semantico = new AnalizadorSemantico();
            semantico.visit(tree);

            System.out.println("--- Ejecutando Programa ---");

            // 3. Fase de Interpretación (El cerebro que ejecuta)
            Interprete interprete = new Interprete();
            interprete.visit(tree);

            System.out.println("--- Proceso finalizado con éxito ---");

        } catch (Exception e) {
            System.err.println("Error en el compilador: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
