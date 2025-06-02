// Generated from C:/Docencia/PL/PL2020-21/Laboratorio/Tema2/lenguaje-expl/src\Anasint.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Anasint}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnasintVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Anasint#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(Anasint.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#exprLogica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLogica(Anasint.ExprLogicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#predicado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicado(Anasint.PredicadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#predicadoInfijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicadoInfijo(Anasint.PredicadoInfijoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#predicadoPrefijo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicadoPrefijo(Anasint.PredicadoPrefijoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(Anasint.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(Anasint.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#term1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm1(Anasint.Term1Context ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#term2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm2(Anasint.Term2Context ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#cuantificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCuantificador(Anasint.CuantificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Anasint#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(Anasint.VariablesContext ctx);
}