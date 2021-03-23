package CryptUtilities.gen;// Generated from C:/Users/user/IdeaProjects/Crypt/src/main/java\CryptLexer.g4 by ANTLR 4.9.1
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
		RSQUARE=21, COMMA=22, POINT=23, COLON=24, SEMICOLON=25, Q_MARK=26, EQUAL=27, 
		DIFFERENT=28, LESSEQ=29, MOREEQ=30, LESS_THAN=31, MORE_THAN=32, ASSIGNMENT=33, 
		ASTERISK=34, SLASH=35, PLUS=36, MINUS=37, PRIMITIVE_TYPE=38, BASIC_TYPE=39, 
		TYPE_ID=40, INT=41, STRING_START=42, WS=43, NL=44, COMMENT=45, LINE_COMMENT=46, 
		STRING_STOP=47, STRING_CONTENT=48, INTERPOLATION_START=49, INTERPOLATION_END=50, 
		FUNC_KW=51, ELSE_KW=52, F_BOOLEAN=53, FIELD_KW=54, VALUE_ID=55, F_AND=56, 
		F_OR=57, F_NOT=58, F_INT=59, F_DECIMAL=60, F_PRIMITIVE_TYPE=61, F_OBJECT_TYPE=62, 
		F_BASIC_TYPE=63;
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
			"Q_MARK", "SEMICOLON", "EQUAL", "DIFFERENT", "LESSEQ", "LESS_THAN", "MOREEQ", 
			"MORE_THAN", "ASSIGNMENT", "ASTERISK", "SLASH", "PLUS", "MINUS", "PRIMITIVE_TYPE", 
			"BASIC_TYPE", "VALUE_ID", "INT", "STRING_START", "WS", "NL", "COMMENT", 
			"LINE_COMMENT", "STRING_STOP", "STRING_CONTENT", "INTERPOLATION_START", 
			"INTERPOLATION_END", "I_PRIMITIVE_TYPE", "I_BASIC_TYPE", "I_FALSE_KW", 
			"I_TRUE_KW", "I_AND_KW", "I_OR_KW", "I_NOT_KW", "I_IF_KW", "I_ELSE_KW", 
			"I_VALUE_ID", "I_INT", "I_COMMA", "I_LPAREN", "I_RPAREN", "I_LSQUARE", 
			"I_RSQUARE", "I_ASTERISK", "I_SLASH", "I_PLUS", "I_MINUS", "I_POINT", 
			"I_EQUAL", "I_DIFFERENT", "I_LESSEQ", "I_LESS", "I_MOREEQ", "I_MORE", 
			"I_STRING_START", "I_WS", "F_AND", "F_OR", "F_NOT", "F_VALUE_ID", "F_INT", 
			"F_DECIMAL", "F_PRIMITIVE_TYPE", "F_OBJECT_TYPE", "F_BOOLEAN", "F_BASIC_TYPE", 
			"ESCAPE_SEQUENCE", "TILDE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'val'", "'println'", "'print'", "'to'", "'import'", "'void'", 
			"'return'", null, null, "'super'", "'for'", null, null, null, null, null, 
			"'{'", null, null, null, null, null, "':'", "';'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "'~{'", null, "'fn'", 
			null, null, "'field'", null, "'and'", "'or'", "'not'", null, null, null, 
			null, "'UInt'"
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
			"FUNC_KW", "ELSE_KW", "F_BOOLEAN", "FIELD_KW", "VALUE_ID", "F_AND", "F_OR", 
			"F_NOT", "F_INT", "F_DECIMAL", "F_PRIMITIVE_TYPE", "F_OBJECT_TYPE", "F_BASIC_TYPE"
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
		case 92:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u028c\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3."+
		"\6.\u0159\n.\r.\16.\u015a\3.\3.\3/\5/\u0160\n/\3/\3/\3\60\3\60\3\60\3"+
		"\60\7\60\u0168\n\60\f\60\16\60\u016b\13\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\7\61\u0176\n\61\f\61\16\61\u0179\13\61\3\61\3\61\3"+
		"\62\3\62\3\62\3\62\3\63\3\63\3\63\6\63\u0184\n\63\r\63\16\63\u0185\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3"+
		";\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3"+
		"@\3@\3@\3@\3A\3A\3A\3A\3B\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3"+
		"E\3F\3F\3F\3F\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3I\3J\3J\3J\3J\3K\3K\3"+
		"K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3N\3N\3N\3N\3O\3O\3O\3O\3O\3P\3P\3"+
		"P\3P\3Q\3Q\3Q\3Q\3Q\3R\6R\u0210\nR\rR\16R\u0211\3R\3R\3R\3S\3S\3S\3S\3"+
		"T\3T\3T\3U\3U\3U\3U\3V\7V\u0223\nV\fV\16V\u0226\13V\3V\3V\7V\u022a\nV"+
		"\fV\16V\u022d\13V\3W\3W\3W\7W\u0232\nW\fW\16W\u0235\13W\5W\u0237\nW\3"+
		"X\3X\3X\7X\u023c\nX\fX\16X\u023f\13X\5X\u0241\nX\3X\3X\3X\3X\7X\u0247"+
		"\nX\fX\16X\u024a\13X\5X\u024c\nX\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3"+
		"Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5"+
		"Y\u0271\nY\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u027d\nZ\3[\3[\5[\u0281\n"+
		"[\3\\\3\\\3\\\3\\\3\\\3]\3]\3^\3^\3^\3\u0169\2_\5\4\78\t\5\13\6\r\7\17"+
		"\b\21\t\23\n\25\13\27\f\31\r\33\16\35\65\37\66!\17#\20%\21\'\22)\23+\24"+
		"-\25/\26\61\27\63\30\65\31\67\329\34;\33=\35?\36A\37C!E G\"I#K$M%O&Q\'"+
		"S(U)W9Y+[,]-_.a/c\60e\61g\62i\63k\64m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2"+
		"\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091"+
		"\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\2\u00a3"+
		"\2\u00a5\2\u00a7:\u00a9;\u00ab<\u00ad\2\u00af=\u00b1>\u00b3?\u00b5@\u00b7"+
		"\67\u00b9A\u00bb\2\u00bd\2\5\2\3\4\7\4\2\"\"vv\4\2pptt\4\2$$\u0080\u0080"+
		"\6\2\62;C\\aac|\6\2$$ppttvv\2\u029f\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\3g\3\2\2\2\3i\3\2\2"+
		"\2\4k\3\2\2\2\4m\3\2\2\2\4o\3\2\2\2\4q\3\2\2\2\4s\3\2\2\2\4u\3\2\2\2\4"+
		"w\3\2\2\2\4y\3\2\2\2\4{\3\2\2\2\4}\3\2\2\2\4\177\3\2\2\2\4\u0081\3\2\2"+
		"\2\4\u0083\3\2\2\2\4\u0085\3\2\2\2\4\u0087\3\2\2\2\4\u0089\3\2\2\2\4\u008b"+
		"\3\2\2\2\4\u008d\3\2\2\2\4\u008f\3\2\2\2\4\u0091\3\2\2\2\4\u0093\3\2\2"+
		"\2\4\u0095\3\2\2\2\4\u0097\3\2\2\2\4\u0099\3\2\2\2\4\u009b\3\2\2\2\4\u009d"+
		"\3\2\2\2\4\u009f\3\2\2\2\4\u00a1\3\2\2\2\4\u00a3\3\2\2\2\4\u00a5\3\2\2"+
		"\2\4\u00a7\3\2\2\2\4\u00a9\3\2\2\2\4\u00ab\3\2\2\2\4\u00af\3\2\2\2\4\u00b1"+
		"\3\2\2\2\4\u00b3\3\2\2\2\4\u00b5\3\2\2\2\4\u00b7\3\2\2\2\4\u00b9\3\2\2"+
		"\2\5\u00bf\3\2\2\2\7\u00c3\3\2\2\2\t\u00c9\3\2\2\2\13\u00d1\3\2\2\2\r"+
		"\u00d7\3\2\2\2\17\u00da\3\2\2\2\21\u00e1\3\2\2\2\23\u00e6\3\2\2\2\25\u00ed"+
		"\3\2\2\2\27\u00f3\3\2\2\2\31\u00f8\3\2\2\2\33\u00fe\3\2\2\2\35\u0102\3"+
		"\2\2\2\37\u0105\3\2\2\2!\u010a\3\2\2\2#\u010c\3\2\2\2%\u010e\3\2\2\2\'"+
		"\u0110\3\2\2\2)\u0112\3\2\2\2+\u0114\3\2\2\2-\u0116\3\2\2\2/\u0118\3\2"+
		"\2\2\61\u011a\3\2\2\2\63\u011c\3\2\2\2\65\u011e\3\2\2\2\67\u0120\3\2\2"+
		"\29\u0122\3\2\2\2;\u0124\3\2\2\2=\u0126\3\2\2\2?\u012a\3\2\2\2A\u012f"+
		"\3\2\2\2C\u0134\3\2\2\2E\u0138\3\2\2\2G\u013d\3\2\2\2I\u0141\3\2\2\2K"+
		"\u0143\3\2\2\2M\u0145\3\2\2\2O\u0147\3\2\2\2Q\u0149\3\2\2\2S\u014b\3\2"+
		"\2\2U\u014d\3\2\2\2W\u014f\3\2\2\2Y\u0151\3\2\2\2[\u0153\3\2\2\2]\u0158"+
		"\3\2\2\2_\u015f\3\2\2\2a\u0163\3\2\2\2c\u0171\3\2\2\2e\u017c\3\2\2\2g"+
		"\u0183\3\2\2\2i\u0187\3\2\2\2k\u018c\3\2\2\2m\u0190\3\2\2\2o\u0194\3\2"+
		"\2\2q\u0198\3\2\2\2s\u01a0\3\2\2\2u\u01a7\3\2\2\2w\u01ab\3\2\2\2y\u01af"+
		"\3\2\2\2{\u01b3\3\2\2\2}\u01b7\3\2\2\2\177\u01be\3\2\2\2\u0081\u01c2\3"+
		"\2\2\2\u0083\u01c6\3\2\2\2\u0085\u01ca\3\2\2\2\u0087\u01ce\3\2\2\2\u0089"+
		"\u01d2\3\2\2\2\u008b\u01d6\3\2\2\2\u008d\u01da\3\2\2\2\u008f\u01de\3\2"+
		"\2\2\u0091\u01e2\3\2\2\2\u0093\u01e6\3\2\2\2\u0095\u01ea\3\2\2\2\u0097"+
		"\u01ee\3\2\2\2\u0099\u01f2\3\2\2\2\u009b\u01f7\3\2\2\2\u009d\u01fc\3\2"+
		"\2\2\u009f\u0200\3\2\2\2\u00a1\u0205\3\2\2\2\u00a3\u0209\3\2\2\2\u00a5"+
		"\u020f\3\2\2\2\u00a7\u0216\3\2\2\2\u00a9\u021a\3\2\2\2\u00ab\u021d\3\2"+
		"\2\2\u00ad\u0224\3\2\2\2\u00af\u0236\3\2\2\2\u00b1\u0240\3\2\2\2\u00b3"+
		"\u0270\3\2\2\2\u00b5\u027c\3\2\2\2\u00b7\u0280\3\2\2\2\u00b9\u0282\3\2"+
		"\2\2\u00bb\u0287\3\2\2\2\u00bd\u0289\3\2\2\2\u00bf\u00c0\7x\2\2\u00c0"+
		"\u00c1\7c\2\2\u00c1\u00c2\7n\2\2\u00c2\6\3\2\2\2\u00c3\u00c4\7h\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7f\2\2"+
		"\u00c8\b\3\2\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7k"+
		"\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0"+
		"\7p\2\2\u00d0\n\3\2\2\2\u00d1\u00d2\7r\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7v\2\2\u00d6\f\3\2\2\2\u00d7\u00d8"+
		"\7v\2\2\u00d8\u00d9\7q\2\2\u00d9\16\3\2\2\2\u00da\u00db\7k\2\2\u00db\u00dc"+
		"\7o\2\2\u00dc\u00dd\7r\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7t\2\2\u00df"+
		"\u00e0\7v\2\2\u00e0\20\3\2\2\2\u00e1\u00e2\7x\2\2\u00e2\u00e3\7q\2\2\u00e3"+
		"\u00e4\7k\2\2\u00e4\u00e5\7f\2\2\u00e5\22\3\2\2\2\u00e6\u00e7\7t\2\2\u00e7"+
		"\u00e8\7g\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7w\2\2\u00ea\u00eb\7t\2\2"+
		"\u00eb\u00ec\7p\2\2\u00ec\24\3\2\2\2\u00ed\u00ee\7h\2\2\u00ee\u00ef\7"+
		"c\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7g\2\2\u00f2\26"+
		"\3\2\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7t\2\2\u00f5\u00f6\7w\2\2\u00f6"+
		"\u00f7\7g\2\2\u00f7\30\3\2\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7w\2\2\u00fa"+
		"\u00fb\7r\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7t\2\2\u00fd\32\3\2\2\2\u00fe"+
		"\u00ff\7h\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7t\2\2\u0101\34\3\2\2\2\u0102"+
		"\u0103\7h\2\2\u0103\u0104\7p\2\2\u0104\36\3\2\2\2\u0105\u0106\7g\2\2\u0106"+
		"\u0107\7n\2\2\u0107\u0108\7u\2\2\u0108\u0109\7g\2\2\u0109 \3\2\2\2\u010a"+
		"\u010b\5\u00a7S\2\u010b\"\3\2\2\2\u010c\u010d\5\u00a9T\2\u010d$\3\2\2"+
		"\2\u010e\u010f\5\u00abU\2\u010f&\3\2\2\2\u0110\u0111\7*\2\2\u0111(\3\2"+
		"\2\2\u0112\u0113\7+\2\2\u0113*\3\2\2\2\u0114\u0115\7}\2\2\u0115,\3\2\2"+
		"\2\u0116\u0117\7\177\2\2\u0117.\3\2\2\2\u0118\u0119\7]\2\2\u0119\60\3"+
		"\2\2\2\u011a\u011b\7_\2\2\u011b\62\3\2\2\2\u011c\u011d\7.\2\2\u011d\64"+
		"\3\2\2\2\u011e\u011f\7\60\2\2\u011f\66\3\2\2\2\u0120\u0121\7<\2\2\u0121"+
		"8\3\2\2\2\u0122\u0123\7A\2\2\u0123:\3\2\2\2\u0124\u0125\7=\2\2\u0125<"+
		"\3\2\2\2\u0126\u0127\7?\2\2\u0127\u0128\3\2\2\2\u0128\u0129\b\36\2\2\u0129"+
		">\3\2\2\2\u012a\u012b\7#\2\2\u012b\u012c\7?\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\b\37\2\2\u012e@\3\2\2\2\u012f\u0130\7>\2\2\u0130\u0131\7?\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0133\b \2\2\u0133B\3\2\2\2\u0134\u0135\7>\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0137\b!\2\2\u0137D\3\2\2\2\u0138\u0139\7@\2\2\u0139"+
		"\u013a\7?\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b\"\2\2\u013cF\3\2\2\2\u013d"+
		"\u013e\7@\2\2\u013e\u013f\3\2\2\2\u013f\u0140\b#\2\2\u0140H\3\2\2\2\u0141"+
		"\u0142\5\67\33\2\u0142J\3\2\2\2\u0143\u0144\7,\2\2\u0144L\3\2\2\2\u0145"+
		"\u0146\7\61\2\2\u0146N\3\2\2\2\u0147\u0148\7-\2\2\u0148P\3\2\2\2\u0149"+
		"\u014a\7/\2\2\u014aR\3\2\2\2\u014b\u014c\5\u00b3Y\2\u014cT\3\2\2\2\u014d"+
		"\u014e\5\u00b9\\\2\u014eV\3\2\2\2\u014f\u0150\5\u00adV\2\u0150X\3\2\2"+
		"\2\u0151\u0152\5\u00afW\2\u0152Z\3\2\2\2\u0153\u0154\7$\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u0156\b-\3\2\u0156\\\3\2\2\2\u0157\u0159\t\2\2\2\u0158"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b.\4\2\u015d^\3\2\2\2\u015e\u0160"+
		"\7t\2\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0162\7p\2\2\u0162`\3\2\2\2\u0163\u0164\7\61\2\2\u0164\u0165\7,\2\2\u0165"+
		"\u0169\3\2\2\2\u0166\u0168\13\2\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3"+
		"\2\2\2\u0169\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c\3\2\2\2\u016b"+
		"\u0169\3\2\2\2\u016c\u016d\7,\2\2\u016d\u016e\7\61\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0170\b\60\5\2\u0170b\3\2\2\2\u0171\u0172\7\61\2\2\u0172\u0173"+
		"\7\61\2\2\u0173\u0177\3\2\2\2\u0174\u0176\n\3\2\2\u0175\u0174\3\2\2\2"+
		"\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a"+
		"\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\b\61\5\2\u017bd\3\2\2\2\u017c"+
		"\u017d\7$\2\2\u017d\u017e\3\2\2\2\u017e\u017f\b\62\6\2\u017ff\3\2\2\2"+
		"\u0180\u0184\n\4\2\2\u0181\u0184\5\u00bb]\2\u0182\u0184\5\u00bd^\2\u0183"+
		"\u0180\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2"+
		"\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186h\3\2\2\2\u0187\u0188"+
		"\7\u0080\2\2\u0188\u0189\7}\2\2\u0189\u018a\3\2\2\2\u018a\u018b\b\64\7"+
		"\2\u018bj\3\2\2\2\u018c\u018d\7\177\2\2\u018d\u018e\3\2\2\2\u018e\u018f"+
		"\b\65\6\2\u018fl\3\2\2\2\u0190\u0191\5\u00b3Y\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0193\b\66\b\2\u0193n\3\2\2\2\u0194\u0195\5\u00b9\\\2\u0195\u0196\3\2"+
		"\2\2\u0196\u0197\b\67\t\2\u0197p\3\2\2\2\u0198\u0199\7h\2\2\u0199\u019a"+
		"\7c\2\2\u019a\u019b\7n\2\2\u019b\u019c\7u\2\2\u019c\u019d\7g\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019f\b8\n\2\u019fr\3\2\2\2\u01a0\u01a1\7v\2\2\u01a1"+
		"\u01a2\7t\2\2\u01a2\u01a3\7w\2\2\u01a3\u01a4\7g\2\2\u01a4\u01a5\3\2\2"+
		"\2\u01a5\u01a6\b9\13\2\u01a6t\3\2\2\2\u01a7\u01a8\5\u00a7S\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01aa\b:\f\2\u01aav\3\2\2\2\u01ab\u01ac\5\u00a9T\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01ae\b;\r\2\u01aex\3\2\2\2\u01af\u01b0\5\u00abU"+
		"\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\b<\16\2\u01b2z\3\2\2\2\u01b3\u01b4"+
		"\7A\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\b=\17\2\u01b6|\3\2\2\2\u01b7\u01b8"+
		"\7g\2\2\u01b8\u01b9\7n\2\2\u01b9\u01ba\7u\2\2\u01ba\u01bb\7g\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\b>\20\2\u01bd~\3\2\2\2\u01be\u01bf\5\u00ad"+
		"V\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\b?\21\2\u01c1\u0080\3\2\2\2\u01c2"+
		"\u01c3\5\u00afW\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\b@\22\2\u01c5\u0082"+
		"\3\2\2\2\u01c6\u01c7\7.\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\bA\23\2\u01c9"+
		"\u0084\3\2\2\2\u01ca\u01cb\7*\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\bB\24"+
		"\2\u01cd\u0086\3\2\2\2\u01ce\u01cf\7+\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1"+
		"\bC\25\2\u01d1\u0088\3\2\2\2\u01d2\u01d3\7]\2\2\u01d3\u01d4\3\2\2\2\u01d4"+
		"\u01d5\bD\26\2\u01d5\u008a\3\2\2\2\u01d6\u01d7\7_\2\2\u01d7\u01d8\3\2"+
		"\2\2\u01d8\u01d9\bE\27\2\u01d9\u008c\3\2\2\2\u01da\u01db\7,\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01dd\bF\30\2\u01dd\u008e\3\2\2\2\u01de\u01df\7\61"+
		"\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\bG\31\2\u01e1\u0090\3\2\2\2\u01e2"+
		"\u01e3\7-\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\bH\32\2\u01e5\u0092\3\2"+
		"\2\2\u01e6\u01e7\7/\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\bI\33\2\u01e9"+
		"\u0094\3\2\2\2\u01ea\u01eb\7\60\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\b"+
		"J\34\2\u01ed\u0096\3\2\2\2\u01ee\u01ef\7?\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f1\bK\2\2\u01f1\u0098\3\2\2\2\u01f2\u01f3\7#\2\2\u01f3\u01f4\7?\2"+
		"\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\bL\2\2\u01f6\u009a\3\2\2\2\u01f7\u01f8"+
		"\7>\2\2\u01f8\u01f9\7?\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\bM\2\2\u01fb"+
		"\u009c\3\2\2\2\u01fc\u01fd\7>\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\bN\2"+
		"\2\u01ff\u009e\3\2\2\2\u0200\u0201\7@\2\2\u0201\u0202\7?\2\2\u0202\u0203"+
		"\3\2\2\2\u0203\u0204\bO\2\2\u0204\u00a0\3\2\2\2\u0205\u0206\7@\2\2\u0206"+
		"\u0207\3\2\2\2\u0207\u0208\bP\2\2\u0208\u00a2\3\2\2\2\u0209\u020a\7$\2"+
		"\2\u020a\u020b\3\2\2\2\u020b\u020c\bQ\35\2\u020c\u020d\bQ\3\2\u020d\u00a4"+
		"\3\2\2\2\u020e\u0210\t\2\2\2\u020f\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211"+
		"\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\bR"+
		"\36\2\u0214\u0215\bR\4\2\u0215\u00a6\3\2\2\2\u0216\u0217\7c\2\2\u0217"+
		"\u0218\7p\2\2\u0218\u0219\7f\2\2\u0219\u00a8\3\2\2\2\u021a\u021b\7q\2"+
		"\2\u021b\u021c\7t\2\2\u021c\u00aa\3\2\2\2\u021d\u021e\7p\2\2\u021e\u021f"+
		"\7q\2\2\u021f\u0220\7v\2\2\u0220\u00ac\3\2\2\2\u0221\u0223\7a\2\2\u0222"+
		"\u0221\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2"+
		"\2\2\u0225\u0227\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u022b\4c|\2\u0228\u022a"+
		"\t\5\2\2\u0229\u0228\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b"+
		"\u022c\3\2\2\2\u022c\u00ae\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u0237\7\62"+
		"\2\2\u022f\u0233\4\63;\2\u0230\u0232\4\62;\2\u0231\u0230\3\2\2\2\u0232"+
		"\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0237\3\2"+
		"\2\2\u0235\u0233\3\2\2\2\u0236\u022e\3\2\2\2\u0236\u022f\3\2\2\2\u0237"+
		"\u00b0\3\2\2\2\u0238\u0241\7\62\2\2\u0239\u023d\4\63;\2\u023a\u023c\4"+
		"\62;\2\u023b\u023a\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023d"+
		"\u023e\3\2\2\2\u023e\u0241\3\2\2\2\u023f\u023d\3\2\2\2\u0240\u0238\3\2"+
		"\2\2\u0240\u0239\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u024b\7\60\2\2\u0243"+
		"\u024c\7\62\2\2\u0244\u0248\4\63;\2\u0245\u0247\4\62;\2\u0246\u0245\3"+
		"\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u0243\3\2\2\2\u024b\u0244\3\2"+
		"\2\2\u024c\u00b2\3\2\2\2\u024d\u024e\7d\2\2\u024e\u024f\7{\2\2\u024f\u0250"+
		"\7v\2\2\u0250\u0271\7g\2\2\u0251\u0252\7k\2\2\u0252\u0253\7p\2\2\u0253"+
		"\u0271\7v\2\2\u0254\u0255\7n\2\2\u0255\u0256\7q\2\2\u0256\u0257\7p\2\2"+
		"\u0257\u0271\7i\2\2\u0258\u0259\7d\2\2\u0259\u025a\7q\2\2\u025a\u025b"+
		"\7q\2\2\u025b\u0271\7n\2\2\u025c\u025d\7e\2\2\u025d\u025e\7j\2\2\u025e"+
		"\u025f\7c\2\2\u025f\u0271\7t\2\2\u0260\u0261\7h\2\2\u0261\u0262\7n\2\2"+
		"\u0262\u0263\7q\2\2\u0263\u0264\7c\2\2\u0264\u0271\7v\2\2\u0265\u0266"+
		"\7f\2\2\u0266\u0267\7q\2\2\u0267\u0268\7w\2\2\u0268\u0269\7d\2\2\u0269"+
		"\u026a\7n\2\2\u026a\u0271\7g\2\2\u026b\u026c\7u\2\2\u026c\u026d\7j\2\2"+
		"\u026d\u026e\7q\2\2\u026e\u026f\7t\2\2\u026f\u0271\7v\2\2\u0270\u024d"+
		"\3\2\2\2\u0270\u0251\3\2\2\2\u0270\u0254\3\2\2\2\u0270\u0258\3\2\2\2\u0270"+
		"\u025c\3\2\2\2\u0270\u0260\3\2\2\2\u0270\u0265\3\2\2\2\u0270\u026b\3\2"+
		"\2\2\u0271\u00b4\3\2\2\2\u0272\u0273\7u\2\2\u0273\u0274\7v\2\2\u0274\u0275"+
		"\7t\2\2\u0275\u0276\7k\2\2\u0276\u0277\7p\2\2\u0277\u027d\7i\2\2\u0278"+
		"\u0279\7x\2\2\u0279\u027a\7q\2\2\u027a\u027b\7k\2\2\u027b\u027d\7f\2\2"+
		"\u027c\u0272\3\2\2\2\u027c\u0278\3\2\2\2\u027d\u00b6\3\2\2\2\u027e\u0281"+
		"\5\27\13\2\u027f\u0281\5\25\n\2\u0280\u027e\3\2\2\2\u0280\u027f\3\2\2"+
		"\2\u0281\u00b8\3\2\2\2\u0282\u0283\7W\2\2\u0283\u0284\7K\2\2\u0284\u0285"+
		"\7p\2\2\u0285\u0286\7v\2\2\u0286\u00ba\3\2\2\2\u0287\u0288\t\6\2\2\u0288"+
		"\u00bc\3\2\2\2\u0289\u028a\7\u0080\2\2\u028a\u028b\6^\2\2\u028b\u00be"+
		"\3\2\2\2\27\2\3\4\u015a\u015f\u0169\u0177\u0183\u0185\u0211\u0224\u022b"+
		"\u0233\u0236\u023d\u0240\u0248\u024b\u0270\u027c\u0280\37\t\3\2\7\3\2"+
		"\2\4\2\2\5\2\6\2\2\7\4\2\t(\2\t)\2\t\13\2\t\f\2\t\17\2\t\20\2\t\21\2\t"+
		"\34\2\t\66\2\t9\2\t+\2\t\30\2\t\22\2\t\23\2\t\26\2\t\27\2\t$\2\t%\2\t"+
		"&\2\t\'\2\t\31\2\t,\2\t-\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}