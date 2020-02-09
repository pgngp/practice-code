/**
 * Candy (126):
 * There are N children standing in a line. Each child is assigned a rating value. You are giving candies to these children subjected to the following requirements:
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * http://www.programcreek.com/2014/03/leetcode-candy-java/
 */

import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0 || n == 1) {
            return n;
        }

        int[] arr = new int[n];
        arr[0] = 0;
        if (ratings[1] > ratings[0]) {
            arr[1] = 1;
        } else if (ratings[1] == ratings[0]) {
            arr[1] = 0;
        } else {
            arr[0] = 1;
            arr[1] = 0;
        }

        int min = 0;
        int start = 0;
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                arr[i] = 0;
            } else {
                if (i == n - 1) {
                    arr[i] = 0;
                } else if (ratings[i + 1] < ratings[i]) {
                    arr[i] = 1;
                } else {
                //if (ratings[i - 1] >= ratings[i - 2]) {
                    arr[i] = arr[i - 1];
                    arr[i - 1] += 1;
                    int diff = 1 - min;
                    for (int j = start; j < i - 1; ++j) {
                        arr[j] += diff;
                        count += arr[j];
                    }
                    start = i - 1;
                }
            }
            min = Math.min(min, arr[i]);
        }

        int diff = 1 - min;
        for (int i = start; i < n; ++i) {
            arr[i] += diff;
            count += arr[i];
        }
        System.out.println("arr: " + Arrays.toString(arr));

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
