package io.rostone.cat.typecheck;

import io.rostone.cat.ast.Ast;

public class TypeCheck {
    Ast ast;

    public TypeCheck(Ast ast) {
        this.ast = ast;
    }

    public void typeCheck(){
        ast.exps.getFirst().typeCheck();
    }
}
