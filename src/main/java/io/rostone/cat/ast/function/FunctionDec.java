package io.rostone.cat.ast.function;

import java.util.List;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;
import io.rostone.cat.ast.var.VarDec;
import io.rostone.cat.binder.Binder;

public class FunctionDec extends Exp{
    public Type type;
    public String name;
    public List<VarDec> list;
    public Exp body;

    public FunctionDec(Type type, String name, List<VarDec> list, Exp body){
        this.type = type;
        this.name = name;
        this.list = list;
        this.body = body;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            bind.addFunc(name, this);
        } catch (Exception e) {
            System.err.print(e.getMessage());
            System.exit(3);
        }

        bind.newVar();
        for (VarDec v : list) {
            bind = v.bind(bind);
        }
        bind = body.bind(bind);
        bind.popVar();

        return bind;
    }
}
