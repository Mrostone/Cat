package io.rostone.cat.ast;

import java.util.ArrayList;

public class SeqExp extends Exp {
    ArrayList<Exp> list = new ArrayList<>();

    public SeqExp() {
    }

    public void add(Exp exp) {
        list.add(exp);
    }
}
