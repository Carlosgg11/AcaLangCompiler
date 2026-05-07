// Generated from com/mycompany/acalangcompiler/AcaLang.g4 by ANTLR 4.13.1
package com.mycompany.acalangcompiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AcaLangParser}.
 */
public interface AcaLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AcaLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(AcaLangParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link AcaLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(AcaLangParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link AcaLangParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(AcaLangParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AcaLangParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(AcaLangParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AcaLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(AcaLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link AcaLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(AcaLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Asignacion}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(AcaLangParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Asignacion}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(AcaLangParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Imprimir}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterImprimir(AcaLangParser.ImprimirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Imprimir}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitImprimir(AcaLangParser.ImprimirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SiCondicional}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterSiCondicional(AcaLangParser.SiCondicionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SiCondicional}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitSiCondicional(AcaLangParser.SiCondicionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mientras}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterMientras(AcaLangParser.MientrasContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mientras}
	 * labeled alternative in {@link AcaLangParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitMientras(AcaLangParser.MientrasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Suma}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterSuma(AcaLangParser.SumaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Suma}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitSuma(AcaLangParser.SumaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparacion}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(AcaLangParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparacion}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(AcaLangParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterVariable(AcaLangParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitVariable(AcaLangParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(AcaLangParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(AcaLangParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Entero}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEntero(AcaLangParser.EnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Entero}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEntero(AcaLangParser.EnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentesis}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterParentesis(AcaLangParser.ParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentesis}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitParentesis(AcaLangParser.ParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cadena}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterCadena(AcaLangParser.CadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cadena}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitCadena(AcaLangParser.CadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Booleano}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(AcaLangParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Booleano}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(AcaLangParser.BooleanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplicacion}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicacion(AcaLangParser.MultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplicacion}
	 * labeled alternative in {@link AcaLangParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicacion(AcaLangParser.MultiplicacionContext ctx);
}