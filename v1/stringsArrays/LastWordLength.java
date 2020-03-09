/**
 * Length of last word (160):
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. If the last word does not exist, return 0.
 * http://www.programcreek.com/2014/05/leetcode-length-of-last-word-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }

        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            ++count;
            --i;
        }

        return count;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <s>");
            System.exit(1);
        }

        LastWordLength lwl = new LastWordLength();
        int result = lwl.lengthOfLastWord(args[0]);
        System.out.println("result: " + result);
    }
}
