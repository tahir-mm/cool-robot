package com.tm.robot;

import com.tm.robot.core.Robot;
import com.tm.robot.core.RobotSimulator;
import com.tm.robot.core.TableTop;
import com.tm.robot.exception.RobotSimulatorException;

import java.io.Console;

/**
 * Main class to kick off robot simulator
 */
public class RobotApplication {

    public static void main(String[] args) {

        Console console = System.console();

        /**
         *handle console unavailability - if run through IDE
         */
        if(console == null) {
            System.err.println("Console not available!");
            System.exit(0);
        }

        /**
         * Instructions
         */
        System.out.println("*******   Welcome, I am a cool robot ********");
        System.out.println("My commands are ");
        System.out.println("\t1 - PLACE X,Y,FACING_DIRECTION (NORTH|SOUTH|EAST|WEST) (To place robot on table).");
        System.out.println("\t2 - MOVE, LEFT, RIGHT (To roam on the table)");
        System.out.println("\t3 - REPORT (To get current location)");
        System.out.println("\t4 - QUIT (To finish roaming)");

        /**
         * flag to check if robot is active or not
         */
        boolean isAlive = true;

        /**
         * setup table top with units and create robot simulator
         * instance to receive commands
         */
        TableTop surface = new TableTop(4,4);
        RobotSimulator simulator = new RobotSimulator(surface, new Robot());

        while (isAlive) {
            String command = console.readLine(">> ");
            if ("QUIT".equalsIgnoreCase(command)) {
                isAlive = false;
            } else {
                try {
                    /**
                     * start processing commands
                     */
                    String result = simulator.processCommand(command);
                    if(null != result) {
                        System.out.println("Output: " + result);
                    }
                } catch (RobotSimulatorException e) {
                    /**
                     * catch all thrown exception and display message to console
                     */
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
