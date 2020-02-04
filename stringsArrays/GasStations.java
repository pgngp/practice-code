/**
 * Gas station (111):
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * http://www.programcreek.com/2014/03/leetcode-gas-station-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

import java.util.*;

public class GasStations {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0, remaining = 0, start = -1, total = 0;
        for (int i = 0; i < gas.length; ++i) {
            diff = gas[i] - cost[i];
            remaining += diff;
            if (start < 0 && remaining > 0) {
                start = i;
            } else if (remaining < 0) {
                remaining = 0;
                start = -1;
            }
            total += diff;
        }

        return total >= 0 ? Math.max(0, start) : -1;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] gas = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; ++i) {
            gas[i] = Integer.parseInt(args[i + 1]);
            cost[i] = Integer.parseInt(args[i + 1 + n]);
        }
        System.out.println("gas:  " + Arrays.toString(gas));
        System.out.println("cost: " + Arrays.toString(cost));
        GasStations gs = new GasStations();
        int result = gs.canCompleteCircuit(gas, cost);
        System.out.println("result: " + result);
    }
}
