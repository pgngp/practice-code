/**
 * Angle between Hands of a Clock:
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */

/*
 * time: O(1)
 * space: O(1)
 */

import java.util.*;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        hour %= 12;
        double hourAngle = ((hour * 5) + ((double) minutes / 12)) * 6;
        double minuteAngle = ((double) minutes) * 6;
        double result = hourAngle > minuteAngle ? hourAngle - minuteAngle : minuteAngle - hourAngle;

        return result < 180 ? result : 360 - result;
    }

    public static void main(String[] args) {
        AngleBetweenHandsOfAClock a = new AngleBetweenHandsOfAClock();
        double result = a.angleClock(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("result: " + result);
    }
}
