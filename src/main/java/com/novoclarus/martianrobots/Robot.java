package com.novoclarus.martianrobots;

import com.novoclarus.martianrobots.instructions.Instruction;
import com.novoclarus.martianrobots.instructions.InstructionFactory;
import com.novoclarus.martianrobots.instructions.MoveInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.novoclarus.martianrobots.Status.LOST;
import static com.novoclarus.martianrobots.Status.OK;

public class Robot
{
    private List<Robot> ancestors = new ArrayList<>();
    private World world;
    private int positionX;
    private int positionY;
    private String orientation;
    private Status status = OK;

    public Robot(final World world, final List<Robot> ancestors)
    {
        this.world = world;
        this.ancestors = ancestors;
    }

    public Robot(final World world, final int positionX, final int positionY, final String orientation)
    {
        this.world = world;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public Robot(final Robot robot)
    {
        this.ancestors = new ArrayList<>(robot.ancestors);
        this.world = robot.world;
        this.positionX = robot.positionX;
        this.positionY = robot.positionY;
        this.orientation = robot.orientation;
        this.status = robot.status;
    }

    public void executeInstruction(final String instruction)
    {
        final Instruction instructionInstance = InstructionFactory.getInstruction(instruction);

        if (instructionInstance instanceof MoveInstruction)
        {
            MoveInstruction moveInstruction = (MoveInstruction) instructionInstance;
            Robot futureRobot = moveInstruction.previewMove(this);

            if (futureRobot.getStatus() == LOST)
            {
                this.status = LOST;

                for (Robot ancestor : ancestors)
                {
                    if (this.equals(ancestor))
                    {
                        this.status = OK;
                    }
                }
                return;
            }
        }

        instructionInstance.execute(this);

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

    public String getStatusReport()
    {
        StringBuilder statusReport = new StringBuilder();
        statusReport.append(positionX).append(" ");
        statusReport.append(positionY).append(" ");
        statusReport.append(orientation);

        if (LOST.equals(status))
        {
            statusReport.append(" ").append(status);
        }

        return statusReport.append("\n").toString();
    }

    protected Status checkStatus()
    {
        status = isOffworld() ? LOST : OK;

        if (LOST.equals(status))
        {
            ancestors.add(this);
        }

        return status;
    }

    private boolean isOffworld()
    {
        return positionX < world.getMinBoundaryX() || positionX > world.getMaxBoundaryX()
                || positionY < world.getMinBoundaryY() || positionY > world.getMaxBoundaryY();
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return positionX == robot.positionX &&
                positionY == robot.positionY &&
                orientation.equals(robot.orientation) &&
                status == robot.status;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(positionX, positionY, orientation, status);
    }

    public int getPositionX()
    {
        return positionX;
    }

    public void setPositionX(final int positionX)
    {
        this.positionX = positionX;
    }

    public int getPositionY()
    {
        return positionY;
    }

    public void setPositionY(final int positionY)
    {
        this.positionY = positionY;
    }

    public String getOrientation()
    {
        return orientation;
    }

    public void setOrientation(final String orientation)
    {
        this.orientation = orientation;
    }

    public Status getStatus()
    {
        return status;
    }
}
