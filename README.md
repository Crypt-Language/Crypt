# The Crypt Programming Language

<img src="https://github.com/Crypt-Language/Crypt/blob/main/Logo/PNG/CryptLogoLarge_Dark.png" width="1000px" height="auto">

![](https://img.shields.io/github/license/Crypt-Language/Crypt)
<!--![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/Crypt-Language/Crypt?include_prereleases)-->

Welcome to the home of the Crypt Programming language!

## Goal
Crypt aims to be a powerful, yet easy to learn/use  programming language leveraging Java's libraries and cross-platform ability by running on the JVM.

## Phase
**Indev** : Compiler Experimental but fully implemented (Sadly, Causes error while running `.class` file. See [this issue](https://github.com/Crypt-Language/Crypt/issues/20) for more info). Updates once every week. 

### Community
Have some ideas for Crypt features? Maybe you have a couple questions to ask about Crypt (or related)? If you do, don't hesitate to ask at the community chat room below.

[![Gitter](https://badges.gitter.im/Crypt-Language/community.svg)](https://gitter.im/Crypt-Language/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

## Compiler Structure

RuleContext visiting and bytecode generation for a statement (or expression) in Crypt will be handled by one file.

Demo Structure given below:

```java
public SomeStatementBuilder extends SomeLanguageBaseVisitor<Void> {
  // some fields for data handling

  @Override
  public Void visitSomeStatement(@NotNull SomeStatementContext ctx){
    //visitor code goes here
    
    buildSomeStatement(/*Arguments if parameters are present (probably visited values)*/);
  }
  
  public void buildSomeStatement(/*Parameters if needed*/){
    //bytecode generation for someStatement here
  }
}
```

## Contributing

Interested in contributing to Crypt? Refer [CONTRIBUTING.md](https://github.com/Crypt-Language/Crypt/blob/main/CONTRIBUTING.md) for more info. 

## License

This project is licensed under the [MIT License](https://github.com/Crypt-Language/Crypt/blob/main/LICENSE).
