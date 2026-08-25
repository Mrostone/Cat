// Generated from /home/rodolphe/cat/src/main/antlr4/io/rostone/cat/antlr/Cat.g4 by ANTLR 4.13.1

import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
import io.rostone.cat.ast.type.*;
import io.rostone.cat.ast.function.FunctionDec;
import io.rostone.cat.ast.function.ReturnExp;
import io.rostone.cat.ast.OpExp;
import io.rostone.cat.ast.Op;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, INT_NAME=17, 
		FLOAT_NAME=18, STRING_NAME=19, BOOL_NAME=20, VOID_NAME=21, RETURN=22, 
		INT=23, FLOAT=24, STRING=25, ID=26, WS=27, LINE_COMMENT=28, BLOCK_COMMENT=29;
	public static final int
		RULE_ast = 0, RULE_seqExp = 1, RULE_stmt = 2, RULE_type = 3, RULE_var = 4, 
		RULE_varList = 5, RULE_op = 6, RULE_argList = 7, RULE_callExp = 8, RULE_exp = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"ast", "seqExp", "stmt", "type", "var", "varList", "op", "argList", "callExp", 
			"exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'+'", "'-'", "'*'", "'/'", "'='", "'<>'", "'<'", 
			"'<='", "'>'", "'>='", "'('", "')'", "'{'", "'}'", "'int'", "'float'", 
			"'string'", "'bool'", "'void'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "INT_NAME", "FLOAT_NAME", "STRING_NAME", 
			"BOOL_NAME", "VOID_NAME", "RETURN", "INT", "FLOAT", "STRING", "ID", "WS", 
			"LINE_COMMENT", "BLOCK_COMMENT"
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
		public SeqExpContext s;
		public TerminalNode EOF() { return getToken(CatParser.EOF, 0); }
		public List<SeqExpContext> seqExp() {
			return getRuleContexts(SeqExpContext.class);
		}
		public SeqExpContext seqExp(int i) {
			return getRuleContext(SeqExpContext.class,i);
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 117317632L) != 0)) {
				{
				{
				setState(20);
				((AstContext)_localctx).s = seqExp();
				 _localctx.node.exps.add(((AstContext)_localctx).s.node); 
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
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
	public static class SeqExpContext extends ParserRuleContext {
		public SeqExp node;
		public StmtContext s;
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SeqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqExp; }
	}

	public final SeqExpContext seqExp() throws RecognitionException {
		SeqExpContext _localctx = new SeqExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_seqExp);
		 ((SeqExpContext)_localctx).node =  new SeqExp(); 
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(30);
					((SeqExpContext)_localctx).s = stmt();
					 _localctx.node.add(((SeqExpContext)_localctx).s.node); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(35); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		enterRule(_localctx, 4, RULE_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			((StmtContext)_localctx).e = exp(0);
			setState(38);
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
		public TerminalNode VOID_NAME() { return getToken(CatParser.VOID_NAME, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(INT_NAME);
				 ((TypeContext)_localctx).node =  IntType.getInstance(); 
				}
				break;
			case FLOAT_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(FLOAT_NAME);
				 ((TypeContext)_localctx).node =  FloatType.getInstance(); 
				}
				break;
			case STRING_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(STRING_NAME);
				 ((TypeContext)_localctx).node =  StringType.getInstance(); 
				}
				break;
			case BOOL_NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(BOOL_NAME);
				 ((TypeContext)_localctx).node =  BoolType.getInstance(); 
				}
				break;
			case VOID_NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				match(VOID_NAME);
				 ((TypeContext)_localctx).node =  VoidType.getInstance(); 
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
		enterRule(_localctx, 8, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			((VarContext)_localctx).t = type();
			setState(54);
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
		enterRule(_localctx, 10, RULE_varList);
		 ((VarListContext)_localctx).list =  new ArrayList<>(); 
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NAME:
			case FLOAT_NAME:
			case STRING_NAME:
			case BOOL_NAME:
			case VOID_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((VarListContext)_localctx).v = var();
				 _localctx.list.add(((VarListContext)_localctx).v.node); 
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(59);
					match(T__1);
					setState(60);
					((VarListContext)_localctx).v = var();
					 _localctx.list.add(((VarListContext)_localctx).v.node); 
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class OpContext extends ParserRuleContext {
		public Op value;
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_op);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(T__2);
				 ((OpContext)_localctx).value =  Op.add; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(T__3);
				 ((OpContext)_localctx).value =  Op.sub; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(T__4);
				 ((OpContext)_localctx).value =  Op.mul; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(T__5);
				 ((OpContext)_localctx).value =  Op.div; 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				match(T__6);
				 ((OpContext)_localctx).value =  Op.eq; 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				match(T__7);
				 ((OpContext)_localctx).value =  Op.ne; 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				match(T__8);
				 ((OpContext)_localctx).value =  Op.lt; 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				match(T__9);
				 ((OpContext)_localctx).value =  Op.le; 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 9);
				{
				setState(87);
				match(T__10);
				 ((OpContext)_localctx).value =  Op.gt; 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 10);
				{
				setState(89);
				match(T__11);
				 ((OpContext)_localctx).value =  Op.ge; 
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
		enterRule(_localctx, 14, RULE_argList);
		 ((ArgListContext)_localctx).list =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			((ArgListContext)_localctx).e = exp(0);
			 _localctx.list.add(((ArgListContext)_localctx).e.node); 
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(95);
				match(T__1);
				setState(96);
				((ArgListContext)_localctx).e = exp(0);
				 _localctx.list.add(((ArgListContext)_localctx).e.node); 
				}
				}
				setState(103);
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
	public static class CallExpContext extends ParserRuleContext {
		public CallExp node;
		public Token ID;
		public ArgListContext a;
		public TerminalNode ID() { return getToken(CatParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public CallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExp; }
	}

	public final CallExpContext callExp() throws RecognitionException {
		CallExpContext _localctx = new CallExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_callExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((CallExpContext)_localctx).ID = match(ID);
			setState(105);
			match(T__12);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 117317632L) != 0)) {
				{
				setState(106);
				((CallExpContext)_localctx).a = argList();
				}
			}

			setState(109);
			match(T__13);
			 ((CallExpContext)_localctx).node =  new CallExp((((CallExpContext)_localctx).ID!=null?((CallExpContext)_localctx).ID.getText():null), (((CallExpContext)_localctx).a != null) ? ((CallExpContext)_localctx).a.list : new ArrayList<>(), null); 
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
		public ExpContext left;
		public CallExpContext c;
		public Token ID;
		public Token INT;
		public Token STRING;
		public TypeContext t;
		public ExpContext e;
		public VarListContext l;
		public SeqExpContext s;
		public OpContext o;
		public ExpContext right;
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(CatParser.ID, 0); }
		public TerminalNode INT() { return getToken(CatParser.INT, 0); }
		public TerminalNode STRING() { return getToken(CatParser.STRING, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public SeqExpContext seqExp() {
			return getRuleContext(SeqExpContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CatParser.RETURN, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(113);
				((ExpContext)_localctx).c = callExp();
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).c.node; 
				}
				break;
			case 2:
				{
				setState(116);
				((ExpContext)_localctx).ID = match(ID);
				 ((ExpContext)_localctx).node =  new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null)); 
				}
				break;
			case 3:
				{
				setState(118);
				((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).node =  new IntExp((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null)); 
				}
				break;
			case 4:
				{
				setState(120);
				((ExpContext)_localctx).STRING = match(STRING);
				 ((ExpContext)_localctx).node =  new StringExp(Utils.unescape((((ExpContext)_localctx).STRING!=null?((ExpContext)_localctx).STRING.getText():null))); 
				}
				break;
			case 5:
				{
				setState(122);
				((ExpContext)_localctx).t = type();
				setState(123);
				((ExpContext)_localctx).ID = match(ID);
				setState(124);
				match(T__6);
				setState(125);
				((ExpContext)_localctx).e = exp(5);
				 ((ExpContext)_localctx).node =  new VarDec((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), ((ExpContext)_localctx).t.node, ((ExpContext)_localctx).e.node); 
				}
				break;
			case 6:
				{
				setState(128);
				((ExpContext)_localctx).t = type();
				setState(129);
				((ExpContext)_localctx).ID = match(ID);
				setState(130);
				match(T__12);
				setState(131);
				((ExpContext)_localctx).l = varList();
				setState(132);
				match(T__13);
				setState(133);
				match(T__14);
				setState(134);
				((ExpContext)_localctx).s = seqExp();
				setState(135);
				match(T__15);
				 ((ExpContext)_localctx).node =  new FunctionDec(((ExpContext)_localctx).t.node, (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), ((ExpContext)_localctx).l.list, ((ExpContext)_localctx).s.node); 
				}
				break;
			case 7:
				{
				setState(138);
				match(T__12);
				setState(139);
				((ExpContext)_localctx).e = exp(0);
				setState(140);
				match(T__13);
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).e.node; 
				}
				break;
			case 8:
				{
				setState(143);
				match(RETURN);
				setState(144);
				((ExpContext)_localctx).e = exp(1);
				 ((ExpContext)_localctx).node =  new ReturnExp(((ExpContext)_localctx).e.node); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(149);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(150);
					((ExpContext)_localctx).o = op();
					setState(151);
					((ExpContext)_localctx).right = exp(5);
					 ((ExpContext)_localctx).node =  new OpExp(((ExpContext)_localctx).left.node, ((ExpContext)_localctx).o.value, ((ExpContext)_localctx).right.node); 
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00a0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001\"\b\u0001\u000b\u0001"+
		"\f\u0001#\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00034\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005@\b\u0005\n\u0005\f\u0005"+
		"C\t\u0005\u0001\u0005\u0003\u0005F\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\\\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007d\b\u0007\n\u0007\f\u0007g\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0003\bl\b\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0094\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u009b\b\t\n\t\f\t\u009e\t\t"+
		"\u0001\t\u0000\u0001\u0012\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0000\u0000\u00b0\u0000\u0019\u0001\u0000\u0000\u0000\u0002!\u0001"+
		"\u0000\u0000\u0000\u0004%\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000"+
		"\u0000\b5\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000\f[\u0001"+
		"\u0000\u0000\u0000\u000e]\u0001\u0000\u0000\u0000\u0010h\u0001\u0000\u0000"+
		"\u0000\u0012\u0093\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002\u0001"+
		"\u0000\u0015\u0016\u0006\u0000\uffff\uffff\u0000\u0016\u0018\u0001\u0000"+
		"\u0000\u0000\u0017\u0014\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0005\u0000\u0000\u0001\u001d\u0001\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0006\u0001\uffff"+
		"\uffff\u0000 \"\u0001\u0000\u0000\u0000!\u001e\u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000"+
		"\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0003\u0012\t\u0000&\'\u0005\u0001"+
		"\u0000\u0000\'(\u0006\u0002\uffff\uffff\u0000(\u0005\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0011\u0000\u0000*4\u0006\u0003\uffff\uffff\u0000+,\u0005"+
		"\u0012\u0000\u0000,4\u0006\u0003\uffff\uffff\u0000-.\u0005\u0013\u0000"+
		"\u0000.4\u0006\u0003\uffff\uffff\u0000/0\u0005\u0014\u0000\u000004\u0006"+
		"\u0003\uffff\uffff\u000012\u0005\u0015\u0000\u000024\u0006\u0003\uffff"+
		"\uffff\u00003)\u0001\u0000\u0000\u00003+\u0001\u0000\u0000\u00003-\u0001"+
		"\u0000\u0000\u00003/\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"4\u0007\u0001\u0000\u0000\u000056\u0003\u0006\u0003\u000067\u0005\u001a"+
		"\u0000\u000078\u0006\u0004\uffff\uffff\u00008\t\u0001\u0000\u0000\u0000"+
		"9:\u0003\b\u0004\u0000:A\u0006\u0005\uffff\uffff\u0000;<\u0005\u0002\u0000"+
		"\u0000<=\u0003\b\u0004\u0000=>\u0006\u0005\uffff\uffff\u0000>@\u0001\u0000"+
		"\u0000\u0000?;\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BF\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000E9\u0001\u0000\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000F\u000b\u0001\u0000\u0000\u0000GH\u0005"+
		"\u0003\u0000\u0000H\\\u0006\u0006\uffff\uffff\u0000IJ\u0005\u0004\u0000"+
		"\u0000J\\\u0006\u0006\uffff\uffff\u0000KL\u0005\u0005\u0000\u0000L\\\u0006"+
		"\u0006\uffff\uffff\u0000MN\u0005\u0006\u0000\u0000N\\\u0006\u0006\uffff"+
		"\uffff\u0000OP\u0005\u0007\u0000\u0000P\\\u0006\u0006\uffff\uffff\u0000"+
		"QR\u0005\b\u0000\u0000R\\\u0006\u0006\uffff\uffff\u0000ST\u0005\t\u0000"+
		"\u0000T\\\u0006\u0006\uffff\uffff\u0000UV\u0005\n\u0000\u0000V\\\u0006"+
		"\u0006\uffff\uffff\u0000WX\u0005\u000b\u0000\u0000X\\\u0006\u0006\uffff"+
		"\uffff\u0000YZ\u0005\f\u0000\u0000Z\\\u0006\u0006\uffff\uffff\u0000[G"+
		"\u0001\u0000\u0000\u0000[I\u0001\u0000\u0000\u0000[K\u0001\u0000\u0000"+
		"\u0000[M\u0001\u0000\u0000\u0000[O\u0001\u0000\u0000\u0000[Q\u0001\u0000"+
		"\u0000\u0000[S\u0001\u0000\u0000\u0000[U\u0001\u0000\u0000\u0000[W\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\\r\u0001\u0000\u0000\u0000"+
		"]^\u0003\u0012\t\u0000^e\u0006\u0007\uffff\uffff\u0000_`\u0005\u0002\u0000"+
		"\u0000`a\u0003\u0012\t\u0000ab\u0006\u0007\uffff\uffff\u0000bd\u0001\u0000"+
		"\u0000\u0000c_\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u000f\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000hi\u0005\u001a\u0000\u0000ik\u0005\r\u0000"+
		"\u0000jl\u0003\u000e\u0007\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005\u000e\u0000\u0000no\u0006"+
		"\b\uffff\uffff\u0000o\u0011\u0001\u0000\u0000\u0000pq\u0006\t\uffff\uffff"+
		"\u0000qr\u0003\u0010\b\u0000rs\u0006\t\uffff\uffff\u0000s\u0094\u0001"+
		"\u0000\u0000\u0000tu\u0005\u001a\u0000\u0000u\u0094\u0006\t\uffff\uffff"+
		"\u0000vw\u0005\u0017\u0000\u0000w\u0094\u0006\t\uffff\uffff\u0000xy\u0005"+
		"\u0019\u0000\u0000y\u0094\u0006\t\uffff\uffff\u0000z{\u0003\u0006\u0003"+
		"\u0000{|\u0005\u001a\u0000\u0000|}\u0005\u0007\u0000\u0000}~\u0003\u0012"+
		"\t\u0005~\u007f\u0006\t\uffff\uffff\u0000\u007f\u0094\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0003\u0006\u0003\u0000\u0081\u0082\u0005\u001a\u0000"+
		"\u0000\u0082\u0083\u0005\r\u0000\u0000\u0083\u0084\u0003\n\u0005\u0000"+
		"\u0084\u0085\u0005\u000e\u0000\u0000\u0085\u0086\u0005\u000f\u0000\u0000"+
		"\u0086\u0087\u0003\u0002\u0001\u0000\u0087\u0088\u0005\u0010\u0000\u0000"+
		"\u0088\u0089\u0006\t\uffff\uffff\u0000\u0089\u0094\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\r\u0000\u0000\u008b\u008c\u0003\u0012\t\u0000\u008c"+
		"\u008d\u0005\u000e\u0000\u0000\u008d\u008e\u0006\t\uffff\uffff\u0000\u008e"+
		"\u0094\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0016\u0000\u0000\u0090"+
		"\u0091\u0003\u0012\t\u0001\u0091\u0092\u0006\t\uffff\uffff\u0000\u0092"+
		"\u0094\u0001\u0000\u0000\u0000\u0093p\u0001\u0000\u0000\u0000\u0093t\u0001"+
		"\u0000\u0000\u0000\u0093v\u0001\u0000\u0000\u0000\u0093x\u0001\u0000\u0000"+
		"\u0000\u0093z\u0001\u0000\u0000\u0000\u0093\u0080\u0001\u0000\u0000\u0000"+
		"\u0093\u008a\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000"+
		"\u0094\u009c\u0001\u0000\u0000\u0000\u0095\u0096\n\u0004\u0000\u0000\u0096"+
		"\u0097\u0003\f\u0006\u0000\u0097\u0098\u0003\u0012\t\u0005\u0098\u0099"+
		"\u0006\t\uffff\uffff\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0095"+
		"\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u0013"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\n\u0019#"+
		"3AE[ek\u0093\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}