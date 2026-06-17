package main.java;

import main.java.lexing.Lexer;

class Main {
    public static void main(String[] args){
        Lexer lexer = new Lexer();
        lexer.lexing(args[0]);
    }
}