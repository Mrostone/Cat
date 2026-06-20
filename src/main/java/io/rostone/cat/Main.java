package io.rostone.cat;

public class Main {
    public static void main(String[] args){
        Lexer lexer = new Lexer(args[0]);
        Token token = lexer.getToken();
        while (token != null) {
            System.out.println(token.getText());
            System.out.println(token.getCategory());
            System.out.println(token);
            token = lexer.getToken();
        }

        Class<?>[] list = Exp.class.getPermittedSubclasses();
        System.out.println(list);

        System.out.println("========= END ==========");
    }
}