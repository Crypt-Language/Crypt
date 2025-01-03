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
**Inactive** : The project is currently inactive. It may be picked up once more at a later date.

  - [x] Lexer
  - [x] Parser
  - [x] Interpreter (for quick tests)
  - [ ] JVM Bytecode Compiler --> (In Progress)

_I Recommend not downloading source code as the compiler is incomplete and is subject to many changes. But, if you wish to try what has been done so far... go right ahead :)_

### Running
 - clone repo
 - build `mvn clean package`
 - run the main function in `Crypt.java` to run CLI.
 - type `commands` to get list of commands
 - to run a `.crypt` file, type `crypt <path to file>` on the CLI.


 - or type `runPrompt` to run the REPL.
 - type `exitPrompt` to exit REPL.

Discord coming soon!

## Contributing

Interested in contributing to the Crypt Interpreter? Refer [CONTRIBUTING.md](https://github.com/Crypt-Language/Crypt/blob/main/CONTRIBUTING.md) for more info.

## License

This project is licensed under the [MIT License](https://github.com/Crypt-Language/Crypt/blob/main/LICENSE).
