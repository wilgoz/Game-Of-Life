# Game of Life
Game of Life program written in Java. Supports an infinitely expanding grid.

Runs the `Glider Gun` pattern by default. The config file for cell patterns can be found in:
- src/main/java/resources/

`O` denotes a life cell while `.` denotes a dead cell.

## Limitations
- Drawing might not work properly on non-UNIX systems.

## Environment Setup
- Java 11 (OpenJDK)
- Gradle 5.2.1
- JUnit 4
​
## Cell Pattern Format
```
........................................................
..................................O.....................
................................O.O.....................
......................OO......OO............OO..........
.....................O...O....OO............OO..........
..........OO........O.....O...OO........................
..........OO........O...O.OO....O.O.....................
....................O.....O.......O.....................
.....................O...O..............................
......................OO................................
........................................................
```

## Run Test
```
./gradlew check
```

## Run Instruction
```
./gradlew --console plain run
```
Executing the above command will run game of life with the default glider gun cell pattern.

## Running Custom Cell Patterns
```
./gradlew --console plain run --args="[FILE_NAME]"
```
Place your custom cell configuration file within the `src/main/java/resources/` directory, following
the above defined cell pattern format.

For instance, to run a custom `toad.txt` file:
- Place the `toad.txt` file within the `src/main/java/resources/` directory 
- Execute: `./gradlew --console plain run --args="toad.txt"`
