/**
 * Gas station (111):
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * http://www.programcreek.com/2014/03/leetcode-gas-station-java/
 */

import java.util.*;

public class GasStations {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (gas[i] >= cost[i]) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); ++i) {
            int start = list.get(i);
            int avail = gas[start];
            int idx = start;
            while (avail >= cost[idx]) {
                avail -= cost[idx];
                idx = (idx + 1) < n ? idx + 1 : 0;
                if (idx == start) {
                    return idx;
                }
                avail += gas[idx];
            } 
        }
        
        return -1;
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
