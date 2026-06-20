package io.rostone.cat.ast.function;

import io.rostone.cat.ast.*;
import io.rostone.cat.lexing.*;

import java.util.*;

public class CallExp extends Exp {
    Token func;
    List<Token> list;

    public CallExp(){

    }

    private CallExp(Token func, List<Token> list){
        this.func = func;
        this.list = list;
    }

    @Override
    public Exp parse(List<Token> list) {
        System.out.println("Analyse via l'instance unique de CallExp");
        if(list.size() < 2){
            return null;
        }
        if(list.get(0).getCategory() != TokenCategory.PRIMITIVE)
        {
            return null;
        }
        if(list.get(1).type() != TokenType.LPAREN)
        {
            return null;
        }
        for (int i = 2; i < list.size() - 2; i++){
            if(list.get(i).getCategory() != TokenCategory.VARIABLE){
                return null;
            }
        }
        if(list.get(list.size() - 1).type() != TokenType.RPAREN)
        {
            return null;
        }

        return new CallExp(list.get(0), list.subList(2,list.size() - 1)); 
    }
}
