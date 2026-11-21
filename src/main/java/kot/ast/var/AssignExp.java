package kot.ast.var;

import kot.assembly.Assembly;
import kot.ast.Exp;
import kot.ast.type.IntType;
import kot.ast.type.Type;
import kot.ast.type.VoidType;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;

public class AssignExp extends Exp {
    public VarExp var;
    public Exp exp;

    public AssignExp(VarExp var, Exp exp, Position pos) {
        this.var = var;
        this.exp = exp;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (var != null) {
            bind = var.bind(bind);
        }
        if (exp != null) {
            bind = exp.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        if (var != null) {
            var.typeCheck();;
        }
        if (exp != null) {
            exp.typeCheck();;
        }

        Type t1 = var.getType();
        Type t2 = exp.getType();

        if (!t1.verify(t2)) {
            ErrorHandler.error(this, 4, "Type incompatible excpected : " + t1 + " got : " + t2);
        }

        this.type = VoidType.getInstance();
    }

    @Override
    public void clean() {
        exp.clean();
    }

    @Override
    public Assembly assemble(Assembly asm) {
        asm = exp.assemble(asm);
        String expValue = asm.lastExp;

        if(var.type == IntType.getInstance())
        {
            String out = String.format("\tmovq %s, %s\n", expValue, var.name);
            asm.lastExp = out;
        }
        // TODO Other type

        return asm;
    }
}
