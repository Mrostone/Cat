package io.rostone.cat.lexing;

public record Token(TokenType type, String text) {
    public String getText(){
        return this.type().getText();
    }

    public TokenCategory getCategory(){
        return this.type().getCategory();
    }
}
