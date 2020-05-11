class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];
        if (origColor == newColor) {
            return image;
        }
        
        helper(image, sr, sc, newColor, image[sr][sc]);
        
        return image;
    }
    
    private void helper(int[][] image, int row, int col, int newColor, int origColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != origColor) {
            return;
        }
        
        image[row][col] = newColor;
        helper(image, row, col - 1, newColor, origColor);
        helper(image, row - 1, col, newColor, origColor);
        helper(image, row, col + 1, newColor, origColor);
        helper(image, row + 1, col, newColor, origColor);
    }
}
