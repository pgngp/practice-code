/**
 * Perfect square:
 * https://leetcode.com/problems/perfect-squares/
 */

import java.util.*;

public class PerfectSquares {
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt == Math.floor(sqrt)) {
            return 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int ps = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i += 2) {
            ps += i;
            if (ps > n) {
                break;
            }
            map.put(ps, 1);
            list.add(ps);
        }
        map.put(0, 1);

        return Math.min(n, getCount(list, n, n, map));
    }

    private int getCount(List<Integer> list, int x, int n, Map<Integer, Integer> map) {
        if (map.containsKey(x)) {
            return map.get(x);
        } else if (x < 0) {
            return n;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            min = Math.min(min, 1 + getCount(list, x - list.get(i), n, map));
        }
        map.put(x, min);

        return min;
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        int result = ps.numSquares(Integer.parseInt(args[0]));
        System.out.println("result: " + result);
    }
}
