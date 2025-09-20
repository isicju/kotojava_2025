#!/bin/bash

wget https://repo1.maven.org/maven2/org/apache/commons/commons-lang3/3.18.0/commons-lang3-3.18.0.jar

javac -cp commons-lang3-3.18.0.jar Main.java

echo "Main-Class: Main" > manifest.txt
echo "Class-Path: commons-lang3-3.18.0.jar" >> manifest.txt

jar cfm Main.jar manifest.txt Main.class

java -jar Main.jar