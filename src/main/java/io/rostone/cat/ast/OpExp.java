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
    public void bind(Binder bind) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bind'");
    }
}
