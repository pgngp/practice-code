/**
 * Multiply strings (93):
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * http://www.programcreek.com/2014/05/leetcode-multiply-strings-java/
 */

/**
 * time: O(m * n) where m is length of str1 and n is length of str2
 * space: O(m + n)
 */

public class MultiplyStrings {
    public static String multiply(String str1, String str2) {
        if (str1 == null || str1 == "" || str2 == null || str2 == "") {
            return null;
        }

        char[] result = new char[str1.length() + str2.length()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = '0';
        }

        if ((str1.charAt(0) == '-' && str2.charAt(0) != '-') || 
                (str1.charAt(0) != '-' && str2.charAt(0) == '-')) {
            result[0] = '-';
        }
        
        int carryOver = 0;
        int index = str2.length() - 1;
        for (int i = str2.length() - 1; i >= 0; --i) {
            if (i == 0 && str2.charAt(i) == '-') {
                break;
            }

            int num2 = str2.charAt(i) - '0';
            index = result.length - (str2.length() - i);
            for (int j = str1.length() - 1; j >= 0; --j) {
                if (j == 0 && str1.charAt(j) == '-') {
                    break;
                }

                int num1 = str1.charAt(j) - '0';
                int tmp = (num2 * num1) + (result[index] - '0') + carryOver;
                result[index] = (char) ('0' + (tmp % 10));
                --index;
                carryOver = tmp / 10;
            }
        }

        if (carryOver > 0) {
            result[index] = (char) ('0' + carryOver);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java <prog> <arg1>");
            System.exit(1);
        }

        String result = multiply(args[0], args[1]);
        System.out.println(String.format("%s x %s = %s", args[0], args[1], result));
    }
}

