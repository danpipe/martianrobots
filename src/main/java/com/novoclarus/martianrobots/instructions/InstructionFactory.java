package com.novoclarus.martianrobots.instructions;

public interface InstructionFactory
{
    Instruction getInstruction(String instr);
}
