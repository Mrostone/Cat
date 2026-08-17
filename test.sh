#!/usr/bin/env bash

export MAVEN_OPTS="--sun-misc-unsafe-memory-access=allow"

mvn clean package -q

java -jar target/cat-1.0-SNAPSHOT.jar src/test/java/valid/functionDec/add.cat
