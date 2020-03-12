package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;

import static com.novoclarus.martianrobots.Constants.ORIENTATION_EAST;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_NORTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_SOUTH;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_WEST;

public class ForwardInstructionImpl extends MoveInstructionImpl
{
    @Override
    public Robot execute(Robot robot)
    {
        switch (robot.getOrientation())
        {
            case ORIENTATION_NORTH:
                robot.moveVertically(1);
                break;
            case ORIENTATION_EAST:
                robot.moveHorizontally(1);
                break;
            case ORIENTATION_SOUTH:
                robot.moveVertically(-1);
                break;
            case ORIENTATION_WEST:
                robot.moveHorizontally(-1);
                break;
            default:
                // Do nothing
        }

        return robot;
    }
}
