grammar Cat;

// PARSER

@header {
import io.rostone.cat.ast.*;
import io.rostone.cat.ast.var.*;
import io.rostone.cat.ast.function.CallExp;
import java.util.*;
import io.rostone.cat.antlr.*;
}

ast returns [Ast node]
    @init { $node = new Ast(); }
    : (s=stmt { $node.exps.add($s.node); })* EOF
    ;

stmt returns [Exp node]
    : e=exp ';'   { $node = $e.node; }
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
    | '(' e=exp ')'   { $node = $e.node; }
    ;

argList returns [List<Exp> list]
    @init { $list = new ArrayList<>(); }
    : e=exp { $list.add($e.node); } (',' e=exp { $list.add($e.node); })*
    ;

// LEXER

INT     : [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]+ ;
STRING  : '"' (~["\\] | '\\' .)* '"' ;
ID      : [a-zA-Z_] [a-zA-Z_0-9]* ;

WS            : [ \t\r\n]+   -> skip ;
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;