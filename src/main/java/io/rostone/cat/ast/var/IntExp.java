package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.IntType;

public class IntExp extends Exp {
    public long value;

    public IntExp(String value)
    {
        this.value = Long.parseLong(value);
    }

    public void typeCheck() {
        this.type = IntType.getInstance();
    }
}
