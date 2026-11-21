package kot.ast;

import kot.assembly.Assembly;
import kot.ast.type.VoidType;
import kot.binder.Binder;
import kot.utils.Position;
import java.util.ArrayList;
import kot.utils.ErrorHandler;

public class IfExp extends Exp {
    Exp op;
    SeqExp body;
    ArrayList<IfExp> elifList;
    SeqExp elseClause;

    public IfExp(Exp op, SeqExp body, ArrayList<IfExp> elifList, SeqExp elseClause, Position pos) {
        this.op = op;
        this.body = body;
        this.elifList = elifList;
        this.elseClause = elseClause;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (op != null) {
            bind = op.bind(bind);
        }
        if (body != null) {
            bind = body.bind(bind);
        }
        for (IfExp el : elifList)
        {
            bind = el.bind(bind);
        }
        if(elseClause != null) {
            bind = elseClause.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        if (op != null) {
            op.typeCheck();
        }
        if (body != null) {
            body.typeCheck();
            this.type = body.getType();
        }
        else {
            this.type = VoidType.getInstance();
        }

        for (IfExp el : elifList)
        {
            el.typeCheck();
            if (this.type != el.getType())
            {
                ErrorHandler.error(this, 4, "Error if type : " + this.type.getClass() + " and elif type : " + el.getType().getClass());
            }
        }
        if(elseClause != null) {
            elseClause.typeCheck();
            if (this.type != elseClause.getType())
            {
                ErrorHandler.error(this, 4, "Error if type : " + this.type.getClass() + " and else type : " + elseClause.getType().getClass());
            }
        }
    }

    @Override
    public void clean() {
        if (op != null) {
            op.clean();
        }
        if (body != null) {
            body.clean();
        }
        for (IfExp el : elifList)
        {
            el.clean();
        }
        if(elseClause != null) {
            elseClause.clean();
        }
    }

    @Override
    public Assembly assemble(Assembly asm) {
        String out = "";
        if (op instanceof OpExp) {
            OpExp opExp = (OpExp) op;
            opExp.assemble(asm);
            out = out.concat(asm.lastExp);
        }
        // TODO other type of op
        out = out.concat("\tcall my_if\n");
        out = out.concat("\tcmp $1, %rax\n");
        
        body.assemble(asm);

        out = out.concat("\tje " + body.nameAssembly + "\n");

        for (IfExp el : elifList)
        {
            el.assemble(asm);
            out = out.concat(asm.lastExp);
        }

        asm.lastExp = out;
        return asm;
    }
}