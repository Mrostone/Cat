package io.rostone.cat.binder;

import java.util.ArrayList;
import java.util.HashMap;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.function.FunctionDec;
import io.rostone.cat.ast.type.IntType;
import io.rostone.cat.ast.type.StringType;
import io.rostone.cat.ast.type.VoidType;
import io.rostone.cat.ast.var.VarDec;

public class Binder {
    Ast ast;
    public ArrayList<HashMap<String,FunctionDec>> function = new ArrayList<>();
    public ArrayList<HashMap<String,VarDec>> var = new ArrayList<>();

    public Binder(Ast ast) {
        this.ast = ast;
    }

    public void bind(){
        newFunc();
        newVar();
        ast.exps.getFirst().bind(this);
    }

    //PRIMITIVES

    public FunctionDec getPrimitive(String name) {
        for (Exp e : ast.exps) {
            if (e instanceof FunctionDec) {
                FunctionDec f = (FunctionDec) e;
                if (f.name == name) {
                    return f;
                }
            }
        }

        if (name.equals("print")) {
            ArrayList<VarDec> list = new ArrayList<>();
            list.add(new VarDec("string", StringType.getInstance(), null));
            FunctionDec func = new FunctionDec(VoidType.getInstance(), name, list, null);
            ast.exps.addFirst(func);
            return func;
        }
        else if (name.equals("exit")) {
            ArrayList<VarDec> list = new ArrayList<>();
            list.add(new VarDec("number", IntType.getInstance(), null));
            FunctionDec func = new FunctionDec(VoidType.getInstance(), name, list, null);
            ast.exps.addFirst(func);
            return func;
        }
        else if (name.equals("strCmp")) {
            ArrayList<VarDec> list = new ArrayList<>();
            list.add(new VarDec("string1", StringType.getInstance(), null));
            list.add(new VarDec("string2", StringType.getInstance(), null));
            FunctionDec func = new FunctionDec(IntType.getInstance(), name, list, null);
            ast.exps.addFirst(func);
            return func;
        }
        return null;
    }

    // FUNCTIONS

    public void newFunc() {
        function.add(new HashMap<>());
    }

    public void popFunc() {
        function.removeLast();
    }

    public void addFunc(String name, FunctionDec func) throws Exception {
        if (function.size() == 0) {
            throw new Exception("No scope for function");
        }

        function.getLast().put(name, func);
    }

    public FunctionDec getFunc(String name) throws Exception {
        FunctionDec primitive = getPrimitive(name);
        if (primitive != null) {
            return primitive;
        }

        if (function.size() == 0) {
            throw new Exception("No scope for function");
        }

        for (HashMap<String, FunctionDec> h : function.reversed()) {
            if (h.containsKey(name)) {
                return h.get(name);
            }
        }

        throw new Exception("No function " + name + " in scope");
    }

    public void newVar() {
        var.add(new HashMap<>());
    }

    public void popVar() {
        var.removeLast();
    }

    public void addVar(String name,VarDec exp) throws Exception {
        if (var.size() == 0) {
            throw new Exception("No scope for var");
        }

        var.getLast().put(name, exp);
    }

    public VarDec getVar(String name) throws Exception {
        if (var.size() == 0) {
            throw new Exception("No scope for var");
        }

        for (HashMap<String,VarDec> h : var.reversed()) {
            if (h.containsKey(name)) {
                return h.get(name);
            }
        }

        return null;
    }
}
