grammar AcaLang;

@header {
package com.mycompany.acalangcompiler;
}

// --- 1. REGLAS SINTÁCTICAS (Parser) ---
programa    : (declaracion | instruccion)+ ;

declaracion : tipo ID (IGUAL expresion)? PUNTO_COMA ;

tipo        : T_ENT | T_DEC | T_BOL | T_CAD ;

instruccion : ID IGUAL expresion PUNTO_COMA                                     # Asignacion
            | IMPRIMIR PAREN_ABRE expresion PAREN_CIERRA PUNTO_COMA                # Imprimir
            | SI PAREN_ABRE expresion PAREN_CIERRA LLAVE_ABRE programa LLAVE_CIERRA
                (SINO LLAVE_ABRE programa LLAVE_CIERRA)?                         # SiCondicional
            | MIENTRAS PAREN_ABRE expresion PAREN_CIERRA LLAVE_ABRE programa LLAVE_CIERRA # Mientras
            ;

expresion   : PAREN_ABRE expresion PAREN_CIERRA          # Parentesis
            | expresion (MULT | DIV) expresion           # Multiplicacion
            | expresion (SUMA | RESTA) expresion         # Suma
            | expresion op=OP_COMP expresion             # Comparacion
            | ID                                         # Variable
            | LIT_ENT                                    # Entero
            | LIT_DEC                                    # Decimal 
            | LIT_CAD                                    # Cadena
            | LIT_BOL                                    # Booleano
            ;

// --- 2. REGLAS LÉXICAS (Tokens) ---

// Palabras Reservadas (Keywords)
SI       : 'si' ;
SINO     : 'sino' ;
MIENTRAS : 'mientras' ;
IMPRIMIR : 'imprimir' ;

// Tipos de Datos
T_ENT    : 'ent' ;
T_DEC    : 'dec' ;
T_BOL    : 'bol' ;
T_CAD    : 'cad' ;

// Operadores y Símbolos
IGUAL      : '=' ;
PUNTO_COMA : ';' ;
SUMA       : '+' ;
RESTA      : '-' ;
MULT       : '*' ;
DIV        : '/' ;
PAREN_ABRE : '(' ;
PAREN_CIERRA: ')' ;
LLAVE_ABRE  : '{' ;
LLAVE_CIERRA: '}' ;

// Operadores de Comparación (Agrupados para el Analizador Léxico)
OP_COMP    : '>=' | '<=' | '==' | '!=' | '>' | '<' ;

// Literales
LIT_ENT    : [0-9]+ ;
LIT_DEC    : [0-9]+ '.' [0-9]+ ;
LIT_CAD    : '"' ( ~["] )* '"' ;
LIT_BOL    : 'verdadero' | 'falso' ;

// Identificadores
ID         : [a-zA-Z][a-zA-Z0-9_]* ;

// Comentarios
// Ignorar comentarios de una sola línea
COMMENT : '//' ~[\r\n]* -> skip ;
// 2. Comentario de bloque (soporta varias líneas)
COMMENT_BLOQUE : '/*' .*? '*/' -> skip ;

// Ignorar espacios
WS         : [ \t\r\n]+ -> skip ;