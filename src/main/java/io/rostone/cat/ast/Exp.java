package io.rostone.cat.ast;

import io.rostone.cat.ast.type.Type;
import io.rostone.cat.binder.Binder;

public abstract class Exp {
    public Type type = null;

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
