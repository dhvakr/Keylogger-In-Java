[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/dhvakr/keylogger-in-java/blob/main/LICENSE)
[![made-with-java](https://img.shields.io/badge/Made%20with-java-1f425f.svg)](https://www.oracle.com/java/)
![JDK](https://img.shields.io/badge/JDK-%3E%3D%20v8-blue)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-no-green.svg)](https://github.com/dhvakr/keylogger-in-java/graphs/commit-activity)

# Java-Keylogger
A simple keylogger application implemented in Java. It uses [Native Hook](https://github.com/kwhat/jnativehook) library to add global listener for key presses.

## How to Build and Run Project
TO build project: 
```bash
mvn package
```
Run ./target/keylogger-jar-with-dependencies.jar file using command:
```bash
java -jar `./target/keylogger-jar-with-dependencies.jar`
```
The keys will be written in **`keys.txt`** file and application logs will reside inside **`all.log`** file.

## Note 
Don't forget to stop the keylogger application after you've done logging.
