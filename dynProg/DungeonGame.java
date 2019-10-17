/**
 * Dungeon game (85):
 * -2 (K)    -3    3
 * -5    -10    1
 * 10    30    -5 (P)
 * http://www.programcreek.com/2014/03/leetcode-dungeon-game-java/
 */

/*
 * time: O(mn)
 * space: O(1)
 */

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int numRows = dungeon.length;
        int numCols = dungeon[0].length;
        
        // last cell
        dungeon[numRows - 1][numCols - 1] = Math.min(0, dungeon[numRows - 1][numCols - 1]);

        // last row
        for (int col = numCols - 2; col >= 0; --col) {
            dungeon[numRows - 1][col] = Math.min(0, dungeon[numRows - 1][col] + dungeon[numRows - 1][col + 1]);
        }

        // last col
        for (int row = numRows - 2; row >= 0; --row) {
            dungeon[row][numCols - 1] = Math.min(0, dungeon[row][numCols - 1] + dungeon[row + 1][numCols - 1]);
        }

        // remaining cells
        for (int row = numRows - 2; row >= 0; --row) {
            for (int col = numCols - 2; col >= 0; --col) {
                dungeon[row][col] = Math.min(0, dungeon[row][col] + Math.max(dungeon[row + 1][col], dungeon[row][col + 1]));
            }
        }

        return Math.abs(dungeon[0][0]) + 1;
    }

    private void printMatrix(int[][] m) {
        System.out.println("[");
        for (int row = 0; row < m.length; ++row) {
            System.out.print("  [ ");
            for (int col = 0; col < m[0].length; ++col) {
                System.out.printf("%4d", m[row][col]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <m> <n> <item1> <item2> ...");
            System.exit(1);
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[][] matrix = new int[m][n];
        int i = 2;
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                matrix[row][col] = Integer.parseInt(args[i++]);
            }
        }

        DungeonGame dg = new DungeonGame();
        dg.printMatrix(matrix);
        int result = dg.calculateMinimumHP(matrix);
        System.out.println("result: " + result);
    }
}
