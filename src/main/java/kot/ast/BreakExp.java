package kot.ast;

import kot.ast.var.VarDec;
import kot.binder.Binder;
import kot.utils.Position;
import kot.utils.ErrorHandler;

public class BreakExp extends Exp {
    Exp loop;
    public BreakExp(Position pos) {
        this.pos = pos;
        this.loop = null;
    }

    @Override
    public Binder bind(Binder bind) {
        if (bind.currentLoop == null)
        {
            ErrorHandler.error(this, 3, "Break not inside a loop");
        }
        this.loop = bind.currentLoop;
        return bind;
    }

    @Override
    public void typeCheck() {
        return;
    }

    @Override
    public void clean() {
        return;
    }
}