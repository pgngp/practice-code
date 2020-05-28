/* https://leetcode.com/problems/counting-bits/ */
class CountingBits {
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = arr[i >> 1] + (i & 1);
        }
        
        return arr;
    }
}
