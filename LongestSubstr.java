/* Longest substring without repeating characters (257):
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/ */

import java.util.*;

public class LongestSubstr {
	public static int getLongestSubstrLen(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int substrLen = 0, maxLen = -1;
		for (int i = 0; i < s.length(); ++i) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
				++substrLen;
			} else {
				maxLen = Math.max(maxLen, substrLen);
				substrLen = i - map.get(s.charAt(i));
				map.replace(s.charAt(i), i);
			}
		}
		maxLen = Math.max(maxLen, substrLen);
		
		return maxLen;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("Usage: java LongestSubstr <str>");
			return;
		}
		
		String s = args[0];
		System.out.println("Input str: " + s);
		
		int len = getLongestSubstrLen(s);
		System.out.println("Longest substr len: " + len);
	}
}