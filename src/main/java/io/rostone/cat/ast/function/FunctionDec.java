package io.rostone.cat.ast.function;

import java.util.ArrayList;
import java.util.List;

import io.rostone.cat.ast.Exp;
import io.rostone.cat.ast.function.args.Argument;
import io.rostone.cat.lexing.Token;
import io.rostone.cat.lexing.TokenCategory;
import io.rostone.cat.lexing.TokenType;

public class FunctionDec extends Exp{
    public String name;
    public List<Argument> list;
    public Exp body;

    public FunctionDec(){

    }

    private FunctionDec(String name, List<Argument> list, Exp body){
        this.name = name;
        this.list = list;
        this.body = body;
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

        // TODO
        return null;

        //return new FunctionDec(list.get(0).text(), listArgs, null); 
    }
}
