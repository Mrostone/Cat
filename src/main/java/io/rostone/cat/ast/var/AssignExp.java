package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.ast.type.VoidType;
import io.rostone.cat.binder.Binder;
import io.rostone.cat.utils.ErrorHandler;
import io.rostone.cat.utils.Position;

public class AssignExp extends Exp {
    public VarExp var;
    public Exp exp;

    public AssignExp(VarExp var, Exp exp, Position pos) {
        this.var = var;
        this.exp = exp;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (var != null) {
            bind = var.bind(bind);
        }
        if (exp != null) {
            bind = exp.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        if (var != null) {
            var.typeCheck();;
        }
        if (exp != null) {
            exp.typeCheck();;
        }

        Type t1 = var.getType();
        Type t2 = exp.getType();

        if (!t1.verify(t2)) {
            ErrorHandler.error(this, 4, "Type incompatible excpected : " + t1 + " got : " + t2);
        }

        this.type = VoidType.getInstance();
    }
}
