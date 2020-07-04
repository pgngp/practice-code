/* https://leetcode.com/problems/minimum-knight-moves/ */
class MinKnightMoves {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        if (x == 0 && y == 0) {
            return 0;
        }
        
        Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        Pair<Integer, Integer> origin = new Pair<>(0, 0);
        q.add(origin);
        
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(origin);
        
        int[][] directions = new int[][] {
            {-2, -1}, {-2, 1},
            {-1, -2}, {1, -2},
            {2, -1}, {2, 1},
            {-1, 2}, {1, 2}
        };
        
        int count = 0;
        while (!q.isEmpty()) {
            // printQ(q);
            Deque<Pair<Integer, Integer>> newQ = new ArrayDeque<>();
            count++;
            while (!q.isEmpty()) {
                Pair<Integer, Integer> cell = q.pollFirst();
                int x1 = cell.getKey();
                int y1 = cell.getValue();

                for (int i = 0; i < directions.length; i++) {
                    int x2 = x1 + directions[i][0];
                    int y2 = y1 + directions[i][1];
                    
                    if (x == x2 && y == y2) {
                        return count;
                    }
                    
                    Pair<Integer, Integer> pair = new Pair<>(x2, y2);
                    if (x2 < -1 || y2 < -1 || Math.abs(x2) + Math.abs(y2) > 300 || visited.contains(pair)) {
                        continue;
                    }

                    visited.add(pair);
                    newQ.offerLast(pair);
                }
            }
            q = newQ;
        }
        
        return -1;
    }
    
    private void printQ(Deque<Pair<Integer, Integer>> q) {
        Deque<Pair<Integer, Integer>> newQ = new ArrayDeque<>(q);
        while (!newQ.isEmpty()) {
            Pair<Integer, Integer> pair = newQ.pollFirst();
            System.out.print("[" + pair.getKey() + "," + pair.getValue() + "] ");
        }
        System.out.println();
    }
}
