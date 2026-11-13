package kot.ast.function;

import java.util.List;

import kot.ast.Exp;
import kot.ast.type.Type;
import kot.ast.var.VarDec;
import kot.binder.Binder;
import kot.utils.ErrorHandler;
import kot.utils.Position;

public class FunctionDec extends Exp{
    public String name;
    public List<VarDec> list;
    public Exp body;

    public FunctionDec(Type type, String name, List<VarDec> list, Exp body, Position pos){
        this.type = type;
        this.name = name;
        this.list = list;
        this.body = body;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            bind.addFunc(name, this);
        } catch (Exception e) {
            ErrorHandler.error(this, 3, e.getMessage());
        }

        bind.newVar();
        for (VarDec v : list) {
            bind = v.bind(bind);
        }
        if (body != null) {
            bind = body.bind(bind);
        }
        bind.popVar();

        return bind;
    }

    @Override
    public void typeCheck() {
        for (VarDec v : list) {
            v.typeCheck();
        }
        if (body != null) {
            body.typeCheck();
            if (body.getType() != this.type) {
                ErrorHandler.error(this, 4, "type body different from type function " + this.type + " and " + body.getType());
            }
        }
    }
}
