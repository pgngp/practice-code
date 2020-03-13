/**
 * Repeated DNA sequences (152):
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * http://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/
 */

import java.util.*;

public class RepeatedDnaSeq {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }

        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A', 0b00);
        dnaMap.put('C', 0b01);
        dnaMap.put('G', 0b10);
        dnaMap.put('T', 0b11);

        Map<Integer, Boolean> map = new HashMap<>();
        int num = 0;
        int i = 0;
        while (i < 10) {
            num |= dnaMap.get(s.charAt(i));
            num <<= 2;
            ++i;
        }
        num >>= 2;
        map.put(num, false);

        int mask = 0b11111111111111111111;
        while (i < s.length()) {
            num <<= 2;
            num &= mask;
            num |= dnaMap.get(s.charAt(i));
            if (!map.containsKey(num)) {
                map.put(num, false);
            } else if (!map.get(num)) {
                result.add(convertNumToStr(num));
                map.put(num, true);
            }
            ++i;
        }

        return result;
    }

    private String convertNumToStr(int num) {
        char[] arr = new char[10];
        int i = 9;
        while (i >= 0) {
            if ((num & 3) == 3) {
                arr[i] = 'T';
            } else if ((num & 2) == 2) {
                arr[i] = 'G';
            } else if ((num & 1) == 1) {
                arr[i] = 'C';
            } else {
                arr[i] = 'A';
            }
            --i;
            num >>= 2;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        RepeatedDnaSeq rds = new RepeatedDnaSeq();
        List<String> result = rds.findRepeatedDnaSequences(args[0]);
        System.out.println("result: " + result);
    }
}
