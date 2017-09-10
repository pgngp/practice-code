/* Remove duplicates from sorted array II (117):
Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, and A is now [1,1,2,2,3].
http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/ */

import java.util.*;

public class RemoveDuplicatesV2 {
	public static int getNewLen(ArrayList<Integer> list) {
		int j = 1, count = 0;
		for (int i = 1; i < list.size(); ++i) {
			if (list.get(i) > list.get(i - 1) && j < i) {
				list.set(j, list.get(i));
				++j;
				count = 0;
			} else if (list.get(i) > list.get(i - 1)) {
				++j;
				count = 0;
			} else if (count == 0 && j < i) {
				list.set(j, list.get(i));
				++j;
				++count;
			} else if (count == 0) {
				++j;
				++count;
			}
		}
		
		System.out.print("New arr: ");
		for (int i = 0; i < j; ++i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(" ");
		
		return j;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Usage: java RemoveDuplicatesV2 <arr>");
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
		
		int newLen = getNewLen(list);
		System.out.println("New len: " + newLen);
	}
}