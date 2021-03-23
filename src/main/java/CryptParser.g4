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

block : LBRACKET statement* RBRACKET;

statement   : printlnStatement
            | printStatement
            | COMMENT
            | LINE_COMMENT
            ;

printlnStatement : PRINTLN_KW LPAREN expression RPAREN SEMICOLON;

printStatement : PRINT_KW LPAREN expression RPAREN SEMICOLON;

//parametersList : parameter (COMMA paramter)*;

expression                  //variableReference                                           #VarReference
                            //| owner=expression '.' functionName '(' argumentList ')'';' #FunctionCall
                            //| functionName '(' argumentList ')'';'                      #FunctionCall
                            //| superCall=SUPER '('argumentList ')'';'                    #SuperCall
                            //| newCall=NEW className '('argumentList ')'';'              #ConstructorCall
                            : value                                                       #ValueExpr
                            | LPAREN expression ASTERISK expression RPAREN                #Multiply
                            | expression ASTERISK expression                              #Multiply
                            | LPAREN expression SLASH expression RPAREN                   #Divide
                            | expression SLASH expression                                 #Divide
                            | LPAREN expression PLUS expression RPAREN                    #Add
                            | expression PLUS expression                                  #Add
                            | LPAREN expression MINUS expression RPAREN                   #Subtract
                            | expression MINUS expression                                 #Subtract
                            | expression cmp=MORE_THAN expression                         #ConditionalExpression                            | expression cmp=LESS_THAN expression                             #ConditionalExpression
                            | expression cmp=EQUAL expression                             #ConditionalExpression
                            | expression cmp=DIFFERENT expression                         #ConditionalExpression
                            | expression cmp=MOREEQ expression                            #ConditionalExpression
                            | expression cmp=LESSEQ expression                            #ConditionalExpression
                            ;

value : STRING_START | INT | F_DECIMAL | F_BOOLEAN;