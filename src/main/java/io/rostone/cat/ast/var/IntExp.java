package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.IntType;
import io.rostone.cat.utils.Position;

public class IntExp extends Exp {
    public long value;

    public IntExp(String value, Position pos)
    {
        this.value = Long.parseLong(value);
        this.pos = pos;
    }

    public void typeCheck() {
        this.type = IntType.getInstance();
    }
}
