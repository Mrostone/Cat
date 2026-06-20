package main.java.ast;

import java.util.List;

import main.java.lexing.LexerToken;

public abstract class Exp {
    public List<LexerToken> tokens;

    public abstract Exp parse(List<LexerToken> list);
}
