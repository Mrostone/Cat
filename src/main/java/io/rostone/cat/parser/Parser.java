package io.rostone.cat.parser;

import org.reflections.Reflections;

public class Parser {
    private void registerExpressions() {
        Reflections reflections = new Reflections("main.java.ast");
        Set<Class<? extends Exp>> subTypes = reflections.getSubTypesOf(Exp.class);

        for (Class<? extends Exp> clazz : subTypes) {
            try {
                Exp instance = clazz.getDeclaredConstructor().newInstance();
                availableExpressions.add(instance);
                System.out.println("Expression enregistrée automatiquement : " + clazz.getSimpleName());
            } catch (Exception e) {
                System.err.println("Impossible d'enregistrer " + clazz.getName() + " : " + e.getMessage());
            }
        }
    }
}
