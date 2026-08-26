package io.rostone.cat.utils;

import io.rostone.cat.ast.Exp;

public class ErrorHandler {
    public static final String RESET = "\u001B[0m";

    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

    public static void error(Exp exp, int status, String message) {
        if (status == 2) {
            System.err.println(RED + "ERROR " + PURPLE + "PARSING " + RESET + exp.pos.print() + " : " + message);
        }
        else if (status == 3) {
            System.err.println(RED + "ERROR " + CYAN + "BINDER " + RESET + exp.pos.print() + " : " + message);
        }
        else if (status == 4) {
            System.err.println(RED + "ERROR " + YELLOW + "TYPE " + RESET + exp.pos.print() + " : " + message);
        }
        System.exit(status);
    }
}
