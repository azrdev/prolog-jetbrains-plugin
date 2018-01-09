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
// 6.4.7
BACK_QUOTED_STRING: '`' '`';
// 6.4.8


// 6.5.1
fragment GRAPHIC_CHAR: [#$&*+-./:<=>?@^~] ;
// 6.5.2
fragment ALNUM: ALPHA | DECIMAL_DIGIT ;
fragment ALPHA: '_' | LETTER ;
fragment LETTER: CAPITAL_LETTER | SMALL_LETTER ;
fragment SMALL_LETTER : [a-z] ;
fragment CAPITAL_LETTER: [A-Z] ;
fragment DECIMAL_DIGIT: [0-9] ;
fragment BINARY_DIGIT: [01] ;
fragment OCTAL_DIGIT: [0-7] ;
fragment HEX_DIGIT: [0-9a-fA-F] ;
// 6.5.3
fragment CUT: '!' ;
fragment OPEN: '(' ;
fragment CLOSE: ')' ;
fragment COMMA: ',' ;
fragment SEMICOLON: ';' ;
fragment OPEN_LIST: '[' ;
fragment CLOSE_LIST: ']' ;
fragment OPEN_CURLY: '{' ;
fragment CLOSE_CURLY: '}' ;
fragment HEAD_TAIL_SEP: '|';


LINE_COMMENT:   '%' [^\n]* ('\n'|EOF) -> skip;

COMMENT:    '/*' .*? '*/' -> skip;

// 6.5.4 layout characters
WS:     [ \t\r\n]+ -> skip;
