package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.StringType;

public class StringExp extends Exp{
    public String value;

    public StringExp(String value)
    {
        this.value = value;
    }

    public void typeCheck() {
        this.type = StringType.getInstance();
    }
}
