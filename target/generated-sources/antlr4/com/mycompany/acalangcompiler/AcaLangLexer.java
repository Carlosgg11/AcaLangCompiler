// Generated from com/mycompany/acalangcompiler/AcaLang.g4 by ANTLR 4.13.1
package com.mycompany.acalangcompiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AcaLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, IGUAL=9, 
		PUNTO_COMA=10, SUMA=11, RESTA=12, MULT=13, DIV=14, PAREN_ABRE=15, PAREN_CIERRA=16, 
		IGUAL_IGUAL=17, LLAVE_ABRE=18, LLAVE_CIERRA=19, LIT_ENT=20, LIT_DEC=21, 
		LIT_CAD=22, LIT_BOL=23, ID=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "IGUAL", 
			"PUNTO_COMA", "SUMA", "RESTA", "MULT", "DIV", "PAREN_ABRE", "PAREN_CIERRA", 
			"IGUAL_IGUAL", "LLAVE_ABRE", "LLAVE_CIERRA", "LIT_ENT", "LIT_DEC", "LIT_CAD", 
			"LIT_BOL", "ID", "WS"
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


	public AcaLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AcaLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u00ab\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013"+
		"v\b\u0013\u000b\u0013\f\u0013w\u0001\u0014\u0004\u0014{\b\u0014\u000b"+
		"\u0014\f\u0014|\u0001\u0014\u0001\u0014\u0004\u0014\u0081\b\u0014\u000b"+
		"\u0014\f\u0014\u0082\u0001\u0015\u0001\u0015\u0005\u0015\u0087\b\u0015"+
		"\n\u0015\f\u0015\u008a\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u009c\b\u0016\u0001\u0017\u0001\u0017\u0005\u0017\u00a0"+
		"\b\u0017\n\u0017\f\u0017\u00a3\t\u0017\u0001\u0018\u0004\u0018\u00a6\b"+
		"\u0018\u000b\u0018\f\u0018\u00a7\u0001\u0018\u0001\u0018\u0000\u0000\u0019"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u0019\u0001\u0000\u0005\u0001\u000009\u0001\u0000\"\"\u0002\u0000"+
		"AZaz\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u00b1\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00037"+
		"\u0001\u0000\u0000\u0000\u0005;\u0001\u0000\u0000\u0000\u0007?\u0001\u0000"+
		"\u0000\u0000\tC\u0001\u0000\u0000\u0000\u000bL\u0001\u0000\u0000\u0000"+
		"\rO\u0001\u0000\u0000\u0000\u000fT\u0001\u0000\u0000\u0000\u0011]\u0001"+
		"\u0000\u0000\u0000\u0013_\u0001\u0000\u0000\u0000\u0015a\u0001\u0000\u0000"+
		"\u0000\u0017c\u0001\u0000\u0000\u0000\u0019e\u0001\u0000\u0000\u0000\u001b"+
		"g\u0001\u0000\u0000\u0000\u001di\u0001\u0000\u0000\u0000\u001fk\u0001"+
		"\u0000\u0000\u0000!m\u0001\u0000\u0000\u0000#p\u0001\u0000\u0000\u0000"+
		"%r\u0001\u0000\u0000\u0000\'u\u0001\u0000\u0000\u0000)z\u0001\u0000\u0000"+
		"\u0000+\u0084\u0001\u0000\u0000\u0000-\u009b\u0001\u0000\u0000\u0000/"+
		"\u009d\u0001\u0000\u0000\u00001\u00a5\u0001\u0000\u0000\u000034\u0005"+
		"e\u0000\u000045\u0005n\u0000\u000056\u0005t\u0000\u00006\u0002\u0001\u0000"+
		"\u0000\u000078\u0005d\u0000\u000089\u0005e\u0000\u00009:\u0005c\u0000"+
		"\u0000:\u0004\u0001\u0000\u0000\u0000;<\u0005b\u0000\u0000<=\u0005o\u0000"+
		"\u0000=>\u0005l\u0000\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005c\u0000"+
		"\u0000@A\u0005a\u0000\u0000AB\u0005d\u0000\u0000B\b\u0001\u0000\u0000"+
		"\u0000CD\u0005i\u0000\u0000DE\u0005m\u0000\u0000EF\u0005p\u0000\u0000"+
		"FG\u0005r\u0000\u0000GH\u0005i\u0000\u0000HI\u0005m\u0000\u0000IJ\u0005"+
		"i\u0000\u0000JK\u0005r\u0000\u0000K\n\u0001\u0000\u0000\u0000LM\u0005"+
		"s\u0000\u0000MN\u0005i\u0000\u0000N\f\u0001\u0000\u0000\u0000OP\u0005"+
		"s\u0000\u0000PQ\u0005i\u0000\u0000QR\u0005n\u0000\u0000RS\u0005o\u0000"+
		"\u0000S\u000e\u0001\u0000\u0000\u0000TU\u0005m\u0000\u0000UV\u0005i\u0000"+
		"\u0000VW\u0005e\u0000\u0000WX\u0005n\u0000\u0000XY\u0005t\u0000\u0000"+
		"YZ\u0005r\u0000\u0000Z[\u0005a\u0000\u0000[\\\u0005s\u0000\u0000\\\u0010"+
		"\u0001\u0000\u0000\u0000]^\u0005=\u0000\u0000^\u0012\u0001\u0000\u0000"+
		"\u0000_`\u0005;\u0000\u0000`\u0014\u0001\u0000\u0000\u0000ab\u0005+\u0000"+
		"\u0000b\u0016\u0001\u0000\u0000\u0000cd\u0005-\u0000\u0000d\u0018\u0001"+
		"\u0000\u0000\u0000ef\u0005*\u0000\u0000f\u001a\u0001\u0000\u0000\u0000"+
		"gh\u0005/\u0000\u0000h\u001c\u0001\u0000\u0000\u0000ij\u0005(\u0000\u0000"+
		"j\u001e\u0001\u0000\u0000\u0000kl\u0005)\u0000\u0000l \u0001\u0000\u0000"+
		"\u0000mn\u0005=\u0000\u0000no\u0005=\u0000\u0000o\"\u0001\u0000\u0000"+
		"\u0000pq\u0005{\u0000\u0000q$\u0001\u0000\u0000\u0000rs\u0005}\u0000\u0000"+
		"s&\u0001\u0000\u0000\u0000tv\u0007\u0000\u0000\u0000ut\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000x(\u0001\u0000\u0000\u0000y{\u0007\u0000\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0005.\u0000"+
		"\u0000\u007f\u0081\u0007\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083*\u0001\u0000\u0000\u0000"+
		"\u0084\u0088\u0005\"\u0000\u0000\u0085\u0087\b\u0001\u0000\u0000\u0086"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089"+
		"\u008b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005\"\u0000\u0000\u008c,\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005v\u0000\u0000\u008e\u008f\u0005e\u0000\u0000\u008f\u0090\u0005r"+
		"\u0000\u0000\u0090\u0091\u0005d\u0000\u0000\u0091\u0092\u0005a\u0000\u0000"+
		"\u0092\u0093\u0005d\u0000\u0000\u0093\u0094\u0005e\u0000\u0000\u0094\u0095"+
		"\u0005r\u0000\u0000\u0095\u009c\u0005o\u0000\u0000\u0096\u0097\u0005f"+
		"\u0000\u0000\u0097\u0098\u0005a\u0000\u0000\u0098\u0099\u0005l\u0000\u0000"+
		"\u0099\u009a\u0005s\u0000\u0000\u009a\u009c\u0005o\u0000\u0000\u009b\u008d"+
		"\u0001\u0000\u0000\u0000\u009b\u0096\u0001\u0000\u0000\u0000\u009c.\u0001"+
		"\u0000\u0000\u0000\u009d\u00a1\u0007\u0002\u0000\u0000\u009e\u00a0\u0007"+
		"\u0003\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a20\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a6\u0007\u0004\u0000\u0000\u00a5\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0006\u0018\u0000\u0000\u00aa2\u0001\u0000\u0000"+
		"\u0000\b\u0000w|\u0082\u0088\u009b\u00a1\u00a7\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}