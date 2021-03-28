# The Crypt Programming Language

<img src="https://github.com/Crypt-Language/Crypt/blob/main/Logo/PNG/CryptLogoLarge_Dark.png" width="1000px" height="auto">

Welcome to the home of the Crypt Programming language!

## Goal
Crypt aims to be a powerful, yet easy to learn/use  programming language leveraging Java's libraries and cross-platform ability by running on the JVM.

## Phase
**Indev** : Compiler Experimental but fully implemented (Sadly, Causes error while running `.class` file. See [this issue](https://github.com/Crypt-Language/Crypt/issues/20) for more info). Updates once every week. 

### Community
[![Gitter](https://badges.gitter.im/Crypt-Language/community.svg)](https://gitter.im/Crypt-Language/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

## Compiler Structure

RuleContext visiting and bytecode generation for a statement (or expression) in Crypt will be handled by one file.

Demo Structure given below:

```java
public SomeStatementBuilder extends SomeLanguageBaseVisitor<Void> {
  // some fields for data handling

  @Override
  public void visitSomeStatement(@NotNull SomeStatementContext ctx){
    //visitor code goes here
    
    generate(/*Arguments if parameters are there (possibly SomeStatementContext)*/);
  }
  
  public void generate(/*Parameters if needed*/){
    //bytecode generation for someStatement here
  }
}
```

**If this README has an (Available for Testing) label right below the heading, anyone is welcome to try out and test the compiler and report bugs (user testing)**
