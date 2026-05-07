// Generated from com/mycompany/acalangcompiler/AcaLang.g4 by ANTLR 4.13.1
package com.mycompany.acalangcompiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AcaLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AcaLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AcaLangParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(AcaLangParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link AcaLangParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(AcaLangParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AcaLangParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(AcaLangParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Asignacion}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(AcaLangParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Imprimir}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImprimir(AcaLangParser.ImprimirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SiCondicional}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiCondicional(AcaLangParser.SiCondicionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mientras}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMientras(AcaLangParser.MientrasContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Suma}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuma(AcaLangParser.SumaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparacion}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(AcaLangParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(AcaLangParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(AcaLangParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Entero}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntero(AcaLangParser.EnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentesis}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesis(AcaLangParser.ParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cadena}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCadena(AcaLangParser.CadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Booleano}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleano(AcaLangParser.BooleanoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplicacion}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicacion(AcaLangParser.MultiplicacionContext ctx);
}