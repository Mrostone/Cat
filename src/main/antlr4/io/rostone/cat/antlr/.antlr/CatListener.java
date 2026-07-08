// Generated from /home/rodolphe/cat/src/main/antlr4/io/rostone/cat/antlr/Cat.g4 by ANTLR 4.13.1

package io.rostone.cat.antlr;
import io.rostone.cat.ast.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CatParser}.
 */
public interface CatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CatParser#ast}.
	 * @param ctx the parse tree
	 */
	void enterAst(CatParser.AstContext ctx);
	/**
	 * Exit a parse tree produced by {@link CatParser#ast}.
	 * @param ctx the parse tree
	 */
	void exitAst(CatParser.AstContext ctx);
	/**
	 * Enter a parse tree produced by {@link CatParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(CatParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CatParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(CatParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CatParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(CatParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CatParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(CatParser.ArgListContext ctx);
}