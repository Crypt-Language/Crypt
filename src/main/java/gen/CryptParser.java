package gen;// Generated from C:/Users/user/IdeaProjects/Crypt/src/main/java\CryptParser.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CryptParser extends Parser {
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
		RULE_fileUnit = 0, RULE_fileBody = 1, RULE_field = 2, RULE_function = 3, 
		RULE_type = 4, RULE_name = 5, RULE_functionName = 6, RULE_block = 7, RULE_statement = 8, 
		RULE_printlnStatement = 9, RULE_printStatement = 10, RULE_variableDeclaration = 11, 
		RULE_identifier = 12, RULE_variableReference = 13, RULE_expression = 14, 
		RULE_value = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"fileUnit", "fileBody", "field", "function", "type", "name", "functionName", 
			"block", "statement", "printlnStatement", "printStatement", "variableDeclaration", 
			"identifier", "variableReference", "expression", "value"
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

	@Override
	public String getGrammarFileName() { return "CryptParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CryptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileUnitContext extends ParserRuleContext {
		public FileBodyContext fileBody() {
			return getRuleContext(FileBodyContext.class,0);
		}
		public FileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterFileUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitFileUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitFileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileUnitContext fileUnit() throws RecognitionException {
		FileUnitContext _localctx = new FileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fileUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			fileBody();
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

	public static class FileBodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterFileBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitFileBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitFileBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileBodyContext fileBody() throws RecognitionException {
		FileBodyContext _localctx = new FileBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fileBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINTLN_KW) | (1L << PRINT_KW) | (1L << LBRACKET) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0)) {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			type();
			setState(41);
			name();
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNC_KW() { return getToken(CryptParser.FUNC_KW, 0); }
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(FUNC_KW);
			setState(44);
			functionName();
			setState(45);
			match(LPAREN);
			setState(46);
			match(RPAREN);
			setState(47);
			block();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode F_PRIMITIVE_TYPE() { return getToken(CryptParser.F_PRIMITIVE_TYPE, 0); }
		public TerminalNode F_OBJECT_TYPE() { return getToken(CryptParser.F_OBJECT_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==F_PRIMITIVE_TYPE || _la==F_OBJECT_TYPE) ) {
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode VALUE_ID() { return getToken(CryptParser.VALUE_ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(VALUE_ID);
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

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode VALUE_ID() { return getToken(CryptParser.VALUE_ID, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(VALUE_ID);
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleStatementBlockContext extends BlockContext {
		public TerminalNode BLOCK_OP() { return getToken(CryptParser.BLOCK_OP, 0); }
		public TerminalNode WS() { return getToken(CryptParser.WS, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SingleStatementBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterSingleStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitSingleStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitSingleStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiStatementBlockContext extends BlockContext {
		public TerminalNode BLOCK_OP() { return getToken(CryptParser.BLOCK_OP, 0); }
		public TerminalNode NL() { return getToken(CryptParser.NL, 0); }
		public TerminalNode WS() { return getToken(CryptParser.WS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MultiStatementBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterMultiStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitMultiStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitMultiStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new MultiStatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(BLOCK_OP);
				setState(56);
				match(NL);
				setState(57);
				match(WS);
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(58);
					statement();
					}
					}
					setState(61); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINTLN_KW) | (1L << PRINT_KW) | (1L << LBRACKET) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0) );
				}
				break;
			case 2:
				_localctx = new SingleStatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(BLOCK_OP);
				setState(64);
				match(WS);
				setState(65);
				statement();
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
		public PrintlnStatementContext printlnStatement() {
			return getRuleContext(PrintlnStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(CryptParser.COMMENT, 0); }
		public TerminalNode LINE_COMMENT() { return getToken(CryptParser.LINE_COMMENT, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINTLN_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				printlnStatement();
				}
				break;
			case PRINT_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				printStatement();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				variableDeclaration();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				match(COMMENT);
				}
				break;
			case LINE_COMMENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				match(LINE_COMMENT);
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

	public static class PrintlnStatementContext extends ParserRuleContext {
		public TerminalNode PRINTLN_KW() { return getToken(CryptParser.PRINTLN_KW, 0); }
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CryptParser.SEMICOLON, 0); }
		public PrintlnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printlnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterPrintlnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitPrintlnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitPrintlnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintlnStatementContext printlnStatement() throws RecognitionException {
		PrintlnStatementContext _localctx = new PrintlnStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printlnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(PRINTLN_KW);
			setState(76);
			match(LPAREN);
			setState(77);
			expression(0);
			setState(78);
			match(RPAREN);
			setState(79);
			match(SEMICOLON);
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

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT_KW() { return getToken(CryptParser.PRINT_KW, 0); }
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(CryptParser.SEMICOLON, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(PRINT_KW);
			setState(82);
			match(LPAREN);
			setState(83);
			expression(0);
			setState(84);
			match(RPAREN);
			setState(85);
			match(SEMICOLON);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(CryptParser.LBRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(CryptParser.RBRACKET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CryptParser.SEMICOLON, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(LBRACKET);
			setState(88);
			type();
			setState(89);
			match(RBRACKET);
			setState(90);
			identifier();
			setState(91);
			match(SEMICOLON);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode VALUE_ID() { return getToken(CryptParser.VALUE_ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(VALUE_ID);
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

	public static class VariableReferenceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitVariableReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			identifier();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CryptParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CryptParser.WS, i);
		}
		public TerminalNode PLUS() { return getToken(CryptParser.PLUS, 0); }
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public AddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExprContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitValueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CryptParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CryptParser.WS, i);
		}
		public TerminalNode SLASH() { return getToken(CryptParser.SLASH, 0); }
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public DivideContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarReferenceContext extends ExpressionContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public VarReferenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterVarReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitVarReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitVarReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CryptParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CryptParser.WS, i);
		}
		public TerminalNode ASTERISK() { return getToken(CryptParser.ASTERISK, 0); }
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public MultiplyContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalExpressionContext extends ExpressionContext {
		public Token cmp;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MORE_THAN() { return getToken(CryptParser.MORE_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(CryptParser.LESS_THAN, 0); }
		public TerminalNode EQUAL() { return getToken(CryptParser.EQUAL, 0); }
		public TerminalNode DIFFERENT() { return getToken(CryptParser.DIFFERENT, 0); }
		public TerminalNode MOREEQ() { return getToken(CryptParser.MOREEQ, 0); }
		public TerminalNode LESSEQ() { return getToken(CryptParser.LESSEQ, 0); }
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(CryptParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CryptParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CryptParser.WS, i);
		}
		public TerminalNode MINUS() { return getToken(CryptParser.MINUS, 0); }
		public TerminalNode RPAREN() { return getToken(CryptParser.RPAREN, 0); }
		public SubtractContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitSubtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new VarReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				variableReference();
				}
				break;
			case 2:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				value();
				}
				break;
			case 3:
				{
				_localctx = new MultiplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(LPAREN);
				setState(101);
				expression(0);
				setState(102);
				match(WS);
				setState(103);
				match(ASTERISK);
				setState(104);
				match(WS);
				setState(105);
				expression(0);
				setState(106);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new DivideContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(LPAREN);
				setState(109);
				expression(0);
				setState(110);
				match(WS);
				setState(111);
				match(SLASH);
				setState(112);
				match(WS);
				setState(113);
				expression(0);
				setState(114);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new AddContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(LPAREN);
				setState(117);
				expression(0);
				setState(118);
				match(WS);
				setState(119);
				match(PLUS);
				setState(120);
				match(WS);
				setState(121);
				expression(0);
				setState(122);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SubtractContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(LPAREN);
				setState(125);
				expression(0);
				setState(126);
				match(WS);
				setState(127);
				match(MINUS);
				setState(128);
				match(WS);
				setState(129);
				expression(0);
				setState(130);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplyContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(135);
						match(WS);
						setState(136);
						match(ASTERISK);
						setState(137);
						match(WS);
						setState(138);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new DivideContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(140);
						match(WS);
						setState(141);
						match(SLASH);
						setState(142);
						match(WS);
						setState(143);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new AddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(145);
						match(WS);
						setState(146);
						match(PLUS);
						setState(147);
						match(WS);
						setState(148);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new SubtractContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(150);
						match(WS);
						setState(151);
						match(MINUS);
						setState(152);
						match(WS);
						setState(153);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(155);
						((ConditionalExpressionContext)_localctx).cmp = match(MORE_THAN);
						setState(156);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(158);
						((ConditionalExpressionContext)_localctx).cmp = match(LESS_THAN);
						setState(159);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(161);
						((ConditionalExpressionContext)_localctx).cmp = match(EQUAL);
						setState(162);
						expression(5);
						}
						break;
					case 8:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(164);
						((ConditionalExpressionContext)_localctx).cmp = match(DIFFERENT);
						setState(165);
						expression(4);
						}
						break;
					case 9:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(167);
						((ConditionalExpressionContext)_localctx).cmp = match(MOREEQ);
						setState(168);
						expression(3);
						}
						break;
					case 10:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(170);
						((ConditionalExpressionContext)_localctx).cmp = match(LESSEQ);
						setState(171);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CryptParser.STRING, 0); }
		public TerminalNode INT() { return getToken(CryptParser.INT, 0); }
		public TerminalNode F_DECIMAL() { return getToken(CryptParser.F_DECIMAL, 0); }
		public TerminalNode F_BOOLEAN() { return getToken(CryptParser.F_BOOLEAN, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CryptParserListener ) ((CryptParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CryptParserVisitor ) return ((CryptParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << F_BOOLEAN) | (1L << STRING) | (1L << F_DECIMAL))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3C\u00b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\7\3&\n\3\f\3\16\3)\13\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\6\t>\n\t\r\t\16\t?\3\t\3\t\3\t\5\tE\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\5\nL\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0087\n\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00af\n\20\f\20\16\20\u00b2\13\20\3\21\3\21"+
		"\3\21\2\3\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\4\3\2AB\5\2"+
		"++\678@@\2\u00bb\2\"\3\2\2\2\4\'\3\2\2\2\6*\3\2\2\2\b-\3\2\2\2\n\63\3"+
		"\2\2\2\f\65\3\2\2\2\16\67\3\2\2\2\20D\3\2\2\2\22K\3\2\2\2\24M\3\2\2\2"+
		"\26S\3\2\2\2\30Y\3\2\2\2\32_\3\2\2\2\34a\3\2\2\2\36\u0086\3\2\2\2 \u00b3"+
		"\3\2\2\2\"#\5\4\3\2#\3\3\2\2\2$&\5\22\n\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2"+
		"\2\'(\3\2\2\2(\5\3\2\2\2)\'\3\2\2\2*+\5\n\6\2+,\5\f\7\2,\7\3\2\2\2-.\7"+
		"\65\2\2./\5\16\b\2/\60\7\22\2\2\60\61\7\23\2\2\61\62\5\20\t\2\62\t\3\2"+
		"\2\2\63\64\t\2\2\2\64\13\3\2\2\2\65\66\7;\2\2\66\r\3\2\2\2\678\7;\2\2"+
		"8\17\3\2\2\29:\79\2\2:;\7.\2\2;=\7-\2\2<>\5\22\n\2=<\3\2\2\2>?\3\2\2\2"+
		"?=\3\2\2\2?@\3\2\2\2@E\3\2\2\2AB\79\2\2BC\7-\2\2CE\5\22\n\2D9\3\2\2\2"+
		"DA\3\2\2\2E\21\3\2\2\2FL\5\24\13\2GL\5\26\f\2HL\5\30\r\2IL\7/\2\2JL\7"+
		"\60\2\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2L\23\3\2\2\2"+
		"MN\7\5\2\2NO\7\22\2\2OP\5\36\20\2PQ\7\23\2\2QR\7\33\2\2R\25\3\2\2\2ST"+
		"\7\6\2\2TU\7\22\2\2UV\5\36\20\2VW\7\23\2\2WX\7\33\2\2X\27\3\2\2\2YZ\7"+
		"\24\2\2Z[\5\n\6\2[\\\7\25\2\2\\]\5\32\16\2]^\7\33\2\2^\31\3\2\2\2_`\7"+
		";\2\2`\33\3\2\2\2ab\5\32\16\2b\35\3\2\2\2cd\b\20\1\2d\u0087\5\34\17\2"+
		"e\u0087\5 \21\2fg\7\22\2\2gh\5\36\20\2hi\7-\2\2ij\7$\2\2jk\7-\2\2kl\5"+
		"\36\20\2lm\7\23\2\2m\u0087\3\2\2\2no\7\22\2\2op\5\36\20\2pq\7-\2\2qr\7"+
		"%\2\2rs\7-\2\2st\5\36\20\2tu\7\23\2\2u\u0087\3\2\2\2vw\7\22\2\2wx\5\36"+
		"\20\2xy\7-\2\2yz\7&\2\2z{\7-\2\2{|\5\36\20\2|}\7\23\2\2}\u0087\3\2\2\2"+
		"~\177\7\22\2\2\177\u0080\5\36\20\2\u0080\u0081\7-\2\2\u0081\u0082\7\'"+
		"\2\2\u0082\u0083\7-\2\2\u0083\u0084\5\36\20\2\u0084\u0085\7\23\2\2\u0085"+
		"\u0087\3\2\2\2\u0086c\3\2\2\2\u0086e\3\2\2\2\u0086f\3\2\2\2\u0086n\3\2"+
		"\2\2\u0086v\3\2\2\2\u0086~\3\2\2\2\u0087\u00b0\3\2\2\2\u0088\u0089\f\17"+
		"\2\2\u0089\u008a\7-\2\2\u008a\u008b\7$\2\2\u008b\u008c\7-\2\2\u008c\u00af"+
		"\5\36\20\20\u008d\u008e\f\r\2\2\u008e\u008f\7-\2\2\u008f\u0090\7%\2\2"+
		"\u0090\u0091\7-\2\2\u0091\u00af\5\36\20\16\u0092\u0093\f\13\2\2\u0093"+
		"\u0094\7-\2\2\u0094\u0095\7&\2\2\u0095\u0096\7-\2\2\u0096\u00af\5\36\20"+
		"\f\u0097\u0098\f\t\2\2\u0098\u0099\7-\2\2\u0099\u009a\7\'\2\2\u009a\u009b"+
		"\7-\2\2\u009b\u00af\5\36\20\n\u009c\u009d\f\b\2\2\u009d\u009e\7\"\2\2"+
		"\u009e\u00af\5\36\20\t\u009f\u00a0\f\7\2\2\u00a0\u00a1\7!\2\2\u00a1\u00af"+
		"\5\36\20\b\u00a2\u00a3\f\6\2\2\u00a3\u00a4\7\35\2\2\u00a4\u00af\5\36\20"+
		"\7\u00a5\u00a6\f\5\2\2\u00a6\u00a7\7\36\2\2\u00a7\u00af\5\36\20\6\u00a8"+
		"\u00a9\f\4\2\2\u00a9\u00aa\7 \2\2\u00aa\u00af\5\36\20\5\u00ab\u00ac\f"+
		"\3\2\2\u00ac\u00ad\7\37\2\2\u00ad\u00af\5\36\20\4\u00ae\u0088\3\2\2\2"+
		"\u00ae\u008d\3\2\2\2\u00ae\u0092\3\2\2\2\u00ae\u0097\3\2\2\2\u00ae\u009c"+
		"\3\2\2\2\u00ae\u009f\3\2\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a5\3\2\2\2\u00ae"+
		"\u00a8\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\37\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4"+
		"\t\3\2\2\u00b4!\3\2\2\2\t\'?DK\u0086\u00ae\u00b0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}