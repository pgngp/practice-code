/**
 * Jump game (126):
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
 * http://www.programcreek.com/2014/03/leetcode-jump-game-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        } else if (nums.length == 1) {
            return true;
        }      

        int max = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (max <= i && nums[i] == 0) {
                return false;
            }

            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }

        return true;
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

        JumpGame jg = new JumpGame();
        boolean result = jg.canJump(nums);
        System.out.println("result: " + result);
    }
}
