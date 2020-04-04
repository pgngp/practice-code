/**
 * Multiply strings (93):
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * http://www.programcreek.com/2014/05/leetcode-multiply-strings-java/
 */

import java.util.*;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        char[] arr = new char[num1.length() + num2.length()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = '0';
        }

        int arrIdx = 0;
        for (int i = num1.length() - 1; i >= 0; --i) {
            int x = num1.charAt(i) - '0';
            arrIdx = arr.length - (num1.length() - i);
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; --j) {
                int y = num2.charAt(j) - '0';
                int z = (x * y) + carry + (arr[arrIdx] - '0');
                carry = z / 10;
                arr[arrIdx] = (char) ('0' + (z % 10));
                --arrIdx;
            }
            
            if (carry > 0) {
                arr[arrIdx] = (char) ('0' + (carry % 10));
                --arrIdx;
            }
        }
        ++arrIdx;
        System.out.println("arrIdx: " + arrIdx);

        return new String(arr, arrIdx, arr.length - arrIdx);
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        String result = ms.multiply(args[0], args[1]);
        System.out.println("result: *" + result + "*");
    }
}
