package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.binder.Binder;

public class VarDec extends Exp{
    public String name;
    //public Type type;
    public Exp init;

    public VarDec(String name, Type type, Exp init) {
        this.name = name;
        this.type = type;
        this.init = init;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            bind.addVar(name, this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(3);
        }
        if (init != null) {
            return init.bind(bind);
        }
        return bind;
    }

    public void typeCheck() {
        if (init != null) {
            init.typeCheck();
            Type t = init.getType();
            if (t != this.type) {
                System.err.println("Error type VarDec");
                System.exit(4);
            }
        }
    }
}
