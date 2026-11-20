package kot.ast.var;

import kot.ast.Exp;
import kot.ast.type.StringType;
import kot.utils.Position;

public class StringExp extends Exp{
    public String value;

    public StringExp(String value, Position pos)
    {
        this.value = value;
        this.pos = pos;
    }

    @Override
    public void typeCheck() {
        this.type = StringType.getInstance();
    }
}
