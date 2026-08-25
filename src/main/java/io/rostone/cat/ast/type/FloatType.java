package io.rostone.cat.ast.type;

public final class FloatType extends Type{
    private static FloatType INSTANCE;
    
    private FloatType() {        
    }
    
    public static FloatType getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new FloatType();
        }
        
        return INSTANCE;
    }
}
