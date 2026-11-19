package kot.ast;

import java.util.ArrayList;
import java.util.HashMap;

import kot.ast.function.FunctionDec;
import kot.ast.var.VarDec;
import kot.binder.Binder;
import kot.utils.Position;

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

        list.removeAll(toRemove);
    }
}
