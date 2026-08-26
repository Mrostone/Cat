package io.rostone.cat.ast.function;

import io.rostone.cat.ast.*;
import io.rostone.cat.binder.Binder;
import io.rostone.cat.utils.ErrorHandler;
import io.rostone.cat.utils.Position;

import java.util.*;

public class CallExp extends Exp {
    public String name;
    public List<Exp> args;
    public FunctionDec functionDec;

    public CallExp(){
    }

    public CallExp(String name, List<Exp> args, FunctionDec functionDec, Position pos){
        this.name = name;
        this.args = args;
        this.functionDec = functionDec;
        this.pos = pos;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            functionDec = bind.getFunc(name);
        } catch (Exception e) {
            ErrorHandler.error(this, 4, e.getMessage());
        }

        for (Exp e : args) {
            bind = e.bind(bind);
        }

        return bind;
    }

    @Override
    public void typeCheck() {
        if (args.size() != functionDec.list.size()) {
            ErrorHandler.error(this, 4, "number argument invalid got : " +args.size() + "excpected : " + functionDec.list.size());
        }
        for (int i = 0; i <= args.size(); i++) {
            args.get(i).typeCheck();
            if (args.get(i).getType() != functionDec.list.get(i).getType()) {
                ErrorHandler.error(this, 4, "argument " + i + "invalid type : " + args.get(i).getType() + " excpected : " + functionDec.list.get(i).getType());
            }
        }
        this.type = functionDec.getType();
    }
}