package com.tm.robot.core.enums;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testDirection() {
        Direction direction = Direction.EAST;

        Assert.assertEquals(direction.getLeft(), Direction.NORTH.name());
        Assert.assertEquals(direction.getRight(), Direction.SOUTH.name());

        direction = Direction.NORTH;

        Assert.assertEquals(direction.getLeft(), Direction.WEST.name());
        Assert.assertEquals(direction.getRight(), Direction.EAST.name());

        direction = Direction.WEST;

        Assert.assertEquals(direction.getLeft(), Direction.SOUTH.name());
        Assert.assertEquals(direction.getRight(), Direction.NORTH.name());

        direction = Direction.SOUTH;

        Assert.assertEquals(direction.getLeft(), Direction.EAST.name());
        Assert.assertEquals(direction.getRight(), Direction.WEST.name());
    }
}
