/**
 * String to int (atoi) (214):
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 */

/*
 * time: O(n)
 * space: O(1)
 */

public class StringToInt {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            ++i;
        }

        boolean isNeg = false;
        if (i >= str.length()) {
            return 0;
        } else if (str.charAt(i) == '-') {
            isNeg = true;
            ++i;
        } else if (str.charAt(i) == '+') {
            ++i;
        }

        if (i < str.length() && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
            return 0;
        }

        long result = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = (result * 10) + (str.charAt(i) - '0');
            if (result > Integer.MAX_VALUE) {
                break;
            }
            ++i;
        }
        if (isNeg) {
            result = 0 - result;
        }
        result = Math.max(result, Integer.MIN_VALUE);
        result = Math.min(result, Integer.MAX_VALUE);

        return (int) result;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("java <prog> <str>");
            System.exit(1);
        }

        StringToInt stoi = new StringToInt();
        int result = stoi.myAtoi(args[0]);
        System.out.println("result: " + result);
    }
}
