package io.rostone.cat.ast.var;

import io.rostone.cat.ast.Exp;

public class VarDec extends Exp{
    public String name;
    public String type;
    public Exp init;
}
