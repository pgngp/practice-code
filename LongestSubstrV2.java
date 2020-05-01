/* Longest substring that contains 2 unique characters (33):
This is a problem asked by Google.
Given a string, find the longest substring that contains only two unique characters. 
For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/ */

import java.util.*;

public class LongestSubstrV2 {
	public static int getLongestSubstrLen(String s) {
		int i, maxLen = -1, startPos = 0, newStartPos;
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for (i = 0; i < s.length(); ++i) {
			if (m.containsKey(s.charAt(i)) || m.size() < 2) {
				m.put(s.charAt(i), i);
			} else {
				maxLen = Math.max(maxLen, i - startPos);
				// System.out.println("startPos: " + startPos + ", char: " + s.charAt(startPos));
				newStartPos = m.get(s.charAt(startPos)) + 1;
				m.remove(s.charAt(startPos));
				startPos = newStartPos;
				m.put(s.charAt(i), i);
			}
		}
		maxLen = Math.max(maxLen, i - startPos);

		return maxLen;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Usage: java LongestSubstrV2 <str>");
			return;
		}
		
		String s = args[0];
		System.out.println("Input str: " + s);
		
		int strlen = getLongestSubstrLen(s);
		System.out.println("Longest substr len: " + strlen);
	}
}