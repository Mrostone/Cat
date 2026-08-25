package io.rostone.cat.ast.type;

public final class StringType extends Type {
    private static StringType INSTANCE;
    
    private StringType() {        
    }
    
    public static StringType getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new StringType();
        }
        
        return INSTANCE;
    }
}
