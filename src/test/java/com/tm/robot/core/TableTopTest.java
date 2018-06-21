package com.tm.robot.core;

import com.tm.robot.core.Position;
import com.tm.robot.core.TableTop;
import com.tm.robot.core.enums.Direction;
import org.junit.Assert;
import org.junit.Test;


public class TableTopTest {

    @Test
    public void testValidCoordinates() {
        TableTop surface = new TableTop(4,4);
        Position position = new Position(0,3, Direction.NORTH);

        Assert.assertTrue(surface.checkCoordinates(position));
    }

    @Test
    public void testInvalidCoordinates() {
        TableTop surface = new TableTop(4,4);
        Position position = new Position(-1,0, Direction.NORTH);
        Assert.assertFalse(surface.checkCoordinates(position));
    }


}
