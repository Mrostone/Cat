package io.rostone.cat.ast;

import java.util.ArrayList;

import io.rostone.cat.binder.Binder;

public class SeqExp extends Exp {
    ArrayList<Exp> list = new ArrayList<>();

    public SeqExp() {
    }

    public void add(Exp exp) {
        list.add(exp);
    }

    @Override
    public Binder bind(Binder bind) {
        for(Exp e : list) {
            bind = e.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        for(Exp e : list) {
            e.typeCheck();
        }

        this.type = list.getLast().getType();
    }
}
