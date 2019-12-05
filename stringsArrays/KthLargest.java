/**
 * Kth largest element in an array (102):
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
 */

/*
 * time: O(n*log(n))
 * space: O(1)
 */

import java.util.Arrays;
import java.util.LinkedList;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }

    void quickSelect(int[] nums, int start, int end, int k) {
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        swap(nums, mid, end);

        int i = start;
        int j = start;
        for (; i < end; ++i) {
            if (j <= i && nums[i] < pivot) {
                ++j;
                continue;
            }

            while (j < end && nums[j] >= pivot) {
                ++j;
            }

            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++j;

                if (j == end) {
                    ++i;
                }
            }

            if (j == end) {
                swap(nums, i, j);
                break;
            }
        }

        if (nums.length - k == i) {
            return;
        } else if (nums.length - k < i) {
            quickSelect(nums, start, i - 1, k);
        } else {
            quickSelect(nums, i + 1, end, k);
        }
    }

    void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    class MinHeap {
        int maxSize;
        int size;
        int[] arr;
        
        // constructor
        MinHeap(int size) {
            arr = new int[size];
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

        // swap
        void swap(int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        // Up heap
        void upHeap() {
            int idx = size - 1;
            int parent = (int) Math.floor((idx - 1) / 2);
            while (parent >= 0) {
                if (arr[parent] <= arr[idx]) {
                    return;
                }
                swap(parent, idx);
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
                    swap(idx, left);
                    idx = left;
                } else {
                    swap(idx, right);
                    idx = right;
                }
                left = (2 * idx) + 1;
                right = left + 1;
            }

            if (left < size && arr[left] < arr[idx]) {
                swap(idx, left);
            }
        }
    }

    public int findKthLargest2(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        heap.addAll(nums);
        return heap.peekMin();
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
