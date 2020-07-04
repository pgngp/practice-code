/* https://leetcode.com/problems/ugly-number-ii/ */
class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int i2Val = 2 * arr[i2];
            int i3Val = 3 * arr[i3];
            int i5Val = 5 * arr[i5];
            
            arr[i] = Math.min(i2Val, Math.min(i3Val, i5Val));
            if (arr[i] == i2Val) {
                i2++;
            }
            if (arr[i] == i3Val) {
                i3++;
            }
            if (arr[i] == i5Val) {
                i5++;
            }
        }
        
        return arr[n - 1];
    }
}
