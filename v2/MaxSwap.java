/* https://leetcode.com/problems/maximum-swap/ */
class MaxSwap {
    public int maximumSwap(int num) {
        // convert num to char arr
        char[] digitArr = Integer.toString(num).toCharArray();
        
        // create array to store the last position of a digit
        int[] posArr = new int[10];
        for (int i = 0; i < digitArr.length; i++) {
            posArr[digitArr[i] - '0'] = i;
        }
        
        // for each digit from left to right, find the largest digit
        // greater than the current digit and to the right of current
        // digit
        for (int i = 0; i < digitArr.length; i++) {
            int currDigit = digitArr[i] - '0';
            for (int j = 9; j > currDigit; j--) {
                int k = posArr[j];
                if (i < k) {
                    char tmp = digitArr[i];
                    digitArr[i] = digitArr[k];
                    digitArr[k] = tmp;
                    
                    return Integer.parseInt(new String(digitArr));
                }
            }
        }
        
        return num;
    }
}
