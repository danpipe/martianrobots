package com.novoclarus.martianrobots.instructions;

import com.novoclarus.martianrobots.Robot;

public interface MoveInstruction extends Instruction
{
    Robot previewMove(final Robot robot);
}
