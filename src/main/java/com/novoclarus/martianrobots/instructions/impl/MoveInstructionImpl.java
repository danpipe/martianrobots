package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.Robot;
import com.novoclarus.martianrobots.instructions.MoveInstruction;

public abstract class MoveInstructionImpl implements MoveInstruction
{
    public Robot previewMove(Robot robot)
    {
        return robot;
    }

    protected boolean isOffworld(Robot robot)
    {
        return false;
    }

}
