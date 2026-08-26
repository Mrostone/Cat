package io.rostone.cat.utils;

public class Position {
    int startLine;
    int startChar;

    public Position(int startLine, int startChar)  {
        this.startLine = startLine;
        this.startChar = startChar;
    }

    public String print() {
        return startLine + ":" + startChar;
    }
}
