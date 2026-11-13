package kot.ast.var;

import kot.ast.Exp;
import kot.ast.type.Type;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;

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
