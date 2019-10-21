/**
 * Rotate array (265):
 * Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
 * Ex1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Ex2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * http://www.programcreek.com/2015/03/rotate-array-in-java/
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int start = -1;
        while (count < nums.length) {
            ++start;
            int curr = (start + k) % nums.length;
            int tmp = nums[start];
            while (curr != start) {
                int tmp2 = nums[curr];
                nums[curr] = tmp;
                tmp = tmp2;
                curr = (curr + k) % nums.length;
                ++count;
            }
            nums[curr] = tmp;
            ++count;
        }
    }

    private static void printArr(int[] m) {
        System.out.print("[ ");
        for (int i = 0; i < m.length; ++i) {
            System.out.print(m[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <k> <arr size> <item1> <item2>...");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }

        RotateArray ra = new RotateArray();
        ra.rotate(nums, k);
        printArr(nums);
    }
}
