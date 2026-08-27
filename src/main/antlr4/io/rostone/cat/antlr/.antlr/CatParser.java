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
import io.rostone.cat.utils.Position;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, INT_NAME=21, FLOAT_NAME=22, STRING_NAME=23, 
		BOOL_NAME=24, VOID_NAME=25, RETURN=26, INT=27, FLOAT=28, STRING=29, ID=30, 
		WS=31, LINE_COMMENT=32, BLOCK_COMMENT=33;
	public static final int
		RULE_ast = 0, RULE_seqExp = 1, RULE_stmt = 2, RULE_type = 3, RULE_var = 4, 
		RULE_varList = 5, RULE_argList = 6, RULE_callExp = 7, RULE_varDec = 8, 
		RULE_for = 9, RULE_exp = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"ast", "seqExp", "stmt", "type", "var", "varList", "argList", "callExp", 
			"varDec", "for", "exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'('", "')'", "'='", "'for'", "'{'", "'}'", "'*'", 
			"'/'", "'+'", "'-'", "'++'", "'--'", "'<'", "'<='", "'>'", "'>='", "'=='", 
			"'!='", "'int'", "'float'", "'string'", "'bool'", "'void'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "INT_NAME", "FLOAT_NAME", 
			"STRING_NAME", "BOOL_NAME", "VOID_NAME", "RETURN", "INT", "FLOAT", "STRING", 
			"ID", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1876951112L) != 0)) {
				{
				{
				setState(22);
				((AstContext)_localctx).s = seqExp();
				 _localctx.node.exps.add(((AstContext)_localctx).s.node); 
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
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
		 ((SeqExpContext)_localctx).node =  new SeqExp(new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(32);
					((SeqExpContext)_localctx).s = stmt();
					 _localctx.node.add(((SeqExpContext)_localctx).s.node); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(37); 
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
			setState(39);
			((StmtContext)_localctx).e = exp(0);
			setState(40);
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
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(INT_NAME);
				 ((TypeContext)_localctx).node =  IntType.getInstance(); 
				}
				break;
			case FLOAT_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(FLOAT_NAME);
				 ((TypeContext)_localctx).node =  FloatType.getInstance(); 
				}
				break;
			case STRING_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(STRING_NAME);
				 ((TypeContext)_localctx).node =  StringType.getInstance(); 
				}
				break;
			case BOOL_NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(BOOL_NAME);
				 ((TypeContext)_localctx).node =  BoolType.getInstance(); 
				}
				break;
			case VOID_NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
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
			setState(55);
			((VarContext)_localctx).t = type();
			setState(56);
			((VarContext)_localctx).ID = match(ID);
			 ((VarContext)_localctx).node =  new VarDec((((VarContext)_localctx).ID!=null?((VarContext)_localctx).ID.getText():null), ((VarContext)_localctx).t.node, null, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NAME:
			case FLOAT_NAME:
			case STRING_NAME:
			case BOOL_NAME:
			case VOID_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((VarListContext)_localctx).v = var();
				 _localctx.list.add(((VarListContext)_localctx).v.node); 
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(61);
					match(T__1);
					setState(62);
					((VarListContext)_localctx).v = var();
					 _localctx.list.add(((VarListContext)_localctx).v.node); 
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
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
			setState(73);
			((ArgListContext)_localctx).e = exp(0);
			 _localctx.list.add(((ArgListContext)_localctx).e.node); 
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(75);
				match(T__1);
				setState(76);
				((ArgListContext)_localctx).e = exp(0);
				 _localctx.list.add(((ArgListContext)_localctx).e.node); 
				}
				}
				setState(83);
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
		enterRule(_localctx, 14, RULE_callExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			((CallExpContext)_localctx).ID = match(ID);
			setState(85);
			match(T__2);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1876951112L) != 0)) {
				{
				setState(86);
				((CallExpContext)_localctx).a = argList();
				}
			}

			setState(89);
			match(T__3);
			 ((CallExpContext)_localctx).node =  new CallExp((((CallExpContext)_localctx).ID!=null?((CallExpContext)_localctx).ID.getText():null), (((CallExpContext)_localctx).a != null) ? ((CallExpContext)_localctx).a.list : new ArrayList<>(), null, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
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
	public static class VarDecContext extends ParserRuleContext {
		public VarDec node;
		public TypeContext t;
		public Token ID;
		public ExpContext e;
		public TerminalNode ID() { return getToken(CatParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((VarDecContext)_localctx).t = type();
			setState(93);
			((VarDecContext)_localctx).ID = match(ID);
			setState(94);
			match(T__4);
			setState(95);
			((VarDecContext)_localctx).e = exp(0);
			 ((VarDecContext)_localctx).node =  new VarDec((((VarDecContext)_localctx).ID!=null?((VarDecContext)_localctx).ID.getText():null), ((VarDecContext)_localctx).t.node, ((VarDecContext)_localctx).e.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
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
	public static class ForContext extends ParserRuleContext {
		public ForExp node;
		public VarDecContext v;
		public ExpContext o;
		public ExpContext e;
		public SeqExpContext b;
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqExpContext seqExp() {
			return getRuleContext(SeqExpContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__5);
			setState(99);
			match(T__2);
			setState(100);
			((ForContext)_localctx).v = varDec();
			setState(101);
			match(T__0);
			setState(102);
			((ForContext)_localctx).o = exp(0);
			setState(103);
			match(T__0);
			setState(104);
			((ForContext)_localctx).e = exp(0);
			setState(105);
			match(T__3);
			setState(106);
			match(T__6);
			setState(107);
			((ForContext)_localctx).b = seqExp();
			setState(108);
			match(T__7);
			 ((ForContext)_localctx).node =  new ForExp(((ForContext)_localctx).v.node, ((ForContext)_localctx).o.node, ((ForContext)_localctx).e.node, ((ForContext)_localctx).b.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
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
		public TypeContext t;
		public Token ID;
		public VarListContext l;
		public SeqExpContext s;
		public VarDecContext v;
		public ForContext f;
		public ExpContext e;
		public CallExpContext c;
		public Token INT;
		public Token STRING;
		public Token op;
		public ExpContext right;
		public TerminalNode ID() { return getToken(CatParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public SeqExpContext seqExp() {
			return getRuleContext(SeqExpContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CatParser.RETURN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CallExpContext callExp() {
			return getRuleContext(CallExpContext.class,0);
		}
		public TerminalNode INT() { return getToken(CatParser.INT, 0); }
		public TerminalNode STRING() { return getToken(CatParser.STRING, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(112);
				((ExpContext)_localctx).t = type();
				setState(113);
				((ExpContext)_localctx).ID = match(ID);
				setState(114);
				match(T__2);
				setState(115);
				((ExpContext)_localctx).l = varList();
				setState(116);
				match(T__3);
				setState(117);
				match(T__6);
				setState(118);
				((ExpContext)_localctx).s = seqExp();
				setState(119);
				match(T__7);
				 ((ExpContext)_localctx).node =  new FunctionDec(((ExpContext)_localctx).t.node, (((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), ((ExpContext)_localctx).l.list, ((ExpContext)_localctx).s.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 2:
				{
				setState(122);
				((ExpContext)_localctx).v = varDec();
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).v.node; 
				}
				break;
			case 3:
				{
				setState(125);
				((ExpContext)_localctx).f = for_();
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).f.node; 
				}
				break;
			case 4:
				{
				setState(128);
				match(RETURN);
				setState(129);
				((ExpContext)_localctx).e = exp(13);
				 ((ExpContext)_localctx).node =  new ReturnExp(((ExpContext)_localctx).e.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 5:
				{
				setState(132);
				((ExpContext)_localctx).ID = match(ID);
				setState(133);
				match(T__12);
				 ((ExpContext)_localctx).node =  new AssignExp(new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), new OpExp(new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), Op.add, new IntExp("1", new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 6:
				{
				setState(135);
				((ExpContext)_localctx).ID = match(ID);
				setState(136);
				match(T__13);
				 ((ExpContext)_localctx).node =  new AssignExp(new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), new OpExp(new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), Op.sub, new IntExp("1", new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 7:
				{
				setState(138);
				((ExpContext)_localctx).ID = match(ID);
				setState(139);
				match(T__4);
				setState(140);
				((ExpContext)_localctx).e = exp(6);
				 ((ExpContext)_localctx).node =  new AssignExp(new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())), ((ExpContext)_localctx).e.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 8:
				{
				setState(143);
				((ExpContext)_localctx).c = callExp();
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).c.node; 
				}
				break;
			case 9:
				{
				setState(146);
				((ExpContext)_localctx).ID = match(ID);
				 ((ExpContext)_localctx).node =  new VarExp((((ExpContext)_localctx).ID!=null?((ExpContext)_localctx).ID.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 10:
				{
				setState(148);
				((ExpContext)_localctx).INT = match(INT);
				 ((ExpContext)_localctx).node =  new IntExp((((ExpContext)_localctx).INT!=null?((ExpContext)_localctx).INT.getText():null), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 11:
				{
				setState(150);
				((ExpContext)_localctx).STRING = match(STRING);
				 ((ExpContext)_localctx).node =  new StringExp(Utils.unescape((((ExpContext)_localctx).STRING!=null?((ExpContext)_localctx).STRING.getText():null)), new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
				}
				break;
			case 12:
				{
				setState(152);
				match(T__2);
				setState(153);
				((ExpContext)_localctx).e = exp(0);
				setState(154);
				match(T__3);
				 ((ExpContext)_localctx).node =  ((ExpContext)_localctx).e.node; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(179);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(159);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(160);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(161);
						((ExpContext)_localctx).right = exp(13);
						 
						                    Op o = (((ExpContext)_localctx).op!=null?((ExpContext)_localctx).op.getText():null).equals("*") ? Op.mul : Op.div;
						                    ((ExpContext)_localctx).node =  new OpExp(((ExpContext)_localctx).left.node, o, ((ExpContext)_localctx).right.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
						                  
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(164);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(165);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(166);
						((ExpContext)_localctx).right = exp(12);
						 
						                    Op o = (((ExpContext)_localctx).op!=null?((ExpContext)_localctx).op.getText():null).equals("+") ? Op.add : Op.sub;
						                    ((ExpContext)_localctx).node =  new OpExp(((ExpContext)_localctx).left.node, o, ((ExpContext)_localctx).right.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
						                  
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(169);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(170);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0)) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(171);
						((ExpContext)_localctx).right = exp(9);
						 
						                    Op o = switch ((((ExpContext)_localctx).op!=null?((ExpContext)_localctx).op.getText():null)) {
						                        case "<"  -> Op.lt;
						                        case "<=" -> Op.le;
						                        case ">"  -> Op.gt;
						                        default   -> Op.ge;
						                    };
						                    ((ExpContext)_localctx).node =  new OpExp(((ExpContext)_localctx).left.node, o, ((ExpContext)_localctx).right.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
						                  
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(174);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(175);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(176);
						((ExpContext)_localctx).right = exp(8);
						 
						                    Op o = (((ExpContext)_localctx).op!=null?((ExpContext)_localctx).op.getText():null).equals("=") ? Op.eq : Op.ne;
						                    ((ExpContext)_localctx).node =  new OpExp(((ExpContext)_localctx).left.node, o, ((ExpContext)_localctx).right.node, new Position(_localctx.start.getLine(), _localctx.start.getCharPositionInLine())); 
						                  
						}
						break;
					}
					} 
				}
				setState(183);
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
		case 10:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u00b9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u001a\b\u0000\n\u0000\f\u0000\u001d\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001$\b\u0001"+
		"\u000b\u0001\f\u0001%\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00036\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005B\b\u0005"+
		"\n\u0005\f\u0005E\t\u0005\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"P\b\u0006\n\u0006\f\u0006S\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007X\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u009e\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00b4\b\n\n\n\f\n\u00b7\t\n"+
		"\u0001\n\u0000\u0001\u0014\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0000\u0004\u0001\u0000\t\n\u0001\u0000\u000b\f\u0001\u0000"+
		"\u000f\u0012\u0001\u0000\u0013\u0014\u00c6\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0002#\u0001\u0000\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000"+
		"\u00065\u0001\u0000\u0000\u0000\b7\u0001\u0000\u0000\u0000\nG\u0001\u0000"+
		"\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000"+
		"\u0010\\\u0001\u0000\u0000\u0000\u0012b\u0001\u0000\u0000\u0000\u0014"+
		"\u009d\u0001\u0000\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017"+
		"\u0018\u0006\u0000\uffff\uffff\u0000\u0018\u001a\u0001\u0000\u0000\u0000"+
		"\u0019\u0016\u0001\u0000\u0000\u0000\u001a\u001d\u0001\u0000\u0000\u0000"+
		"\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000"+
		"\u001c\u001e\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005\u0000\u0000\u0001\u001f\u0001\u0001\u0000\u0000\u0000"+
		" !\u0003\u0004\u0002\u0000!\"\u0006\u0001\uffff\uffff\u0000\"$\u0001\u0000"+
		"\u0000\u0000# \u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000"+
		"\u0000\'(\u0003\u0014\n\u0000()\u0005\u0001\u0000\u0000)*\u0006\u0002"+
		"\uffff\uffff\u0000*\u0005\u0001\u0000\u0000\u0000+,\u0005\u0015\u0000"+
		"\u0000,6\u0006\u0003\uffff\uffff\u0000-.\u0005\u0016\u0000\u0000.6\u0006"+
		"\u0003\uffff\uffff\u0000/0\u0005\u0017\u0000\u000006\u0006\u0003\uffff"+
		"\uffff\u000012\u0005\u0018\u0000\u000026\u0006\u0003\uffff\uffff\u0000"+
		"34\u0005\u0019\u0000\u000046\u0006\u0003\uffff\uffff\u00005+\u0001\u0000"+
		"\u0000\u00005-\u0001\u0000\u0000\u00005/\u0001\u0000\u0000\u000051\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u00006\u0007\u0001\u0000\u0000"+
		"\u000078\u0003\u0006\u0003\u000089\u0005\u001e\u0000\u00009:\u0006\u0004"+
		"\uffff\uffff\u0000:\t\u0001\u0000\u0000\u0000;<\u0003\b\u0004\u0000<C"+
		"\u0006\u0005\uffff\uffff\u0000=>\u0005\u0002\u0000\u0000>?\u0003\b\u0004"+
		"\u0000?@\u0006\u0005\uffff\uffff\u0000@B\u0001\u0000\u0000\u0000A=\u0001"+
		"\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DH\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000FH\u0001\u0000\u0000\u0000G;\u0001\u0000\u0000\u0000GF\u0001\u0000"+
		"\u0000\u0000H\u000b\u0001\u0000\u0000\u0000IJ\u0003\u0014\n\u0000JQ\u0006"+
		"\u0006\uffff\uffff\u0000KL\u0005\u0002\u0000\u0000LM\u0003\u0014\n\u0000"+
		"MN\u0006\u0006\uffff\uffff\u0000NP\u0001\u0000\u0000\u0000OK\u0001\u0000"+
		"\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000R\r\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"TU\u0005\u001e\u0000\u0000UW\u0005\u0003\u0000\u0000VX\u0003\f\u0006\u0000"+
		"WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YZ\u0005\u0004\u0000\u0000Z[\u0006\u0007\uffff\uffff\u0000[\u000f"+
		"\u0001\u0000\u0000\u0000\\]\u0003\u0006\u0003\u0000]^\u0005\u001e\u0000"+
		"\u0000^_\u0005\u0005\u0000\u0000_`\u0003\u0014\n\u0000`a\u0006\b\uffff"+
		"\uffff\u0000a\u0011\u0001\u0000\u0000\u0000bc\u0005\u0006\u0000\u0000"+
		"cd\u0005\u0003\u0000\u0000de\u0003\u0010\b\u0000ef\u0005\u0001\u0000\u0000"+
		"fg\u0003\u0014\n\u0000gh\u0005\u0001\u0000\u0000hi\u0003\u0014\n\u0000"+
		"ij\u0005\u0004\u0000\u0000jk\u0005\u0007\u0000\u0000kl\u0003\u0002\u0001"+
		"\u0000lm\u0005\b\u0000\u0000mn\u0006\t\uffff\uffff\u0000n\u0013\u0001"+
		"\u0000\u0000\u0000op\u0006\n\uffff\uffff\u0000pq\u0003\u0006\u0003\u0000"+
		"qr\u0005\u001e\u0000\u0000rs\u0005\u0003\u0000\u0000st\u0003\n\u0005\u0000"+
		"tu\u0005\u0004\u0000\u0000uv\u0005\u0007\u0000\u0000vw\u0003\u0002\u0001"+
		"\u0000wx\u0005\b\u0000\u0000xy\u0006\n\uffff\uffff\u0000y\u009e\u0001"+
		"\u0000\u0000\u0000z{\u0003\u0010\b\u0000{|\u0006\n\uffff\uffff\u0000|"+
		"\u009e\u0001\u0000\u0000\u0000}~\u0003\u0012\t\u0000~\u007f\u0006\n\uffff"+
		"\uffff\u0000\u007f\u009e\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u001a"+
		"\u0000\u0000\u0081\u0082\u0003\u0014\n\r\u0082\u0083\u0006\n\uffff\uffff"+
		"\u0000\u0083\u009e\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u001e\u0000"+
		"\u0000\u0085\u0086\u0005\r\u0000\u0000\u0086\u009e\u0006\n\uffff\uffff"+
		"\u0000\u0087\u0088\u0005\u001e\u0000\u0000\u0088\u0089\u0005\u000e\u0000"+
		"\u0000\u0089\u009e\u0006\n\uffff\uffff\u0000\u008a\u008b\u0005\u001e\u0000"+
		"\u0000\u008b\u008c\u0005\u0005\u0000\u0000\u008c\u008d\u0003\u0014\n\u0006"+
		"\u008d\u008e\u0006\n\uffff\uffff\u0000\u008e\u009e\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0003\u000e\u0007\u0000\u0090\u0091\u0006\n\uffff\uffff\u0000"+
		"\u0091\u009e\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u001e\u0000\u0000"+
		"\u0093\u009e\u0006\n\uffff\uffff\u0000\u0094\u0095\u0005\u001b\u0000\u0000"+
		"\u0095\u009e\u0006\n\uffff\uffff\u0000\u0096\u0097\u0005\u001d\u0000\u0000"+
		"\u0097\u009e\u0006\n\uffff\uffff\u0000\u0098\u0099\u0005\u0003\u0000\u0000"+
		"\u0099\u009a\u0003\u0014\n\u0000\u009a\u009b\u0005\u0004\u0000\u0000\u009b"+
		"\u009c\u0006\n\uffff\uffff\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d"+
		"o\u0001\u0000\u0000\u0000\u009dz\u0001\u0000\u0000\u0000\u009d}\u0001"+
		"\u0000\u0000\u0000\u009d\u0080\u0001\u0000\u0000\u0000\u009d\u0084\u0001"+
		"\u0000\u0000\u0000\u009d\u0087\u0001\u0000\u0000\u0000\u009d\u008a\u0001"+
		"\u0000\u0000\u0000\u009d\u008f\u0001\u0000\u0000\u0000\u009d\u0092\u0001"+
		"\u0000\u0000\u0000\u009d\u0094\u0001\u0000\u0000\u0000\u009d\u0096\u0001"+
		"\u0000\u0000\u0000\u009d\u0098\u0001\u0000\u0000\u0000\u009e\u00b5\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\n\f\u0000\u0000\u00a0\u00a1\u0007\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0003\u0014\n\r\u00a2\u00a3\u0006\n\uffff\uffff"+
		"\u0000\u00a3\u00b4\u0001\u0000\u0000\u0000\u00a4\u00a5\n\u000b\u0000\u0000"+
		"\u00a5\u00a6\u0007\u0001\u0000\u0000\u00a6\u00a7\u0003\u0014\n\f\u00a7"+
		"\u00a8\u0006\n\uffff\uffff\u0000\u00a8\u00b4\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\n\b\u0000\u0000\u00aa\u00ab\u0007\u0002\u0000\u0000\u00ab\u00ac"+
		"\u0003\u0014\n\t\u00ac\u00ad\u0006\n\uffff\uffff\u0000\u00ad\u00b4\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\n\u0007\u0000\u0000\u00af\u00b0\u0007\u0003"+
		"\u0000\u0000\u00b0\u00b1\u0003\u0014\n\b\u00b1\u00b2\u0006\n\uffff\uffff"+
		"\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u009f\u0001\u0000\u0000"+
		"\u0000\u00b3\u00a4\u0001\u0000\u0000\u0000\u00b3\u00a9\u0001\u0000\u0000"+
		"\u0000\u00b3\u00ae\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u0015\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\n\u001b%5CGQW\u009d\u00b3\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}