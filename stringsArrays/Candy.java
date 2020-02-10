/**
 * Candy (126):
 * There are N children standing in a line. Each child is assigned a rating value. You are giving candies to these children subjected to the following requirements:
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * http://www.programcreek.com/2014/03/leetcode-candy-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0 || n == 1) {
            return n;
        }

        // Find valleys
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                if (ratings[i] < ratings[i + 1]) {
                    list.add(i);
                }
            } else if (i == n - 1) {
                if (ratings[i - 1] > ratings[i]) {
                    list.add(i);
                }
            } else if (ratings[i - 1] > ratings[i] && ratings[i] <= ratings[i + 1]) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return n;
        }

        // Start from valleys and move left and right
        int[] arr = new int[n];
        for (Integer i : list) {
            arr[i] = 1;
            int num = 2;
            int j = i - 1;
            
            // Go left
            while (j >= 0) {
                if (ratings[j] < ratings[j + 1]) {
                    break;
                } else if (arr[j] != 0) {
                    arr[j] = Math.max(arr[j], num);
                    break;
                } else if (ratings[j] == ratings[j + 1]) {
                    arr[j] = 1;
                    num = 2;
                } else {
                    arr[j] = num;
                    ++num;
                }
                --j;
            }

            // Go right
            num = 2;
            j = i + 1;
            while (j < n) {
                if (ratings[j - 1] > ratings[j]) {
                    break;
                } else if (arr[j] != 0) {
                    arr[j] = Math.max(arr[j], num);
                    break;
                } else if (ratings[j - 1] == ratings[j]) {
                    arr[j] = 1;
                    num = 2;
                } else {
                    arr[j] = num;
                    ++num;
                }
                ++j;
            }
        }

        // Count
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += arr[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ratings = new int[args.length];
        for (int i = 0; i < ratings.length; ++i) {
            ratings[i] = Integer.parseInt(args[i]);
        }
        System.out.println("input: " + Arrays.toString(ratings));

        Candy c = new Candy();
        int result = c.candy(ratings);
        System.out.println("result: " + result);
    }
}
