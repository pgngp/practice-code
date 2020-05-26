/* https://leetcode.com/problems/prison-cells-after-n-days/ */
class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        int cycleSize = 0;
        for (int i = 0; i < N; i++) {
            int[] nextDayCells = nextDay(cells);
            if (set.contains(Arrays.toString(nextDayCells))) {
                hasCycle = true;
                break;
            }
            cycleSize++;
            set.add(Arrays.toString(nextDayCells));
            cells = nextDayCells;
        }
        
        if (!hasCycle) {
            return cells;
        }
        
        N %= cycleSize;
        for (int i = 0; i < N; i++) {
            int[] nextDayCells = nextDay(cells);
            cells = nextDayCells;
        }
        
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] newCells = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                newCells[i] = 1;
            }
        }
        
        return newCells;
    }
}
