package kot.assembly;

import kot.ast.*;
import kot.ast.var.VarDec;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Assembly {
    Ast ast;
    String file;
    String out = ".globl _start\n\n";

    public HashMap<VarDec,String> varMap;
    public HashMap<SeqExp,String> seqMap;
    public FunctionDec main;

    public Assembly(Ast ast, String file) {
        this.ast = ast;
        this.file = file;
        this.varMap = new HashMap<>();
        this.seqMap = new HashMap<>();
        this.main = null;
    }

    public void convert() {
        for (Exp exp : ast.exps)
        {
            exp.assemble(this);
        }
        out = out.concat(".section .data\n\n");
        for (VarDec varDec : varMap.keySet())
        {
            out = out.concat(varMap.get(varDec));
        }
        out = out.concat("\n");
        out = out.concat(".text\n_start:\n");
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