package kot.ast.var;

import kot.ast.Exp;
import kot.ast.type.IntType;
import kot.utils.Position;
import kot.assembly.*;

public class IntExp extends Exp {
    public long value;

    public IntExp(String value, Position pos)
    {
        this.value = Long.parseLong(value);
        this.pos = pos;
    }

    @Override
    public void typeCheck() {
        this.type = IntType.getInstance();
    }

    @Override
    public Assembly assemble(Assembly asm) {
        String ret = String.format("$%d", value);
        asm.lastExp = ret;
        return asm;
    }
}
