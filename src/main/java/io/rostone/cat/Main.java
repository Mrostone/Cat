package io.rostone.cat;

import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import io.rostone.cat.antlr.CatLexer;
import io.rostone.cat.antlr.CatParser;
import io.rostone.cat.ast.Ast;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("No args given");
            return;
        }
        CharStream input;
        try {
                input = CharStreams.fromFileName(args[0]);
                CatLexer lexer = new CatLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CatParser parser = new CatParser(tokens);

                Ast ast = parser.ast().node;

                if (parser.getNumberOfSyntaxErrors() > 0) {
                    System.err.println("Compilation failed: Syntax errors found.");
                    System.exit(1);
                }

                //Ast.toHtml(ast, Path.of("ast.html"));
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.err.println("Compilation failed: Syntax errors found.");
                System.exit(1);
        }
    }
}