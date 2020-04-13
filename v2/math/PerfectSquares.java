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

        // list of perfect squares
        Set<Integer> set = new HashSet<>();
        int ps = 0;
        for (int i = 1; i < n; i += 2) {
            ps += i;
            if (ps > n) {
                break;
            }
            set.add(ps);
        }

        // bfs
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(Integer.MAX_VALUE);
        q.addLast(n);
        int steps = 0;
        while (q.size() > 0) {
            int x = q.removeFirst();
            if (x == Integer.MAX_VALUE) {
                ++steps;
                q.add(Integer.MAX_VALUE);
                continue;
            }

            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                int rem = x - it.next();
                if (set.contains(rem)) {
                    return steps + 1;
                } else if (rem < 0) {
                    continue;
                }
                q.addLast(rem);
            }
        }

        return n;
    }

    public int numSquares2(int n) {
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
        map.put(-1, n);

        return Math.min(n, getCount(list, n, map));
    }

    private int getCount(List<Integer> list, int x, Map<Integer, Integer> map) {
        if (map.containsKey(x)) {
            return map.get(x);
        } else if (x < 0) {
            return map.get(-1);
        }

        int min = Integer.MAX_VALUE;
        for (int ps : list) {
            min = Math.min(min, 1 + getCount(list, x - ps, map));
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
