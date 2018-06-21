package com.tm.robot.core.enums;

import com.tm.robot.exception.RobotSimulatorException;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void testDirection() throws RobotSimulatorException {

        Command command = Command.PLACE;
        Assert.assertEquals(command, Command.validateCommand("PLACE"));

        command = Command.MOVE;
        Assert.assertEquals(command, Command.validateCommand("MOVE"));

        command = Command.QUIT;
        Assert.assertEquals(command, Command.validateCommand("QUIT"));
    }

    @Test (expected = RobotSimulatorException.class)
    public void testInvalidCommand() throws RobotSimulatorException {
        Command.validateCommand("ABCD");
    }
}
