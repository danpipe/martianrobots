package com.novoclarus.martianrobots;

public class World
{
    private int minBoundaryX;
    private int maxBoundaryX;
    private int minBoundaryY;
    private int maxBoundaryY;

    public int getMinBoundaryX() {
        return minBoundaryX;
    }

    public void setMinBoundaryX(int minBoundaryX) {
        this.minBoundaryX = minBoundaryX;
    }

    public int getMaxBoundaryX() {
        return maxBoundaryX;
    }

    public void setMaxBoundaryX(int maxBoundaryX) {
        this.maxBoundaryX = maxBoundaryX;
    }

    public int getMinBoundaryY() {
        return minBoundaryY;
    }

    public void setMinBoundaryY(int minBoundaryY) {
        this.minBoundaryY = minBoundaryY;
    }

    public int getMaxBoundaryY() {
        return maxBoundaryY;
    }

    public void setMaxBoundaryY(int maxBoundaryY) {
        this.maxBoundaryY = maxBoundaryY;
    }
}
