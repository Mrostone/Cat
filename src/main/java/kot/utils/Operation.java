public enum Operation {
    EQ(0),
    NE(1),
    LE(2),
    GE(3),
    LT(4),
    GT(5);

    private int num;

    Operation(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}