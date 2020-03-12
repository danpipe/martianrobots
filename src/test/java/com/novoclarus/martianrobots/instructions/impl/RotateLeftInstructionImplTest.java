package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;
import com.novoclarus.martianrobots.World;
import org.junit.Test;

import static com.novoclarus.martianrobots.Constants.ORIENTATION_EAST;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_NORTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_SOUTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_WEST;
import static org.junit.Assert.assertEquals;

public class RotateLeftInstructionImplTest
{
    private World world = new World();
    private RotateLeftInstructionImpl rotateLeftInstruction = new RotateLeftInstructionImpl();

    @Test
    public void testRobotShouldRotateNorthToWest()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_NORTH);
        final Robot updatedRobot = rotateLeftInstruction.execute(robot);
        assertEquals(ORIENTATION_WEST, updatedRobot.getOrientation());
    }

    @Test
    public void testRobotShouldRotateWestToSouth()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_WEST);
        final Robot updatedRobot = rotateLeftInstruction.execute(robot);
        assertEquals(ORIENTATION_SOUTH, updatedRobot.getOrientation());
    }

    @Test
    public void testRobotShouldRotateSouthToEast()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_SOUTH);
        final Robot updatedRobot = rotateLeftInstruction.execute(robot);
        assertEquals(ORIENTATION_EAST, updatedRobot.getOrientation());
    }

    @Test
    public void testRobotShouldRotateEastToNorth()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_EAST);
        final Robot updatedRobot = rotateLeftInstruction.execute(robot);
        assertEquals(ORIENTATION_NORTH, updatedRobot.getOrientation());
    }
}
