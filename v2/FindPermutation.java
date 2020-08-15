/* https://leetcode.com/problems/find-permutation/ */
class FindPermutation {
    public int[] findPermutation(String s) {
        // initialize arr
        int n = s.length() + 1;
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = i;
        }
        
        // reverse subarrays
        int i = 0, j = 0;
        while (j < n) {
            if (j < n - 1 && s.charAt(j) == 'I') {
                if (i < j) {
                    reverse(result, i, j);
                }
                i = j;
                i++;
            }
            j++;
        }
        if (i < j - 1) {
            reverse(result, i, j - 1);
        }
        
        return result;
    }
    
    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
