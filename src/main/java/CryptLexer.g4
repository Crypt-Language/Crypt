lexer grammar CryptLexer;

@lexer::members {
    public static final int WHITESPACE = 1;
    public static final int COMMENTS = 2;
}

channels{
    WHITESPACE, COMMENTS
}

tokens { RELOP, VAL_KW, PRINTLN_KW, PRINT_KW, TO_KW, IMPORT_KW,
         VOID_KW, RETURN_KW, FALSE_KW, TRUE_KW, SUPER_KW, FOR_KW,
         AND_KW, OR_KW, NOT_KW, LPAREN, RPAREN, LBRACKET, RBRACKET,
         LSQUARE, RSQUARE, COMMA, POINT, COLON, SEMICOLON, Q_MARK, EQUAL,
         DIFFERENT, LESSEQ, MOREEQ, LESS_THAN, MORE_THAN, ASSIGNMENT,
         ASTERISK, SLASH, PLUS, MINUS, PRIMITIVE_TYPE, BASIC_TYPE,
         TYPE_ID, INT, STRING_START, WS, NL, COMMENT,LINE_COMMENT,
         STRING_STOP, STRING_CONTENT, INTERPOLATION_START,
         INTERPOLATION_END, FUNC_KW, ELSE_KW, F_BOOLEAN, STRING, BLOCK_OP}

/*LEXER*/

// Of course keywords has to be defined before the rules for identifiers
VAL_KW              : 'val';
FIELD_KW            : 'field';
PRINTLN_KW          : 'println';
PRINT_KW            : 'print';
TO_KW               : 'to';
IMPORT_KW           : 'import';
VOID_KW             : 'void';
RETURN_KW           : 'return';
FALSE_KW            : 'false';
TRUE_KW             : 'true';
SUPER_KW            : 'super';
FOR_KW              : 'for';
FUNC_KW             : 'fn';
ELSE_KW             : 'else';

// For definitions reused in mode in-interpolation we define and refer to fragments
AND_KW              : F_AND;
OR_KW               : F_OR;
NOT_KW              : F_NOT;

LPAREN              : '(';
RPAREN              : ')';
LBRACKET            : '{';
RBRACKET            : '}';
LSQUARE             : '[';
RSQUARE             : ']';
COMMA               : ',';
POINT               : '.';
COLON               : ':';
Q_MARK              : '?';
SEMICOLON           : ';';

// https://github.com/antlr/antlr4/issues/840
EQUAL               : '=' -> type(RELOP);
DIFFERENT           : '!=' -> type(RELOP);
LESSEQ              : '<=' -> type(RELOP);
LESS_THAN           : '<'  -> type(RELOP);
MOREEQ              : '>=' -> type(RELOP);
MORE_THAN           : '>'  -> type(RELOP);

ASSIGNMENT          : COLON;

ASTERISK            : '*';
SLASH               : '/';
PLUS                : '+';
MINUS               : '-';

PRIMITIVE_TYPE      : F_PRIMITIVE_TYPE;
BASIC_TYPE          : F_BASIC_TYPE;

VALUE_ID            : F_VALUE_ID;

INT                 : F_INT;

// Let's switch to another mode here
//STRING_START        : '"' -> pushMode(IN_STRING);

WS                  : (' ' | 't')+ -> channel(WHITESPACE);
NL                  : 'r'? 'n';

COMMENT             : '/*' .*? '*/' -> channel(COMMENTS);

LINE_COMMENT        : '//' ~[rn]* -> channel(COMMENTS);

BLOCK_OP            : '>>';

STRING              : '"' .*? '"';

/*
mode IN_STRING;

STRING_STOP         : '"' -> popMode;
STRING_CONTENT      : (~["~]|ESCAPE_SEQUENCE|TILDE)+;
INTERPOLATION_START : '~{' -> pushMode(IN_INTERPOLATION);

mode IN_INTERPOLATION;

INTERPOLATION_END   : '}' -> popMode;
I_PRIMITIVE_TYPE    : F_PRIMITIVE_TYPE -> type(PRIMITIVE_TYPE);
I_BASIC_TYPE        : F_BASIC_TYPE -> type(BASIC_TYPE);
I_FALSE_KW          : 'false' -> type(FALSE_KW);
I_TRUE_KW           : 'true' -> type(TRUE_KW);
I_AND_KW            : F_AND -> type(AND_KW);
I_OR_KW             : F_OR -> type(OR_KW);
I_NOT_KW            : F_NOT -> type(NOT_KW);
I_IF_KW             : '?' -> type(Q_MARK);
I_ELSE_KW           : 'else' -> type(ELSE_KW);
I_VALUE_ID          : F_VALUE_ID   -> type(VALUE_ID);
I_INT               : F_INT -> type(INT);
I_COMMA             : ',' -> type(COMMA);
I_LPAREN            : '(' -> type(LPAREN);
I_RPAREN            : ')' -> type(RPAREN);
I_LSQUARE           : '[' -> type(LSQUARE);
I_RSQUARE           : ']' -> type(RSQUARE);

I_ASTERISK          : '*' -> type(ASTERISK);
I_SLASH             : '/' -> type(SLASH);
I_PLUS              : '+' -> type(PLUS);
I_MINUS             : '-' -> type(MINUS);

I_POINT             : '.' -> type(POINT);
I_EQUAL             : '=' -> type(RELOP);
I_DIFFERENT         : '!=' -> type(RELOP);
I_LESSEQ            : '<=' -> type(RELOP);
I_LESS              : '<'  -> type(RELOP);
I_MOREEQ            : '>=' -> type(RELOP);
I_MORE              : '>'  -> type(RELOP);
I_STRING_START      : '"' -> type(STRING_START), pushMode(IN_STRING);
I_WS                : (' ' | 't')+ -> type(WS), channel(WHITESPACE);
*/

F_AND            : 'and';
F_OR             : 'or';
F_NOT            : 'not';
fragment F_VALUE_ID       : ('_')*'a'..'z' ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')*;

// Only for types
F_INT            : '0' | (('1'..'9')('0'..'9')*);
F_DECIMAL        : ('0'| ('1'..'9')('0'..'9')*) '.' ('0'| ('1'..'9')('0'..'9')*);
F_PRIMITIVE_TYPE : 'byte' | 'int' | 'long' | 'bool' | 'char' | 'float' | 'double' | 'short';
F_OBJECT_TYPE    : 'string' | VOID_KW ;
F_BOOLEAN        : TRUE_KW | FALSE_KW;
F_BASIC_TYPE     : 'UInt';

fragment ESCAPE_SEQUENCE  : 'r'|'n'|'t'|'"';
fragment TILDE            : '~'{ _input.LA(1)!='{' }?;


