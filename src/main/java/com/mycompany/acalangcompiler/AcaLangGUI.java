/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acalangcompiler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

// Librerías para el editor con colores
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class AcaLangGUI extends JFrame {

    private RSyntaxTextArea txtCodigo;      // Editor con Syntax Highlighting
    private JTextPane txtConsola;           // Consola multiculor
    private DefaultTableModel modelTokens;   
    private DefaultTableModel modelSimbolos; 

    public AcaLangGUI() {
        setTitle("AcaLang IDE Professional - Compilador Visual");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- 1. BARRA DE HERRAMIENTAS ---
        JToolBar toolbar = new JToolBar();
        JButton btnRun = new JButton("EJECUTAR CÓDIGO");
        btnRun.setFont(new Font("Arial", Font.BOLD, 12));
        toolbar.add(btnRun);
        add(toolbar, BorderLayout.NORTH);

        // --- 2. PANEL IZQUIERDO (Editor y Consola) ---
        // Inicializamos el editor profesional
        txtCodigo = new RSyntaxTextArea();
        txtCodigo.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // Estilo similar a Java
        txtCodigo.setCodeFoldingEnabled(true);
        txtCodigo.setAntiAliasingEnabled(true);
        txtCodigo.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        RTextScrollPane scrollCodigo = new RTextScrollPane(txtCodigo);
        scrollCodigo.setBorder(BorderFactory.createTitledBorder("Editor de Código AcaLang"));

        txtConsola = new JTextPane();
        txtConsola.setEditable(false);
        txtConsola.setBackground(new Color(20, 20, 20)); 
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollConsola = new JScrollPane(txtConsola);
        scrollConsola.setBorder(BorderFactory.createTitledBorder("Consola de Salida"));

        JSplitPane splitIzquierdo = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollCodigo, scrollConsola);
        splitIzquierdo.setDividerLocation(400);

        // --- 3. PANEL DERECHO (Tablas) ---
        String[] colTokens = {"#", "Tipo de Token", "Valor Texto", "Línea", "Col."};
        modelTokens = new DefaultTableModel(colTokens, 0);
        JTable tblTokens = new JTable(modelTokens);
        JScrollPane scrollTokens = new JScrollPane(tblTokens);
        scrollTokens.setBorder(BorderFactory.createTitledBorder("1. Analizador Léxico (Tokens)"));

        String[] colSimbolos = {"Variable (ID)", "Valor Final"};
        modelSimbolos = new DefaultTableModel(colSimbolos, 0);
        JTable tblSimbolos = new JTable(modelSimbolos);
        JScrollPane scrollSimbolos = new JScrollPane(tblSimbolos);
        scrollSimbolos.setBorder(BorderFactory.createTitledBorder("2. Tabla de Símbolos (Memoria)"));

        JSplitPane splitTablasDerecha = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollTokens, scrollSimbolos);
        splitTablasDerecha.setDividerLocation(300);

        JSplitPane splitPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitIzquierdo, splitTablasDerecha);
        splitPrincipal.setDividerLocation(550);
        add(splitPrincipal, BorderLayout.CENTER);

        // --- INTERACTIVIDAD: Clic en tabla resalta código ---
        tblTokens.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblTokens.getSelectedRow() != -1) {
                try {
                    int fila = tblTokens.getSelectedRow();
                    int linea = (int) modelTokens.getValueAt(fila, 3) - 1;
                    txtCodigo.setCaretPosition(txtCodigo.getLineStartOffset(linea));
                    txtCodigo.requestFocusInWindow();
                } catch (Exception ex) {}
            }
        });

        btnRun.addActionListener(e -> ejecutarCompilador());
    }
    
    // Método para escribir en la consola con colores
    private void escribirConsola(String mensaje, Color color) {
        StyledDocument doc = txtConsola.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, color);
        try {
            doc.insertString(doc.getLength(), mensaje + "\n", style);
        } catch (Exception e) {
            System.err.println("Error al escribir en consola: " + e.getMessage());
        }
    }

    private void ejecutarCompilador() {
        String input = txtCodigo.getText();
        
        // Limpiar
        txtConsola.setText(""); 
        modelTokens.setRowCount(0);
        modelSimbolos.setRowCount(0);
        
        if (input.trim().isEmpty()) {
            escribirConsola("Sistema: Escribe código para procesar.", Color.ORANGE);
            return;
        }

        try {
            // --- FASE 1: LÉXICO ---
            AcaLangLexer lexer = new AcaLangLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            tokens.fill(); 
            int contador = 1;
            for (Token t : tokens.getTokens()) {
                String nombreTipo = AcaLangLexer.VOCABULARY.getSymbolicName(t.getType());
                if (nombreTipo == null) nombreTipo = "LITERAL";
                
                if (t.getType() != Token.EOF) {
                    modelTokens.addRow(new Object[]{
                        contador++, nombreTipo, t.getText(), t.getLine(), t.getCharPositionInLine()
                    });
                }
            }

            // --- FASE 2: SINTÁCTICO ---
            AcaLangParser parser = new AcaLangParser(tokens);
            ParseTree tree = parser.programa();

            // --- FASE 3: SEMÁNTICO ---
            AnalizadorSemantico semantico = new AnalizadorSemantico();
            semantico.visit(tree);

            // --- FASE 4: INTÉRPRETE ---
            Interprete interprete = new Interprete() {
                @Override
                public Object visitImprimir(AcaLangParser.ImprimirContext ctx) {
                    Object valor = visit(ctx.expresion());
                    // USAR EL MÉTODO DE COLOR VERDE AQUÍ
                    escribirConsola(">> " + valor, new Color(50, 255, 50)); 
                    return null;
                }
            };
            
            interprete.limpiarMemoria();
            interprete.visit(tree);

            // Actualizar Tabla Símbolos
            for (Map.Entry<String, Object> entry : interprete.memoria.entrySet()) {
                modelSimbolos.addRow(new Object[]{entry.getKey(), entry.getValue()});
            }

            escribirConsola("\n--- Proceso finalizado con éxito ---", Color.CYAN);

        } catch (Exception ex) {
            escribirConsola("\n❌ ERROR EN COMPILACIÓN/EJECUCIÓN:", Color.RED);
            escribirConsola(ex.getMessage(), Color.WHITE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new AcaLangGUI().setVisible(true);
        });
    }
}