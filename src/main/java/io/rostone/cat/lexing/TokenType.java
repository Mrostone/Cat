package io.rostone.cat.lexing;

import java.util.Map;
import java.util.HashMap;

public enum TokenType {
    PRINT("print", TokenCategory.PRIMITIVE),
    EXIT("exit", TokenCategory.PRIMITIVE),
    STRING_COMPARE("stringCompare", TokenCategory.PRIMITIVE),

    // Ponctuation
    LPAREN("(", TokenCategory.PONCTUATION),
    RPAREN(")", TokenCategory.PONCTUATION),
    COMMA(",", TokenCategory.PONCTUATION),
    SEMI_COLON(";", TokenCategory.PONCTUATION),

    // editable token
    STRING(null, TokenCategory.VARIABLE),
    NUMBER(null, TokenCategory.VARIABLE);

    private final String text;
    private final TokenCategory category;

    private static final Map<String, TokenType> BY_TEXT = new HashMap<>();

    static {
        for (TokenType type : values()) {
            BY_TEXT.put(type.text, type);
        }
    }

    TokenType(String text, TokenCategory category) {
        this.text = text;
        this.category = category;
    }

    public String getText(){
        return this.text;
    }

    public TokenCategory getCategory(){
        return this.category;
    }

    public static TokenType fromText(String text) {
        return BY_TEXT.get(text);
    }
}
