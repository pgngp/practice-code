/**
 * Find minimum in rotated sorted array:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. You may assume no duplicate exists in the array.
 * http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/
 */

public class RotatedSortedArray {
    /**
     * Recursive
     * time: O(logn)
     * space: O(logn)
     */
    public static int findMin(int left, int right, int[] arr) {
        int mid = left + ((right - left) / 2);

        // If only 1 element left
        if (left >= right) {  
            return arr[left];
        // If the element to the left is greater
        } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return arr[mid];
        // If not rotated
        } else if (arr[left] < arr[right]) {
            return arr[left];
        // Go left
        } else if (arr[left] > arr[mid]) {
            return findMin(left, mid - 1, arr);
        // Go right
        } else {
            return findMin(mid + 1, right, arr);
        }
    }

    public static int findMinIterative(int left, int right, int[] arr) {
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            // If there's only 1 element left
            if (left == right) {
                min = arr[left];
                break;
            // If left-of-mid is greater than mid
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                min = arr[mid];
                break;
            // If array is not rotated
            } else if (arr[left] < arr[right]) {
                min = arr[left];
                break;
            // Go left
            } else if (arr[left] > arr[mid]) {
                right = mid - 1;
            // Go right
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java <prog> <arg1> [<args>...]");
            System.exit(1);
        }

        int arrSize = args.length;
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; ++i) {
            arr[i] = Integer.parseInt(args[i]);
        }
        //int min = findMin(0, arrSize - 1, arr);
        int min = findMinIterative(0, arrSize - 1, arr);
        System.out.println("min: " + min);
    }
} 
