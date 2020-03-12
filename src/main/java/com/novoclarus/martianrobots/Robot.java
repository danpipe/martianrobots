package com.novoclarus.martianrobots;

import java.util.List;

import static com.novoclarus.martianrobots.Status.LOST;
import static com.novoclarus.martianrobots.Status.OK;

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

    public Robot(final Robot robot)
    {
        this.ancestors = robot.ancestors;
        this.world = robot.world;
        this.positionX = robot.positionX;
        this.positionY = robot.positionY;
        this.orientation = robot.orientation;
        this.status = robot.status;
    }

    public void executeInstruction(String instruction)
    {

    }

    public void moveHorizontally(final int distance)
    {
       this.positionX += distance;
       checkStatus();
    }

    public void moveVertically(final int distance)
    {
        this.positionY += distance;
        checkStatus();
    }

    public Status checkStatus()
    {
        status = isOffworld() ? LOST : OK;
        return status;
    }


    private boolean isOffworld()
    {
        return positionX < world.getMinBoundaryX() || positionX > world.getMaxBoundaryX()
                || positionY < world.getMinBoundaryY() || positionY > world.getMaxBoundaryY();
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
