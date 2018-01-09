// azrdev 2018

grammar prolog;

prolog_text
    :   read_term*
    ;

read_term
    :   term* '.'
    ;

term
    :   name
    |   VARIABLE
//    |   integer
//    |   float
//    |   double_quoted_list
    |   '(' // open
    |   ')' // close
    |   '[' // open_list
    |   ']' // close_list
    |   '{' // open_curly
    |   '}' // close_curly
    |   '|' // ht_sep
    |   ',' // comma
    ;

name
    :   NAME
    |   GRAPHIC
    |   QUOTED
    |   ';'
    |   '!'
    ;

VARIABLE
    :   '_'
    |   '_'ALNUM+
    |   [A-Z] ALNUM*
    ;


NAME:   [a-z]ALNUM* ;
GRAPHIC:    (GRAPHIC_CHAR|'\\')+ ;
QUOTED: '\'' ('\\\n' | '\'\'' | . )*? '\'' ;


fragment GRAPHIC_CHAR:   [#$&*+-./:<=>?@^~] ;
fragment ALNUM: [a-zA-Z0-9] ;


LINE_COMMENT:   '%' [^\n]* ('\n'|EOF) -> skip;

COMMENT:    '/*' .*? '*/' -> skip;

WS:     [ \t\r\n]+ -> skip;
