package kot.ast.function;

import kot.assembly.Assembly;
import kot.ast.Exp;
import kot.ast.type.IntType;
import kot.ast.var.IntExp;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;
import kot.assembly.*;

public class ReturnExp extends Exp {
    Exp exp;

    public ReturnExp(Exp exp, Position pos) {
        this.exp = exp;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (exp == null) {
            ErrorHandler.error(this, 3, "null expresion ");
        }
        return exp.bind(bind);
    }

    @Override
    public void typeCheck() {
        exp.typeCheck();
        this.type = exp.getType();
    }

    @Override
    public void clean() {
        exp.clean();
    }

    @Override
    public Assembly assemble(Assembly asm) {
        asm = exp.assemble(asm);
        String ret = String.format("\tmov %s, %%rax\n", asm.lastExp);
        asm.lastExp = ret;
        return asm;
    }
}
