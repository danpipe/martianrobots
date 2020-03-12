package com.novoclarus.martianrobots;


import org.junit.Test;

import static com.novoclarus.martianrobots.Constants.ORIENTATION_EAST;
import static com.novoclarus.martianrobots.Constants.ORIENTATION_NORTH;
import static org.junit.Assert.assertEquals;

public class RobotTest
{
    @Test
    public void testShouldReportOKStatus()
    {
        final Robot robot = new Robot(new World(), 0, 0, ORIENTATION_NORTH);
        robot.checkStatus();

        final String expectedStatusReport = "0 0 " + ORIENTATION_NORTH;
        final String statusReport = robot.getStatusReport();
        assertEquals(expectedStatusReport, statusReport);
    }

    @Test
    public void testShouldReportLostStatus()
    {
        final Robot robot = new Robot(new World(), 1, 1, ORIENTATION_EAST);
        robot.checkStatus();

        final String expectedStatusReport = "1 1 " + ORIENTATION_EAST + " LOST";
        final String statusReport = robot.getStatusReport();
        assertEquals(expectedStatusReport, statusReport);
    }
}