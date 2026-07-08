package io.rostone.cat.ast.function;

import java.util.List;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.var.VarDec;

public class FunctionDec extends Exp{
    public String name;
    public List<VarDec> list;
    public Exp body;

    public FunctionDec(){

    }

    private FunctionDec(String name, List<VarDec> list, Exp body){
        this.name = name;
        this.list = list;
        this.body = body;
    }
}
