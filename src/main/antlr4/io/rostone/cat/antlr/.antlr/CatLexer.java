// Generated from /home/rodolphe/cat/src/main/antlr4/io/rostone/cat/antlr/Cat.g4 by ANTLR 4.13.1

import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
import io.rostone.cat.ast.type.*;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INT_NAME=6, FLOAT_NAME=7, STRING_NAME=8, 
		BOOL_NAME=9, INT=10, FLOAT=11, STRING=12, ID=13, WS=14, LINE_COMMENT=15, 
		BLOCK_COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "INT_NAME", "FLOAT_NAME", "STRING_NAME", 
			"BOOL_NAME", "INT", "FLOAT", "STRING", "ID", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'='", "','", "'int'", "'float'", "'string'", 
			"'bool'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "INT_NAME", "FLOAT_NAME", "STRING_NAME", 
			"BOOL_NAME", "INT", "FLOAT", "STRING", "ID", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
		"\u0004\u0000\u0010\u0086\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0003\tC\b\t\u0001\t\u0004\tF\b\t\u000b"+
		"\t\f\tG\u0001\n\u0004\nK\b\n\u000b\n\f\nL\u0001\n\u0001\n\u0004\nQ\b\n"+
		"\u000b\n\f\nR\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"Y\b\u000b\n\u000b\f\u000b\\\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0005\fb\b\f\n\f\f\fe\t\f\u0001\r\u0004\rh\b\r\u000b\r\f\ri\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000er"+
		"\b\u000e\n\u000e\f\u000eu\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f}\b\u000f\n\u000f\f\u000f"+
		"\u0080\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001~\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000\u0006\u0001\u0000"+
		"09\u0002\u0000\"\"\\\\\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000\n\n\r\r\u008f\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003#\u0001\u0000"+
		"\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007\'\u0001\u0000\u0000"+
		"\u0000\t)\u0001\u0000\u0000\u0000\u000b+\u0001\u0000\u0000\u0000\r/\u0001"+
		"\u0000\u0000\u0000\u000f5\u0001\u0000\u0000\u0000\u0011<\u0001\u0000\u0000"+
		"\u0000\u0013B\u0001\u0000\u0000\u0000\u0015J\u0001\u0000\u0000\u0000\u0017"+
		"T\u0001\u0000\u0000\u0000\u0019_\u0001\u0000\u0000\u0000\u001bg\u0001"+
		"\u0000\u0000\u0000\u001dm\u0001\u0000\u0000\u0000\u001fx\u0001\u0000\u0000"+
		"\u0000!\"\u0005;\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005("+
		"\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005)\u0000\u0000&\u0006"+
		"\u0001\u0000\u0000\u0000\'(\u0005=\u0000\u0000(\b\u0001\u0000\u0000\u0000"+
		")*\u0005,\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005i\u0000\u0000"+
		",-\u0005n\u0000\u0000-.\u0005t\u0000\u0000.\f\u0001\u0000\u0000\u0000"+
		"/0\u0005f\u0000\u000001\u0005l\u0000\u000012\u0005o\u0000\u000023\u0005"+
		"a\u0000\u000034\u0005t\u0000\u00004\u000e\u0001\u0000\u0000\u000056\u0005"+
		"s\u0000\u000067\u0005t\u0000\u000078\u0005r\u0000\u000089\u0005i\u0000"+
		"\u00009:\u0005n\u0000\u0000:;\u0005g\u0000\u0000;\u0010\u0001\u0000\u0000"+
		"\u0000<=\u0005b\u0000\u0000=>\u0005o\u0000\u0000>?\u0005o\u0000\u0000"+
		"?@\u0005l\u0000\u0000@\u0012\u0001\u0000\u0000\u0000AC\u0005-\u0000\u0000"+
		"BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000"+
		"\u0000DF\u0007\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0014"+
		"\u0001\u0000\u0000\u0000IK\u0007\u0000\u0000\u0000JI\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0005.\u0000\u0000OQ\u0007\u0000"+
		"\u0000\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\u0016\u0001\u0000\u0000"+
		"\u0000TZ\u0005\"\u0000\u0000UY\b\u0001\u0000\u0000VW\u0005\\\u0000\u0000"+
		"WY\t\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\""+
		"\u0000\u0000^\u0018\u0001\u0000\u0000\u0000_c\u0007\u0002\u0000\u0000"+
		"`b\u0007\u0003\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u001a\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fh\u0007\u0004\u0000\u0000"+
		"gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0006\r\u0000"+
		"\u0000l\u001c\u0001\u0000\u0000\u0000mn\u0005/\u0000\u0000no\u0005/\u0000"+
		"\u0000os\u0001\u0000\u0000\u0000pr\b\u0005\u0000\u0000qp\u0001\u0000\u0000"+
		"\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0006"+
		"\u000e\u0000\u0000w\u001e\u0001\u0000\u0000\u0000xy\u0005/\u0000\u0000"+
		"yz\u0005*\u0000\u0000z~\u0001\u0000\u0000\u0000{}\t\u0000\u0000\u0000"+
		"|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~\u007f\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005*\u0000\u0000\u0082"+
		"\u0083\u0005/\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0006\u000f\u0000\u0000\u0085 \u0001\u0000\u0000\u0000\u000b\u0000BG"+
		"LRXZcis~\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}