parser grammar CryptParser;

options{
    tokenVocab=CryptLexer;
}

//File Related

fileUnit   :  fileDeclaration;
fileDeclaration : fileBody;
fileBody    : field* function*;

field : type name;

function: FUNC_KW functionName LPAREN /*parametersList*/ RPAREN block;

type : F_PRIMITIVE_TYPE | F_OBJECT_TYPE | RELOP;

name : VALUE_ID;

functionName : VALUE_ID;

block : LBRACKET statement* RBRACKET;

statement   : printlnStatement
            | printStatement
            ;

printlnStatement : PRINTLN_KW LPAREN /*expression*/ RPAREN /*SEMICOLON*/;

printStatement : PRINT_KW LPAREN /*expression*/ RPAREN /*SEMICOLON*/;

//parametersList : parameter;