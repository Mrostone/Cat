package io.rostone.cat.ast;

public enum Op {
    // Arithmetics.
    /* "+" */ add,
    /* "-" */ sub,
    /* "*" */ mul,
    /* "/" */ div,

    // Comparison.
    /* "=" */ eq,
    /* "<>" */ ne,
    /* "<" */ lt,
    /* "<=" */ le,
    /* ">" */ gt,
    /* ">=" */ ge
}
