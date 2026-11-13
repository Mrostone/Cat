package kot;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import kot.antlr.KotLexer;
import kot.antlr.KotParser;
import kot.antlr.KotParser.AstContext;
import kot.ast.Ast;
import kot.binder.Binder;
import kot.typecheck.TypeCheck;

public class Main {
    public static void main(String[] args){
        if(args.length == 0){
            System.err.println("No args given");
            return;
        }
        String file = "";
        boolean displayAst = false;
        boolean txtParse = false;
        String fileAst = "ast.html";
        for (int i = 0; i < args.length; i++)
        {
            String arg = args[i];
            switch (arg) {
                case "-a":
                        displayAst = true;
                        if(i + 2 < args.length)
                        {
                            fileAst = args[i + 1];
                            i++;
                        }
                    break;
                case "--txt":
                        txtParse = true;
                        if(i + 2 < args.length)
                        {
                            fileAst = args[i + 1];
                            i++;
                        }
                    break;
                default:
                    if (arg.startsWith("-"))
                    {
                        System.err.println("Unkown option");
                    }
                    else
                    {
                        file = arg;
                    }
                    break;
            }
        }
        CharStream input;
        try {
                input = CharStreams.fromFileName(file);
                KotLexer lexer = new KotLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                KotParser parser = new KotParser(tokens);

                AstContext astContext = parser.ast();

                Ast ast = astContext.node;

                if (parser.getNumberOfSyntaxErrors() > 0) {
                    System.err.println("Compilation failed: Syntax errors found.");
                    System.exit(1);
                }

                if (txtParse)
                {
                    KotParser.AstContext tree = astContext;
                    try {
                      FileWriter myWriter = new FileWriter(file + ".txt");
                      myWriter.write(tree.getText().substring(0, tree.getText().length() - 5));
                      myWriter.close();
                    } catch (IOException e) {
                      System.out.println("An error occurred.");
                      e.printStackTrace();
                    }
                }

                Binder binder = new Binder(ast);

                binder.bind();

                TypeCheck typeCheck = new TypeCheck(ast);

                typeCheck.typeCheck();

                if(displayAst)
                {
                    Ast.toHtml(ast, Path.of(fileAst));
                }
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.err.println("Compilation failed: Syntax errors found.");
                System.exit(1);
        }
    }
}