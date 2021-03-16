// Generated from C:/Users/user/IdeaProjects/Crypt/src/main/java/CryptCompiler/parse\CryptParser.g4 by ANTLR 4.9.1
package CryptUtilities.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CryptParser}.
 */
public interface CryptParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CryptParser#fileUnit}.
	 * @param ctx the parse tree
	 */
	void enterFileUnit(CryptParser.FileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#fileUnit}.
	 * @param ctx the parse tree
	 */
	void exitFileUnit(CryptParser.FileUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#fileBody}.
	 * @param ctx the parse tree
	 */
	void enterFileBody(CryptParser.FileBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#fileBody}.
	 * @param ctx the parse tree
	 */
	void exitFileBody(CryptParser.FileBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CryptParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CryptParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(CryptParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(CryptParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CryptParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CryptParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(CryptParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(CryptParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(CryptParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(CryptParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CryptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CryptParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CryptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CryptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#printlnStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnStatement(CryptParser.PrintlnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#printlnStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnStatement(CryptParser.PrintlnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(CryptParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(CryptParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(CryptParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(CryptParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(CryptParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(CryptParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivide(CryptParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivide(CryptParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(CryptParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(CryptParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(CryptParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(CryptParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(CryptParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(CryptParser.SubtractContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CryptParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CryptParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CryptParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(CryptParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CryptParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(CryptParser.DecimalContext ctx);
}