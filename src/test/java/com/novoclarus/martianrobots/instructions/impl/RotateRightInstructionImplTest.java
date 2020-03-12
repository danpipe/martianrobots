package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;
import com.novoclarus.martianrobots.World;
import org.junit.Test;

import static com.novoclarus.martianrobots.Constants.ORIENTATION_EAST;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_NORTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_SOUTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_WEST;
import static org.junit.Assert.assertEquals;

public class RotateRightInstructionImplTest
{
    private World world = new World();
    private RotateRightInstructionImpl rotateRightInstruction = new RotateRightInstructionImpl();

    @Test
    public void testRobotShouldRotateNorthToEast()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_NORTH);
        final Robot updatedRobot = rotateRightInstruction.execute(robot);
        assertEquals(ORIENTATION_EAST, updatedRobot.getOrientation());
    }

    @Test
    public void testRobotShouldRotateEastToSouth()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_EAST);
        final Robot updatedRobot = rotateRightInstruction.execute(robot);
        assertEquals(ORIENTATION_SOUTH, updatedRobot.getOrientation());
    }

    @Test
    public void testRobotShouldRotateSouthToWest()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_SOUTH);
        final Robot updatedRobot = rotateRightInstruction.execute(robot);
        assertEquals(ORIENTATION_WEST, updatedRobot.getOrientation());
    }

    @Test
    public void testRobotShouldRotateWestToNorth()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_WEST);
        final Robot updatedRobot = rotateRightInstruction.execute(robot);
        assertEquals(ORIENTATION_NORTH, updatedRobot.getOrientation());
    }
}
