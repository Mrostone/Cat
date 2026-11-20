package kot.ast;

import java.util.ArrayList;
import java.util.HashMap;

import kot.ast.function.FunctionDec;
import kot.ast.var.VarDec;
import kot.binder.Binder;
import kot.utils.Position;
import kot.assembly.*;

public class SeqExp extends Exp {
    public ArrayList<Exp> list = new ArrayList<>();

    public SeqExp(Position pos) {
        this.pos = pos;
    }

    public void add(Exp exp) {
        list.add(exp);
    }

    @Override
    public Binder bind(Binder bind) {
        for(Exp e : list) {
            bind = e.bind(bind);
        }
        return bind;
    }

    @Override
    public void typeCheck() {
        for(Exp e : list) {
            e.typeCheck();
        }

        this.type = list.getLast().getType();
    }

    @Override
    public void clean() {
        ArrayList<Exp> toRemove = new ArrayList<Exp>();
        HashMap<Integer, ArrayList<Exp>> forList = new HashMap<>();
        HashMap<Integer, ArrayList<Exp>> seqList = new HashMap<>();
        for(Exp e : list) {
            if (e instanceof FunctionDec) {
                FunctionDec functionDec = (FunctionDec) e;
                if (!functionDec.isUsed) {
                    toRemove.add(e);
                }
                else {
                    e.clean();
                }
            }
            else if (e instanceof VarDec) {
                VarDec varDec = (VarDec) e;
                if (!varDec.isUsed) {
                    toRemove.add(e);
                }
                else {
                    e.clean();
                }
            }
            else if (e instanceof ForExp) {
                e.clean();
                ForExp forExp = (ForExp) e;
                int index = list.indexOf(e);
                SeqExp bodyFor = forExp.body;
                bodyFor.list.add(forExp.op);
                WhileExp whileExp = new WhileExp(forExp.bound, bodyFor, forExp.pos);
                SeqExp seqWhile = new SeqExp(forExp.pos);
                seqWhile.list.add(whileExp);
                IfExp ifExp = new IfExp(forExp.bound, seqWhile, null, null, forExp.pos);
                ArrayList<Exp> listFor = new ArrayList<>();
                listFor.add(forExp.var);
                listFor.add(ifExp);
                forList.put(index, listFor);
            }
            else if (e instanceof SeqExp) {
                e.clean();
                SeqExp seqExp = (SeqExp) e;
                int index = list.indexOf(e);
                ArrayList<Exp> listSeq = new ArrayList<>();
                for (Exp exp : seqExp.list) {
                    listSeq.add(exp);
                }
                seqList.put(index, listSeq);
            }
            else {
                e.clean();
            }
        }

        for (int ind : forList.keySet())
        {
            toRemove.add(list.get(ind));
            int index = ind;
            for (Exp exp : forList.get(ind))
            {
                list.add(index, exp);
                index++;
            }
        }
        for (int ind : seqList.keySet())
        {
            toRemove.add(list.get(ind));
            int index = ind;
            for (Exp exp : seqList.get(ind))
            {
                list.add(index, exp);
                index++;
            }
        }

        list.removeAll(toRemove);
    }

    @Override
    public Assembly assemble(Assembly asm) {
        String func = "seq_" + asm.nbFunc;
        this.nameAssembly = func;
        func = func.concat(":\n");
        asm.nbFunc++;
        for (Exp exp : list)
        {
            asm = exp.assemble(asm);
            if (asm.lastExp != null)
            {
                func = func.concat(asm.lastExp);
                asm.lastExp = null;
            }
        }
        func = func.concat("\tret\n");
        asm.funcMap.put(this,func);
        return asm;
    }
}
