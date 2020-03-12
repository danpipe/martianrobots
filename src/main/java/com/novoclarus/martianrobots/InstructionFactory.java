package com.novoclarus.martianrobots;

import java.util.HashMap;
import java.util.Map;

public class InstructionFactory
{
    private Map<String, Instruction> instructions = new HashMap<>();

    public Instruction getInstruction(String instr)
    {
        return instructions.get(instr);
    }
}
