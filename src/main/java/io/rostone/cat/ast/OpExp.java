package io.rostone.cat.ast;

public class OpExp extends Exp{
    Exp left;
    Op op;
    Exp right;

    public OpExp(Exp left, Op op, Exp right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
