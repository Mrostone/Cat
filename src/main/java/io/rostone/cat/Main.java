package io.rostone.cat;

import io.rostone.cat.parser.*;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("No args given");
            return;
        }
        Parser parse = new Parser();

        parse.parse(args[0]);

        System.out.println("========= END ==========");
    }
}