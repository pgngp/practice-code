/* Remove duplicates from sorted array (216):
Given a sorted array, remove the duplicates in place such that each element appear 
only once and return the new length. Do not allocate extra space for another array, 
you must do this in place with constant memory.
For example, given input array A = [1,1,2], your function should return length = 2, 
and A is now [1,2].
http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/ */

import java.util.*;

public class RemoveDuplicates {
	public static int removeDuplicates(ArrayList<Integer> list) {
		int j = 1;
		for (int i = 1; i < list.size(); ++i) {
			if (list.get(i) != list.get(i - 1) && i > j) {
				list.set(j, list.get(i));
				++j;
			} else if (list.get(i) != list.get(i - 1)) {
				++j;
			}
		}
		
		System.out.print("New arr: ");
		for (int i = 0; i < j; ++i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
		
		return j;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Usage: java RemoveDuplicates <arr>");
			return;
		} else if (args.length < 2) {
			System.out.println("Array size needs to be at least 2");
			return;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < args.length; ++i) {
			list.add(Integer.parseInt(args[i]));
		}
		
		System.out.print("Orig arr: ");
		for (int i = 0; i < list.size(); ++i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
		
		int newLen = removeDuplicates(list);
		System.out.println("New len: " + newLen);
	}
}