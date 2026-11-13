package kot.typecheck;

import kot.ast.Ast;
import kot.ast.Exp;

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
