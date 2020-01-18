grammar prefix_notation;

@parser::members {
TAB = "    "
w = "generated"

def repres(self, op, left, right):
    res = "(" + left + " "
    if op == prefix_notationParser.MUL:
        res += "*"
    elif op == prefix_notationParser.DIV:
        res += "/"
    elif op == prefix_notationParser.ADD:
        res += "+"
    elif op == prefix_notationParser.SUB:
        res += "-"
    elif op == prefix_notationParser.AND:
        res += "&&"
    elif op == prefix_notationParser.OR:
        res += "||"
    elif op == prefix_notationParser.XOR:
        res += "^"
    elif op == prefix_notationParser.LT:
        res += ">"
    elif op == prefix_notationParser.TT:
        res += "<"
    elif op == prefix_notationParser.EQ:
        res += "=="
    elif op == prefix_notationParser.NE:
        res += "!="
    elif op == prefix_notationParser.LTE:
        res += ">="
    elif op == prefix_notationParser.TTE:
        res += "<="
    elif op == prefix_notationParser.SR:
        res += ">>"
    elif op == prefix_notationParser.SL:
        res += "<<"
    res += " " + right + ")"
    return res
}

s : program [2] EOF
{
with open(prefix_notationParser.w, mode='w') as f:
    f.write("public class Main {\n    public static void main(String[] args){\n" + $program.v + "    }\n}\n")
   }
| {
with open(prefix_notationParser.w, mode='w') as f:
    f.write("public class Main {\n}\n")
};

program [tabs] returns [v] : operation [$tabs]
{
$v = $operation.v + "\n"
}
| operation [$tabs] ' ' program [$tabs]
{
$v = $program.v + "\n" + $operation.v
}
;

ifstat [int tabs] returns [String v, boolean c] : 'if' ' ' logic ' ' a=operation [$tabs + 1]
{
$v = ""
for i in range($tabs):
    $v += prefix_notationParser.TAB
$v += "if (" + $logic.v + ") {\n" + $a.v + "\n"
for i in range($tabs):
    $v += prefix_notationParser.TAB
$v += "}\n"
};

operation [tabs] returns [v, c]: a=assignment [$tabs]
{
$v = $a.v + ";"
$c = True
}

| 'begin' ' ' b=program [$tabs + 1] ' ' 'end'
{
$v = ""
for i in range(tabs):
    $v += prefix_notationParser.TAB
$v += "{\n" + $b.v
for i in range(tabs):
    $v += prefix_notationParser.TAB
$v += "}"
$c = False
}

| 'print' ' ' expr
{
$v = ""
for i in range(tabs):
    $v += prefix_notationParser.TAB
$v += "System.out.println(" + $expr.v + ");"
$c = True
}

| ifstat [$tabs]
{
$v = $ifstat.v
if not ($ifstat.c):
    $v += ";"
$c = True
};

assignment [tabs] returns [v]
           : '=' ' ' ID ' ' logic
{
$v = ""
for i in range(tabs):
    $v += prefix_notationParser.TAB
$v += "boolean " + $ID.text + " = " + $logic.v
}
           | '=' ' ' ID ' ' mt_expr
{
$v = "";
for i in range(tabs):
    $v += prefix_notationParser.TAB

$v += "int " + $ID.text + " = " + $mt_expr.v
}
           | '=' ' ' ID ' ' ST
{
$v = ""
for i in range(tabs):
    $v += prefix_notationParser.TAB
$v += "String " + $ID.text + " = " + $ST.text
};

expr returns [v]
     : logic
{
$v = $logic.v
}
     | mt_expr
{
$v = $mt_expr.v
}
     | ST
{
$v = $ST.text
};

logic returns [String v]
        : op=('&&'|'||'|'^') ' ' a=logic ' ' b=logic
{
$v = prefix_notationParser.repres($op.type, $a.v, $b.v)
}
        | '!' ' ' a=logic
{
$v = "!" + $a.v
}
        | op=('>'|'<'|'=='|'>='|'<='|'!=') ' ' c=mt_expr ' ' d=mt_expr
{
$v = prefix_notationParser.repres($op.type, $c.v, $d.v)
}
        | 'true'
{
$v = "true"
}
        | 'false'
{
$v = "false"
}
        | ID
{
$v = $ID.text
} ;

mt_expr returns [String v]
       : op=('+'|'-'|'*'|'/'|'>>'|'<<') ' ' a=mt_expr ' ' b=mt_expr
{
$v = prefix_notationParser.repres($op.type, $a.v, $b.v)
}
       | INT
{
$v = $INT.text
}
       | ID
{
$v = $ID.text
};

INT : '-'? [0-9]+ ;
ID : [a-z]+;
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