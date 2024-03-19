# Code Challenge: Robot Explorer

An application that find out the position a robot ends up after a series of given instructions based on an exploration area.

## Architectural style and code design

Given the complexity of the problem the code design is just a separation of concerns in domain, effects, parser and transformers. The only effect in the challenge is the reading of the file and the rest is just a set of pure functions.


## Getting Started

Instructions to run the code on your local machine for development and testing purposes.

### Prerequisites

Please install [sbt: The interactive build tool](https://www.scala-sbt.org/) from [here](https://www.scala-sbt.org/download.html)
in order to build, compile, test and run the code:

For Linux (deb)
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt
```
For Linux (rpm)
```
curl https://bintray.com/sbt/rpm/rpm > bintray-sbt-rpm.repo
sudo mv bintray-sbt-rpm.repo /etc/yum.repos.d/
sudo yum install sbt
```
For MAC
```
brew install sbt
```

## Running

The app receives an argument as the name of the file that should be places inside `src/resources/` and you provide the name of the file as an argument to the shell.

You can run the code directly from sbt-shell typing `sbt` in terminal and then `run <input-file.txt>`. 

If you don't provide any file to the app by default it will process `explorers-input.txt`.

## Running the tests

### Unit tests

Unit tests code is under `src/test`. To run them use `sbt test`.

### Coverage

Coverage report can be run with `sbt coverateReport` and results will be places in `target/scala-2.13/scoverage-report/index.html`

```
Statement coverage.: 81.88%
Branch coverage....: 100.00%
```

## Build With

This project is powered by the following libraries:

* [cats](https://typelevel.org/cats/): Lightweight, modular, and extensible library for functional programming
* [catsEffects](https://typelevel.org/cats-effect/): The IO monad for Scala
* [fs2](https://fs2.io/): Purely functional, effectful, resource-safe, concurrent streams for Scala
* [scalaTest](http://www.scalatest.org/): Testing tool for Scala

## Assumptions made

Currently when the robot navigate the area the exploration area is check after the action taken and if it is out of bound the robot will stop and the remaining instructions are not executed.

## TODO List

Introduce property-based testing with 
* [scalaCheck](https://www.scalacheck.org/): Property-based testing for Scala

Introduce shapeless for the parsing of the file
* [shapeless](https://github.com/milessabin/shapeless): generic programming for Scala

Introduce Validated from typelevel to handle the errors with Either:
* [validated](https://typelevel.org/cats/datatypes/validated.html): Error handling type for scala

