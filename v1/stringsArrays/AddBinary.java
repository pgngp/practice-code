/**
 * Add binary (158):
 * Given two binary strings, return their sum (also a binary string).
 * For example, a = "11", b = "1", the return is "100".
 * http://www.programcreek.com/2014/05/leetcode-add-binary-java/
 */

/*
 * time: O(m + n)
 * space: O(n)
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        if (al < bl) {
            return addBinary(b, a);
        }

        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        int i = al - 1, j = bl - 1;
        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            char c3 = '1';
            if (c1 == '1' && c2 == '1') {
                c3 = carry ? '1' : '0';
                carry = true;
            } else if (c1 == '0' && c2 == '0') {
                c3 = carry ? '1' : '0';
                carry = false;
            } else {
                c3 = carry ? '0' : '1';
            }
            sb.append(c3);
            --i;
            --j;
        }

        while (i >= 0) {
            char c3 = '1';
            if (a.charAt(i) == '1') {
                c3 = carry ? '0' : '1';
            } else {
                c3 = carry ? '1' : '0';
                carry = false;
            }
            sb.append(c3);
            --i;
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
