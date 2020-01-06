/**
 * Zigzag conversion (300):
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the a method convert("PAYPALISHIRING", 3) which returns "PAHNAPLSIIGYIR".
 * http://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java/
 */

/*
 * time: O(n)
 * space: O(n)
 */

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int totalJump = numRows > 2 ? numRows + (numRows - 2) : numRows;
        int to = 0, adjustment = 0;
        char[] arr = new char[s.length()];
        for (int row = 0; row < numRows; ++row) {
            int jump = totalJump - adjustment;
            int from = row;
            while (from < s.length()) {
                arr[to++] = s.charAt(from);
                from += jump;
                jump = adjustment > 0 ? totalJump - jump : jump;
            }
            adjustment = (adjustment + 2 == totalJump) ? 0 : adjustment + 2;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <s> <numrows>");
            System.exit(1);
        }

        String s = args[0];
        int n = Integer.parseInt(args[1]);
        ZigzagConversion zc = new ZigzagConversion();
        String result = zc.convert(s, n);
        System.out.println("result: " + result);
    }
}
