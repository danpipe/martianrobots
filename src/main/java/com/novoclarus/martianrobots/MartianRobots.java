package com.novoclarus.martianrobots;

public class MartianRobots
{
    private static String input = "53\n" +
            "11E\n" +
            "RFRFRFRF\n" +
            "\n" +
            "32N\n " +
            "FRRFLLFFRRFLL\n" +
            "\n" +
            "03W\n" +
            "LLFFFLFLFL";

    public static void main( String[] args )
    {
        final String[] inputLines = input.split("\\n");
        final String worldCoordinates = inputLines[0];
        final World mars = new World(Integer.valueOf(worldCoordinates.substring(0,1)), Integer.valueOf(worldCoordinates.substring(1,2)));



        return;
    }
}
