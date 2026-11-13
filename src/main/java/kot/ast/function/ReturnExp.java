package kot.ast.function;

import kot.ast.Exp;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;

public class ReturnExp extends Exp {
    Exp exp;

    public ReturnExp(Exp exp, Position pos) {
        this.exp = exp;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (exp == null) {
            ErrorHandler.error(this, 3, "null expresion ");
        }
        return exp.bind(bind);
    }

    @Override
    public void typeCheck() {
        exp.typeCheck();
        this.type = exp.getType();
    }
}
