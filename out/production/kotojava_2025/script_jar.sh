#!/bin/bash

javac SimpleServer.java

echo "Main-Class: SimpleServer" > manifest.txt

jar cfm SimpleServer.jar manifest.txt SimpleServer.class

echo "Starting server..."

java -jar SimpleServer.jar