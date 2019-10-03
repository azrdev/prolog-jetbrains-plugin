# prolog-jetbrains-plugin

An ANTLR grammar for the prolog programming language, and a "Language Support" plugin for Jetbrains IDEs (Intellij IDEA etc.), based on <https://github.com/antlr/jetbrains-plugin-sample>.

## TODO

So far the grammar parses fine most constructs found in swi-prolog library files. The main absence (of those mentioned with TODO comments in the `Prolog.g4` file) are the builtin directives (`dynamic`, `multifile`, etc), which probably require support of altering the operator table (i.e. the grammar) from prolog code using `op/3`.


- 2018-01 mvn to generate from grammar overrides plugin.iml
- 2019-10-03 follow sample plugin: switch from maven to gradle

