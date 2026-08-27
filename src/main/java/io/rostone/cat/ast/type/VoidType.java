package io.rostone.cat.ast.type;

public final class VoidType extends Type {
    private static VoidType INSTANCE;
    
    private VoidType() {        
    }
    
    public static VoidType getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new VoidType();
        }
        
        return INSTANCE;
    }

    @Override
    public String toString(){
        return "VoidType";
    }
}
