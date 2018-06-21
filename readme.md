# COOL ROBOT - Simulator

The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.

## Environment

- JAVA 1.8
- Maven
- Junit (Unit Testing)

## Build & Run

- build: `mvn clean install` - a compiled jar will be available in target folder and use following

commands `java -jar cool-robot-1.0-SNAPSHOT.jar` to run from jar file.

- Run: `mvn exec:java`

### Sample Run Commands
>> PLACE 0,2,EAST
>> MOVE

>> REPORT

Output:1,2,EAST

>> PLACE 0,5,WEST

Invalid coordinates!

>> REPORT

Output:1,2,EAST

>> MOVE

>> MOVE

>> MOVE

>> MOVE

>> REPORT

Output:4,2,EAST

>> LEFT

>> REPORT

Output:4,2,NORTH

>> MOVE

>> MOVE

>> MOVE

>> MOVE

>> REPORT

Output:4,4,NORTH

>> QUIT