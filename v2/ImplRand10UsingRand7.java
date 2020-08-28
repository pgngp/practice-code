/* https://leetcode.com/problems/implement-rand10-using-rand7/ */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends ImplRand10UsingRand7 {
    public int rand10() {
        int rand1, rand2, idx;
        do {
            rand1 = rand7();
            rand2 = rand7();
            idx = 7 * (rand1 - 1) + rand2;
        } while (idx > 40);
        
        int val = idx % 10;
        
        return val == 0 ? 10 : val;
    }
}
