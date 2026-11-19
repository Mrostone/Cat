package kot.utils;

public enum Op {
    // Arithmetics.
    /* "+" */ add(-1),
    /* "-" */ sub(-2),
    /* "*" */ mul(-3),
    /* "/" */ div(-4),

    // Comparison.
    /* "==" */ eq(0),
    /* "!=" */ ne(1),
    /* "<" */ lt(4),
    /* "<=" */ le(2),
    /* ">" */ gt(5),
    /* ">=" */ ge(3);

    private int num;

    Op(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
