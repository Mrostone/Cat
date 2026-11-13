package kot.ast.var;

import kot.ast.Exp;
import kot.ast.type.IntType;
import kot.utils.Position;

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
