package com.tm.robot.core;

import com.tm.robot.core.Position;
import com.tm.robot.core.Robot;
import com.tm.robot.core.enums.Direction;
import com.tm.robot.exception.RobotSimulatorException;
import org.junit.Assert;
import org.junit.Test;

public class RobotTest {

    @Test
    public void testRobotMoveCommand() throws RobotSimulatorException {
        Robot robot = new Robot();
        robot.setNewPosition(new Position(1,3, Direction.WEST));
        robot.move(new Position(2,2, Direction.WEST));
        Assert.assertEquals("2,2,WEST", robot.reportPosition());
    }

    @Test
    public void testRobotLeftCommand() throws RobotSimulatorException {
        Robot robot = new Robot();
        robot.setNewPosition(new Position(1,3, Direction.WEST));
        robot.move(new Position(2,2, Direction.WEST));
        robot.left();
        Assert.assertEquals("2,2,SOUTH", robot.reportPosition());
    }

    @Test
    public void testRobotRightCommand() throws RobotSimulatorException {
        Robot robot = new Robot();
        robot.setNewPosition(new Position(1,3, Direction.WEST));
        robot.move(new Position(2,2, Direction.WEST));
        robot.right();
        Assert.assertEquals("2,2,NORTH", robot.reportPosition());
    }
}
