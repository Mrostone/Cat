package main.java.ast.function;

import main.java.ast.Exp;

public class CallExp extends Exp {
    @Override
    public List<Token> getExpectedTokens() {
        return List.of(Token);
    }

    @Override
    public Exp parse(List<Token> list) {
        System.out.println("Analyse via l'instance unique de CallExp");

        return this; 
    }
}
