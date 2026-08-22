// Generated from /home/rodolphe/cat/src/main/antlr4/io/rostone/cat/antlr/Cat.g4 by ANTLR 4.13.1

import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
import io.rostone.cat.ast.type.*;
import io.rostone.cat.ast.function.FunctionDec;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, INT_NAME=8, FLOAT_NAME=9, 
		STRING_NAME=10, BOOL_NAME=11, INT=12, FLOAT=13, STRING=14, ID=15, WS=16, 
		LINE_COMMENT=17, BLOCK_COMMENT=18;
	public static final int
		RULE_ast = 0, RULE_stmt = 1, RULE_type = 2, RULE_var = 3, RULE_varList = 4, 
		RULE_exp = 5, RULE_argList = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"ast", "stmt", "type", "var", "varList", "exp", "argList"
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

	@Override
	public String getGrammarFileName() { return "Cat.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AstContext extends ParserRuleContext {
		public Ast node;
		public StmtContext s;
		public TerminalNode EOF() { return getToken(CatParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public AstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ast; }
	}

	public final AstContext ast() throws RecognitionException {
		AstContext _localctx = new AstContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ast);
		 ((AstContext)_localctx).node =  new Ast(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 57096L) != 0)) {
				{
				{
				setState(14);
				((AstContext)_localctx).s = stmt();
				 _localctx.node.exps.add(((AstContext)_localctx).s.node); 
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public Exp node;
		public ExpContext e;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((StmtContext)_localctx).e = exp();
			setState(25);
			match(T__0);
			 ((StmtContext)_localctx).node =  ((StmtContext)_localctx).e.node; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type node;
		public TerminalNode INT_NAME() { return getToken(CatParser.INT_NAME, 0); }
		public TerminalNode FLOAT_NAME() { return getToken(CatParser.FLOAT_NAME, 0); }
		public TerminalNode STRING_NAME() { return getToken(CatParser.STRING_NAME, 0); }
		public TerminalNode BOOL_NAME() { return getToken(CatParser.BOOL_NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				match(INT_NAME);
				 ((TypeContext)_localctx).node =  new IntType(); 
				}
				break;
			case FLOAT_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(FLOAT_NAME);
				 ((TypeContext)_localctx).node =  new FloatType(); 
				}
				break;
			case STRING_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(STRING_NAME);
				 ((TypeContext)_localctx).node =  new StringType(); 
				}
				break;
			case BOOL_NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				match(BOOL_NAME);
				 ((TypeContext)_localctx).node =  new BoolType(); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public VarDec node;
		public TypeContext t;
		public Token ID;
		public TerminalNode ID() { return getToken(CatParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((VarContext)_localctx).t = type();
			setState(39);
			((VarContext)_localctx).ID = match(ID);
			 ((VarContext)_localctx).node =  new VarDec((((VarContext)_localctx).ID!=null?((VarContext)_localctx).ID.getText():null), ((VarContext)_localctx).t.node, null); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarListContext extends ParserRuleContext {
		public List<VarDec> list;
		public VarContext v;
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varList);
		 ((VarListContext)_localctx).list =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			((VarListContext)_localctx).v = var();
			 _localctx.list.add(((VarListContext)_localctx).v.node); 
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(44);
				match(T__1);
				setState(45);
				((VarListContext)_localctx).v = var();
				 _localctx.list.add(((VarListContext)_localctx).v.node); 
				}
				}
				setState(52);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public Exp node;
		public Token ID;
		public ArgListContext a;
		public Token INT;
		public Token STRING;
		public TypeContext t;
		public ExpContext e;
		public VarListContext l;
		public ExpContext b;
		public TerminalNode ID() { return getToken(CatParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode INT() { return getToken(CatParser.INT, 0); }
		public TerminalNode STRING() { return getToken(CatParser.STRING, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exp);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				((ExpContext)_localctx).ID = match(ID);
				setState(54);
				match(T__2);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 57096L) != 0)) {
					{
					setState(55);
					((ExpContext)_localctx).a = argList();
					}
				}

				setState(58);
				match(T__3);

				            CallExp c = new CallExp();
				            c.name = (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null);
				            c.args = (((ExpContext)_localctx).a != null) ? ((ExpContext)_localctx).a.list : new ArrayList<>();
				            ((ExpContext)_localctx).node =  c;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).node =  new IntExp((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				((ExpContext)_localctx).STRING = match(STRING);
				 ((ExpContext)_localctx).node =  new StringExp(Utils.unescape((((ExpContext)_localctx).STRING!=null?((ExpContext)_localctx).STRING.getText():null))); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				((ExpContext)_localctx).t = type();
				setState(65);
				((ExpContext)_localctx).ID = match(ID);
				setState(66);
				match(T__4);
				setState(67);
				((ExpContext)_localctx).e = exp();
				 ((ExpContext)_localctx).node =  new VarDec((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), ((ExpContext)_localctx).t.node, ((ExpContext)_localctx).e.node); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				((ExpContext)_localctx).t = type();
				setState(71);
				((ExpContext)_localctx).ID = match(ID);
				setState(72);
				match(T__2);
				setState(73);
				((ExpContext)_localctx).l = varList();
				setState(74);
				match(T__3);
				setState(75);
				match(T__5);
				setState(76);
				((ExpContext)_localctx).b = exp();
				setState(77);
				match(T__6);
				 ((ExpContext)_localctx).node =  new FunctionDec(((ExpContext)_localctx).t.node, (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), ((ExpContext)_localctx).l.list, ((ExpContext)_localctx).b.node); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				match(T__2);
				setState(81);
				((ExpContext)_localctx).e = exp();
				setState(82);
				match(T__3);
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).e.node; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<Exp> list;
		public ExpContext e;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argList);
		 ((ArgListContext)_localctx).list =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((ArgListContext)_localctx).e = exp();
			 _localctx.list.add(((ArgListContext)_localctx).e.node); 
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(89);
				match(T__1);
				setState(90);
				((ArgListContext)_localctx).e = exp();
				 _localctx.list.add(((ArgListContext)_localctx).e.node); 
				}
				}
				setState(97);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0012c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002%\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u00041\b\u0004\n\u0004\f\u00044\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u00059\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005V\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006^\b\u0006\n\u0006\f\u0006"+
		"a\t\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f"+
		"\u0000\u0000g\u0000\u0013\u0001\u0000\u0000\u0000\u0002\u0018\u0001\u0000"+
		"\u0000\u0000\u0004$\u0001\u0000\u0000\u0000\u0006&\u0001\u0000\u0000\u0000"+
		"\b*\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000\u0000\fW\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f\u0010\u0006\u0000"+
		"\uffff\uffff\u0000\u0010\u0012\u0001\u0000\u0000\u0000\u0011\u000e\u0001"+
		"\u0000\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013\u0011\u0001"+
		"\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0016\u0001"+
		"\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0016\u0017\u0005"+
		"\u0000\u0000\u0001\u0017\u0001\u0001\u0000\u0000\u0000\u0018\u0019\u0003"+
		"\n\u0005\u0000\u0019\u001a\u0005\u0001\u0000\u0000\u001a\u001b\u0006\u0001"+
		"\uffff\uffff\u0000\u001b\u0003\u0001\u0000\u0000\u0000\u001c\u001d\u0005"+
		"\b\u0000\u0000\u001d%\u0006\u0002\uffff\uffff\u0000\u001e\u001f\u0005"+
		"\t\u0000\u0000\u001f%\u0006\u0002\uffff\uffff\u0000 !\u0005\n\u0000\u0000"+
		"!%\u0006\u0002\uffff\uffff\u0000\"#\u0005\u000b\u0000\u0000#%\u0006\u0002"+
		"\uffff\uffff\u0000$\u001c\u0001\u0000\u0000\u0000$\u001e\u0001\u0000\u0000"+
		"\u0000$ \u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%\u0005\u0001"+
		"\u0000\u0000\u0000&\'\u0003\u0004\u0002\u0000\'(\u0005\u000f\u0000\u0000"+
		"()\u0006\u0003\uffff\uffff\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0003"+
		"\u0006\u0003\u0000+2\u0006\u0004\uffff\uffff\u0000,-\u0005\u0002\u0000"+
		"\u0000-.\u0003\u0006\u0003\u0000./\u0006\u0004\uffff\uffff\u0000/1\u0001"+
		"\u0000\u0000\u00000,\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003\t\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000056\u0005\u000f\u0000\u000068\u0005\u0003"+
		"\u0000\u000079\u0003\f\u0006\u000087\u0001\u0000\u0000\u000089\u0001\u0000"+
		"\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0005\u0004\u0000\u0000;V\u0006"+
		"\u0005\uffff\uffff\u0000<=\u0005\f\u0000\u0000=V\u0006\u0005\uffff\uffff"+
		"\u0000>?\u0005\u000e\u0000\u0000?V\u0006\u0005\uffff\uffff\u0000@A\u0003"+
		"\u0004\u0002\u0000AB\u0005\u000f\u0000\u0000BC\u0005\u0005\u0000\u0000"+
		"CD\u0003\n\u0005\u0000DE\u0006\u0005\uffff\uffff\u0000EV\u0001\u0000\u0000"+
		"\u0000FG\u0003\u0004\u0002\u0000GH\u0005\u000f\u0000\u0000HI\u0005\u0003"+
		"\u0000\u0000IJ\u0003\b\u0004\u0000JK\u0005\u0004\u0000\u0000KL\u0005\u0006"+
		"\u0000\u0000LM\u0003\n\u0005\u0000MN\u0005\u0007\u0000\u0000NO\u0006\u0005"+
		"\uffff\uffff\u0000OV\u0001\u0000\u0000\u0000PQ\u0005\u0003\u0000\u0000"+
		"QR\u0003\n\u0005\u0000RS\u0005\u0004\u0000\u0000ST\u0006\u0005\uffff\uffff"+
		"\u0000TV\u0001\u0000\u0000\u0000U5\u0001\u0000\u0000\u0000U<\u0001\u0000"+
		"\u0000\u0000U>\u0001\u0000\u0000\u0000U@\u0001\u0000\u0000\u0000UF\u0001"+
		"\u0000\u0000\u0000UP\u0001\u0000\u0000\u0000V\u000b\u0001\u0000\u0000"+
		"\u0000WX\u0003\n\u0005\u0000X_\u0006\u0006\uffff\uffff\u0000YZ\u0005\u0002"+
		"\u0000\u0000Z[\u0003\n\u0005\u0000[\\\u0006\u0006\uffff\uffff\u0000\\"+
		"^\u0001\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\r\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000\u0006\u0013$28U_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}