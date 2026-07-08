package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;

public class IntExp extends Exp {
    public long value;

    public IntExp(String value)
    {
        this.value = Long.parseLong(value);
    }
}
