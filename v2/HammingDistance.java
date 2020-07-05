/* https://leetcode.com/problems/hamming-distance/ */
class HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int count = 0;
        while (diff > 0) {
            if ((diff & 1) == 1) {
                count++;
            }
            diff >>= 1;
        }
        
        return count;
    }
}
