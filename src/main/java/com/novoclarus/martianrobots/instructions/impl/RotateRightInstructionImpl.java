package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;

public class RotateRightInstructionImpl extends RotateInstructionImpl
{
    private static final int RIGHT_ROTATION_DIRECTION = 1;

    @Override
    public Robot execute(Robot robot) {
        return rotate90Degrees(robot, RIGHT_ROTATION_DIRECTION);
    }
}
