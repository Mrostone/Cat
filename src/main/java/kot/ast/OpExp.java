package kot.ast;

import kot.assembly.Assembly;
import kot.ast.type.IntType;
import kot.ast.type.Type;
import kot.ast.var.IntExp;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Op;
import kot.utils.Position;

public class OpExp extends Exp{
    Exp left;
    Op op;
    Exp right;

    public OpExp(Exp left, Op op, Exp right, Position pos) {
        this.left = left;
        this.op = op;
        this.right = right;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (left != null) {
            bind = left.bind(bind);
        }
        if (right != null) {
            bind = right.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        if (left != null) {
            left.typeCheck();
        }
        if (right != null) {
            right.typeCheck();
        }

        Type l = left.getType();
        Type r = left.getType();

        if (op.equals(Op.add) || op.equals(Op.sub) || op.equals(Op.mul) || op.equals(Op.div)) {
            if (l != IntType.getInstance()) {
                ErrorHandler.error(this, 4, "Error left expretion not an int : " + l.getClass());
            }
            if (r != IntType.getInstance()) {
                ErrorHandler.error(this, 4, "Error right expretion not an int : " + r.getClass());
            }
        }
        else if (op.equals(Op.eq) || op.equals(Op.ge) || op.equals(Op.gt) || op.equals(Op.le) || op.equals(Op.lt) || op.equals(Op.ne)) {
            if (!l.verify(r)) {
                ErrorHandler.error(this, 4, "Type not compatible : " + l.getClass() + " and " + r.getClass());
            }
        }

        this.type = l;
    }

    @Override
    public Assembly assemble(Assembly asm) {
        asm = left.assemble(asm);
        String leftValue = asm.lastExp;

        asm = right.assemble(asm);
        String rightValue = asm.lastExp;

        String out = String.format("\tmov %s, %%rdi\n\tmov %s, %%rsi\n\tmov $%d, %%rdx\n", leftValue, rightValue, op.getNum());

        asm.lastExp = out;
        return asm;
    }
}
