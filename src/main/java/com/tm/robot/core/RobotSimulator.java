package com.tm.robot.core;

import com.tm.robot.core.Position;
import com.tm.robot.core.Robot;
import com.tm.robot.core.TableTop;
import com.tm.robot.core.enums.Command;
import com.tm.robot.core.enums.Direction;
import com.tm.robot.exception.RobotSimulatorException;

/**
 * Hold robot and table top instance. Receive commands and process
 * according to current robot position.
 */
public class RobotSimulator {

    private TableTop surface;

    private Robot robot;

    /**
     * Constructor
     * @param surface
     * @param robot
     */
    public RobotSimulator(final TableTop surface, final Robot robot) {
        this.surface = surface;
        this.robot = robot;
    }

    /**
     * Replace robot current position
     * @param position
     * @throws RobotSimulatorException
     */
    public void placeRobot(final Position position) throws RobotSimulatorException {

        if(!this.surface.checkCoordinates(position)) {
            throw new RobotSimulatorException("Invalid coordinates!");
        }

        this.robot.setNewPosition(position);
    }

    /**
     * Core method to process all user commands, validate and process.
     * @param input
     * @return
     * @throws RobotSimulatorException
     */
    public String processCommand(final String input) throws RobotSimulatorException {
        String result = null;
        String[] commands = input.split(" ");
        if(commands.length > 0) {

            Command command = Command.validateCommand(commands[0]);

            switch (command) {
                case PLACE:
                    this.placeRobot(this.getPosition(command, commands));
                    break;
                case MOVE:
                    Position nextPosition = this.getNextPosition();
                    /**
                     * move only if new position is a valid position
                     * according to table top units.
                     */
                    if(this.surface.checkCoordinates(nextPosition)) {
                        this.robot.move(nextPosition);
                    }
                    break;
                case REPORT:
                    result = this.robot.reportPosition();
                    break;
                case RIGHT:
                    this.robot.right();
                    break;
                case LEFT:
                    this.robot.left();
                    break;
                default:
                    throw new RobotSimulatorException("Alien command to me!");
            }
        } else {
            throw new RobotSimulatorException("Alien command to me!");
        }

        return result;
    }

    /**
     * Get position & direction if passed command is PLACE
     * @param command
     * @param input
     * @return
     * @throws RobotSimulatorException
     */
    private Position getPosition(final Command command, final String[] input) throws RobotSimulatorException {
        String[] commands;
        int xAxis = 0;
        int yAxis = 0;
        Position position = null;
        if (command == Command.PLACE) {
            try {
                commands = input[1].split(",");

                xAxis = Integer.parseInt(commands[0]);
                yAxis = Integer.parseInt(commands[1]);
                Direction direction = Direction.valueOf(commands[2]);
                position = new Position(xAxis, yAxis, direction);

            } catch (Exception e) {
                throw new RobotSimulatorException("Alien command to me!");
            }
        }

        return position;
    }

    /**
     * Build a new position instance in case of MOVE command
     * @return
     * @throws RobotSimulatorException
     */
    private Position getNextPosition() throws RobotSimulatorException {
        Position nextPosition = new Position(this.robot.getCurrentPosition().getXAxis(),
                this.robot.getCurrentPosition().getYAxis(),
                this.robot.getCurrentPosition().getCurrentDirection());
        switch (this.robot.getCurrentPosition().getCurrentDirection()) {
            case NORTH:
                nextPosition.newCoordinates(0, 1);
                break;
            case EAST:
                nextPosition.newCoordinates(1, 0);
                break;
            case SOUTH:
                nextPosition.newCoordinates(0, -1);
                break;
            case WEST:
                nextPosition.newCoordinates(-1, 0);
                break;
        }

        return nextPosition;
    }
}
