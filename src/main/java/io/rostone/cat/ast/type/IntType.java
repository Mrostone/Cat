package io.rostone.cat.ast.type;

public class IntType extends Type {
    private static IntType INSTANCE;
    
    private IntType() {        
    }
    
    public static IntType getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new IntType();
        }
        
        return INSTANCE;
    }
}
