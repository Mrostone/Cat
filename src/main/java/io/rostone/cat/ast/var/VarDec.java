package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.type.Type;

public class VarDec extends Exp{
    public String name;
    public Type type;
    public Exp init;

    public VarDec(String name, Type type, Exp init) {
        this.name = name;
        this.type = type;
        this.init = init;
    }
}
