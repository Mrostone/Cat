package io.rostone.cat.ast.function.args;

import java.util.List;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.lexing.Token;
import io.rostone.cat.lexing.TokenCategory;

public class Argument extends Exp {
    public String name;
    public String type;

    public Argument(){
    }

    private Argument(String type, String name){
        this.name = name;
        this.type = type;
    }

    @Override
    public Exp parse(List<Token> list) {
        if(list.size() < 2){
            return null;
        }
        if(list.get(0).getCategory() != TokenCategory.VARIABLE && list.get(1).getCategory() != TokenCategory.VARIABLE)
        {
            return null;
        }

        return new Argument(list.get(0).text(), list.get(1).text()); 
    }
    
}
