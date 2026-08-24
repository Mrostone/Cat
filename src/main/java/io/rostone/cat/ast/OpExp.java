package io.rostone.cat.ast;

import io.rostone.cat.binder.Binder;

public class OpExp extends Exp{
    Exp left;
    Op op;
    Exp right;

    public OpExp(Exp left, Op op, Exp right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public Binder bind(Binder bind) {
        bind = left.bind(bind);
        bind = right.bind(bind);
        return bind;
    }
}
