package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;
import com.novoclarus.martianrobots.World;
import org.junit.Before;
import org.junit.Test;

import static com.novoclarus.martianrobots.Constants.ORIENTATION_EAST;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_NORTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_SOUTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_WEST;
import static com.novoclarus.martianrobots.Status.LOST;
import static com.novoclarus.martianrobots.Status.OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ForwardInstructionImplTest
{
    private World world = new World();
    private ForwardInstructionImpl forwardInstruction = new ForwardInstructionImpl();

    @Before
    public void setUp()
    {
        world.setMaxBoundaryX(5);
        world.setMaxBoundaryY(3);
    }

    @Test
    public void testRobotShouldMoveNorthOk()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_NORTH);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(0, updatedRobot.getPositionX());
        assertEquals(1, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_NORTH, updatedRobot.getOrientation());
        assertEquals(OK, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveEastOk()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_EAST);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(1, updatedRobot.getPositionX());
        assertEquals(0, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_EAST, updatedRobot.getOrientation());
        assertEquals(OK, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveSouthOk()
    {
        final Robot robot = new Robot(world, 0, 1, ORIENTATION_SOUTH);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(0, updatedRobot.getPositionX());
        assertEquals(0, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_SOUTH, updatedRobot.getOrientation());
        assertEquals(OK, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveWestOk()
    {
        final Robot robot = new Robot(world, 1, 0, ORIENTATION_WEST);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(0, updatedRobot.getPositionX());
        assertEquals(0, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_WEST, updatedRobot.getOrientation());
        assertEquals(OK, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveNorthOffworld()
    {
        final Robot robot = new Robot(world, 0, 3, ORIENTATION_NORTH);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(0, updatedRobot.getPositionX());
        assertEquals(4, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_NORTH, updatedRobot.getOrientation());
        assertEquals(LOST, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveEastOffworld()
    {
        final Robot robot = new Robot(world, 5, 0, ORIENTATION_EAST);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(6, updatedRobot.getPositionX());
        assertEquals(0, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_EAST, updatedRobot.getOrientation());
        assertEquals(LOST, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveSouthOffworld()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_SOUTH);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(0, updatedRobot.getPositionX());
        assertEquals(-1, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_SOUTH, updatedRobot.getOrientation());
        assertEquals(LOST, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldMoveWestOffworld()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_WEST);
        final Robot updatedRobot = forwardInstruction.execute(robot);
        assertEquals(-1, updatedRobot.getPositionX());
        assertEquals(0, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_WEST, updatedRobot.getOrientation());
        assertEquals(LOST, updatedRobot.getStatus());
        assertEquals(robot, updatedRobot);
    }

    @Test
    public void testRobotShouldPreviewMoveNorthOk()
    {
        final Robot robot = new Robot(world, 0, 0, ORIENTATION_NORTH);
        final Robot updatedRobot = forwardInstruction.previewMove(robot);
        assertEquals(0, updatedRobot.getPositionX());
        assertEquals(1, updatedRobot.getPositionY());
        assertEquals(ORIENTATION_NORTH, updatedRobot.getOrientation());
        assertEquals(OK, updatedRobot.getStatus());
        assertNotEquals(robot, updatedRobot);
    }

}