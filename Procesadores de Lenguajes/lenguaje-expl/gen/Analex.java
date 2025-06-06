// Generated from C:/Docencia/PL/PL2020-21/Laboratorio/Tema2/lenguaje-expl/src\Analex.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Analex extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BLANCO", "TABULADOR", "FIN_LINEA", "COMENTARIO_BLOQUE", "COMENTARIO_LINEA", 
			"DIGITO", "LETRA", "Y", "O", "NO", "IMPLICA", "PARATODO", "EXISTE", "FALSO", 
			"CIERTO", "IDENT", "NUMERO", "MAYOR", "MENOR", "MAYORIGUAL", "MENORIGUAL", 
			"IGUAL", "DISTINTO", "MAS", "MENOS", "POR", "DIVISION", "PA", "PC", "DP", 
			"COMA"
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


	public Analex(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Analex.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00c3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\7\5U\n\5\f\5\16\5X\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7"+
		"\6c\n\6\f\6\16\6f\13\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u009a\n\21\f\21\16\21\u009d"+
		"\13\21\3\22\6\22\u00a0\n\22\r\22\16\22\u00a1\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \4Vd\2!\3"+
		"\3\5\4\7\5\t\6\13\7\r\2\17\2\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17"+
		"!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36"+
		"?\37\3\2\4\3\2\62;\4\2C\\c|\2\u00c6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5E\3\2\2\2\7J\3\2\2\2"+
		"\tP\3\2\2\2\13^\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2\23q\3\2\2\2"+
		"\25s\3\2\2\2\27v\3\2\2\2\31y\3\2\2\2\33\u0082\3\2\2\2\35\u0089\3\2\2\2"+
		"\37\u008f\3\2\2\2!\u0096\3\2\2\2#\u009f\3\2\2\2%\u00a3\3\2\2\2\'\u00a5"+
		"\3\2\2\2)\u00a7\3\2\2\2+\u00aa\3\2\2\2-\u00ad\3\2\2\2/\u00b0\3\2\2\2\61"+
		"\u00b3\3\2\2\2\63\u00b5\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00bb"+
		"\3\2\2\2;\u00bd\3\2\2\2=\u00bf\3\2\2\2?\u00c1\3\2\2\2AB\7\"\2\2BC\3\2"+
		"\2\2CD\b\2\2\2D\4\3\2\2\2EF\7\13\2\2FG\3\2\2\2GH\b\3\2\2H\6\3\2\2\2IK"+
		"\7\17\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\f\2\2MN\3\2\2\2NO\b\4\2\2"+
		"O\b\3\2\2\2PQ\7\61\2\2QR\7,\2\2RV\3\2\2\2SU\13\2\2\2TS\3\2\2\2UX\3\2\2"+
		"\2VW\3\2\2\2VT\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7,\2\2Z[\7\61\2\2[\\\3\2"+
		"\2\2\\]\b\5\2\2]\n\3\2\2\2^_\7\61\2\2_`\7\61\2\2`d\3\2\2\2ac\13\2\2\2"+
		"ba\3\2\2\2cf\3\2\2\2de\3\2\2\2db\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\5\7\4\2"+
		"hi\3\2\2\2ij\b\6\2\2j\f\3\2\2\2kl\t\2\2\2l\16\3\2\2\2mn\t\3\2\2n\20\3"+
		"\2\2\2op\7[\2\2p\22\3\2\2\2qr\7Q\2\2r\24\3\2\2\2st\7P\2\2tu\7Q\2\2u\26"+
		"\3\2\2\2vw\7?\2\2wx\7@\2\2x\30\3\2\2\2yz\7R\2\2z{\7C\2\2{|\7T\2\2|}\7"+
		"C\2\2}~\7V\2\2~\177\7Q\2\2\177\u0080\7F\2\2\u0080\u0081\7Q\2\2\u0081\32"+
		"\3\2\2\2\u0082\u0083\7G\2\2\u0083\u0084\7Z\2\2\u0084\u0085\7K\2\2\u0085"+
		"\u0086\7U\2\2\u0086\u0087\7V\2\2\u0087\u0088\7G\2\2\u0088\34\3\2\2\2\u0089"+
		"\u008a\7h\2\2\u008a\u008b\7c\2\2\u008b\u008c\7n\2\2\u008c\u008d\7u\2\2"+
		"\u008d\u008e\7q\2\2\u008e\36\3\2\2\2\u008f\u0090\7e\2\2\u0090\u0091\7"+
		"k\2\2\u0091\u0092\7g\2\2\u0092\u0093\7t\2\2\u0093\u0094\7v\2\2\u0094\u0095"+
		"\7q\2\2\u0095 \3\2\2\2\u0096\u009b\5\17\b\2\u0097\u009a\5\17\b\2\u0098"+
		"\u009a\5\r\7\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\"\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u00a0\5\r\7\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2$\3\2\2\2\u00a3\u00a4\7@\2\2\u00a4"+
		"&\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\u00a9"+
		"\7?\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7>\2\2\u00ab\u00ac\7?\2\2\u00ac,\3"+
		"\2\2\2\u00ad\u00ae\7?\2\2\u00ae\u00af\7?\2\2\u00af.\3\2\2\2\u00b0\u00b1"+
		"\7#\2\2\u00b1\u00b2\7?\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\62"+
		"\3\2\2\2\u00b5\u00b6\7/\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7,\2\2\u00b8"+
		"\66\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7*\2\2\u00bc"+
		":\3\2\2\2\u00bd\u00be\7+\2\2\u00be<\3\2\2\2\u00bf\u00c0\7<\2\2\u00c0>"+
		"\3\2\2\2\u00c1\u00c2\7.\2\2\u00c2@\3\2\2\2\t\2JVd\u0099\u009b\u00a1\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}