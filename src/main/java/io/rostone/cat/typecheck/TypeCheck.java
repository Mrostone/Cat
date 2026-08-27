package io.rostone.cat.typecheck;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.Exp;

public class TypeCheck {
    Ast ast;

    public TypeCheck(Ast ast) {
        this.ast = ast;
    }

    public void typeCheck(){
        for (Exp e : ast.exps) {
            e.typeCheck();
        }
    }
}
