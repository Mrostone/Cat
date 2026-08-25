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
        if (exp == null) {
            System.err.println("Error null");
            System.exit(3);
        }
        return exp.bind(bind);
    }

    @Override
    public void typeCheck() {
        exp.typeCheck();
        this.type = exp.getType();
    }
}
