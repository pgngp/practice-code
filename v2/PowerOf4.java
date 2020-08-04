/* https://leetcode.com/problems/power-of-four/ */
class PowerOf4 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
