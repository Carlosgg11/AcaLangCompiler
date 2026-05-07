// Generated from com/mycompany/acalangcompiler/AcaLang.g4 by ANTLR 4.13.1
package com.mycompany.acalangcompiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AcaLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, IGUAL=9, 
		PUNTO_COMA=10, SUMA=11, RESTA=12, MULT=13, DIV=14, PAREN_ABRE=15, PAREN_CIERRA=16, 
		IGUAL_IGUAL=17, LLAVE_ABRE=18, LLAVE_CIERRA=19, LIT_ENT=20, LIT_DEC=21, 
		LIT_CAD=22, LIT_BOL=23, ID=24, WS=25;
	public static final int
		RULE_programa = 0, RULE_declaracion = 1, RULE_tipo = 2, RULE_instruccion = 3, 
		RULE_expresion = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracion", "tipo", "instruccion", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ent'", "'dec'", "'bol'", "'cad'", "'imprimir'", "'si'", "'sino'", 
			"'mientras'", "'='", "';'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
			"'=='", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "IGUAL", "PUNTO_COMA", 
			"SUMA", "RESTA", "MULT", "DIV", "PAREN_ABRE", "PAREN_CIERRA", "IGUAL_IGUAL", 
			"LLAVE_ABRE", "LLAVE_CIERRA", "LIT_ENT", "LIT_DEC", "LIT_CAD", "LIT_BOL", 
			"ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AcaLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AcaLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(12);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__2:
				case T__3:
					{
					setState(10);
					declaracion();
					}
					break;
				case T__4:
				case T__5:
				case T__7:
				case ID:
					{
					setState(11);
					instruccion();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 16777598L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(AcaLangParser.ID, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(AcaLangParser.PUNTO_COMA, 0); }
		public TerminalNode IGUAL() { return getToken(AcaLangParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			tipo();
			setState(17);
			match(ID);
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(18);
				match(IGUAL);
				setState(19);
				expresion(0);
				}
			}

			setState(22);
			match(PUNTO_COMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	 
		public InstruccionContext() { }
		public void copyFrom(InstruccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImprimirContext extends InstruccionContext {
		public TerminalNode PAREN_ABRE() { return getToken(AcaLangParser.PAREN_ABRE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_CIERRA() { return getToken(AcaLangParser.PAREN_CIERRA, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(AcaLangParser.PUNTO_COMA, 0); }
		public ImprimirContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterImprimir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitImprimir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitImprimir(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SiCondicionalContext extends InstruccionContext {
		public TerminalNode PAREN_ABRE() { return getToken(AcaLangParser.PAREN_ABRE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_CIERRA() { return getToken(AcaLangParser.PAREN_CIERRA, 0); }
		public List<TerminalNode> LLAVE_ABRE() { return getTokens(AcaLangParser.LLAVE_ABRE); }
		public TerminalNode LLAVE_ABRE(int i) {
			return getToken(AcaLangParser.LLAVE_ABRE, i);
		}
		public List<ProgramaContext> programa() {
			return getRuleContexts(ProgramaContext.class);
		}
		public ProgramaContext programa(int i) {
			return getRuleContext(ProgramaContext.class,i);
		}
		public List<TerminalNode> LLAVE_CIERRA() { return getTokens(AcaLangParser.LLAVE_CIERRA); }
		public TerminalNode LLAVE_CIERRA(int i) {
			return getToken(AcaLangParser.LLAVE_CIERRA, i);
		}
		public SiCondicionalContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterSiCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitSiCondicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitSiCondicional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends InstruccionContext {
		public TerminalNode ID() { return getToken(AcaLangParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(AcaLangParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(AcaLangParser.PUNTO_COMA, 0); }
		public AsignacionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MientrasContext extends InstruccionContext {
		public TerminalNode PAREN_ABRE() { return getToken(AcaLangParser.PAREN_ABRE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_CIERRA() { return getToken(AcaLangParser.PAREN_CIERRA, 0); }
		public TerminalNode LLAVE_ABRE() { return getToken(AcaLangParser.LLAVE_ABRE, 0); }
		public ProgramaContext programa() {
			return getRuleContext(ProgramaContext.class,0);
		}
		public TerminalNode LLAVE_CIERRA() { return getToken(AcaLangParser.LLAVE_CIERRA, 0); }
		public MientrasContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterMientras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitMientras(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitMientras(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruccion);
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(ID);
				setState(27);
				match(IGUAL);
				setState(28);
				expresion(0);
				setState(29);
				match(PUNTO_COMA);
				}
				break;
			case T__4:
				_localctx = new ImprimirContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__4);
				setState(32);
				match(PAREN_ABRE);
				setState(33);
				expresion(0);
				setState(34);
				match(PAREN_CIERRA);
				setState(35);
				match(PUNTO_COMA);
				}
				break;
			case T__5:
				_localctx = new SiCondicionalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(T__5);
				setState(38);
				match(PAREN_ABRE);
				setState(39);
				expresion(0);
				setState(40);
				match(PAREN_CIERRA);
				setState(41);
				match(LLAVE_ABRE);
				setState(42);
				programa();
				setState(43);
				match(LLAVE_CIERRA);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(44);
					match(T__6);
					setState(45);
					match(LLAVE_ABRE);
					setState(46);
					programa();
					setState(47);
					match(LLAVE_CIERRA);
					}
				}

				}
				break;
			case T__7:
				_localctx = new MientrasContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				match(T__7);
				setState(52);
				match(PAREN_ABRE);
				setState(53);
				expresion(0);
				setState(54);
				match(PAREN_CIERRA);
				setState(55);
				match(LLAVE_ABRE);
				setState(56);
				programa();
				setState(57);
				match(LLAVE_CIERRA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SUMA() { return getToken(AcaLangParser.SUMA, 0); }
		public TerminalNode RESTA() { return getToken(AcaLangParser.RESTA, 0); }
		public SumaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterSuma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitSuma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitSuma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparacionContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode IGUAL_IGUAL() { return getToken(AcaLangParser.IGUAL_IGUAL, 0); }
		public ComparacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitComparacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitComparacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(AcaLangParser.ID, 0); }
		public VariableContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalContext extends ExpresionContext {
		public TerminalNode LIT_DEC() { return getToken(AcaLangParser.LIT_DEC, 0); }
		public DecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnteroContext extends ExpresionContext {
		public TerminalNode LIT_ENT() { return getToken(AcaLangParser.LIT_ENT, 0); }
		public EnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterEntero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitEntero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesisContext extends ExpresionContext {
		public TerminalNode PAREN_ABRE() { return getToken(AcaLangParser.PAREN_ABRE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_CIERRA() { return getToken(AcaLangParser.PAREN_CIERRA, 0); }
		public ParentesisContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CadenaContext extends ExpresionContext {
		public TerminalNode LIT_CAD() { return getToken(AcaLangParser.LIT_CAD, 0); }
		public CadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterCadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitCadena(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanoContext extends ExpresionContext {
		public TerminalNode LIT_BOL() { return getToken(AcaLangParser.LIT_BOL, 0); }
		public BooleanoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitBooleano(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitBooleano(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicacionContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(AcaLangParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(AcaLangParser.DIV, 0); }
		public MultiplicacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).enterMultiplicacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AcaLangListener ) ((AcaLangListener)listener).exitMultiplicacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AcaLangVisitor ) return ((AcaLangVisitor<? extends T>)visitor).visitMultiplicacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAREN_ABRE:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(62);
				match(PAREN_ABRE);
				setState(63);
				expresion(0);
				setState(64);
				match(PAREN_CIERRA);
				}
				break;
			case ID:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(ID);
				}
				break;
			case LIT_ENT:
				{
				_localctx = new EnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(LIT_ENT);
				}
				break;
			case LIT_DEC:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(LIT_DEC);
				}
				break;
			case LIT_CAD:
				{
				_localctx = new CadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(LIT_CAD);
				}
				break;
			case LIT_BOL:
				{
				_localctx = new BooleanoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(LIT_BOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(73);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(74);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(75);
						expresion(10);
						}
						break;
					case 2:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(76);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(77);
						_la = _input.LA(1);
						if ( !(_la==SUMA || _la==RESTA) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(78);
						expresion(9);
						}
						break;
					case 3:
						{
						_localctx = new ComparacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(79);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(80);
						match(IGUAL_IGUAL);
						setState(81);
						expresion(8);
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019X\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0004\u0000\r\b\u0000\u000b\u0000\f\u0000\u000e\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u00032\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003<\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004H\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004S\b\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004\u0000\u0001\b\u0005"+
		"\u0000\u0002\u0004\u0006\b\u0000\u0003\u0001\u0000\u0001\u0004\u0001\u0000"+
		"\r\u000e\u0001\u0000\u000b\fa\u0000\f\u0001\u0000\u0000\u0000\u0002\u0010"+
		"\u0001\u0000\u0000\u0000\u0004\u0018\u0001\u0000\u0000\u0000\u0006;\u0001"+
		"\u0000\u0000\u0000\bG\u0001\u0000\u0000\u0000\n\r\u0003\u0002\u0001\u0000"+
		"\u000b\r\u0003\u0006\u0003\u0000\f\n\u0001\u0000\u0000\u0000\f\u000b\u0001"+
		"\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\f\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0001\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\u0003\u0004\u0002\u0000\u0011\u0014\u0005\u0018"+
		"\u0000\u0000\u0012\u0013\u0005\t\u0000\u0000\u0013\u0015\u0003\b\u0004"+
		"\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017\u0005\n\u0000\u0000"+
		"\u0017\u0003\u0001\u0000\u0000\u0000\u0018\u0019\u0007\u0000\u0000\u0000"+
		"\u0019\u0005\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0018\u0000\u0000"+
		"\u001b\u001c\u0005\t\u0000\u0000\u001c\u001d\u0003\b\u0004\u0000\u001d"+
		"\u001e\u0005\n\u0000\u0000\u001e<\u0001\u0000\u0000\u0000\u001f \u0005"+
		"\u0005\u0000\u0000 !\u0005\u000f\u0000\u0000!\"\u0003\b\u0004\u0000\""+
		"#\u0005\u0010\u0000\u0000#$\u0005\n\u0000\u0000$<\u0001\u0000\u0000\u0000"+
		"%&\u0005\u0006\u0000\u0000&\'\u0005\u000f\u0000\u0000\'(\u0003\b\u0004"+
		"\u0000()\u0005\u0010\u0000\u0000)*\u0005\u0012\u0000\u0000*+\u0003\u0000"+
		"\u0000\u0000+1\u0005\u0013\u0000\u0000,-\u0005\u0007\u0000\u0000-.\u0005"+
		"\u0012\u0000\u0000./\u0003\u0000\u0000\u0000/0\u0005\u0013\u0000\u0000"+
		"02\u0001\u0000\u0000\u00001,\u0001\u0000\u0000\u000012\u0001\u0000\u0000"+
		"\u00002<\u0001\u0000\u0000\u000034\u0005\b\u0000\u000045\u0005\u000f\u0000"+
		"\u000056\u0003\b\u0004\u000067\u0005\u0010\u0000\u000078\u0005\u0012\u0000"+
		"\u000089\u0003\u0000\u0000\u00009:\u0005\u0013\u0000\u0000:<\u0001\u0000"+
		"\u0000\u0000;\u001a\u0001\u0000\u0000\u0000;\u001f\u0001\u0000\u0000\u0000"+
		";%\u0001\u0000\u0000\u0000;3\u0001\u0000\u0000\u0000<\u0007\u0001\u0000"+
		"\u0000\u0000=>\u0006\u0004\uffff\uffff\u0000>?\u0005\u000f\u0000\u0000"+
		"?@\u0003\b\u0004\u0000@A\u0005\u0010\u0000\u0000AH\u0001\u0000\u0000\u0000"+
		"BH\u0005\u0018\u0000\u0000CH\u0005\u0014\u0000\u0000DH\u0005\u0015\u0000"+
		"\u0000EH\u0005\u0016\u0000\u0000FH\u0005\u0017\u0000\u0000G=\u0001\u0000"+
		"\u0000\u0000GB\u0001\u0000\u0000\u0000GC\u0001\u0000\u0000\u0000GD\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000"+
		"HT\u0001\u0000\u0000\u0000IJ\n\t\u0000\u0000JK\u0007\u0001\u0000\u0000"+
		"KS\u0003\b\u0004\nLM\n\b\u0000\u0000MN\u0007\u0002\u0000\u0000NS\u0003"+
		"\b\u0004\tOP\n\u0007\u0000\u0000PQ\u0005\u0011\u0000\u0000QS\u0003\b\u0004"+
		"\bRI\u0001\u0000\u0000\u0000RL\u0001\u0000\u0000\u0000RO\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000U\t\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000\b\f"+
		"\u000e\u00141;GRT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}