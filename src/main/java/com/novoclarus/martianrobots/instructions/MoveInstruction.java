package com.novoclarus.martianrobots.instructions;

import com.novoclarus.martianrobots.Robot;
import com.novoclarus.martianrobots.instructions.Instruction;

public interface MoveInstruction extends Instruction
{
    Robot previewMove(Robot robot);
}
