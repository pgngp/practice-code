/**
 * Repeated DNA sequences (152):
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * http://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * time: O(n)
 * space: O(n)
 */

public class RepeatedDnaSeq {
    public static List<String> getRepeatedSeqs(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return results;
        }

        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A', 0);
        dnaMap.put('C', 1);
        dnaMap.put('G', 2);
        dnaMap.put('T', 3);

        Map<Integer, Boolean> repMap = new HashMap<>();
        int mask = (1 << 20) - 1;
        int hash = 0;
        for (int i = 0; i < s.length(); ++i) {
            hash = (hash << 2) + dnaMap.get(s.charAt(i));

            if (i >= 9) {
                hash &= mask;

                Boolean isRep = repMap.get(hash);
                if (isRep == null) {
                    repMap.put(hash, false);
                } else if (isRep == false) {
                    repMap.put(hash, true);
                    results.add(s.substring(i - 9, i + 1));
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java <prog> <sequence>");
            System.exit(1);
        }

        String seq = args[0];
        List<String> list = getRepeatedSeqs(seq);
        System.out.println("Repeated strs: ");
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }
}
