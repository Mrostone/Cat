package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.binder.Binder;
import io.rostone.cat.utils.ErrorHandler;
import io.rostone.cat.utils.Position;

public class VarDec extends Exp{
    public String name;
    public Exp init;

    public VarDec(String name, Type type, Exp init, Position pos) {
        this.name = name;
        this.type = type;
        this.init = init;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            bind.addVar(name, this);
        } catch (Exception e) {
            ErrorHandler.error(this, 3, e.getMessage());
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
                ErrorHandler.error(this, 4, "error type var got : " + this.type + " excpected : " + t);
            }
        }
    }
}
