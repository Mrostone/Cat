package io.rostone.cat.ast;

import io.rostone.cat.ast.type.IntType;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.binder.Binder;
import io.rostone.cat.utils.Position;

public class OpExp extends Exp{
    Exp left;
    Op op;
    Exp right;

    public OpExp(Exp left, Op op, Exp right, Position pos) {
        this.left = left;
        this.op = op;
        this.right = right;
        this.pos = pos;
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
