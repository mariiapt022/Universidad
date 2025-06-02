// Generated from C:/Docencia/PL/PL2020-21/Laboratorio/Tema2/lenguaje-expl/src\Anasint.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Anasint}.
 */
public interface AnasintListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Anasint#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(Anasint.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(Anasint.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#exprLogica}.
	 * @param ctx the parse tree
	 */
	void enterExprLogica(Anasint.ExprLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#exprLogica}.
	 * @param ctx the parse tree
	 */
	void exitExprLogica(Anasint.ExprLogicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#predicado}.
	 * @param ctx the parse tree
	 */
	void enterPredicado(Anasint.PredicadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#predicado}.
	 * @param ctx the parse tree
	 */
	void exitPredicado(Anasint.PredicadoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#predicadoInfijo}.
	 * @param ctx the parse tree
	 */
	void enterPredicadoInfijo(Anasint.PredicadoInfijoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#predicadoInfijo}.
	 * @param ctx the parse tree
	 */
	void exitPredicadoInfijo(Anasint.PredicadoInfijoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#predicadoPrefijo}.
	 * @param ctx the parse tree
	 */
	void enterPredicadoPrefijo(Anasint.PredicadoPrefijoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#predicadoPrefijo}.
	 * @param ctx the parse tree
	 */
	void exitPredicadoPrefijo(Anasint.PredicadoPrefijoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(Anasint.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(Anasint.TermsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(Anasint.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(Anasint.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#term1}.
	 * @param ctx the parse tree
	 */
	void enterTerm1(Anasint.Term1Context ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#term1}.
	 * @param ctx the parse tree
	 */
	void exitTerm1(Anasint.Term1Context ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#term2}.
	 * @param ctx the parse tree
	 */
	void enterTerm2(Anasint.Term2Context ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#term2}.
	 * @param ctx the parse tree
	 */
	void exitTerm2(Anasint.Term2Context ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#cuantificador}.
	 * @param ctx the parse tree
	 */
	void enterCuantificador(Anasint.CuantificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#cuantificador}.
	 * @param ctx the parse tree
	 */
	void exitCuantificador(Anasint.CuantificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Anasint#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(Anasint.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Anasint#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(Anasint.VariablesContext ctx);
}