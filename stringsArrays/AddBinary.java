/**
 * Add binary (158):
 * Given two binary strings, return their sum (also a binary string).
 * For example, a = "11", b = "1", the return is "100".
 * http://www.programcreek.com/2014/05/leetcode-add-binary-java/
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder<>();
        boolean carry = false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            char c3 = '0';
            if (c1 == '1' && c2 == '1') {
                if (carry) {
                    sb.append('1');
                } else {
                    sb.append('0');
                    carry = true;
                }
            } else if (c1 == '1' && c2 == '0') {
                if (carry) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else if (c1 == '0' && c2 == '1') {
                if (carry) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else {
                if (carry) {
                    sb.append('1');
                    carry = false;   
                } else {
                    sb.append('0');
                }
            }
            ++i;
            ++j;
        }

        while (i < a.length()) {
            if (a.charAt(i) == '1') {
                if (carry) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else {
                if (carry) {
                    sb.append('1');
                    carry = false;
                } else {
                    sb.append('0');
                }
            }
            ++i;
        }

        while (j < b.length()) {
            if (b.charAt(j) == '1') {
                if (carry) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            } else {
                if (carry) {
                    sb.append('1');
                    carry = false;
                } else {
                    sb.append('0');
                }
            }
            ++j;
        }

        if (carry) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <str1> <str2>");
            System.exit(1);
        }

        AddBinary ab = new AddBinary();
        String result = ab.addBinary(args[0], args[1]);
        System.out.println("result: " + result);
    }
}
