package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.binder.Binder;
import io.rostone.cat.utils.ErrorHandler;
import io.rostone.cat.utils.Position;

public class VarExp extends Exp {
    public String name;
    public VarDec var;

    public VarExp(String name, Position pos) {
        this.name = name;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            var = bind.getVar(name);
        } catch (Exception e) {
            ErrorHandler.error(this, 3, e.getMessage());
        }

        return bind;
    }

    @Override
    public void typeCheck() {
        Type t = var.getType();
        if (t == null) {
            var.typeCheck();
            t = var.getType();
        }
        this.type = t;
    }
}
