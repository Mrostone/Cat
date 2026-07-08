package io.rostone.cat;

import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import io.rostone.cat.antlr.CatLexer;
import io.rostone.cat.antlr.CatParser;
import io.rostone.cat.ast.Ast;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("No args given");
            return;
        }
        //Parser parse = new Parser();
//
        //Ast ast = parse.parse(args[0]);
//
        //System.out.println("======= ast =========");
        //Ast.toHtml(ast, Path.of("ast.html"));
        //System.out.println("======= end ast =====");
//
        //System.out.println(((CallExp) ast.exps.get(0)).list);
//
        //System.out.println("========= END ==========");
        CharStream input;
        try {
                input = CharStreams.fromFileName(args[0]);
                CatLexer lexer = new CatLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CatParser parser = new CatParser(tokens);

                Ast ast = parser.ast().node;

                Ast.toHtml(ast, Path.of("ast.html"));
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
}