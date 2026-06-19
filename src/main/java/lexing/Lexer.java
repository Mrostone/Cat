package main.java.lexing;

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

    public LexerToken getToken(){
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
                        LexerToken lexerToken = LexerToken.STRING;
                        lexerToken.setText(currentToken);
                        currentToken = "";
                        inQuote = false;
                        return lexerToken;
                    }
                }
                else if(c == '"' || c == '\''){
                    inQuote = true;
                    quote = c;
                    continue;
                }

                LexerToken out = addChar(c);
                if(out != null){
                    currentToken = "";
                    return out;
                }
            }
            return LexerToken.fromText(currentToken);
        } 
        catch (IOException e) {
            System.err.println("Error reading file : " + e.getMessage());
            return null;
        }
    }

    private LexerToken addChar(char c){
        currentToken += c;
        //System.out.println(currentToken);

        return LexerToken.fromText(currentToken);
    }
}
