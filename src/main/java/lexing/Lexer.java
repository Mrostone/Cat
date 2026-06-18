package main.java.lexing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PushbackReader;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {
    String currentToken = "";
    PushbackReader pushbackReader;

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

                LexerToken temp = addChar(c);
                if(temp != null){
                    return temp;
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

        return LexerToken.fromText(currentToken);
    }
}
