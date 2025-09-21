#!/bin/bash

mvn clean install

echo "Starting server..."

java -jar target/hello-world-1.0-jar-with-dependencies.jar