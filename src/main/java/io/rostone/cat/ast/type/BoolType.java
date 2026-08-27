package io.rostone.cat.ast.type;

public final class BoolType extends Type {
    private static BoolType INSTANCE;
    
    private BoolType() {        
    }
    
    public static BoolType getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new BoolType();
        }
        
        return INSTANCE;
    }

    @Override
    public String toString(){
        return "BoolType";
    }
}
