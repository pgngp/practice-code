/**
 * Plus one (156):
 * Given a non-negative number represented as an array of digits, plus one to the number. 
 * The digits are stored such that the most significant digit is at the head of the list.
 * http://www.programcreek.com/2014/05/leetcode-plus-one-java/
 */

/**
 * time: O(n) where n is number of digits
 * space: O(n) because we're creating an array to save the input array of digits; we use this same array for our output
 */

public class PlusOne {
    public static void plusOne(int[] arr) {
        boolean carryOver = false;
        int arrSize = arr.length;
        int start = arrSize - 1;

        if (arr[start] == 9) {
            arr[start--] = 0;
            carryOver = true;
        } else {
            ++arr[arrSize - 1];
            return;
        }

        for (int i = start; i >= 0; --i) {
            if (carryOver && arr[i] == 9) {
                arr[i] = 0;
                carryOver = true;
            } else {
                ++arr[i];
                carryOver = false;
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java <prog> <arg> [<args>...]");
            System.exit(1);
        }

        int[] arr;
        int arrIndex = 0;
        if (Integer.parseInt(args[0]) == 9) {
            arr = new int[args.length + 1];
            arr[0] = 0;
            arrIndex = 1;
        } else {
            arr = new int[args.length];
        }
        
        for (int i = 0; i < args.length; ++i) {
            arr[arrIndex++] = Integer.parseInt(args[i]);
        }

        System.out.print("Orig arr: ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        plusOne(arr);
        System.out.print("New arr: ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
