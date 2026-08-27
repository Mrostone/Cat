package io.rostone.cat.ast;

import io.rostone.cat.ast.var.VarDec;
import io.rostone.cat.binder.Binder;
import io.rostone.cat.utils.Position;

public class ForExp extends Exp {
    VarDec var;
    Exp bound;
    Exp op;
    SeqExp body;

    public ForExp(VarDec var,Exp bound, Exp op, SeqExp body, Position pos) {
        this.var = var;
        this.bound = bound;
        this.op = op;
        this.body = body;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        bind.newVar();
        if (var != null) {
            bind = var.bind(bind);
        }
        if (bound != null) {
            bind = bound.bind(bind);
        }
        if (op != null) {
            bind = op.bind(bind);
        }
        if (body != null) {
            bind = body.bind(bind);
        }
        bind.popVar();
        return bind;
    }

    @Override
    public void typeCheck() {
        if (var != null) {
            var.typeCheck();
        }
        if (bound != null) {
            bound.typeCheck();
        }
        if (op != null) {
            op.typeCheck();
        }
        if (body != null) {
            body.typeCheck();
        }

        this.type = body.getType();
    }
}
