package com.novoclarus.martianrobots.instructions.impl;

import com.novoclarus.martianrobots.instructions.Instruction;
import com.novoclarus.martianrobots.instructions.InstructionFactory;

import java.util.HashMap;
import java.util.Map;

public class InstructionFactoryImpl implements InstructionFactory
{
    private Map<String, Instruction> instructions = new HashMap<>();

    @Override
    public Instruction getInstruction(String instr)
    {
        return instructions.get(instr);
    }
}
