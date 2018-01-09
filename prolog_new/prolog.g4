// azrdev 2018

grammar prolog;

prolog_text
    :   term*
    ;

term
    :   atomic
    |   variable
    |   compound
    ;

atomic
    :   number
    |   '-' number //TODO: no ws
    |   atom
    ;

number
    :   integer
    |   float
    ;

atom
    :   NAME
    |   '[' ']'
    |   '{' '}'
    ;

variable
    :
    ;

compound
    :   atom open_ct
        argument ( ',' argument )* //FIXME: comma infix operator vs argument/list separator, see 6.3.3.1
        close_ct
    ;


NAME
    : [a-z]+
    ;
