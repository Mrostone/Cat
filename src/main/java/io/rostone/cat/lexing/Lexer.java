package io.rostone.cat.lexing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PushbackReader;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {
    String currentToken = "";
    PushbackReader pushbackReader;
    boolean inQuote = false;
    char quote = ' ';

    public Lexer(String filename){
        try{
            this.pushbackReader = new PushbackReader(new BufferedReader(new FileReader(filename)), 1);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error getting file : " + e.getMessage());
        }
    }

    public Token getToken(){
        try{
            int ValueChar;
            while ((ValueChar = this.pushbackReader.read()) != -1) {
                char c = (char) ValueChar;

                if(inQuote){
                    if(c != '"' && c != '\''){
                        addChar(c);
                        continue;
                    }
                    else if(quote != c){
                        addChar(c);
                        continue;
                    }
                    else{
                        Token token = new Token(TokenType.STRING, currentToken);
                        currentToken = "";
                        inQuote = false;
                        return token;
                    }
                }
                else if(c == '"' || c == '\''){
                    inQuote = true;
                    quote = c;
                    continue;
                }

                Token out = addChar(c);
                if(out != null){
                    currentToken = "";
                    return out;
                }
            }
            TokenType type = TokenType.fromText(currentToken);
            if(type == null){
                return null;
            }

            return new Token(type, currentToken);
        } 
        catch (IOException e) {
            System.err.println("Error reading file : " + e.getMessage());
            return null;
        }
    }

    private Token addChar(char c){
        currentToken += c;

        TokenType type = TokenType.fromText(currentToken);
        if(type == null){
            return null;
        }

        return new Token(type, currentToken);
    }
}
