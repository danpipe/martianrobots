package com.novoclarus.martianrobots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.novoclarus.martianrobots.Status.LOST;

public class MartianRobots
{
    public static void main(String[] args)
    {
        String input = "53\n" +
                "11E\n" +
                "RFRFRFRF\n" +
                "\n" +
                "32N\n" +
                "FRRFLLFFRRFLL\n" +
                "\n" +
                "03W\n" +
                "LLFFFLFLFL";

        final List<String> inputLines = new LinkedList<>(Arrays.asList(input.split("\\n")));

        (new MartianRobots()).exploreWorld(inputLines);
    }

    public void exploreWorld(final List<String> inputLines)
    {
        final String worldCoordinates = inputLines.get(0);
        final World mars = new World(Integer.valueOf(worldCoordinates.substring(0, 1)), Integer.valueOf(worldCoordinates.substring(1, 2)));
        inputLines.remove(0);
        int instructionBlockIndex = 0;
        final StringBuilder statusReport = new StringBuilder();
        final List<Robot> robotAncestors = new ArrayList<>();
        Robot currentRobot = new Robot(mars, robotAncestors);

        for (final String inputLine : inputLines)
        {
            if (inputLine.isEmpty())
            {
                robotAncestors.add(currentRobot);
                currentRobot = new Robot(mars, robotAncestors);
                instructionBlockIndex = 0;
                continue;
            }

            if ((instructionBlockIndex % 2) == 0)
            {
                initialiseRobot(currentRobot, inputLine);
            }
            else
            {
                statusReport.append(processInstructions(currentRobot, inputLine));
            }

            instructionBlockIndex++;
        }

        System.out.println(statusReport);
    }

    private String processInstructions(final Robot robot, final String inputLine)
    {
        final String[] instructions = inputLine.trim().split("");

        for (String instruction : instructions)
        {
            robot.executeInstruction(instruction);

            if (LOST.equals(robot.getStatus()))
            {
                break;
            }
        }

        return robot.getStatusReport();
    }

    private void initialiseRobot(final Robot currentRobot, final String inputLine)
    {
        currentRobot.setPositionX(Integer.valueOf(inputLine.substring(0, 1)));
        currentRobot.setPositionY(Integer.valueOf(inputLine.substring(1, 2)));
        currentRobot.setOrientation(inputLine.substring(2, 3));
    }
}
