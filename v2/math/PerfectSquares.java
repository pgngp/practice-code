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
        Set<Integer> set = new TreeSet<>();
        int ps = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i += 2) {
            ps += i;
            if (ps > n) {
                break;
            }
            set.add(ps);
        }
        System.out.println("set: " + set);

        return Math.min(n, getCount(set, n, n, map));
    }

    private int getCount(Set<Integer> set, int x, int n, Map<Integer, Integer> map) {
        if (x == 0 || set.contains(x)) {
            return 1;
        } else if (x < 0) {
            return n;
        } else if (map.containsKey(x)) {
            return map.get(x);
        }

        Iterator<Integer> it = set.iterator();
        int min = Integer.MAX_VALUE;
        while (it.hasNext()) {
            min = Math.min(min, 1 + getCount(set, x - it.next(), n, map));
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
