package main.java.lexing;

import java.util.Map;
import java.util.HashMap;

public enum LexerToken {
    PRINT("print"),
    LPAREN("("),
    RPAREN(")"),
    STRING("");

    private String text;

    private static final Map<String, LexerToken> BY_TEXT = new HashMap<>();

    static {
        for (LexerToken type : values()) {
            BY_TEXT.put(type.text, type);
        }
    }

    LexerToken(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }

    public static LexerToken fromText(String text) {
        return BY_TEXT.get(text);
    }
}
