package primitives;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.ast.function.CallExp;
import io.rostone.cat.lexing.TokenType;
import io.rostone.cat.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

public class Primitives {
    Parser parse = new Parser();

    @Test
    void printHello() {
        Ast ast = parse.parse("src/test/java/primitives/printHello.cat");

        assertEquals(1, ast.exps.size());
        assertInstanceOf(CallExp.class, ast.exps.get(0));
        assertEquals(TokenType.PRINT, ((CallExp) ast.exps.get(0)).func.type());
    }

    @Test
    void exit() {
        Ast ast = parse.parse("src/test/java/primitives/exit.cat");

        assertEquals(1, ast.exps.size());
        assertInstanceOf(CallExp.class, ast.exps.get(0));
        assertEquals(TokenType.EXIT, ((CallExp) ast.exps.get(0)).func.type());
    }
}
