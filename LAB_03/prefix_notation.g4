grammar prefix_notation;


s : program [2] EOF {
    w += "public class Main {\n    public static void main(String[] args){\n" + $program.v + "    }\n}\n"
};

program [tabs] returns [v]
    : operation [$tabs] {$v = $operation.v + '\n'}
    | operation [$tabs] ' ' program [$tabs] {$v = $program.v + "\n" + $operation.v};

if_stm [tabs] returns [v, c]:
    'if' ' ' logic ' ' a=operation [$tabs + 1] {
        $v = ''
        for i in range($tabs):
            $v += TAB
    }

    ;
operation [tabs] returns [v, c]:
    ;

assigment [tabs] returns [v]:


;

expr returns [v]:
;

logic returns [v]:
;

mt_expr returns [v]:
;

INT : '-'? [0-9]+ ;
ID : [a-z]+ ;
WS : [ \t\r\n]+ -> skip;
ST : '"' [a-zA-Z0-9 \r\t\n]* '"' ;

AND : '&&' ;
OR : '||' ;
XOR : '^' ;
NOT : '!' ;
ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
LT : '>' ;
TT : '<' ;
EQ : '==' ;
LTE : '>=' ;
TTE : '<=' ;
NE : '!=' ;
SR : '>>' ;
SL : '<<' ;