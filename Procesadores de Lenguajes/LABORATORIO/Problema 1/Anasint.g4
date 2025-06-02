// Analizador sintactico lenguaje-expl

parser grammar Anasint;
options{
    tokenVicab=Analex;
    }                                                       // sentecia
//                                                              /   \
sentencia : exprLogica EOF;  //EOF == END OF FILE       exprLogica  EOF         ... es lo que viene a decir la primera sentencia

exprLogica: CIERTO
            | FALSO
            | predicado
            | exprLogica Y exprLogica
            | exprLogica O exprLogica
            | NO exprLogica
            | exprLogica IMPLICACION exprLogica
            | exprLogica EQUIVALENCIA exprLogica
            | PA exprLogica PC
            | cuantificador variables DP PA exprLogica PC
            ;

predicado: predicadoInfijo | predicadoPrefijo;

predicadoInfijo: term (IGUAL|MAYOR|MENOR|MAYORIGUAL|MENORIGUAL|DISTINTO) term;

predicadoPrefijo : INDENT PA terms PC;

term: NUMERO
    | IDENT
    | IDENT PA terms PC
    | PA terms PC
    | MENOS term
    | term (MAS|MENOS|POR|DIVISION) term
    ;

terms: term
    | term COMA terms
    ;

cuantificador: PARATODO | EXISTE;

variables: IDENT | IDENT COMA variables;