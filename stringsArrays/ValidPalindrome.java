/**
 * Valid palindrome (157):
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            int l = s.charAt(i);
            int r = s.charAt(j);
            if (!Character.isLetterOrDigit(l)) {
                ++i;
            } else if (!Character.isLetterOrDigit(r)) {
                --j;
            } else if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            } else {
                ++i;
                --j;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java <prog> <str>");
            System.exit(1);
        }

        ValidPalindrome vp = new ValidPalindrome();
        boolean result = vp.isPalindrome(args[0]);
        System.out.println("result: " + result);
    }
}
