/**
 * Kth largest element in an array (102):
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
 */

import java.util.Arrays;
import java.util.LinkedList;

public class KthLargest {
    class MinHeap {
        int maxSize;
        int size;
        int[] arr;
        
        // constructor
        MinHeap(int size) {
            arr = new int[size];
            for (int i = 0; i < size; ++i) {
                arr[i] = Integer.MAX_VALUE;
            }
            maxSize = size;
            this.size = 0;
        }

        // retrun the min without removing it
        int peekMin() {
            return arr[0];
        }

        // return the min and remove it from heap
        int removeMin() {
            int min = arr[0];
            arr[0] = arr[size - 1];
            arr[size - 1] = Integer.MAX_VALUE;
            --size;
            downHeap();
            return min;
        }

        // add num to heap
        void add(int num) {
            if (size == maxSize) {
                if (num <= arr[0]) {
                    return;
                }
                removeMin();
            }
            arr[size] = num;
            ++size;
            upHeap();
        }

        // add all nums to heap
        void addAll(int[] nums) {
            for (int num : nums) {
                if (size == maxSize) {
                    if (num <= arr[0]) {
                        continue;
                    }
                    removeMin();
                }
                arr[size] = num;
                ++size;
                upHeap();
            }
        }

        // Up heap
        void upHeap() {
            int idx = size - 1;
            int parent = (int) Math.floor((idx - 1) / 2);
            while (parent >= 0) {
                if (arr[parent] <= arr[idx]) {
                    return;
                }
                int tmp = arr[parent];
                arr[parent] = arr[idx];
                arr[idx] = tmp;
                idx = parent;
                parent = (int) Math.floor((idx - 1) / 2);
            }
        }

        // Down heap
        void downHeap() {
            int idx = 0;
            int left = 1;
            int right = 2;
            while (right < size) {
                if (arr[idx] <= arr[left] && arr[idx] <= arr[right]) {
                    return;
                } else if (arr[left] <= arr[right]) {
                    int tmp = arr[idx];
                    arr[idx] = arr[left];
                    arr[left] = tmp;
                    idx = left;
                } else {
                    int tmp = arr[idx];
                    arr[idx] = arr[right];
                    arr[right] = tmp;
                    idx = right;
                }
                left = (2 * idx) + 1;
                right = (2 * idx) + 2;
            }

            if (left < size && arr[left] < arr[idx]) {
                int tmp = arr[idx];
                arr[idx] = arr[left];
                arr[left] = tmp;
            }
        }

        // To string
        String toStr() {
            return Arrays.toString(arr);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        heap.addAll(nums);
        return heap.peekMin();
    }

    private void addToList(LinkedList<Integer> ll, int num, int k) {
        if (ll.size() == 0) {
            ll.add(num);
            return;
        } else if (ll.size() == k && num < ll.peek()) {
            return;
        }

        if (ll.size() < k) {
            for (int i = 0; i < ll.size(); ++i) {
                if (num <= ll.get(i)) {
                    ll.add(i, num);
                    return;
                }
            }
            ll.add(num);
        } else {
            ll.pop();
            for (int i = 0; i < ll.size(); ++i) {
                if (num <= ll.get(i)) {
                    ll.add(i, num);
                    return;
                }
            }
            ll.add(num);
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java <prog> <k> <size> <item1> <item2> ...");
            System.exit(1);
        }    

        int k = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(args[i + 2]);
        }
        System.out.println("k: " + k + ", nums: " + Arrays.toString(nums));

        KthLargest l = new KthLargest();
        int result = l.findKthLargest(nums, k);
        System.out.println("result: " + result);
    }
}
