package kot.ast;

import kot.ast.type.Type;
import kot.binder.Binder;
import kot.utils.Position;

public abstract class Exp {
    public Type type = null;
    public Position pos = null;

    public Binder bind(Binder bind) {
        return bind;
    }

    public void typeCheck() {
        return;
    }

    public Type getType() {
        return type;
    }
}
