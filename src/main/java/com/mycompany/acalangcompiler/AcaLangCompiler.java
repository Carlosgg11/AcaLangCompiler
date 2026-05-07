/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.acalangcompiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class AcaLangCompiler {
    public static void main(String[] args) {
        try {
            
            String input = "imprimir(10 > 5); " +
               "imprimir(10 == 10); " +
               "imprimir(20 < 5); " +
               "imprimir(15.5 >= 15.0);";

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
