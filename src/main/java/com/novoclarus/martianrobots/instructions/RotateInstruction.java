package com.novoclarus.martianrobots.instructions;

import com.novoclarus.martianrobots.Robot;

public interface RotateInstruction extends Instruction
{
    Robot rotate90Degrees(Robot robot, int direction);
}
