# The Crypt Programming Language

<img src="https://github.com/Crypt-Language/Crypt/blob/main/Logo/PNG/CryptLogoLarge_Dark.png" width="1000px" height="auto">

Welcome to the home of the Crypt Programming language!

## Phase
**Pre-Indev** : Compiler is still experimental (WIP) and isn't fully implemented. Updates once every week 

The reason for a repository right now is to document the journey/growth of Crypt from the very beginning.

### Contributing
If you wish to contribute, you can use this community chat room -->  [![Gitter](https://badges.gitter.im/Crypt-Language/community.svg)](https://gitter.im/Crypt-Language/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)  where you can contact me for a feature that you would like to implement.

## Compiler

The compiler structure and build will be a sort of experiment, where the visiting and bytecode generation for a statement in Crypt will be handled by one file. An example to demonstrate is given below:

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

As you can see, if the above code works, we can effectively cut the compiler files by almost half (comparing to [Cylvre](https://github.com/Cylvre-Language/Cylvre)) and all the code for the compiling of `SomeStatement` is present in one file, so bug fixing will be made easier. And obviously, I will still be using ANTLRv4 for lexing/parsing. 

So far, all of this is just theory, and it is being implemented. I am going to set up a proper compiler though so that if the theory doesn't work, reverting to the original model (the one present in Cylvre) will be easy.

**If this README has an (Available for Testing) label right below the heading, anyone is welcome to try out and test the compiler and report bugs (user testing)**
