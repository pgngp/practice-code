/**
 * Letter combinations of a phone number (110):
 * Given a digit string, return all possible letter combinations that the number could represent. (Check out your cellphone to see the mappings) Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * http://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/
 */

/**
 * time: O(product of number of elements representing each digit)
 * space: O(product of number of elements representing each digit)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String s = map.get(digits.charAt(0));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            result.add(Character.toString(s.charAt(i)));
        }
        
        return helper(result, map, digits, 1);
    }

    private List<String> helper(List<String> result, Map<Character, String> map, String digits, int currDigitIdx) {
        if (currDigitIdx >= digits.length()) {
            return result;
        }

        List<String> newList = new ArrayList<>();
        String s = map.get(digits.charAt(currDigitIdx));
        int resultSize = result.size();
        for (int i = 0; i < result.size(); ++i) {
            String s2 = result.get(i);
            for (int j = 0; j < s.length(); ++j) {
                newList.add(s2 + s.charAt(j));
            }
        }

        return helper(newList, map, digits, currDigitIdx + 1);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java <prog> <digit string>");
            System.exit(1);
        }

        String digits = args[0];
        PhoneNumber pn = new PhoneNumber();
        List<String> list = pn.letterCombinations(digits);
        System.out.printf("Output (%d):%n", list.size());
        System.out.println(list);
    }
}
