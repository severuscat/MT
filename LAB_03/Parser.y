
%name      parseForth
%tokentype { Token }
%error     { parseError }
%monad     { Either Text } { >>= } { return }

%token WORD       { WordT $$ }
%token STROUT     { StrOutputT $$ }
%token COLON      { ColonT }
%token SEMICOLON  { SemicolonT }

%%

forth : ops                              { Ast (reverse $1) }

ops : ops definition                     { $2 : $1 }
    | defOps                             { $1 }

defOps : {- empty -}                     { [] }
       | ops WORD                        { Word $2 : $1 }
       | ops STROUT                      { StrOut $2 : $1 }

definition : COLON WORD defOps SEMICOLON { Definition $2 (Ast (reverse $3)) }

