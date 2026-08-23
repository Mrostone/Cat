package io.rostone.cat.ast.function;

import io.rostone.cat.ast.Exp;

public class ReturnExp extends Exp {
    Exp exp;

    public ReturnExp(Exp exp) {
        this.exp = exp;
    }
}
