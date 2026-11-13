package kot.ast.var;

import kot.ast.Exp;
import kot.ast.type.Type;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;

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
            if (var == null)
            {
                ErrorHandler.error(this, 3, "No var '" + name + "' in scope");
            }
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
