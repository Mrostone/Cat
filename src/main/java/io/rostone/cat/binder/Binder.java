package io.rostone.cat.binder;

import java.util.HashMap;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.Exp;

public class Binder {
    Ast ast;
    HashMap<String,Exp> functionMap = new HashMap<>();

    public Binder(Ast ast) {
        this.ast = ast;
    }

    public void bind(){
    }
}
