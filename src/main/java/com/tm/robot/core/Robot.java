package com.tm.robot.core;

import com.tm.robot.core.enums.Direction;
import com.tm.robot.exception.RobotSimulatorException;

/**
 * Robot class with behavior MOVE, LEFT, RIGHT or REPORT
 */
public class Robot {

    private Position currentPosition;

    public Robot() { }

    public Position getCurrentPosition() throws RobotSimulatorException {

        if(null == this.currentPosition) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        return currentPosition;
    }

    public void setNewPosition(final Position position) {
        this.currentPosition = position;
    }

    public void move(final Position nextPosition) {
        this.currentPosition = nextPosition;
    }

    /**
     * will rotate the robot 90 degrees in the specified direction
     * @throws RobotSimulatorException
     */
    public void left() throws RobotSimulatorException {
        if(null == this.currentPosition) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        this.currentPosition.setCurrentDirection(Direction.valueOf(this.currentPosition.getCurrentDirection().getLeft()));
    }

    /**
     * will rotate the robot 90 degrees in the specified direction
     * @throws RobotSimulatorException
     */
    public void right() throws RobotSimulatorException {
        if(null == this.currentPosition) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        this.currentPosition.setCurrentDirection(Direction.valueOf(this.currentPosition.getCurrentDirection().getRight()));
    }

    /**
     * Will display current direction and coordinates.
     * @return
     * @throws RobotSimulatorException
     */
    public String reportPosition() throws RobotSimulatorException {
        StringBuilder report = new StringBuilder();
        report.append(this.getCurrentPosition().getXAxis())
                .append(",")
                .append(this.getCurrentPosition().getYAxis())
                .append(",")
                .append(this.getCurrentPosition().getCurrentDirection().toString());

        return report.toString();
    }

}
