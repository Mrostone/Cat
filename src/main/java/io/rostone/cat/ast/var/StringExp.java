package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.StringType;
import io.rostone.cat.utils.Position;

public class StringExp extends Exp{
    public String value;

    public StringExp(String value, Position pos)
    {
        this.value = value;
        this.pos = pos;
    }

    public void typeCheck() {
        this.type = StringType.getInstance();
    }
}
