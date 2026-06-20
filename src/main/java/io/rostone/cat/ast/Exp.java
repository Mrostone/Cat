package io.rostone.cat.ast;

import io.rostone.cat.lexing.*;

import java.util.List;

public abstract class Exp {
    public abstract Exp parse(List<Token> list);
}
