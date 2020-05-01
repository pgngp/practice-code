/* Substring with concatenation of all words (110):
You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in 
words exactly once and without any intervening characters.
For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9].
http://www.programcreek.com/2014/06/leetcode-substring-with-concatenation-of-all-words-java/ */

import java.util.*;

public class SubstrWithConcatenation {
	public static ArrayList<Integer> getIndices(String s, ArrayList<String> list) {
		if (s == null || s.trim().length() == 0 || list == null || list.size() == 0) {
			return new ArrayList<Integer>();
		}
		
		HashSet<String> words = new HashSet<String>();
		for (int i = 0; i < list.size(); ++i) {
			words.add(list.get(i));
		}
		
		HashSet<String> set = new HashSet<String>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int len = list.get(0).length(), i;
		boolean hasDuplicateWords = false;
		for (i = 0; i < s.length(); i += len) {
			String word = s.substring(i, i + len);
			if (words.contains(word) && !set.contains(word)) {
				set.add(word);
			} else if (set.contains(word)) {
				hasDuplicateWords = true;
			} else {
				if (set.size() == list.size() && !hasDuplicateWords) {
					indices.add(i - (set.size() * len));
				}
				hasDuplicateWords = false;
				set.clear();
			}
		}
		if (set.size() == list.size() && !hasDuplicateWords) {
			indices.add(i - (set.size() * len));
		}
		
		return indices;
	}
	
	public static void main(String args[]) {
		if (args.length < 2) {
			System.out.println("Usage: java SubstrWithConcatenation <str> <arr>");
			return;
		}
		
		String s = args[0];
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < args.length; ++i) {
			list.add(args[i]);
		}
		System.out.println("Str: " + s);
		System.out.print("Array: ");
		for (int i = 0; i < list.size(); ++i) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
		
		ArrayList<Integer> indexList = getIndices(s, list);
		System.out.print("Index list: ");
		for (int i = 0; i < indexList.size(); ++i) {
			System.out.print(indexList.get(i) + ", ");
		}
		System.out.println("");
	}
}