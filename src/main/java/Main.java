package main.java;

import main.java.lexing.Lexer;
import main.java.lexing.LexerToken;

class Main {
    public static void main(String[] args){
        Lexer lexer = new Lexer(args[0]);
        LexerToken token = lexer.getToken();
        while (token != null) {
            System.out.println(token.getText());
            System.out.println(token);
            token = lexer.getToken();
        }

        System.out.println("========= END ==========");
    }
}