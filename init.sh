#!/bin/bash
./gradlew assemble;
cp build/libs/desafio-sincredi-0.1.0-SNAPSHOT.jar src/main/resources/docker/.;
cd src/main/resources/docker;
docker build -t java-app .;
