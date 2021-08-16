# The Crypt Programming Language

<img src="https://github.com/Crypt-Language/Crypt/blob/main/Logo/PNG/CryptLogoLarge_Dark.png" width="1000px" height="auto">

![](https://img.shields.io/github/license/Crypt-Language/Crypt)
![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/Crypt-Language/Crypt?include_prereleases)

Welcome to the home of the Crypt Programming language!

## Goal
Crypt aims to be a powerful, yet easy to learn/use  programming language leveraging Java's libraries and cross-platform ability by running on the JVM.

## Compiler Pipeline
Lexing -> Parsing -> JVM Bytecode emitting -> Running
But, before this... I will setup an interpreter to run the language

## Phase
**In Development** : A new compiler is being actively developed, with updates being released every week. The full compiler, once completed, will be uploaded into this repository.

  - [x] Lexer
  - [ ] Parser --> In Progress
  - [ ] IRCompiler
  - [ ] IR to JVM Bytecode Compiler

_I Recommend not downloading source code as the compiler is incomplete and is subject to many changes. But, if you wish to try what has been done so far... go right ahead :)_

### Running
 - clone repo
 - build `mvn build`
 - run the main function in `Crypt.java` to open REPL.
 - Type in expressions (that's all that has been done so far.. statements coming soon!)

### Community
Have some ideas for Crypt features? Maybe you have a couple questions to ask about Crypt (or related)? If you do, don't hesitate to ask at the community chat room below.

[![Gitter](https://badges.gitter.im/Crypt-Language/community.svg)](https://gitter.im/Crypt-Language/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

Discord coming soon!

## Contributing

<!--Interested in contributing to Crypt? Refer [CONTRIBUTING.md](https://github.com/Crypt-Language/Crypt/blob/main/CONTRIBUTING.md) for more info.-->
Contributions are closed until a finished compiler is uploaded. (*Sorry*) :(

## License

This project is licensed under the [MIT License](https://github.com/Crypt-Language/Crypt/blob/main/LICENSE).
