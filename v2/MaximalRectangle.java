/* https://leetcode.com/problems/maximal-rectangle/ */
class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[] hist = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '0') {
                    hist[col] = 0;
                } else {
                    hist[col]++;
                }
            }
            maxArea = Math.max(maxArea, calcMaxArea(hist));
        }
        
        return maxArea;
    }
    
    private int calcMaxArea(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int i = 0;
        while (i < arr.length) {
            if (stack.isEmpty() || arr[stack.peekFirst()] <= arr[i]) {
                stack.offerFirst(i++);
            } else {
                while (!stack.isEmpty() && arr[stack.peekFirst()] > arr[i]) {
                    int top = stack.pollFirst();
                    if (stack.isEmpty()) {
                        maxArea = Math.max(maxArea, arr[top] * i);
                    } else {
                        maxArea = Math.max(maxArea, arr[top] * (i - stack.peekFirst() - 1));   
                    }
                }
                stack.offerFirst(i++);
            }
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, arr[top] * i);   
            } else {
                maxArea = Math.max(maxArea, arr[top] * (i - stack.peekFirst() - 1));
            }
        }
        
        return maxArea;
    }
}
