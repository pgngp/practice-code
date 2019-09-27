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
        }

        int[] cache = new int[nums.length];
        int result = dfs(nums, cache, 0);

        return result;
    }

    private int dfs(int[] nums, int[] cache, int idx) {
        if (idx == nums.length - 1) {
            return 0;
        } else if (cache[idx] > 0) {
            return cache[idx];
        }

        int min = nums.length - idx - 1;;
        for (int i = nums[idx]; i > 0; --i) {
            if (idx + i >= nums.length) {
                continue;
            }
            min = Integer.min(min, 1 + dfs(nums, cache, idx + i));
        }
        cache[idx] = min;

        return min;
    }

    private void printArr(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < n; ++i) {
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
