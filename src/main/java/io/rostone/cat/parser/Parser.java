package io.rostone.cat.parser;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.Exp;
import io.rostone.cat.lexing.Lexer;
import io.rostone.cat.lexing.Token;

import org.reflections.Reflections;
import java.util.*;

public class Parser {
    private final List<Exp> availableExpressions = new ArrayList<>();
    private Ast ast = new Ast();

    public Parser() {
        registerExpressions();
    }

    private void registerExpressions() {
        Reflections reflections = new Reflections("io.rostone.cat.ast");
        Set<Class<? extends Exp>> subTypes = reflections.getSubTypesOf(Exp.class);

        for (Class<? extends Exp> clazz : subTypes) {
            try {
                Exp instance = clazz.getDeclaredConstructor().newInstance();
                availableExpressions.add(instance);
            } catch (Exception e) {
                System.err.println("Error on class " + clazz.getName() + " : " + e.getMessage());
            }
        }
    }

    public Ast parse(String file){
        Lexer lexer = new Lexer(file);
        List<Token> list = new ArrayList<>();
        Token token = lexer.getToken();
        while (token != null) {
            list.add(token);
            for (Exp exp : availableExpressions){
                Exp n = exp.parse(list);
                if(n != null){
                    ast.exps.add(n);
                    list.clear();
                    break;
                }
            }
            token = lexer.getToken();
        }

        return ast;
    }
}
