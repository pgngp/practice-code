/* Contains duplicate III (72):
Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/ */

/* Run time: O(nlog(k)) */

import java.util.*;

public class DuplicateFinder {
	public static boolean hasDuplicate(ArrayList<Integer> list, int t, int k) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int i = 0; i < list.size(); ++i) {
			int left = list.get(i) - t;
			int right = list.get(i) + t + 1;
			SortedSet<Integer> sortedSet = treeSet.subSet(left, right);
			if (!sortedSet.isEmpty()) {
				return true;
			}
			
			treeSet.add(list.get(i));
			
			if (i >= k) {
				treeSet.remove(list.get(i - k));
			}
		}
		
		return false;
	}
	
	public static void main (String args[]) {
		if (args.length < 3) {
			System.out.println("Usage: java DuplicateFinder <t> <k> <arr>");
			return;
		}
		
		int t = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < args.length; ++i) {
			list.add(Integer.parseInt(args[i]));
		}
		
		if (hasDuplicate(list, t, k)) {
			System.out.println("has duplicate");
		} else {
			System.out.println("no duplicate");
		}
	}
}