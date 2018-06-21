package com.tm.robot.core.enums;

/**
 * Hold direction with left and right faces with respect to
 * direction
 */
public enum Direction {

    NORTH ("WEST", "EAST"),
    EAST ("NORTH", "SOUTH"),
    SOUTH ("EAST", "WEST"),
    WEST ("SOUTH", "NORTH");

    private String left;
    private String right;

    private Direction(final String left, final String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}
