/* https://leetcode.com/problems/number-of-ways-to-split-a-string/ */
class NumWaysToSplitString {
    public int numWays(String s) {
        // calc num ones
        int numOnes = getNumOnes(s);
        if (numOnes % 3 != 0) {
            return 0;
        }
        
        // if all items are 0
        int n = s.length();
        if (numOnes == 0) {
            return (int) (((long) (n - 2) * (n - 1) / 2) % 1000000007);   
        }
        
        // calc num ones in each group
        int maxNumOnesInEachGroup = numOnes / 3;
        
        // go through items
        int numOnesInEachGroup = 0, numZeros = 0;
        long count = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (numOnesInEachGroup == maxNumOnesInEachGroup) {
                    count = (count * ((long) numZeros + 1)) % 1000000007;
                    numZeros = 0;
                    numOnesInEachGroup = 0;
                }
                numOnesInEachGroup++;
            } else if (numOnesInEachGroup == maxNumOnesInEachGroup) {
                numZeros++;
            }
        }
        
        return (int) count;
    }
    
    private int getNumOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        
        return count;
    }
}
