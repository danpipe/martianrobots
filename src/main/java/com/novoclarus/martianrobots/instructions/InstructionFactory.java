package com.novoclarus.martianrobots.instructions;

import com.novoclarus.martianrobots.instructions.impl.ForwardInstructionImpl;
import com.novoclarus.martianrobots.instructions.impl.RotateLeftInstructionImpl;
import com.novoclarus.martianrobots.instructions.impl.RotateRightInstructionImpl;

import java.util.HashMap;
import java.util.Map;

import static com.novoclarus.martianrobots.Constants.INSTRUCTION_FORWARD;
import static com.novoclarus.martianrobots.Constants.INSTRUCTION_LEFT;
import static com.novoclarus.martianrobots.Constants.INSTRUCTION_RIGHT;

public class InstructionFactory
{
    private static Map<String, Instruction> instructions = new HashMap<>();

    static
    {
        instructions.put(INSTRUCTION_FORWARD, new ForwardInstructionImpl());
        instructions.put(INSTRUCTION_RIGHT, new RotateRightInstructionImpl());
        instructions.put(INSTRUCTION_LEFT, new RotateLeftInstructionImpl());
    }

    public static Instruction getInstruction(final String instruction)
    {
        return instructions.get(instruction);
    }

    private InstructionFactory() {}
}
