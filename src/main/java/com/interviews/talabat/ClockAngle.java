package com.interviews.talabat;

/**
 * How to find the angle between hour and minute hands of a clock at any given time?
 * : The user will input hour and minute of the time and the method should give the
 * angle between the hour hand and minute hand at that given time.
 * input: 9 30, output: The angle between hour hand and minute hand is 105 degrees
 * input: 13 30, output: The angle between hour hand and minute hand is 135 degree
 */
public class ClockAngle {
    public static void main(String[] args) {
        System.out.println(findClockAngle(13, 30));
    }

    private static final int hourDegrees = 360 / 12;

    private static final int minuteDegrees = 360 / 60;

    private static final double minuteDeviation = Double.valueOf(hourDegrees) / 60;

    private static int findClockAngle(int hour, int min) {
        if (hour > 12)
            hour -= 12;

        // A clock has 12 hours for 360 degrees so each hour adds 360/12 = 30 degrees.
        int hourHandPos = hour * hourDegrees;

        // we need to add the deviation due to minute hand
        int minHandPos = min * minuteDegrees;

        // Additional angle to be added to Hour hands position due to minute hand position
        double deviationDueToMinuteHand = min * minuteDeviation;

        int actualHourHandPosition = (int) (hourHandPos + deviationDueToMinuteHand);

        int angle = actualHourHandPosition - minHandPos;

        if (angle < 1)
            angle *= -1;

        return angle;
    }
}
