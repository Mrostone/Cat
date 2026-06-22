package io.rostone.cat.ast.function;

import io.rostone.cat.ast.*;
import io.rostone.cat.lexing.*;

import java.util.*;

public class CallExp extends Exp {
    public String name;
    public List<Token> list;
    public FunctionDec functionDec;

    public CallExp(){

    }

    private CallExp(String name, List<Token> list, FunctionDec functionDec){
        this.name = name;
        this.list = list;
        this.functionDec = functionDec;
    }

    @Override
    public Exp parse(List<Token> list) {
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
        ArrayList<Token> listArgs = new ArrayList<>();
        for (int i = 2; i <= list.size() - 2; i++){
            if(i % 2 == 0){
                if(list.get(i).getCategory() != TokenCategory.VARIABLE)
                {
                    return null;
                }
                listArgs.add(list.get(i));
            }
            else{
                if(list.get(i).getCategory() != TokenCategory.PONCTUATION){
                    return null;
                }
            }
        }
        if(list.get(list.size() - 1).type() != TokenType.RPAREN)
        {
            return null;
        }

        return new CallExp(list.get(0).text(), listArgs, null); 
    }
}
