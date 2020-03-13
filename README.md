# Game of Life
Naive Game of Life program written in Java. Supports an infinitely expanding grid.

Cell pattern configurations in the form of .txt files can be found in:
- src/main/java/assets

`O` denotes a life cell while `.` denotes a dead cell.

## Limitations
- Drawing might not work properly on non-UNIX systems.

## Environment Setup
- Java 11 (OpenJDK)
- Gradle 5.2.1
- JUnit 4
​
## Run Test
```
./gradlew check
```

## Run Instruction
```
./gradlew run
```
Executing the above command will run game of life with the glider gun cell pattern.
