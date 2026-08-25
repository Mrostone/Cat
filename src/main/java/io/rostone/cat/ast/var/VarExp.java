package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.binder.Binder;

public class VarExp extends Exp {
    public String name;
    public VarDec var;

    public VarExp(String name) {
        this.name = name;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            var = bind.getVar(name);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(3);
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
