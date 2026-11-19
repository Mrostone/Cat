package kot.assembly;

import kot.ast.*;
import java.io.FileWriter;
import java.io.IOException;

public class Assembly {
    Ast ast;
    String file;
    String out = ".globl _start\n\n.section .rodata\n\n";

    public Assembly(Ast ast, String file) {
        this.ast = ast;
        this.file = file;
    }

    public void convert() {
        out = out.concat(".text\n_start:\n");
        for (Exp exp : ast.exps)
        {
            out = exp.assemble(out);
        }
        //out = out.concat("\txor %rdi, %rdi\n\tcall my_exit\n\tret\n");
        try {
            FileWriter fWriter = new FileWriter(file);

            fWriter.write(out);

            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}