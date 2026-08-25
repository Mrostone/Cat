package io.rostone.cat.ast;

import io.rostone.cat.ast.type.IntType;
import io.rostone.cat.ast.type.Type;
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
        if (left != null) {
            bind = left.bind(bind);
        }
        if (right != null) {
            bind = right.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        if (left != null) {
            left.typeCheck();
        }
        if (right != null) {
            right.typeCheck();
        }

        Type l = left.getType();
        Type r = left.getType();

        if (l != IntType.getInstance() || r != IntType.getInstance() || l != r) {
            System.err.println("Error type OpExp");
            System.err.println(l + " == " + r);
            System.exit(4);
        }

        this.type = l;
    }
}
