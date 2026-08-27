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
    @init { $node = new SeqExp(new Position($start.getLine(), $start.getCharPositionInLine())); }
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
    : t=type ID { $node = new VarDec($ID.text, $t.node, null, new Position($start.getLine(), $start.getCharPositionInLine())); }
    ;

varList returns [ List<VarDec> list]
    @init { $list = new ArrayList<>(); }
    : v=var { $list.add($v.node); } (',' v=var { $list.add($v.node); })*
    |
    ;

argList returns [List<Exp> list]
    @init { $list = new ArrayList<>(); }
    : e=exp { $list.add($e.node); } (',' e=exp { $list.add($e.node); })*
    ;

callExp returns [CallExp node]
    : ID '(' a=argList? ')' { $node = new CallExp($ID.text, ($a.ctx != null) ? $a.list : new ArrayList<>(), null, new Position($start.getLine(), $start.getCharPositionInLine())); } 
    ;

varDec returns [VarDec node]
    : t=type ID '=' e=exp { $node = new VarDec($ID.text, $t.node, $e.node, new Position($start.getLine(), $start.getCharPositionInLine())); }
    ;

for returns [ForExp node]
    : 'for' '(' v=varDec ';' o=exp ';' e=exp ')' '{' b=seqExp '}' { $node = new ForExp($v.node, $o.node, $e.node, $b.node, new Position($start.getLine(), $start.getCharPositionInLine())); }
    ;

exp returns [Exp node]
    : t=type ID '(' l=varList ')' '{' s=seqExp '}' { $node = new FunctionDec($t.node, $ID.text, $l.list, $s.node, new Position($start.getLine(), $start.getCharPositionInLine())); }
    | v=varDec { $node = $v.node; }
    | f=for { $node = $f.node; }
    | RETURN e=exp { $node = new ReturnExp($e.node, new Position($start.getLine(), $start.getCharPositionInLine())); }
    | left=exp op=('*' | '/') right=exp 
        { 
          Op o = $op.text.equals("*") ? Op.mul : Op.div;
          $node = new OpExp($left.node, o, $right.node, new Position($start.getLine(), $start.getCharPositionInLine())); 
        }
    | left=exp op=('+' | '-') right=exp 
        { 
          Op o = $op.text.equals("+") ? Op.add : Op.sub;
          $node = new OpExp($left.node, o, $right.node, new Position($start.getLine(), $start.getCharPositionInLine())); 
        }
    | ID '++' { $node = new AssignExp(new VarExp($ID.text, new Position($start.getLine(), $start.getCharPositionInLine())), new OpExp(new VarExp($ID.text, new Position($start.getLine(), $start.getCharPositionInLine())), Op.add, new IntExp("1", new Position($start.getLine(), $start.getCharPositionInLine())), new Position($start.getLine(), $start.getCharPositionInLine())), new Position($start.getLine(), $start.getCharPositionInLine())); }
    | ID '--' { $node = new AssignExp(new VarExp($ID.text, new Position($start.getLine(), $start.getCharPositionInLine())), new OpExp(new VarExp($ID.text, new Position($start.getLine(), $start.getCharPositionInLine())), Op.sub, new IntExp("1", new Position($start.getLine(), $start.getCharPositionInLine())), new Position($start.getLine(), $start.getCharPositionInLine())), new Position($start.getLine(), $start.getCharPositionInLine())); }
    | left=exp op=('<' | '<=' | '>' | '>=') right=exp 
        { 
          Op o = switch ($op.text) {
              case "<"  -> Op.lt;
              case "<=" -> Op.le;
              case ">"  -> Op.gt;
              default   -> Op.ge;
          };
          $node = new OpExp($left.node, o, $right.node, new Position($start.getLine(), $start.getCharPositionInLine())); 
        }
    | left=exp op=('==' | '!=') right=exp 
        { 
          Op o = $op.text.equals("=") ? Op.eq : Op.ne;
          $node = new OpExp($left.node, o, $right.node, new Position($start.getLine(), $start.getCharPositionInLine())); 
        }
    | ID '=' e=exp { $node = new AssignExp(new VarExp($ID.text, new Position($start.getLine(), $start.getCharPositionInLine())), $e.node, new Position($start.getLine(), $start.getCharPositionInLine())); }
    | c=callExp { $node = $c.node; }
    | ID { $node = new VarExp($ID.text, new Position($start.getLine(), $start.getCharPositionInLine())); }
    | INT { $node = new IntExp($INT.text, new Position($start.getLine(), $start.getCharPositionInLine())); }
    | STRING { $node = new StringExp(Utils.unescape($STRING.text), new Position($start.getLine(), $start.getCharPositionInLine())); }
    | '(' e=exp ')' { $node = $e.node; }
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