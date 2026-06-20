package primitives;

import io.rostone.cat.ast.Ast;
import io.rostone.cat.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class Primitives {
    Parser parse = new Parser();

    @Test
    void printHello() {
        Path cat;
        try {
            cat = Paths.get(
                getClass().getClassLoader().getResource("printHello.cat").toURI()
            );

            Ast ast = parse.parse(cat.toString());

            assertEquals(1, ast.exps.size());

        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
