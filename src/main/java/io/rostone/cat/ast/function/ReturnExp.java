package io.rostone.cat.ast.function;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.binder.Binder;

public class ReturnExp extends Exp {
    Exp exp;

    public ReturnExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public Binder bind(Binder bind) {
        return exp.bind(bind);
    }
}
