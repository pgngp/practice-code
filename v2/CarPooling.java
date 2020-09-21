/* https://leetcode.com/problems/car-pooling/ */
class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];
        for (int[] trip : trips) {
            locations[trip[1]] += trip[0];
            locations[trip[2]] -= trip[0];
        }
        
        int actualCapacity = 0;
        for (int i = 0; i < 1001; i++) {
            actualCapacity += locations[i];
            if (actualCapacity > capacity) {
                return false;
            }
        }
        
        return true;
    }
}
