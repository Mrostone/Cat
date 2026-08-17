grammar Cat;

// PARSER

@header {
import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
import io.rostone.cat.ast.type.*;
}

ast returns [Ast node]
    @init { $node = new Ast(); }
    : (s=stmt { $node.exps.add($s.node); })* EOF
    ;

stmt returns [Exp node]
    : e=exp ';'   { $node = $e.node; }
    ;

type returns [Type node]
    : INT_NAME { $node = new IntType(); }
    | FLOAT_NAME { $node = new FloatType(); }
    | STRING_NAME { $node = new StringType(); }
    | BOOL_NAME { $node = new BoolType(); }
    ;

exp returns [Exp node]
    : ID '(' a=argList? ')'
        {
            CallExp c = new CallExp();
            c.name = $ID.text;
            c.args = ($a.ctx != null) ? $a.list : new ArrayList<>();
            $node = c;
        }
    | INT      { $node = new IntExp($INT.text); }
    | STRING   { $node = new StringExp(Utils.unescape($STRING.text)); }
    | t=type ID '=' e=exp { $node = new VarDec($ID.text, $t.node, $e.node); }
    | '(' e=exp ')'   { $node = $e.node; }
    ;

argList returns [List<Exp> list]
    @init { $list = new ArrayList<>(); }
    : e=exp { $list.add($e.node); } (',' e=exp { $list.add($e.node); })*
    ;

// LEXER

INT_NAME : 'int';
FLOAT_NAME : 'float';
STRING_NAME : 'string';
BOOL_NAME : 'bool';

INT     : '-'? [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]+ ;
STRING  : '"' (~["\\] | '\\' .)* '"' ;
ID      : [a-zA-Z_] [a-zA-Z_0-9]* ;

WS            : [ \t\r\n]+   -> skip ;
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;