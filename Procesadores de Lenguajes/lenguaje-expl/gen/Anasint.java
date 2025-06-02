// Generated from C:/Docencia/PL/PL2020-21/Laboratorio/Tema2/lenguaje-expl/src\Anasint.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Anasint extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BLANCO=1, TABULADOR=2, FIN_LINEA=3, COMENTARIO_BLOQUE=4, COMENTARIO_LINEA=5, 
		Y=6, O=7, NO=8, IMPLICA=9, PARATODO=10, EXISTE=11, FALSO=12, CIERTO=13, 
		IDENT=14, NUMERO=15, MAYOR=16, MENOR=17, MAYORIGUAL=18, MENORIGUAL=19, 
		IGUAL=20, DISTINTO=21, MAS=22, MENOS=23, POR=24, DIVISION=25, PA=26, PC=27, 
		DP=28, COMA=29;
	public static final int
		RULE_sentencia = 0, RULE_exprLogica = 1, RULE_predicado = 2, RULE_predicadoInfijo = 3, 
		RULE_predicadoPrefijo = 4, RULE_terms = 5, RULE_term = 6, RULE_term1 = 7, 
		RULE_term2 = 8, RULE_cuantificador = 9, RULE_variables = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"sentencia", "exprLogica", "predicado", "predicadoInfijo", "predicadoPrefijo", 
			"terms", "term", "term1", "term2", "cuantificador", "variables"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'\t'", null, null, null, "'Y'", "'O'", "'NO'", "'=>'", 
			"'PARATODO'", "'EXISTE'", "'falso'", "'cierto'", null, null, "'>'", "'<'", 
			"'>='", "'<='", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
			"':'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BLANCO", "TABULADOR", "FIN_LINEA", "COMENTARIO_BLOQUE", "COMENTARIO_LINEA", 
			"Y", "O", "NO", "IMPLICA", "PARATODO", "EXISTE", "FALSO", "CIERTO", "IDENT", 
			"NUMERO", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", "IGUAL", "DISTINTO", 
			"MAS", "MENOS", "POR", "DIVISION", "PA", "PC", "DP", "COMA"
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
	public String getGrammarFileName() { return "Anasint.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Anasint(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SentenciaContext extends ParserRuleContext {
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Anasint.EOF, 0); }
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitSentencia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitSentencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sentencia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			exprLogica(0);
			setState(23);
			match(EOF);
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

	public static class ExprLogicaContext extends ParserRuleContext {
		public TerminalNode CIERTO() { return getToken(Anasint.CIERTO, 0); }
		public TerminalNode FALSO() { return getToken(Anasint.FALSO, 0); }
		public PredicadoContext predicado() {
			return getRuleContext(PredicadoContext.class,0);
		}
		public TerminalNode NO() { return getToken(Anasint.NO, 0); }
		public List<ExprLogicaContext> exprLogica() {
			return getRuleContexts(ExprLogicaContext.class);
		}
		public ExprLogicaContext exprLogica(int i) {
			return getRuleContext(ExprLogicaContext.class,i);
		}
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public CuantificadorContext cuantificador() {
			return getRuleContext(CuantificadorContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public TerminalNode DP() { return getToken(Anasint.DP, 0); }
		public TerminalNode Y() { return getToken(Anasint.Y, 0); }
		public TerminalNode O() { return getToken(Anasint.O, 0); }
		public TerminalNode IMPLICA() { return getToken(Anasint.IMPLICA, 0); }
		public ExprLogicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprLogica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterExprLogica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitExprLogica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitExprLogica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprLogicaContext exprLogica() throws RecognitionException {
		return exprLogica(0);
	}

	private ExprLogicaContext exprLogica(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprLogicaContext _localctx = new ExprLogicaContext(_ctx, _parentState);
		ExprLogicaContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exprLogica, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(26);
				match(CIERTO);
				}
				break;
			case 2:
				{
				setState(27);
				match(FALSO);
				}
				break;
			case 3:
				{
				setState(28);
				predicado();
				}
				break;
			case 4:
				{
				setState(29);
				match(NO);
				setState(30);
				exprLogica(3);
				}
				break;
			case 5:
				{
				setState(31);
				match(PA);
				setState(32);
				exprLogica(0);
				setState(33);
				match(PC);
				}
				break;
			case 6:
				{
				setState(35);
				cuantificador();
				setState(36);
				variables();
				setState(37);
				match(DP);
				setState(38);
				match(PA);
				setState(39);
				exprLogica(0);
				setState(40);
				match(PC);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(53);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprLogicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exprLogica);
						setState(44);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(45);
						match(Y);
						setState(46);
						exprLogica(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprLogicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exprLogica);
						setState(47);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(48);
						match(O);
						setState(49);
						exprLogica(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprLogicaContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exprLogica);
						setState(50);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(51);
						match(IMPLICA);
						setState(52);
						exprLogica(5);
						}
						break;
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class PredicadoContext extends ParserRuleContext {
		public PredicadoInfijoContext predicadoInfijo() {
			return getRuleContext(PredicadoInfijoContext.class,0);
		}
		public PredicadoPrefijoContext predicadoPrefijo() {
			return getRuleContext(PredicadoPrefijoContext.class,0);
		}
		public PredicadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterPredicado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitPredicado(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitPredicado(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicadoContext predicado() throws RecognitionException {
		PredicadoContext _localctx = new PredicadoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_predicado);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				predicadoInfijo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				predicadoPrefijo();
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

	public static class PredicadoInfijoContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode IGUAL() { return getToken(Anasint.IGUAL, 0); }
		public TerminalNode MAYOR() { return getToken(Anasint.MAYOR, 0); }
		public TerminalNode MENOR() { return getToken(Anasint.MENOR, 0); }
		public TerminalNode MAYORIGUAL() { return getToken(Anasint.MAYORIGUAL, 0); }
		public TerminalNode MENORIGUAL() { return getToken(Anasint.MENORIGUAL, 0); }
		public TerminalNode DISTINTO() { return getToken(Anasint.DISTINTO, 0); }
		public PredicadoInfijoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicadoInfijo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterPredicadoInfijo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitPredicadoInfijo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitPredicadoInfijo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicadoInfijoContext predicadoInfijo() throws RecognitionException {
		PredicadoInfijoContext _localctx = new PredicadoInfijoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_predicadoInfijo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			term();
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAYOR) | (1L << MENOR) | (1L << MAYORIGUAL) | (1L << MENORIGUAL) | (1L << IGUAL) | (1L << DISTINTO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(64);
			term();
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

	public static class PredicadoPrefijoContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(Anasint.IDENT, 0); }
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public PredicadoPrefijoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicadoPrefijo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterPredicadoPrefijo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitPredicadoPrefijo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitPredicadoPrefijo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicadoPrefijoContext predicadoPrefijo() throws RecognitionException {
		PredicadoPrefijoContext _localctx = new PredicadoPrefijoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_predicadoPrefijo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(IDENT);
			setState(67);
			match(PA);
			setState(68);
			terms();
			setState(69);
			match(PC);
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

	public static class TermsContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode COMA() { return getToken(Anasint.COMA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_terms);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				term();
				setState(73);
				match(COMA);
				setState(74);
				terms();
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

	public static class TermContext extends ParserRuleContext {
		public Term1Context term1() {
			return getRuleContext(Term1Context.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MAS() { return getToken(Anasint.MAS, 0); }
		public TerminalNode MENOS() { return getToken(Anasint.MENOS, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				term1();
				setState(79);
				_la = _input.LA(1);
				if ( !(_la==MAS || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(80);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				term1();
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

	public static class Term1Context extends ParserRuleContext {
		public Term2Context term2() {
			return getRuleContext(Term2Context.class,0);
		}
		public Term1Context term1() {
			return getRuleContext(Term1Context.class,0);
		}
		public TerminalNode POR() { return getToken(Anasint.POR, 0); }
		public TerminalNode DIVISION() { return getToken(Anasint.DIVISION, 0); }
		public Term1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTerm1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTerm1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTerm1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term1Context term1() throws RecognitionException {
		Term1Context _localctx = new Term1Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_term1);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				term2();
				setState(86);
				_la = _input.LA(1);
				if ( !(_la==POR || _la==DIVISION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				term1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				term2();
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

	public static class Term2Context extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(Anasint.NUMERO, 0); }
		public TerminalNode IDENT() { return getToken(Anasint.IDENT, 0); }
		public TerminalNode PA() { return getToken(Anasint.PA, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode PC() { return getToken(Anasint.PC, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MENOS() { return getToken(Anasint.MENOS, 0); }
		public Term2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterTerm2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitTerm2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitTerm2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term2Context term2() throws RecognitionException {
		Term2Context _localctx = new Term2Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_term2);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(NUMERO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(IDENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(IDENT);
				setState(95);
				match(PA);
				setState(96);
				terms();
				setState(97);
				match(PC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(PA);
				setState(100);
				term();
				setState(101);
				match(PC);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				match(MENOS);
				setState(104);
				term();
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

	public static class CuantificadorContext extends ParserRuleContext {
		public TerminalNode PARATODO() { return getToken(Anasint.PARATODO, 0); }
		public TerminalNode EXISTE() { return getToken(Anasint.EXISTE, 0); }
		public CuantificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterCuantificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitCuantificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitCuantificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CuantificadorContext cuantificador() throws RecognitionException {
		CuantificadorContext _localctx = new CuantificadorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cuantificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==PARATODO || _la==EXISTE) ) {
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

	public static class VariablesContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(Anasint.IDENT, 0); }
		public TerminalNode COMA() { return getToken(Anasint.COMA, 0); }
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnasintListener ) ((AnasintListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnasintVisitor ) return ((AnasintVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variables);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(IDENT);
				setState(111);
				match(COMA);
				setState(112);
				variables();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return exprLogica_sempred((ExprLogicaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprLogica_sempred(ExprLogicaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37v\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\38\n\3"+
		"\f\3\16\3;\13\3\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\5\bV\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\5\t]\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\nl\n\n\3\13\3\13\3\f\3\f\3\f\3\f\5\ft\n\f\3\f\2\3\4\r\2\4\6\b\n\f\16"+
		"\20\22\24\26\2\6\3\2\22\27\3\2\30\31\3\2\32\33\3\2\f\r\2{\2\30\3\2\2\2"+
		"\4,\3\2\2\2\6>\3\2\2\2\b@\3\2\2\2\nD\3\2\2\2\fN\3\2\2\2\16U\3\2\2\2\20"+
		"\\\3\2\2\2\22k\3\2\2\2\24m\3\2\2\2\26s\3\2\2\2\30\31\5\4\3\2\31\32\7\2"+
		"\2\3\32\3\3\2\2\2\33\34\b\3\1\2\34-\7\17\2\2\35-\7\16\2\2\36-\5\6\4\2"+
		"\37 \7\n\2\2 -\5\4\3\5!\"\7\34\2\2\"#\5\4\3\2#$\7\35\2\2$-\3\2\2\2%&\5"+
		"\24\13\2&\'\5\26\f\2\'(\7\36\2\2()\7\34\2\2)*\5\4\3\2*+\7\35\2\2+-\3\2"+
		"\2\2,\33\3\2\2\2,\35\3\2\2\2,\36\3\2\2\2,\37\3\2\2\2,!\3\2\2\2,%\3\2\2"+
		"\2-9\3\2\2\2./\f\b\2\2/\60\7\b\2\2\608\5\4\3\t\61\62\f\7\2\2\62\63\7\t"+
		"\2\2\638\5\4\3\b\64\65\f\6\2\2\65\66\7\13\2\2\668\5\4\3\7\67.\3\2\2\2"+
		"\67\61\3\2\2\2\67\64\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\5\3\2\2"+
		"\2;9\3\2\2\2<?\5\b\5\2=?\5\n\6\2><\3\2\2\2>=\3\2\2\2?\7\3\2\2\2@A\5\16"+
		"\b\2AB\t\2\2\2BC\5\16\b\2C\t\3\2\2\2DE\7\20\2\2EF\7\34\2\2FG\5\f\7\2G"+
		"H\7\35\2\2H\13\3\2\2\2IO\5\16\b\2JK\5\16\b\2KL\7\37\2\2LM\5\f\7\2MO\3"+
		"\2\2\2NI\3\2\2\2NJ\3\2\2\2O\r\3\2\2\2PQ\5\20\t\2QR\t\3\2\2RS\5\16\b\2"+
		"SV\3\2\2\2TV\5\20\t\2UP\3\2\2\2UT\3\2\2\2V\17\3\2\2\2WX\5\22\n\2XY\t\4"+
		"\2\2YZ\5\20\t\2Z]\3\2\2\2[]\5\22\n\2\\W\3\2\2\2\\[\3\2\2\2]\21\3\2\2\2"+
		"^l\7\21\2\2_l\7\20\2\2`a\7\20\2\2ab\7\34\2\2bc\5\f\7\2cd\7\35\2\2dl\3"+
		"\2\2\2ef\7\34\2\2fg\5\16\b\2gh\7\35\2\2hl\3\2\2\2ij\7\31\2\2jl\5\16\b"+
		"\2k^\3\2\2\2k_\3\2\2\2k`\3\2\2\2ke\3\2\2\2ki\3\2\2\2l\23\3\2\2\2mn\t\5"+
		"\2\2n\25\3\2\2\2ot\7\20\2\2pq\7\20\2\2qr\7\37\2\2rt\5\26\f\2so\3\2\2\2"+
		"sp\3\2\2\2t\27\3\2\2\2\13,\679>NU\\ks";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}