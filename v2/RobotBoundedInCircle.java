/* https://leetcode.com/problems/robot-bounded-in-circle/ */
class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        // directions
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // perform 1 cycle
        int idx = 0, x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'L') {
                idx = (idx + 3) % 4;
            } else if (c == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }
        
        return (x == 0 & y == 0) || idx != 0 ? true : false;
    }
}
