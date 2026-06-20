package io.rostone.cat;

import io.rostone.cat.ast.function.CallExp;
import io.rostone.cat.lexing.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("No args given");
            return;
        }
        Lexer lexer = new Lexer(args[0]);
        List<Token> list = new ArrayList<>();
        CallExp callExp = new CallExp();
        Token token = lexer.getToken();
        while (token != null) {
            list.add(token);
            System.out.println(callExp.parse(list));
            System.out.println(token);
            token = lexer.getToken();
        }

        //Class<?>[] list = Exp.class.getPermittedSubclasses();
        //System.out.println(list);

        System.out.println("========= END ==========");
    }
}