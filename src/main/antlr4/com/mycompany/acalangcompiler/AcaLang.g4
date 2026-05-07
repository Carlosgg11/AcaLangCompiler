grammar AcaLang;

// Definición del paquete para que coincida con tu proyecto
@header {
package com.mycompany.acalangcompiler;
}

// --- 1. REGLAS SINTÁCTICAS (Parser) ---
programa    : (declaracion | instruccion)+ ;

declaracion : tipo ID (IGUAL expresion)? PUNTO_COMA ;

tipo        : 'ent' | 'dec' | 'bol' | 'cad' ;

instruccion : ID IGUAL expresion PUNTO_COMA                                                     # Asignacion
            | 'imprimir' PAREN_ABRE expresion PAREN_CIERRA PUNTO_COMA                           # Imprimir
            | 'si' PAREN_ABRE expresion PAREN_CIERRA LLAVE_ABRE programa LLAVE_CIERRA
                ('sino' LLAVE_ABRE programa LLAVE_CIERRA)?                                      # SiCondicional
            | 'mientras' PAREN_ABRE expresion PAREN_CIERRA LLAVE_ABRE programa LLAVE_CIERRA     # Mientras
            ;

expresion   : expresion (MULT | DIV) expresion                           # Multiplicacion
            | expresion (SUMA | RESTA) expresion                         # Suma
            | expresion ('>' | '<' | '>=' | '<=' | '==' | '!=') expresion # Comparacion
            | PAREN_ABRE expresion PAREN_CIERRA                          # Parentesis
            | ID                                                         # Variable
            | LIT_ENT                                                    # Entero
            | LIT_DEC                                                    # Decimal 
            | LIT_CAD                                                    # Cadena
            | LIT_BOL                                                    # Booleano
            ;

// --- 2. REGLAS LÉXICAS (Tokens) ---
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

LIT_ENT    : [0-9]+ ;
LIT_DEC    : [0-9]+ '.' [0-9]+ ;
LIT_CAD    : '"' ( ~["] )* '"' ;
LIT_BOL    : 'verdadero' | 'falso' ;
ID         : [a-zA-Z][a-zA-Z0-9_]* ;

WS         : [ \t\r\n]+ -> skip ; // Ignorar espacios y saltos de línea