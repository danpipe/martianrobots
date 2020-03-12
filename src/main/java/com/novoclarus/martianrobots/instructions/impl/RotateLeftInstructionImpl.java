package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;

public class RotateLeftInstructionImpl extends RotateInstructionImpl
{
    private static final int LEFT_ROTATION_DIRECTION = -1;

    @Override
    public Robot execute(Robot robot) {
        return rotate90Degrees(robot, LEFT_ROTATION_DIRECTION);
    }
}
