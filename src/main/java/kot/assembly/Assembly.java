package kot.assembly;

import kot.ast.*;
import kot.ast.var.VarDec;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import kot.ast.function.FunctionDec;

public class Assembly {
    Ast ast;
    String file;
    String out = ".globl _start\n\n";

    public HashMap<VarDec,String> varMap;
    public HashMap<Exp,String> funcMap;
    public SeqExp main = null;
    public int nbFunc;
    public int nbString;
    public String lastExp;

    public Assembly(Ast ast, String file) {
        this.ast = ast;
        this.file = file;
        this.varMap = new HashMap<>();
        this.funcMap = new HashMap<>();
        this.nbFunc = 0;
        this.nbString = 0;
        this.lastExp = null;
    }

    public void convert() {
        for (Exp exp : ast.exps)
        {
            if(exp instanceof SeqExp)
            {
                continue;
            }
            else
            {
                exp.assemble(this);
            }
        }
        for (Exp exp : funcMap.keySet())
        {
            out = out.concat(".globl " + exp.nameAssembly + "\n");
        }
        if(!varMap.isEmpty())
        {
            out = out.concat("\n.section .data\n\n");
        }
        for (VarDec varDec : varMap.keySet())
        {
            out = out.concat(varMap.get(varDec));
        }
        out = out.concat("\n");
        out = out.concat(".text\n_start:\n");
        out = out.concat("\tcall " + main.nameAssembly + "\n");
        out = out.concat("\tmov %rax, %rdi\n\tcall my_exit\n\tret\n\n");
        for (Exp exp : funcMap.keySet())
        {
            out = out.concat(funcMap.get(exp));
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