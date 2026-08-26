grammar Cat;

// PARSER

@header {
import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
import io.rostone.cat.ast.type.*;
import io.rostone.cat.ast.function.FunctionDec;
import io.rostone.cat.ast.function.ReturnExp;
import io.rostone.cat.ast.OpExp;
import io.rostone.cat.ast.Op;
import io.rostone.cat.utils.Position;
}

ast returns [Ast node]
    @init { $node = new Ast(); }
    : (s=seqExp { $node.exps.add($s.node); })* EOF
    ;

seqExp returns [SeqExp node]
    @init { $node = new SeqExp(); }
    : (s=stmt { $node.add($s.node); })+
    ;

stmt returns [Exp node]
    : e=exp ';'   { $node = $e.node; }
    ;



type returns [Type node]
    : INT_NAME { $node = IntType.getInstance(); }
    | FLOAT_NAME { $node = FloatType.getInstance(); }
    | STRING_NAME { $node = StringType.getInstance(); }
    | BOOL_NAME { $node = BoolType.getInstance(); }
    | VOID_NAME { $node = VoidType.getInstance(); }
    ;

var returns [ VarDec node]
    : t=type ID { $node = new VarDec($ID.text, $t.node, null); }
    ;

varList returns [ List<VarDec> list]
    @init { $list = new ArrayList<>(); }
    : v=var { $list.add($v.node); } (',' v=var { $list.add($v.node); })*
    |
    ;

op returns [Op value]
    : '+'  { $value = Op.add; }
    | '-'  { $value = Op.sub; }
    | '*'  { $value = Op.mul; }
    | '/'  { $value = Op.div; }
    | '='  { $value = Op.eq; }
    | '<>' { $value = Op.ne; }
    | '<'  { $value = Op.lt; }
    | '<=' { $value = Op.le; }
    | '>'  { $value = Op.gt; }
    | '>=' { $value = Op.ge; }
    ;

argList returns [List<Exp> list]
    @init { $list = new ArrayList<>(); }
    : e=exp { $list.add($e.node); } (',' e=exp { $list.add($e.node); })*
    ;

callExp returns [CallExp node]
    : ID '(' a=argList? ')' { $node = new CallExp($ID.text, ($a.ctx != null) ? $a.list : new ArrayList<>(), null); } 
    ;

exp returns [Exp node]
    : c=callExp { $node = $c.node; }
    | ID { $node = new VarExp($ID.text); }
    | INT { $node = new IntExp($INT.text); }
    | STRING { $node = new StringExp(Utils.unescape($STRING.text)); }
    | t=type ID '=' e=exp { $node = new VarDec($ID.text, $t.node, $e.node); }
    | left=exp o=op right=exp { $node = new OpExp($left.node, $o.value, $right.node, new Position($start.getLine(), $start.getCharPositionInLine())); }
    | t=type ID '(' l=varList ')' '{' s=seqExp '}' { $node = new FunctionDec($t.node, $ID.text, $l.list, $s.node); }
    | '(' e=exp ')'   { $node = $e.node; }
    | RETURN e=exp { $node = new ReturnExp($e.node); }
    ;


// LEXER

INT_NAME : 'int';
FLOAT_NAME : 'float';
STRING_NAME : 'string';
BOOL_NAME : 'bool';
VOID_NAME : 'void';

RETURN : 'return';

INT     : '-'? [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]+ ;
STRING  : '"' (~["\\] | '\\' .)* '"' ;
ID      : [a-zA-Z_] [a-zA-Z_0-9]* ;

WS            : [ \t\r\n]+   -> skip ;
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;