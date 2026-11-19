package kot.ast;

import kot.ast.type.VoidType;
import kot.binder.Binder;
import kot.utils.Position;

public class WhileExp extends Exp {
    Exp op;
    SeqExp body;

    public WhileExp(Exp op, SeqExp body, Position pos) {
        this.op = op;
        this.body = body;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        if (op != null) {
            bind = op.bind(bind);
        }
        if (body != null) {
            Exp tempLoop = bind.currentLoop;
            bind.currentLoop = this;
            bind = body.bind(bind);
            bind.currentLoop = tempLoop;
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
    }

    @Override
    public void clean() {
        if (op != null) {
            op.clean();
        }
        if (body != null) {
            body.clean();
        }
    }
}