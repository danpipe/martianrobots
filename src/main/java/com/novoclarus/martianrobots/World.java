package com.novoclarus.martianrobots;

public class World
{
    private int maxBoundaryX;
    private int maxBoundaryY;

    public World(int maxBoundaryX, int maxBoundaryY)
    {
        this.maxBoundaryX = maxBoundaryX;
        this.maxBoundaryY = maxBoundaryY;
    }

    public int getMinBoundaryX() {
        return 0;
    }

    public int getMaxBoundaryX() {
        return maxBoundaryX;
    }

    public int getMinBoundaryY() {
        return 0;
    }

    public int getMaxBoundaryY() {
        return maxBoundaryY;
    }
}
