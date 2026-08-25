package io.rostone.cat.ast.function;

import io.rostone.cat.ast.*;
import io.rostone.cat.binder.Binder;

import java.util.*;

public class CallExp extends Exp {
    public String name;
    public List<Exp> args;
    public FunctionDec functionDec;

    public CallExp(){
    }

    public CallExp(String name, List<Exp> args, FunctionDec functionDec){
        this.name = name;
        this.args = args;
        this.functionDec = functionDec;
    }

    @Override
    public Binder bind(Binder bind) {
        try {
            functionDec = bind.getFunc(name);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(3);
        }

        for (Exp e : args) {
            bind = e.bind(bind);
        }

        return bind;
    }

    @Override
    public void typeCheck() {
        if (args.size() != functionDec.list.size()) {
            System.err.println("Nb args error");
            System.exit(4);
        }
        for (int i = 0; i <= args.size(); i++) {
            args.get(i).typeCheck();
            if (args.get(i).getType() != functionDec.list.get(i).getType()) {
                System.err.println("Arg error");
                System.exit(4);
            }
        }
        this.type = functionDec.getType();
    }
}