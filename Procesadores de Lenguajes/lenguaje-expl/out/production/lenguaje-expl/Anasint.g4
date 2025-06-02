// Analizador sint�ctico lenguaje expr
parser grammar Anasint;
options{
	tokenVocab=Analex;
}

sentencia : exprLogica EOF ;

exprLogica: CIERTO
          | FALSO
          | predicado
          | exprLogica Y exprLogica
          | exprLogica O exprLogica
          | exprLogica IMPLICA exprLogica
          | NO exprLogica
          | PA exprLogica PC
          | cuantificador variables DP PA exprLogica PC
          ;

predicado : predicadoInfijo | predicadoPrefijo ;

predicadoInfijo :
  term
  (IGUAL|MAYOR|MENOR|MAYORIGUAL|MENORIGUAL|DISTINTO)
  term ;

predicadoPrefijo : IDENT PA terms PC ;

terms : term | term COMA terms ;

term: term1 (MAS|MENOS) term
    | term1
    ;

term1: term2 (POR|DIVISION) term1
     | term2
     ;

term2: NUMERO
    | IDENT
    | IDENT PA terms PC
    | PA term PC
    | MENOS term
    ;

cuantificador : PARATODO | EXISTE ;

variables : IDENT | IDENT COMA variables ;