TDD Exercise — Calculator
=========================

Objective
---------
This repository contains a small `Calculator` class. The goal of the exercise is
to implement and test a method that evaluates simple arithmetic expressions
using Test-Driven Development (TDD).

Specification (Requirements)
---------------------------
`Calculator`'s `compute` method evaluates an expression provided as a non-null `String`.
Each number appearing in the expression must be an integer with at most three
digits. Operators are the four basic binary arithmetic symbols: `+`, `-`, `*`, and `/`.

Evaluation is carried out strictly left-to-right: operations are applied in the
order they appear without any operator precedence. Arithmetic uses integer
semantics; division performs integer division and discards any fractional part.

If the input is `null`, does not start with a valid integer, or contains
invalid tokens, the method must throw `IllegalArgumentException`. Division by
zero must throw `ArithmeticException`.

Running tests
-------------
Run the unit tests with Maven:

```bash
mvn test
```
