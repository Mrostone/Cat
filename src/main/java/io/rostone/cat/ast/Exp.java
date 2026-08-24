package io.rostone.cat.ast;

import io.rostone.cat.binder.Binder;

public abstract class Exp {
    public abstract Binder bind(Binder bind);
}
