package kot.ast.var;

import kot.ast.Exp;
import kot.ast.type.Type;
import kot.ast.type.VoidType;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;

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
