package com.tm.robot.core;

import com.tm.robot.core.enums.Direction;
import com.tm.robot.exception.RobotSimulatorException;

/**
 * Hold robot's current coordinates and direction
 */
public class Position {

    private int xAxis;

    private int yAxis;

    private Direction currentDirection;

    public Position(final int xAxis, final int yAxis, final Direction currentDirection) {
        this.currentDirection = currentDirection;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public Direction getCurrentDirection() throws RobotSimulatorException {
        if(null == this.currentDirection) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void newCoordinates(final int x, final int y) {
        this.xAxis += x;
        this.yAxis += y;
    }
}
