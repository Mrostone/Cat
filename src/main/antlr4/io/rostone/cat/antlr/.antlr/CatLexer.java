// Generated from /home/rodolphe/cat/src/main/antlr4/io/rostone/cat/antlr/Cat.g4 by ANTLR 4.13.1

import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
import io.rostone.cat.ast.type.*;
import io.rostone.cat.ast.function.FunctionDec;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CatLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT_NAME=8, FLOAT_NAME=9, 
		STRING_NAME=10, BOOL_NAME=11, INT=12, FLOAT=13, STRING=14, ID=15, WS=16, 
		LINE_COMMENT=17, BLOCK_COMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "INT_NAME", "FLOAT_NAME", 
			"STRING_NAME", "BOOL_NAME", "INT", "FLOAT", "STRING", "ID", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'('", "')'", "'='", "'{'", "'}'", "'int'", "'float'", 
			"'string'", "'bool'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "INT_NAME", "FLOAT_NAME", 
			"STRING_NAME", "BOOL_NAME", "INT", "FLOAT", "STRING", "ID", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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


	public CatLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cat.g4"; }

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
		"\u0004\u0000\u0012\u008e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0003\u000bK\b\u000b\u0001\u000b\u0004\u000bN\b\u000b\u000b"+
		"\u000b\f\u000bO\u0001\f\u0004\fS\b\f\u000b\f\f\fT\u0001\f\u0001\f\u0004"+
		"\fY\b\f\u000b\f\f\fZ\u0001\r\u0001\r\u0001\r\u0001\r\u0005\ra\b\r\n\r"+
		"\f\rd\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000ej\b\u000e"+
		"\n\u000e\f\u000em\t\u000e\u0001\u000f\u0004\u000fp\b\u000f\u000b\u000f"+
		"\f\u000fq\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010z\b\u0010\n\u0010\f\u0010}\t\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u0085\b\u0011\n\u0011\f\u0011\u0088\t\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0086\u0000\u0012\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012\u0001\u0000\u0006\u0001\u000009\u0002\u0000\"\"\\\\\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000\n\n"+
		"\r\r\u0097\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%"+
		"\u0001\u0000\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000\u0005)\u0001"+
		"\u0000\u0000\u0000\u0007+\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000"+
		"\u0000\u000b/\u0001\u0000\u0000\u0000\r1\u0001\u0000\u0000\u0000\u000f"+
		"3\u0001\u0000\u0000\u0000\u00117\u0001\u0000\u0000\u0000\u0013=\u0001"+
		"\u0000\u0000\u0000\u0015D\u0001\u0000\u0000\u0000\u0017J\u0001\u0000\u0000"+
		"\u0000\u0019R\u0001\u0000\u0000\u0000\u001b\\\u0001\u0000\u0000\u0000"+
		"\u001dg\u0001\u0000\u0000\u0000\u001fo\u0001\u0000\u0000\u0000!u\u0001"+
		"\u0000\u0000\u0000#\u0080\u0001\u0000\u0000\u0000%&\u0005;\u0000\u0000"+
		"&\u0002\u0001\u0000\u0000\u0000\'(\u0005,\u0000\u0000(\u0004\u0001\u0000"+
		"\u0000\u0000)*\u0005(\u0000\u0000*\u0006\u0001\u0000\u0000\u0000+,\u0005"+
		")\u0000\u0000,\b\u0001\u0000\u0000\u0000-.\u0005=\u0000\u0000.\n\u0001"+
		"\u0000\u0000\u0000/0\u0005{\u0000\u00000\f\u0001\u0000\u0000\u000012\u0005"+
		"}\u0000\u00002\u000e\u0001\u0000\u0000\u000034\u0005i\u0000\u000045\u0005"+
		"n\u0000\u000056\u0005t\u0000\u00006\u0010\u0001\u0000\u0000\u000078\u0005"+
		"f\u0000\u000089\u0005l\u0000\u00009:\u0005o\u0000\u0000:;\u0005a\u0000"+
		"\u0000;<\u0005t\u0000\u0000<\u0012\u0001\u0000\u0000\u0000=>\u0005s\u0000"+
		"\u0000>?\u0005t\u0000\u0000?@\u0005r\u0000\u0000@A\u0005i\u0000\u0000"+
		"AB\u0005n\u0000\u0000BC\u0005g\u0000\u0000C\u0014\u0001\u0000\u0000\u0000"+
		"DE\u0005b\u0000\u0000EF\u0005o\u0000\u0000FG\u0005o\u0000\u0000GH\u0005"+
		"l\u0000\u0000H\u0016\u0001\u0000\u0000\u0000IK\u0005-\u0000\u0000JI\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"LN\u0007\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0018\u0001"+
		"\u0000\u0000\u0000QS\u0007\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VX\u0005.\u0000\u0000WY\u0007\u0000\u0000"+
		"\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u001a\u0001\u0000\u0000\u0000"+
		"\\b\u0005\"\u0000\u0000]a\b\u0001\u0000\u0000^_\u0005\\\u0000\u0000_a"+
		"\t\u0000\u0000\u0000`]\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000"+
		"ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000ce\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005\"\u0000"+
		"\u0000f\u001c\u0001\u0000\u0000\u0000gk\u0007\u0002\u0000\u0000hj\u0007"+
		"\u0003\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l\u001e\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000np\u0007\u0004\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0006\u000f\u0000"+
		"\u0000t \u0001\u0000\u0000\u0000uv\u0005/\u0000\u0000vw\u0005/\u0000\u0000"+
		"w{\u0001\u0000\u0000\u0000xz\b\u0005\u0000\u0000yx\u0001\u0000\u0000\u0000"+
		"z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0006"+
		"\u0010\u0000\u0000\u007f\"\u0001\u0000\u0000\u0000\u0080\u0081\u0005/"+
		"\u0000\u0000\u0081\u0082\u0005*\u0000\u0000\u0082\u0086\u0001\u0000\u0000"+
		"\u0000\u0083\u0085\t\u0000\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000"+
		"\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005*\u0000\u0000\u008a"+
		"\u008b\u0005/\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0006\u0011\u0000\u0000\u008d$\u0001\u0000\u0000\u0000\u000b\u0000JO"+
		"TZ`bkq{\u0086\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}