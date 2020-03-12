package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;
import com.novoclarus.martianrobots.instructions.RotateInstruction;

import java.util.Arrays;
import java.util.List;

import static com.novoclarus.martianrobots.Constants.ORIENTATION_EAST;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_NORTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_SOUTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_WEST;

public abstract class RotateInstructionImpl implements RotateInstruction
{
    private static List<String> orientations = Arrays.asList(ORIENTATION_NORTH, ORIENTATION_EAST, ORIENTATION_SOUTH, ORIENTATION_WEST);

    @Override
    public Robot rotate90Degrees(Robot robot, int direction)
    {
        int newOrientationIndex = getOrientations().indexOf(robot.getOrientation()) + direction;

        if (newOrientationIndex < 0)
        {
            newOrientationIndex = getOrientations().size() - 1;
        }
        else if (newOrientationIndex == getOrientations().size())
        {
            newOrientationIndex = 0;
        }

        robot.setOrientation(getOrientations().get(newOrientationIndex));
        return robot;
    }

    private List<String> getOrientations()
    {
        return RotateInstructionImpl.orientations;
    }
}
