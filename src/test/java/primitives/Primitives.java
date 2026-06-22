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
        assertEquals("print", ((CallExp) ast.exps.get(0)).name);
        assertEquals(1, ((CallExp) ast.exps.get(0)).list.size());

        assertEquals(TokenType.STRING, ((CallExp) ast.exps.get(0)).list.get(0).type());
        assertEquals("Hello World !", ((CallExp) ast.exps.get(0)).list.get(0).text());
    }

    @Test
    void exit() {
        Ast ast = parse.parse("src/test/java/primitives/exit.cat");

        assertEquals(1, ast.exps.size());
        assertInstanceOf(CallExp.class, ast.exps.get(0));
        assertEquals("exit", ((CallExp) ast.exps.get(0)).name);
        assertEquals(1, ((CallExp) ast.exps.get(0)).list.size());

        assertEquals(TokenType.NUMBER, ((CallExp) ast.exps.get(0)).list.get(0).type());
        assertEquals("3", ((CallExp) ast.exps.get(0)).list.get(0).text());
    }

    @Test
    void stringCompare() {
        Ast ast = parse.parse("src/test/java/primitives/stringCompare.cat");

        assertEquals(1, ast.exps.size());
        assertInstanceOf(CallExp.class, ast.exps.get(0));
        assertEquals("stringCompare", ((CallExp) ast.exps.get(0)).name);
        assertEquals(2, ((CallExp) ast.exps.get(0)).list.size());

        assertEquals(TokenType.STRING, ((CallExp) ast.exps.get(0)).list.get(0).type());
        assertEquals("toto", ((CallExp) ast.exps.get(0)).list.get(0).text());
        assertEquals(TokenType.STRING, ((CallExp) ast.exps.get(0)).list.get(1).type());
        assertEquals("tata", ((CallExp) ast.exps.get(0)).list.get(1).text());
    }
}
