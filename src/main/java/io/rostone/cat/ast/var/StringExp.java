package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;

public class StringExp extends Exp{
    public String value;

    public StringExp(String value)
    {
        this.value = value;
    }
}
