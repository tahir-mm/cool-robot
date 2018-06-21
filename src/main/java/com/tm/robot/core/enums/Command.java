package com.tm.robot.core.enums;

import com.tm.robot.exception.RobotSimulatorException;

/**
 * Hold all valid commands for robot
 */
public enum Command {

    PLACE,
    MOVE,
    RIGHT,
    LEFT,
    REPORT,
    QUIT;

    /**
     * validate passed commands and throw exception if not a valid
     * @param command
     * @return
     * @throws RobotSimulatorException
     */
    public static Command validateCommand(final String command) throws RobotSimulatorException {
        try {
            return Command.valueOf(command);
        } catch(IllegalArgumentException e) {
            throw new RobotSimulatorException("Alien command to me!");
        }
    }
}
