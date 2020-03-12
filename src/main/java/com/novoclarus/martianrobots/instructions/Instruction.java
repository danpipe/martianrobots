package com.novoclarus.martianrobots.instructions;

import com.novoclarus.martianrobots.Robot;

public interface Instruction
{
    Robot execute(final Robot robot);
}
