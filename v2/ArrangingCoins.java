/* https://leetcode.com/problems/arranging-coins/ */
class ArrangingCoins {
    public int arrangeCoins(int n) {
        long left = 1, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long numCoins = mid * (mid + 1) / 2;
            
            if (numCoins == n) {
                return (int) mid;
            } else if (numCoins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) right;
    }
}
