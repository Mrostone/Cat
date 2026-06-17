package main.java.lexing;

import java.io.BufferedReader;
import java.io.PushbackReader;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {
    String currentToken = "";

    public void lexing(String filename){
        try (PushbackReader pushbackReader = new PushbackReader(new BufferedReader(new FileReader(filename)), 1);) {

            int ValueChar;
            while ((ValueChar = pushbackReader.read()) != -1) {
                char c = (char) ValueChar;
                
                addChar(c);
            }
            
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    private void addChar(char c){
        currentToken += c;
        System.out.println(currentToken);

        LexerToken token = LexerToken.fromText(currentToken);
        if(token != null){
            System.out.println(token);
        }
    }
}
