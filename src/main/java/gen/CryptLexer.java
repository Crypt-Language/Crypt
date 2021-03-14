// Generated from C:/Users/user/IdeaProjects/Crypt/src/main/java/CryptCompiler/parse\CryptLexer.g4 by ANTLR 4.9.1
package gen;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

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
		RSQUARE=21, COMMA=22, POINT=23, COLON=24, Q_MARK=25, EQUAL=26, DIFFERENT=27, 
		LESSEQ=28, MOREEQ=29, LESS_THAN=30, MORE_THAN=31, ASSIGNMENT=32, ASTERISK=33, 
		SLASH=34, PLUS=35, MINUS=36, PRIMITIVE_TYPE=37, BASIC_TYPE=38, TYPE_ID=39, 
		INT=40, STRING_START=41, WS=42, NL=43, COMMENT=44, LINE_COMMENT=45, STRING_STOP=46, 
		STRING_CONTENT=47, INTERPOLATION_START=48, INTERPOLATION_END=49, FUNC_KW=50, 
		ELSE_KW=51, FIELD_KW=52, VALUE_ID=53, F_AND=54, F_OR=55, F_NOT=56, F_INT=57, 
		F_PRIMITIVE_TYPE=58, F_OBJECT_TYPE=59, F_BASIC_TYPE=60;
	public static final int
		WHITESPACE=2, COMMENTS=3;
	public static final int
		IN_STRING=1, IN_INTERPOLATION=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "WHITESPACE", "COMMENTS"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_STRING", "IN_INTERPOLATION"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "FIELD_KW", "PRINTLN_KW", "PRINT_KW", "TO_KW", "IMPORT_KW", 
			"VOID_KW", "RETURN_KW", "FALSE_KW", "TRUE_KW", "SUPER_KW", "FOR_KW", 
			"FUNC_KW", "ELSE_KW", "AND_KW", "OR_KW", "NOT_KW", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "LSQUARE", "RSQUARE", "COMMA", "POINT", "COLON", 
			"Q_MARK", "EQUAL", "DIFFERENT", "LESSEQ", "LESS_THAN", "MOREEQ", "MORE_THAN", 
			"ASSIGNMENT", "ASTERISK", "SLASH", "PLUS", "MINUS", "PRIMITIVE_TYPE", 
			"BASIC_TYPE", "VALUE_ID", "INT", "STRING_START", "WS", "NL", "COMMENT", 
			"LINE_COMMENT", "STRING_STOP", "STRING_CONTENT", "INTERPOLATION_START", 
			"INTERPOLATION_END", "I_PRIMITIVE_TYPE", "I_BASIC_TYPE", "I_FALSE_KW", 
			"I_TRUE_KW", "I_AND_KW", "I_OR_KW", "I_NOT_KW", "I_IF_KW", "I_ELSE_KW", 
			"I_VALUE_ID", "I_INT", "I_COMMA", "I_LPAREN", "I_RPAREN", "I_LSQUARE", 
			"I_RSQUARE", "I_ASTERISK", "I_SLASH", "I_PLUS", "I_MINUS", "I_POINT", 
			"I_EQUAL", "I_DIFFERENT", "I_LESSEQ", "I_LESS", "I_MOREEQ", "I_MORE", 
			"I_STRING_START", "I_WS", "F_AND", "F_OR", "F_NOT", "F_VALUE_ID", "F_INT", 
			"F_PRIMITIVE_TYPE", "F_OBJECT_TYPE", "F_BASIC_TYPE", "ESCAPE_SEQUENCE", 
			"TILDE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'val'", "'println'", "'print'", "'to'", "'import'", "'void'", 
			"'return'", null, null, "'super'", "'for'", null, null, null, null, null, 
			"'{'", null, null, null, null, null, "':'", null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'~{'", null, "'fn'", null, "'field'", 
			null, "'and'", "'or'", "'not'", null, null, null, "'UInt'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RELOP", "VAL_KW", "PRINTLN_KW", "PRINT_KW", "TO_KW", "IMPORT_KW", 
			"VOID_KW", "RETURN_KW", "FALSE_KW", "TRUE_KW", "SUPER_KW", "FOR_KW", 
			"AND_KW", "OR_KW", "NOT_KW", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", 
			"LSQUARE", "RSQUARE", "COMMA", "POINT", "COLON", "Q_MARK", "EQUAL", "DIFFERENT", 
			"LESSEQ", "MOREEQ", "LESS_THAN", "MORE_THAN", "ASSIGNMENT", "ASTERISK", 
			"SLASH", "PLUS", "MINUS", "PRIMITIVE_TYPE", "BASIC_TYPE", "TYPE_ID", 
			"INT", "STRING_START", "WS", "NL", "COMMENT", "LINE_COMMENT", "STRING_STOP", 
			"STRING_CONTENT", "INTERPOLATION_START", "INTERPOLATION_END", "FUNC_KW", 
			"ELSE_KW", "FIELD_KW", "VALUE_ID", "F_AND", "F_OR", "F_NOT", "F_INT", 
			"F_PRIMITIVE_TYPE", "F_OBJECT_TYPE", "F_BASIC_TYPE"
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
		case 89:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u026b\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\3-\6-\u0151\n-\r-\16-\u0152"+
		"\3-\3-\3.\5.\u0158\n.\3.\3.\3/\3/\3/\3/\7/\u0160\n/\f/\16/\u0163\13/\3"+
		"/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u016e\n\60\f\60\16\60\u0171\13"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\6\62\u017c\n\62\r\62"+
		"\16\62\u017d\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3"+
		"\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"8\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3"+
		"=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3A\3"+
		"B\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3F\3F\3F\3F\3G\3G\3G\3"+
		"G\3H\3H\3H\3H\3I\3I\3I\3I\3J\3J\3J\3J\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3"+
		"M\3M\3M\3M\3N\3N\3N\3N\3N\3O\3O\3O\3O\3P\3P\3P\3P\3P\3Q\6Q\u0208\nQ\r"+
		"Q\16Q\u0209\3Q\3Q\3Q\3R\3R\3R\3R\3S\3S\3S\3T\3T\3T\3T\3U\7U\u021b\nU\f"+
		"U\16U\u021e\13U\3U\3U\7U\u0222\nU\fU\16U\u0225\13U\3V\3V\3V\7V\u022a\n"+
		"V\fV\16V\u022d\13V\5V\u022f\nV\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W"+
		"\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\5W"+
		"\u0254\nW\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\5X\u0260\nX\3Y\3Y\3Y\3Y\3Y\3Z"+
		"\3Z\3[\3[\3[\3\u0161\2\\\5\4\7\66\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27"+
		"\f\31\r\33\16\35\64\37\65!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30"+
		"\65\31\67\329\33;\34=\35?\36A C\37E!G\"I#K$M%O&Q\'S(U\67W*Y+[,]-_.a/c"+
		"\60e\61g\62i\63k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085"+
		"\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097"+
		"\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a58\u00a79\u00a9"+
		":\u00ab\2\u00ad;\u00af<\u00b1=\u00b3>\u00b5\2\u00b7\2\5\2\3\4\7\4\2\""+
		"\"vv\4\2pptt\4\2$$\u0080\u0080\6\2\62;C\\aac|\6\2$$ppttvv\2\u0279\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2"+
		"\3e\3\2\2\2\3g\3\2\2\2\4i\3\2\2\2\4k\3\2\2\2\4m\3\2\2\2\4o\3\2\2\2\4q"+
		"\3\2\2\2\4s\3\2\2\2\4u\3\2\2\2\4w\3\2\2\2\4y\3\2\2\2\4{\3\2\2\2\4}\3\2"+
		"\2\2\4\177\3\2\2\2\4\u0081\3\2\2\2\4\u0083\3\2\2\2\4\u0085\3\2\2\2\4\u0087"+
		"\3\2\2\2\4\u0089\3\2\2\2\4\u008b\3\2\2\2\4\u008d\3\2\2\2\4\u008f\3\2\2"+
		"\2\4\u0091\3\2\2\2\4\u0093\3\2\2\2\4\u0095\3\2\2\2\4\u0097\3\2\2\2\4\u0099"+
		"\3\2\2\2\4\u009b\3\2\2\2\4\u009d\3\2\2\2\4\u009f\3\2\2\2\4\u00a1\3\2\2"+
		"\2\4\u00a3\3\2\2\2\4\u00a5\3\2\2\2\4\u00a7\3\2\2\2\4\u00a9\3\2\2\2\4\u00ad"+
		"\3\2\2\2\4\u00af\3\2\2\2\4\u00b1\3\2\2\2\4\u00b3\3\2\2\2\5\u00b9\3\2\2"+
		"\2\7\u00bd\3\2\2\2\t\u00c3\3\2\2\2\13\u00cb\3\2\2\2\r\u00d1\3\2\2\2\17"+
		"\u00d4\3\2\2\2\21\u00db\3\2\2\2\23\u00e0\3\2\2\2\25\u00e7\3\2\2\2\27\u00ed"+
		"\3\2\2\2\31\u00f2\3\2\2\2\33\u00f8\3\2\2\2\35\u00fc\3\2\2\2\37\u00ff\3"+
		"\2\2\2!\u0104\3\2\2\2#\u0106\3\2\2\2%\u0108\3\2\2\2\'\u010a\3\2\2\2)\u010c"+
		"\3\2\2\2+\u010e\3\2\2\2-\u0110\3\2\2\2/\u0112\3\2\2\2\61\u0114\3\2\2\2"+
		"\63\u0116\3\2\2\2\65\u0118\3\2\2\2\67\u011a\3\2\2\29\u011c\3\2\2\2;\u011e"+
		"\3\2\2\2=\u0122\3\2\2\2?\u0127\3\2\2\2A\u012c\3\2\2\2C\u0130\3\2\2\2E"+
		"\u0135\3\2\2\2G\u0139\3\2\2\2I\u013b\3\2\2\2K\u013d\3\2\2\2M\u013f\3\2"+
		"\2\2O\u0141\3\2\2\2Q\u0143\3\2\2\2S\u0145\3\2\2\2U\u0147\3\2\2\2W\u0149"+
		"\3\2\2\2Y\u014b\3\2\2\2[\u0150\3\2\2\2]\u0157\3\2\2\2_\u015b\3\2\2\2a"+
		"\u0169\3\2\2\2c\u0174\3\2\2\2e\u017b\3\2\2\2g\u017f\3\2\2\2i\u0184\3\2"+
		"\2\2k\u0188\3\2\2\2m\u018c\3\2\2\2o\u0190\3\2\2\2q\u0198\3\2\2\2s\u019f"+
		"\3\2\2\2u\u01a3\3\2\2\2w\u01a7\3\2\2\2y\u01ab\3\2\2\2{\u01af\3\2\2\2}"+
		"\u01b6\3\2\2\2\177\u01ba\3\2\2\2\u0081\u01be\3\2\2\2\u0083\u01c2\3\2\2"+
		"\2\u0085\u01c6\3\2\2\2\u0087\u01ca\3\2\2\2\u0089\u01ce\3\2\2\2\u008b\u01d2"+
		"\3\2\2\2\u008d\u01d6\3\2\2\2\u008f\u01da\3\2\2\2\u0091\u01de\3\2\2\2\u0093"+
		"\u01e2\3\2\2\2\u0095\u01e6\3\2\2\2\u0097\u01ea\3\2\2\2\u0099\u01ef\3\2"+
		"\2\2\u009b\u01f4\3\2\2\2\u009d\u01f8\3\2\2\2\u009f\u01fd\3\2\2\2\u00a1"+
		"\u0201\3\2\2\2\u00a3\u0207\3\2\2\2\u00a5\u020e\3\2\2\2\u00a7\u0212\3\2"+
		"\2\2\u00a9\u0215\3\2\2\2\u00ab\u021c\3\2\2\2\u00ad\u022e\3\2\2\2\u00af"+
		"\u0253\3\2\2\2\u00b1\u025f\3\2\2\2\u00b3\u0261\3\2\2\2\u00b5\u0266\3\2"+
		"\2\2\u00b7\u0268\3\2\2\2\u00b9\u00ba\7x\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc"+
		"\7n\2\2\u00bc\6\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0"+
		"\7g\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7f\2\2\u00c2\b\3\2\2\2\u00c3\u00c4"+
		"\7r\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7"+
		"\u00c8\7v\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7p\2\2\u00ca\n\3\2\2\2\u00cb"+
		"\u00cc\7r\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7p\2\2"+
		"\u00cf\u00d0\7v\2\2\u00d0\f\3\2\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7q"+
		"\2\2\u00d3\16\3\2\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7o\2\2\u00d6\u00d7"+
		"\7r\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7v\2\2\u00da"+
		"\20\3\2\2\2\u00db\u00dc\7x\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7k\2\2\u00de"+
		"\u00df\7f\2\2\u00df\22\3\2\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2\7g\2\2\u00e2"+
		"\u00e3\7v\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7p\2\2"+
		"\u00e6\24\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7"+
		"n\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec\7g\2\2\u00ec\26\3\2\2\2\u00ed\u00ee"+
		"\7v\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0\7w\2\2\u00f0\u00f1\7g\2\2\u00f1"+
		"\30\3\2\2\2\u00f2\u00f3\7u\2\2\u00f3\u00f4\7w\2\2\u00f4\u00f5\7r\2\2\u00f5"+
		"\u00f6\7g\2\2\u00f6\u00f7\7t\2\2\u00f7\32\3\2\2\2\u00f8\u00f9\7h\2\2\u00f9"+
		"\u00fa\7q\2\2\u00fa\u00fb\7t\2\2\u00fb\34\3\2\2\2\u00fc\u00fd\7h\2\2\u00fd"+
		"\u00fe\7p\2\2\u00fe\36\3\2\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7n\2\2\u0101"+
		"\u0102\7u\2\2\u0102\u0103\7g\2\2\u0103 \3\2\2\2\u0104\u0105\5\u00a5R\2"+
		"\u0105\"\3\2\2\2\u0106\u0107\5\u00a7S\2\u0107$\3\2\2\2\u0108\u0109\5\u00a9"+
		"T\2\u0109&\3\2\2\2\u010a\u010b\7*\2\2\u010b(\3\2\2\2\u010c\u010d\7+\2"+
		"\2\u010d*\3\2\2\2\u010e\u010f\7}\2\2\u010f,\3\2\2\2\u0110\u0111\7\177"+
		"\2\2\u0111.\3\2\2\2\u0112\u0113\7]\2\2\u0113\60\3\2\2\2\u0114\u0115\7"+
		"_\2\2\u0115\62\3\2\2\2\u0116\u0117\7.\2\2\u0117\64\3\2\2\2\u0118\u0119"+
		"\7\60\2\2\u0119\66\3\2\2\2\u011a\u011b\7<\2\2\u011b8\3\2\2\2\u011c\u011d"+
		"\7A\2\2\u011d:\3\2\2\2\u011e\u011f\7?\2\2\u011f\u0120\3\2\2\2\u0120\u0121"+
		"\b\35\2\2\u0121<\3\2\2\2\u0122\u0123\7#\2\2\u0123\u0124\7?\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0126\b\36\2\2\u0126>\3\2\2\2\u0127\u0128\7>\2\2\u0128"+
		"\u0129\7?\2\2\u0129\u012a\3\2\2\2\u012a\u012b\b\37\2\2\u012b@\3\2\2\2"+
		"\u012c\u012d\7>\2\2\u012d\u012e\3\2\2\2\u012e\u012f\b \2\2\u012fB\3\2"+
		"\2\2\u0130\u0131\7@\2\2\u0131\u0132\7?\2\2\u0132\u0133\3\2\2\2\u0133\u0134"+
		"\b!\2\2\u0134D\3\2\2\2\u0135\u0136\7@\2\2\u0136\u0137\3\2\2\2\u0137\u0138"+
		"\b\"\2\2\u0138F\3\2\2\2\u0139\u013a\5\67\33\2\u013aH\3\2\2\2\u013b\u013c"+
		"\7,\2\2\u013cJ\3\2\2\2\u013d\u013e\7\61\2\2\u013eL\3\2\2\2\u013f\u0140"+
		"\7-\2\2\u0140N\3\2\2\2\u0141\u0142\7/\2\2\u0142P\3\2\2\2\u0143\u0144\5"+
		"\u00afW\2\u0144R\3\2\2\2\u0145\u0146\5\u00b3Y\2\u0146T\3\2\2\2\u0147\u0148"+
		"\5\u00abU\2\u0148V\3\2\2\2\u0149\u014a\5\u00adV\2\u014aX\3\2\2\2\u014b"+
		"\u014c\7$\2\2\u014c\u014d\3\2\2\2\u014d\u014e\b,\3\2\u014eZ\3\2\2\2\u014f"+
		"\u0151\t\2\2\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\b-\4\2\u0155"+
		"\\\3\2\2\2\u0156\u0158\7t\2\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2"+
		"\u0158\u0159\3\2\2\2\u0159\u015a\7p\2\2\u015a^\3\2\2\2\u015b\u015c\7\61"+
		"\2\2\u015c\u015d\7,\2\2\u015d\u0161\3\2\2\2\u015e\u0160\13\2\2\2\u015f"+
		"\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u0162\3\2\2\2\u0161\u015f\3\2"+
		"\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7,\2\2\u0165"+
		"\u0166\7\61\2\2\u0166\u0167\3\2\2\2\u0167\u0168\b/\5\2\u0168`\3\2\2\2"+
		"\u0169\u016a\7\61\2\2\u016a\u016b\7\61\2\2\u016b\u016f\3\2\2\2\u016c\u016e"+
		"\n\3\2\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\b\60"+
		"\5\2\u0173b\3\2\2\2\u0174\u0175\7$\2\2\u0175\u0176\3\2\2\2\u0176\u0177"+
		"\b\61\6\2\u0177d\3\2\2\2\u0178\u017c\n\4\2\2\u0179\u017c\5\u00b5Z\2\u017a"+
		"\u017c\5\u00b7[\2\u017b\u0178\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017a"+
		"\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"f\3\2\2\2\u017f\u0180\7\u0080\2\2\u0180\u0181\7}\2\2\u0181\u0182\3\2\2"+
		"\2\u0182\u0183\b\63\7\2\u0183h\3\2\2\2\u0184\u0185\7\177\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u0187\b\64\6\2\u0187j\3\2\2\2\u0188\u0189\5\u00afW\2\u0189"+
		"\u018a\3\2\2\2\u018a\u018b\b\65\b\2\u018bl\3\2\2\2\u018c\u018d\5\u00b3"+
		"Y\2\u018d\u018e\3\2\2\2\u018e\u018f\b\66\t\2\u018fn\3\2\2\2\u0190\u0191"+
		"\7h\2\2\u0191\u0192\7c\2\2\u0192\u0193\7n\2\2\u0193\u0194\7u\2\2\u0194"+
		"\u0195\7g\2\2\u0195\u0196\3\2\2\2\u0196\u0197\b\67\n\2\u0197p\3\2\2\2"+
		"\u0198\u0199\7v\2\2\u0199\u019a\7t\2\2\u019a\u019b\7w\2\2\u019b\u019c"+
		"\7g\2\2\u019c\u019d\3\2\2\2\u019d\u019e\b8\13\2\u019er\3\2\2\2\u019f\u01a0"+
		"\5\u00a5R\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\b9\f\2\u01a2t\3\2\2\2\u01a3"+
		"\u01a4\5\u00a7S\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\b:\r\2\u01a6v\3\2\2"+
		"\2\u01a7\u01a8\5\u00a9T\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\b;\16\2\u01aa"+
		"x\3\2\2\2\u01ab\u01ac\7A\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\b<\17\2\u01ae"+
		"z\3\2\2\2\u01af\u01b0\7g\2\2\u01b0\u01b1\7n\2\2\u01b1\u01b2\7u\2\2\u01b2"+
		"\u01b3\7g\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\b=\20\2\u01b5|\3\2\2\2\u01b6"+
		"\u01b7\5\u00abU\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\b>\21\2\u01b9~\3\2\2"+
		"\2\u01ba\u01bb\5\u00adV\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\b?\22\2\u01bd"+
		"\u0080\3\2\2\2\u01be\u01bf\7.\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\b@\23"+
		"\2\u01c1\u0082\3\2\2\2\u01c2\u01c3\7*\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5"+
		"\bA\24\2\u01c5\u0084\3\2\2\2\u01c6\u01c7\7+\2\2\u01c7\u01c8\3\2\2\2\u01c8"+
		"\u01c9\bB\25\2\u01c9\u0086\3\2\2\2\u01ca\u01cb\7]\2\2\u01cb\u01cc\3\2"+
		"\2\2\u01cc\u01cd\bC\26\2\u01cd\u0088\3\2\2\2\u01ce\u01cf\7_\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01d1\bD\27\2\u01d1\u008a\3\2\2\2\u01d2\u01d3\7,"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\bE\30\2\u01d5\u008c\3\2\2\2\u01d6"+
		"\u01d7\7\61\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\bF\31\2\u01d9\u008e\3"+
		"\2\2\2\u01da\u01db\7-\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\bG\32\2\u01dd"+
		"\u0090\3\2\2\2\u01de\u01df\7/\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\bH\33"+
		"\2\u01e1\u0092\3\2\2\2\u01e2\u01e3\7\60\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01e5\bI\34\2\u01e5\u0094\3\2\2\2\u01e6\u01e7\7?\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01e9\bJ\2\2\u01e9\u0096\3\2\2\2\u01ea\u01eb\7#\2\2\u01eb\u01ec"+
		"\7?\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\bK\2\2\u01ee\u0098\3\2\2\2\u01ef"+
		"\u01f0\7>\2\2\u01f0\u01f1\7?\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\bL\2"+
		"\2\u01f3\u009a\3\2\2\2\u01f4\u01f5\7>\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7"+
		"\bM\2\2\u01f7\u009c\3\2\2\2\u01f8\u01f9\7@\2\2\u01f9\u01fa\7?\2\2\u01fa"+
		"\u01fb\3\2\2\2\u01fb\u01fc\bN\2\2\u01fc\u009e\3\2\2\2\u01fd\u01fe\7@\2"+
		"\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\bO\2\2\u0200\u00a0\3\2\2\2\u0201\u0202"+
		"\7$\2\2\u0202\u0203\3\2\2\2\u0203\u0204\bP\35\2\u0204\u0205\bP\3\2\u0205"+
		"\u00a2\3\2\2\2\u0206\u0208\t\2\2\2\u0207\u0206\3\2\2\2\u0208\u0209\3\2"+
		"\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020c\bQ\36\2\u020c\u020d\bQ\4\2\u020d\u00a4\3\2\2\2\u020e\u020f\7c\2"+
		"\2\u020f\u0210\7p\2\2\u0210\u0211\7f\2\2\u0211\u00a6\3\2\2\2\u0212\u0213"+
		"\7q\2\2\u0213\u0214\7t\2\2\u0214\u00a8\3\2\2\2\u0215\u0216\7p\2\2\u0216"+
		"\u0217\7q\2\2\u0217\u0218\7v\2\2\u0218\u00aa\3\2\2\2\u0219\u021b\7a\2"+
		"\2\u021a\u0219\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d"+
		"\3\2\2\2\u021d\u021f\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0223\4c|\2\u0220"+
		"\u0222\t\5\2\2\u0221\u0220\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2"+
		"\2\2\u0223\u0224\3\2\2\2\u0224\u00ac\3\2\2\2\u0225\u0223\3\2\2\2\u0226"+
		"\u022f\7\62\2\2\u0227\u022b\4\63;\2\u0228\u022a\4\62;\2\u0229\u0228\3"+
		"\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c"+
		"\u022f\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u0226\3\2\2\2\u022e\u0227\3\2"+
		"\2\2\u022f\u00ae\3\2\2\2\u0230\u0231\7d\2\2\u0231\u0232\7{\2\2\u0232\u0233"+
		"\7v\2\2\u0233\u0254\7g\2\2\u0234\u0235\7k\2\2\u0235\u0236\7p\2\2\u0236"+
		"\u0254\7v\2\2\u0237\u0238\7n\2\2\u0238\u0239\7q\2\2\u0239\u023a\7p\2\2"+
		"\u023a\u0254\7i\2\2\u023b\u023c\7d\2\2\u023c\u023d\7q\2\2\u023d\u023e"+
		"\7q\2\2\u023e\u0254\7n\2\2\u023f\u0240\7e\2\2\u0240\u0241\7j\2\2\u0241"+
		"\u0242\7c\2\2\u0242\u0254\7t\2\2\u0243\u0244\7h\2\2\u0244\u0245\7n\2\2"+
		"\u0245\u0246\7q\2\2\u0246\u0247\7c\2\2\u0247\u0254\7v\2\2\u0248\u0249"+
		"\7f\2\2\u0249\u024a\7q\2\2\u024a\u024b\7w\2\2\u024b\u024c\7d\2\2\u024c"+
		"\u024d\7n\2\2\u024d\u0254\7g\2\2\u024e\u024f\7u\2\2\u024f\u0250\7j\2\2"+
		"\u0250\u0251\7q\2\2\u0251\u0252\7t\2\2\u0252\u0254\7v\2\2\u0253\u0230"+
		"\3\2\2\2\u0253\u0234\3\2\2\2\u0253\u0237\3\2\2\2\u0253\u023b\3\2\2\2\u0253"+
		"\u023f\3\2\2\2\u0253\u0243\3\2\2\2\u0253\u0248\3\2\2\2\u0253\u024e\3\2"+
		"\2\2\u0254\u00b0\3\2\2\2\u0255\u0256\7u\2\2\u0256\u0257\7v\2\2\u0257\u0258"+
		"\7t\2\2\u0258\u0259\7k\2\2\u0259\u025a\7p\2\2\u025a\u0260\7i\2\2\u025b"+
		"\u025c\7x\2\2\u025c\u025d\7q\2\2\u025d\u025e\7k\2\2\u025e\u0260\7f\2\2"+
		"\u025f\u0255\3\2\2\2\u025f\u025b\3\2\2\2\u0260\u00b2\3\2\2\2\u0261\u0262"+
		"\7W\2\2\u0262\u0263\7K\2\2\u0263\u0264\7p\2\2\u0264\u0265\7v\2\2\u0265"+
		"\u00b4\3\2\2\2\u0266\u0267\t\6\2\2\u0267\u00b6\3\2\2\2\u0268\u0269\7\u0080"+
		"\2\2\u0269\u026a\6[\2\2\u026a\u00b8\3\2\2\2\22\2\3\4\u0152\u0157\u0161"+
		"\u016f\u017b\u017d\u0209\u021c\u0223\u022b\u022e\u0253\u025f\37\t\3\2"+
		"\7\3\2\2\4\2\2\5\2\6\2\2\7\4\2\t\'\2\t(\2\t\13\2\t\f\2\t\17\2\t\20\2\t"+
		"\21\2\t\33\2\t\65\2\t\67\2\t*\2\t\30\2\t\22\2\t\23\2\t\26\2\t\27\2\t#"+
		"\2\t$\2\t%\2\t&\2\t\31\2\t+\2\t,\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}