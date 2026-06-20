package main.java.ast;

import java.util.List;

import main.java.lexing.Token;

public abstract class Exp {
    public abstract List<Token> getExpectedTokens();

    public abstract Exp parse(List<Token> list);
}
