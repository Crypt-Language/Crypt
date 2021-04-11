parser grammar CryptParser;

options{
    tokenVocab=CryptLexer;
}

//File Related

fileUnit   :  fileBody;

fileBody    : statement* /*field* function**/;

field : type name;

function: FUNC_KW functionName LPAREN /*parametersList*/ RPAREN block;

type : F_PRIMITIVE_TYPE | F_OBJECT_TYPE ;

name : VALUE_ID;

functionName : VALUE_ID;

block   : BLOCK_OP NL WS statement+ #MultiStatementBlock
        | BLOCK_OP WS statement #SingleStatementBlock
        ;

statement   : printlnStatement
            | printStatement
            | variableDeclaration
            | COMMENT
            | LINE_COMMENT
            ;

printlnStatement    : PRINTLN_KW LPAREN expression RPAREN SEMICOLON;

printStatement      : PRINT_KW LPAREN expression RPAREN SEMICOLON;

variableDeclaration : LBRACKET type RBRACKET identifier SEMICOLON;

identifier          : VALUE_ID ;

variableReference   : identifier;

//parametersList : parameter (COMMA paramter)*;

expression                  : variableReference                                           #VarReference
                            //| owner=expression '.' functionName '(' argumentList ')'';' #FunctionCall
                            //| functionName '(' argumentList ')'';'                      #FunctionCall
                            //| superCall=SUPER '('argumentList ')'';'                    #SuperCall
                            //| newCall=NEW className '('argumentList ')'';'              #ConstructorCall
                            | value                                                       #ValueExpr
                            | LPAREN expression WS ASTERISK WS expression RPAREN                #Multiply
                            | expression WS ASTERISK WS expression                              #Multiply
                            | LPAREN expression WS SLASH WS expression RPAREN                   #Divide
                            | expression WS SLASH WS expression                                 #Divide
                            | LPAREN expression WS PLUS WS expression RPAREN                    #Add
                            | expression WS PLUS WS expression                                  #Add
                            | LPAREN expression WS MINUS WS expression RPAREN                   #Subtract
                            | expression WS MINUS WS expression                                 #Subtract
                            | expression cmp=MORE_THAN expression                         #ConditionalExpression                            | expression cmp=LESS_THAN expression                             #ConditionalExpression
                            | expression cmp=EQUAL expression                             #ConditionalExpression
                            | expression cmp=DIFFERENT expression                         #ConditionalExpression
                            | expression cmp=MOREEQ expression                            #ConditionalExpression
                            | expression cmp=LESSEQ expression                            #ConditionalExpression
                            ;

value : STRING | INT | F_DECIMAL | F_BOOLEAN;