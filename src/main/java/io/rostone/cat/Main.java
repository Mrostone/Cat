package io.rostone.cat;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.function.CallExp;
import io.rostone.cat.parser.*;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("No args given");
            return;
        }
        Parser parse = new Parser();

        Ast ast = parse.parse(args[0]);

        System.out.println(((CallExp) ast.exps.get(0)).list);

        System.out.println("========= END ==========");
    }
}