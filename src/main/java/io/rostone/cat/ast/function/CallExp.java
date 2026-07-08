package io.rostone.cat.ast.function;

import io.rostone.cat.ast.*;

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
}