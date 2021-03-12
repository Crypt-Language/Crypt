// Generated from C:/Users/user/IdeaProjects/Crypt/src/main/java/CryptCompiler/parse\CryptParser.g4 by ANTLR 4.9.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CryptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CryptParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CryptParser#fileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileUnit(CryptParser.FileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#fileBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileBody(CryptParser.FileBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(CryptParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(CryptParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CryptParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(CryptParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(CryptParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CryptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CryptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#printlnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintlnStatement(CryptParser.PrintlnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(CryptParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(CryptParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(CryptParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(CryptParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(CryptParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(CryptParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link CryptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(CryptParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CryptParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CryptParser#decimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(CryptParser.DecimalContext ctx);
}