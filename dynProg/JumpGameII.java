/**
 * Jump game II (98):
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example, given array A = [2,3,1,1,4], the minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * http://www.programcreek.com/2014/06/leetcode-jump-game-ii-java/
 */

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums[0] >= nums.length - 1) {
            return 1;
        }

        int max = nums[0];
        int maxIdx = 0;
        int start = 0;
        int end = start + max;
        int count = 1;
        while (end < nums.length) {
            ++count;
            max = start + 1 + nums[start + 1];
            maxIdx = start + 1;
            for (int i = start + 1; i <= end; ++i) {
                if (i + nums[i] >= nums.length - 1) {
                    return count;
                } else if (max <= i + nums[i]) {
                    max = i + nums[i];
                    maxIdx = i;
                }
            }
            start = end;
            end = max;
        }

        return count;
    }

    private void printArr(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <n> <item1> <item2> ...");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.print("[ ");
        for (int i = 0; i < n; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        JumpGameII jg = new JumpGameII();
        int result = jg.jump(nums);
        System.out.println("result: " + result);
    }
}
