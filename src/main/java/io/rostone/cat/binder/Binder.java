package io.rostone.cat.binder;

import java.util.ArrayList;
import java.util.HashMap;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.Exp;

public class Binder {
    Ast ast;
    public ArrayList<HashMap<String,Exp>> function = new ArrayList<>();
    public ArrayList<HashMap<String,Exp>> var = new ArrayList<>();

    public Binder(Ast ast) {
        this.ast = ast;
    }

    public void bind(){
    }

    // FUNCTIONS

    public void newFunc() {
        function.add(new HashMap<>());
    }

    public void popFunc() {
        function.removeLast();
    }

    public void addFunc(String name, Exp exp) throws Exception {
        if (function.size() == 0) {
            throw new Exception("No scope for function");
        }

        function.getLast().put(name, exp);
    }

    public Exp getFunc(String name) throws Exception {
        if (function.size() == 0) {
            throw new Exception("No scope for function");
        }

        int ind = function.size();

        for (int i = ind; ind >= 0; i-- ) {
            HashMap<String,Exp> h = function.get(i);
            if (h.containsKey(name)) {
                return h.get(name);
            }
        }

        return null;
    }

    public void newVar() {
        var.add(new HashMap<>());
    }

    public void popVar() {
        var.removeLast();
    }

    public void addVar(String name, Exp exp) throws Exception {
        if (var.size() == 0) {
            throw new Exception("No scope for var");
        }

        var.getLast().put(name, exp);
    }

    public Exp getVar(String name) throws Exception {
        if (var.size() == 0) {
            throw new Exception("No scope for var");
        }

        int ind = var.size();

        for (int i = ind; ind >= 0; i-- ) {
            HashMap<String,Exp> h = var.get(i);
            if (h.containsKey(name)) {
                return h.get(name);
            }
        }

        return null;
    }
}
