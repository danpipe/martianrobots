package com.novoclarus.martianrobots;

import java.util.List;

public class Robot
{
    private List<Robot> ancestors;
    private World world;
    private int positionX;
    private int positionY;
    private String orientation;
    private Status status;

    public Robot(final World world, final int positionX, final int positionY, final String orientation)
    {
        this.world = world;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    void executeInstruction(String instruction)
    {

    }

    public int getPositionX()
    {
        return positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }

    public String getOrientation()
    {
        return orientation;
    }

    public Status getStatus()
    {
        return status;
    }
}
