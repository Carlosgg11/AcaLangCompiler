/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acalangcompiler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class AcaLangGUI extends JFrame {

    private JTextArea txtCodigo;      // Editor de texto
    private JTextArea txtConsola;     // Consola de salida (negra)
    private DefaultTableModel modelTokens;   // Modelo para el Analizador Léxico
    private DefaultTableModel modelSimbolos; // Modelo para la Tabla de Símbolos

    public AcaLangGUI() {
        // Configuración básica de la ventana
        setTitle("AcaLang IDE Professional - Compilador Visual");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- 1. BARRA DE HERRAMIENTAS ---
        JToolBar toolbar = new JToolBar();
        JButton btnRun = new JButton("▶ Ejecutar Código");
        btnRun.setFont(new Font("Arial", Font.BOLD, 12));
        toolbar.add(btnRun);
        add(toolbar, BorderLayout.NORTH);

        // --- 2. PANEL IZQUIERDO (Editor y Consola) ---
        txtCodigo = new JTextArea();
        txtCodigo.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtCodigo.setTabSize(4);
        JScrollPane scrollCodigo = new JScrollPane(txtCodigo);
        scrollCodigo.setBorder(BorderFactory.createTitledBorder("Editor de Código AcaLang"));

        txtConsola = new JTextArea();
        txtConsola.setEditable(false);
        txtConsola.setBackground(new Color(20, 20, 20)); // Fondo negro oscuro
        txtConsola.setForeground(new Color(50, 255, 50)); // Texto verde neón
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollConsola = new JScrollPane(txtConsola);
        scrollConsola.setBorder(BorderFactory.createTitledBorder("Consola de Salida"));

        JSplitPane splitIzquierdo = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollCodigo, scrollConsola);
        splitIzquierdo.setDividerLocation(400);

        // --- 3. PANEL DERECHO (Análisis Léxico y Memoria) ---
        // Tabla de Tokens (Analizador Léxico)
        String[] colTokens = {"#", "Tipo de Token", "Valor Texto", "Línea", "Col."};
        modelTokens = new DefaultTableModel(colTokens, 0);
        JTable tblTokens = new JTable(modelTokens);
        tblTokens.setEnabled(false); // Solo lectura
        JScrollPane scrollTokens = new JScrollPane(tblTokens);
        scrollTokens.setBorder(BorderFactory.createTitledBorder("1. Analizador Léxico (Tokens Identificados)"));

        // Tabla de Símbolos (Memoria)
        String[] colSimbolos = {"Variable (ID)", "Valor Final en Memoria"};
        modelSimbolos = new DefaultTableModel(colSimbolos, 0);
        JTable tblSimbolos = new JTable(modelSimbolos);
        tblSimbolos.setEnabled(false);
        JScrollPane scrollSimbolos = new JScrollPane(tblSimbolos);
        scrollSimbolos.setBorder(BorderFactory.createTitledBorder("2. Tabla de Símbolos (Estado de Variables)"));

        // Panel que divide las dos tablas a la derecha
        JSplitPane splitTablasDerecha = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollTokens, scrollSimbolos);
        splitTablasDerecha.setDividerLocation(300);

        // --- 4. DIVISOR PRINCIPAL (Izquierda vs Derecha) ---
        JSplitPane splitPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitIzquierdo, splitTablasDerecha);
        splitPrincipal.setDividerLocation(550);
        add(splitPrincipal, BorderLayout.CENTER);

        // --- EVENTO DEL BOTÓN ---
        btnRun.addActionListener(e -> ejecutarCompilador());
    }

    private void ejecutarCompilador() {
        String input = txtCodigo.getText();
        
        // Limpiar todo antes de la nueva ejecución
        txtConsola.setText(""); 
        txtConsola.setForeground(new Color(50, 255, 50)); 
        modelTokens.setRowCount(0);
        modelSimbolos.setRowCount(0);
        
        if (input.trim().isEmpty()) {
            txtConsola.append("Sistema: Por favor, escribe algún código para procesar.");
            return;
        }

        try {
            // --- FASE 1: ANALIZADOR LÉXICO ---
            AcaLangLexer lexer = new AcaLangLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Llenar la tabla de tokens visualmente
            tokens.fill(); 
            int contador = 1;
            for (Token t : tokens.getTokens()) {
                String nombreTipo = AcaLangLexer.VOCABULARY.getSymbolicName(t.getType());
                if (nombreTipo == null) nombreTipo = "TOKEN_TEXTO";
                
                if (t.getType() != Token.EOF) { // No mostrar el final de archivo
                    modelTokens.addRow(new Object[]{
                        contador++, 
                        nombreTipo, 
                        t.getText(), 
                        t.getLine(), 
                        t.getCharPositionInLine()
                    });
                }
            }

            // --- FASE 2: ANALIZADOR SINTÁCTICO ---
            AcaLangParser parser = new AcaLangParser(tokens);
            ParseTree tree = parser.programa();

            // --- FASE 3: ANALIZADOR SEMÁNTICO (Validaciones) ---
            AnalizadorSemantico semantico = new AnalizadorSemantico();
            semantico.visit(tree);

            // --- FASE 4: INTÉRPRETE (Ejecución) ---
            Interprete interprete = new Interprete() {
                // Redirigimos imprimir() de la consola de Java a nuestra JTextArea
                @Override
                public Object visitImprimir(AcaLangParser.ImprimirContext ctx) {
                    Object valor = visit(ctx.expresion());
                    txtConsola.append(">> " + valor + "\n");
                    return null;
                }
            };
            
            interprete.limpiarMemoria();
            interprete.visit(tree);

            // --- ACTUALIZAR TABLA DE SÍMBOLOS ---
            for (Map.Entry<String, Object> entry : interprete.memoria.entrySet()) {
                modelSimbolos.addRow(new Object[]{entry.getKey(), entry.getValue()});
            }

            txtConsola.append("\n--- Proceso finalizado con éxito ---");

        } catch (Exception ex) {
            txtConsola.setForeground(Color.RED);
            txtConsola.append("\n❌ ERROR EN COMPILACIÓN/EJECUCIÓN:\n" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Intentar poner el estilo visual del sistema (Windows/Mac)
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new AcaLangGUI().setVisible(true);
        });
    }
}