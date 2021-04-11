package gen;// Generated from C:/Users/user/IdeaProjects/Crypt/src/main/java\CryptLexer.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CryptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RELOP=1, VAL_KW=2, PRINTLN_KW=3, PRINT_KW=4, TO_KW=5, IMPORT_KW=6, VOID_KW=7, 
		RETURN_KW=8, FALSE_KW=9, TRUE_KW=10, SUPER_KW=11, FOR_KW=12, AND_KW=13, 
		OR_KW=14, NOT_KW=15, LPAREN=16, RPAREN=17, LBRACKET=18, RBRACKET=19, LSQUARE=20, 
		RSQUARE=21, COMMA=22, POINT=23, COLON=24, SEMICOLON=25, Q_MARK=26, EQUAL=27, 
		DIFFERENT=28, LESSEQ=29, MOREEQ=30, LESS_THAN=31, MORE_THAN=32, ASSIGNMENT=33, 
		ASTERISK=34, SLASH=35, PLUS=36, MINUS=37, PRIMITIVE_TYPE=38, BASIC_TYPE=39, 
		TYPE_ID=40, INT=41, STRING_START=42, WS=43, NL=44, COMMENT=45, LINE_COMMENT=46, 
		STRING_STOP=47, STRING_CONTENT=48, INTERPOLATION_START=49, INTERPOLATION_END=50, 
		FUNC_KW=51, ELSE_KW=52, F_BOOLEAN=53, STRING=54, BLOCK_OP=55, FIELD_KW=56, 
		VALUE_ID=57, F_AND=58, F_OR=59, F_NOT=60, F_INT=61, F_DECIMAL=62, F_PRIMITIVE_TYPE=63, 
		F_OBJECT_TYPE=64, F_BASIC_TYPE=65;
	public static final int
		WHITESPACE=2, COMMENTS=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "WHITESPACE", "COMMENTS"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "FIELD_KW", "PRINTLN_KW", "PRINT_KW", "TO_KW", "IMPORT_KW", 
			"VOID_KW", "RETURN_KW", "FALSE_KW", "TRUE_KW", "SUPER_KW", "FOR_KW", 
			"FUNC_KW", "ELSE_KW", "AND_KW", "OR_KW", "NOT_KW", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "LSQUARE", "RSQUARE", "COMMA", "POINT", "COLON", 
			"Q_MARK", "SEMICOLON", "EQUAL", "DIFFERENT", "LESSEQ", "LESS_THAN", "MOREEQ", 
			"MORE_THAN", "ASSIGNMENT", "ASTERISK", "SLASH", "PLUS", "MINUS", "PRIMITIVE_TYPE", 
			"BASIC_TYPE", "VALUE_ID", "INT", "WS", "NL", "COMMENT", "LINE_COMMENT", 
			"BLOCK_OP", "STRING", "F_AND", "F_OR", "F_NOT", "F_VALUE_ID", "F_INT", 
			"F_DECIMAL", "F_PRIMITIVE_TYPE", "F_OBJECT_TYPE", "F_BOOLEAN", "F_BASIC_TYPE", 
			"ESCAPE_SEQUENCE", "TILDE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'val'", "'println'", "'print'", "'to'", "'import'", "'void'", 
			"'return'", "'false'", "'true'", "'super'", "'for'", null, null, null, 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "';'", 
			"'?'", "'='", "'!='", "'<='", "'>='", "'<'", "'>'", null, "'*'", "'/'", 
			"'+'", "'-'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'fn'", "'else'", null, null, "'>>'", "'field'", null, 
			"'and'", "'or'", "'not'", null, null, null, null, "'UInt'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RELOP", "VAL_KW", "PRINTLN_KW", "PRINT_KW", "TO_KW", "IMPORT_KW", 
			"VOID_KW", "RETURN_KW", "FALSE_KW", "TRUE_KW", "SUPER_KW", "FOR_KW", 
			"AND_KW", "OR_KW", "NOT_KW", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
			"LSQUARE", "RSQUARE", "COMMA", "POINT", "COLON", "SEMICOLON", "Q_MARK", 
			"EQUAL", "DIFFERENT", "LESSEQ", "MOREEQ", "LESS_THAN", "MORE_THAN", "ASSIGNMENT", 
			"ASTERISK", "SLASH", "PLUS", "MINUS", "PRIMITIVE_TYPE", "BASIC_TYPE", 
			"TYPE_ID", "INT", "STRING_START", "WS", "NL", "COMMENT", "LINE_COMMENT", 
			"STRING_STOP", "STRING_CONTENT", "INTERPOLATION_START", "INTERPOLATION_END", 
			"FUNC_KW", "ELSE_KW", "F_BOOLEAN", "STRING", "BLOCK_OP", "FIELD_KW", 
			"VALUE_ID", "F_AND", "F_OR", "F_NOT", "F_INT", "F_DECIMAL", "F_PRIMITIVE_TYPE", 
			"F_OBJECT_TYPE", "F_BASIC_TYPE"
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


	    public static final int WHITESPACE = 1;
	    public static final int COMMENTS = 2;


	public CryptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CryptLexer.g4"; }

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

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 60:
			return TILDE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean TILDE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  _input.LA(1)!='{' ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u01b5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\6-\u0113"+
		"\n-\r-\16-\u0114\3-\3-\3.\5.\u011a\n.\3.\3.\3/\3/\3/\3/\7/\u0122\n/\f"+
		"/\16/\u0125\13/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u0130\n\60\f\60"+
		"\16\60\u0133\13\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\7\62\u013c\n\62"+
		"\f\62\16\62\u013f\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\3\66\7\66\u014f\n\66\f\66\16\66\u0152\13\66\3\66\3"+
		"\66\7\66\u0156\n\66\f\66\16\66\u0159\13\66\3\67\3\67\3\67\7\67\u015e\n"+
		"\67\f\67\16\67\u0161\13\67\5\67\u0163\n\67\38\38\38\78\u0168\n8\f8\16"+
		"8\u016b\138\58\u016d\n8\38\38\38\38\78\u0173\n8\f8\168\u0176\138\58\u0178"+
		"\n8\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u019d\n9\3:\3:\3:\3:\3:\3:"+
		"\3:\5:\u01a6\n:\3;\3;\5;\u01aa\n;\3<\3<\3<\3<\3<\3=\3=\3>\3>\3>\4\u0123"+
		"\u013d\2?\3\4\5:\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\65"+
		"\35\66\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\34"+
		"9\33;\35=\36?\37A!C E\"G#I$K%M&O\'Q(S)U;W+Y-[.]/_\60a9c8e<g=i>k\2m?o@"+
		"qAsBu\67wCy\2{\2\3\2\6\4\2\"\"vv\4\2pptt\6\2\62;C\\aac|\6\2$$ppttvv\2"+
		"\u01c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3}\3\2\2\2\5\u0081"+
		"\3\2\2\2\7\u0087\3\2\2\2\t\u008f\3\2\2\2\13\u0095\3\2\2\2\r\u0098\3\2"+
		"\2\2\17\u009f\3\2\2\2\21\u00a4\3\2\2\2\23\u00ab\3\2\2\2\25\u00b1\3\2\2"+
		"\2\27\u00b6\3\2\2\2\31\u00bc\3\2\2\2\33\u00c0\3\2\2\2\35\u00c3\3\2\2\2"+
		"\37\u00c8\3\2\2\2!\u00ca\3\2\2\2#\u00cc\3\2\2\2%\u00ce\3\2\2\2\'\u00d0"+
		"\3\2\2\2)\u00d2\3\2\2\2+\u00d4\3\2\2\2-\u00d6\3\2\2\2/\u00d8\3\2\2\2\61"+
		"\u00da\3\2\2\2\63\u00dc\3\2\2\2\65\u00de\3\2\2\2\67\u00e0\3\2\2\29\u00e2"+
		"\3\2\2\2;\u00e4\3\2\2\2=\u00e8\3\2\2\2?\u00ed\3\2\2\2A\u00f2\3\2\2\2C"+
		"\u00f6\3\2\2\2E\u00fb\3\2\2\2G\u00ff\3\2\2\2I\u0101\3\2\2\2K\u0103\3\2"+
		"\2\2M\u0105\3\2\2\2O\u0107\3\2\2\2Q\u0109\3\2\2\2S\u010b\3\2\2\2U\u010d"+
		"\3\2\2\2W\u010f\3\2\2\2Y\u0112\3\2\2\2[\u0119\3\2\2\2]\u011d\3\2\2\2_"+
		"\u012b\3\2\2\2a\u0136\3\2\2\2c\u0139\3\2\2\2e\u0142\3\2\2\2g\u0146\3\2"+
		"\2\2i\u0149\3\2\2\2k\u0150\3\2\2\2m\u0162\3\2\2\2o\u016c\3\2\2\2q\u019c"+
		"\3\2\2\2s\u01a5\3\2\2\2u\u01a9\3\2\2\2w\u01ab\3\2\2\2y\u01b0\3\2\2\2{"+
		"\u01b2\3\2\2\2}~\7x\2\2~\177\7c\2\2\177\u0080\7n\2\2\u0080\4\3\2\2\2\u0081"+
		"\u0082\7h\2\2\u0082\u0083\7k\2\2\u0083\u0084\7g\2\2\u0084\u0085\7n\2\2"+
		"\u0085\u0086\7f\2\2\u0086\6\3\2\2\2\u0087\u0088\7r\2\2\u0088\u0089\7t"+
		"\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2\2\u008b\u008c\7v\2\2\u008c\u008d"+
		"\7n\2\2\u008d\u008e\7p\2\2\u008e\b\3\2\2\2\u008f\u0090\7r\2\2\u0090\u0091"+
		"\7t\2\2\u0091\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094\7v\2\2\u0094"+
		"\n\3\2\2\2\u0095\u0096\7v\2\2\u0096\u0097\7q\2\2\u0097\f\3\2\2\2\u0098"+
		"\u0099\7k\2\2\u0099\u009a\7o\2\2\u009a\u009b\7r\2\2\u009b\u009c\7q\2\2"+
		"\u009c\u009d\7t\2\2\u009d\u009e\7v\2\2\u009e\16\3\2\2\2\u009f\u00a0\7"+
		"x\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7f\2\2\u00a3\20"+
		"\3\2\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\u00a8\7w\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7p\2\2\u00aa\22\3\2\2\2\u00ab"+
		"\u00ac\7h\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7u\2\2"+
		"\u00af\u00b0\7g\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7"+
		"t\2\2\u00b3\u00b4\7w\2\2\u00b4\u00b5\7g\2\2\u00b5\26\3\2\2\2\u00b6\u00b7"+
		"\7u\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\7r\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7t\2\2\u00bb\30\3\2\2\2\u00bc\u00bd\7h\2\2\u00bd\u00be\7q\2\2\u00be"+
		"\u00bf\7t\2\2\u00bf\32\3\2\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2\7p\2\2\u00c2"+
		"\34\3\2\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7u\2\2\u00c6"+
		"\u00c7\7g\2\2\u00c7\36\3\2\2\2\u00c8\u00c9\5e\63\2\u00c9 \3\2\2\2\u00ca"+
		"\u00cb\5g\64\2\u00cb\"\3\2\2\2\u00cc\u00cd\5i\65\2\u00cd$\3\2\2\2\u00ce"+
		"\u00cf\7*\2\2\u00cf&\3\2\2\2\u00d0\u00d1\7+\2\2\u00d1(\3\2\2\2\u00d2\u00d3"+
		"\7}\2\2\u00d3*\3\2\2\2\u00d4\u00d5\7\177\2\2\u00d5,\3\2\2\2\u00d6\u00d7"+
		"\7]\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7_\2\2\u00d9\60\3\2\2\2\u00da\u00db"+
		"\7.\2\2\u00db\62\3\2\2\2\u00dc\u00dd\7\60\2\2\u00dd\64\3\2\2\2\u00de\u00df"+
		"\7<\2\2\u00df\66\3\2\2\2\u00e0\u00e1\7A\2\2\u00e18\3\2\2\2\u00e2\u00e3"+
		"\7=\2\2\u00e3:\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\b\36\2\2\u00e7<\3\2\2\2\u00e8\u00e9\7#\2\2\u00e9\u00ea\7?\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ec\b\37\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7>\2\2\u00ee"+
		"\u00ef\7?\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\b \2\2\u00f1@\3\2\2\2\u00f2"+
		"\u00f3\7>\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b!\2\2\u00f5B\3\2\2\2\u00f6"+
		"\u00f7\7@\2\2\u00f7\u00f8\7?\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\b\"\2"+
		"\2\u00faD\3\2\2\2\u00fb\u00fc\7@\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\b"+
		"#\2\2\u00feF\3\2\2\2\u00ff\u0100\5\65\33\2\u0100H\3\2\2\2\u0101\u0102"+
		"\7,\2\2\u0102J\3\2\2\2\u0103\u0104\7\61\2\2\u0104L\3\2\2\2\u0105\u0106"+
		"\7-\2\2\u0106N\3\2\2\2\u0107\u0108\7/\2\2\u0108P\3\2\2\2\u0109\u010a\5"+
		"q9\2\u010aR\3\2\2\2\u010b\u010c\5w<\2\u010cT\3\2\2\2\u010d\u010e\5k\66"+
		"\2\u010eV\3\2\2\2\u010f\u0110\5m\67\2\u0110X\3\2\2\2\u0111\u0113\t\2\2"+
		"\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\b-\3\2\u0117Z\3\2\2\2\u0118\u011a"+
		"\7t\2\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\7p\2\2\u011c\\\3\2\2\2\u011d\u011e\7\61\2\2\u011e\u011f\7,\2\2"+
		"\u011f\u0123\3\2\2\2\u0120\u0122\13\2\2\2\u0121\u0120\3\2\2\2\u0122\u0125"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0127\7,\2\2\u0127\u0128\7\61\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012a\b/\4\2\u012a^\3\2\2\2\u012b\u012c\7\61\2\2\u012c\u012d"+
		"\7\61\2\2\u012d\u0131\3\2\2\2\u012e\u0130\n\3\2\2\u012f\u012e\3\2\2\2"+
		"\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\b\60\4\2\u0135`\3\2\2\2\u0136"+
		"\u0137\7@\2\2\u0137\u0138\7@\2\2\u0138b\3\2\2\2\u0139\u013d\7$\2\2\u013a"+
		"\u013c\13\2\2\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013e\3"+
		"\2\2\2\u013d\u013b\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140"+
		"\u0141\7$\2\2\u0141d\3\2\2\2\u0142\u0143\7c\2\2\u0143\u0144\7p\2\2\u0144"+
		"\u0145\7f\2\2\u0145f\3\2\2\2\u0146\u0147\7q\2\2\u0147\u0148\7t\2\2\u0148"+
		"h\3\2\2\2\u0149\u014a\7p\2\2\u014a\u014b\7q\2\2\u014b\u014c\7v\2\2\u014c"+
		"j\3\2\2\2\u014d\u014f\7a\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0153\u0157\4c|\2\u0154\u0156\t\4\2\2\u0155\u0154\3\2\2\2\u0156\u0159"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158l\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u0163\7\62\2\2\u015b\u015f\4\63;\2\u015c\u015e\4"+
		"\62;\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u015a\3\2"+
		"\2\2\u0162\u015b\3\2\2\2\u0163n\3\2\2\2\u0164\u016d\7\62\2\2\u0165\u0169"+
		"\4\63;\2\u0166\u0168\4\62;\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016c\u0164\3\2\2\2\u016c\u0165\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0177\7\60\2\2\u016f\u0178\7\62\2\2\u0170\u0174\4\63;\2\u0171\u0173\4"+
		"\62;\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u016f\3\2"+
		"\2\2\u0177\u0170\3\2\2\2\u0178p\3\2\2\2\u0179\u017a\7d\2\2\u017a\u017b"+
		"\7{\2\2\u017b\u017c\7v\2\2\u017c\u019d\7g\2\2\u017d\u017e\7k\2\2\u017e"+
		"\u017f\7p\2\2\u017f\u019d\7v\2\2\u0180\u0181\7n\2\2\u0181\u0182\7q\2\2"+
		"\u0182\u0183\7p\2\2\u0183\u019d\7i\2\2\u0184\u0185\7d\2\2\u0185\u0186"+
		"\7q\2\2\u0186\u0187\7q\2\2\u0187\u019d\7n\2\2\u0188\u0189\7e\2\2\u0189"+
		"\u018a\7j\2\2\u018a\u018b\7c\2\2\u018b\u019d\7t\2\2\u018c\u018d\7h\2\2"+
		"\u018d\u018e\7n\2\2\u018e\u018f\7q\2\2\u018f\u0190\7c\2\2\u0190\u019d"+
		"\7v\2\2\u0191\u0192\7f\2\2\u0192\u0193\7q\2\2\u0193\u0194\7w\2\2\u0194"+
		"\u0195\7d\2\2\u0195\u0196\7n\2\2\u0196\u019d\7g\2\2\u0197\u0198\7u\2\2"+
		"\u0198\u0199\7j\2\2\u0199\u019a\7q\2\2\u019a\u019b\7t\2\2\u019b\u019d"+
		"\7v\2\2\u019c\u0179\3\2\2\2\u019c\u017d\3\2\2\2\u019c\u0180\3\2\2\2\u019c"+
		"\u0184\3\2\2\2\u019c\u0188\3\2\2\2\u019c\u018c\3\2\2\2\u019c\u0191\3\2"+
		"\2\2\u019c\u0197\3\2\2\2\u019dr\3\2\2\2\u019e\u019f\7u\2\2\u019f\u01a0"+
		"\7v\2\2\u01a0\u01a1\7t\2\2\u01a1\u01a2\7k\2\2\u01a2\u01a3\7p\2\2\u01a3"+
		"\u01a6\7i\2\2\u01a4\u01a6\5\17\b\2\u01a5\u019e\3\2\2\2\u01a5\u01a4\3\2"+
		"\2\2\u01a6t\3\2\2\2\u01a7\u01aa\5\25\13\2\u01a8\u01aa\5\23\n\2\u01a9\u01a7"+
		"\3\2\2\2\u01a9\u01a8\3\2\2\2\u01aav\3\2\2\2\u01ab\u01ac\7W\2\2\u01ac\u01ad"+
		"\7K\2\2\u01ad\u01ae\7p\2\2\u01ae\u01af\7v\2\2\u01afx\3\2\2\2\u01b0\u01b1"+
		"\t\5\2\2\u01b1z\3\2\2\2\u01b2\u01b3\7\u0080\2\2\u01b3\u01b4\6>\2\2\u01b4"+
		"|\3\2\2\2\23\2\u0114\u0119\u0123\u0131\u013d\u0150\u0157\u015f\u0162\u0169"+
		"\u016c\u0174\u0177\u019c\u01a5\u01a9\5\t\3\2\2\4\2\2\5\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}