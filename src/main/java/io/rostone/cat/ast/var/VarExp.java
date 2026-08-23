package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;

public class VarExp extends Exp {
    public String name;

    public VarExp(String name) {
        this.name = name;
    }
}
