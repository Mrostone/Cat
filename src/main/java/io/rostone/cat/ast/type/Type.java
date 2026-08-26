package io.rostone.cat.ast.type;

public abstract class Type {
    public boolean verify(Type type) {
        return this.getClass().equals(type.getClass());
    }
}
