/**
 * Implement strStr() (184):
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
 */

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int hIdx = 0;
        int nIdx = 0;
        while (hIdx < haystack.length() && nIdx < needle.length()) {
            if (haystack.charAt(hIdx) != needle.charAt(nIdx)) {
                hIdx = hIdx - nIdx + 1;
                nIdx = 0;
            } else {
                ++nIdx;
                ++hIdx;
            }
        }

        return (nIdx == needle.length()) ? hIdx - needle.length() : -1;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java <prog> <haystack> <needle>");
            System.exit(1);
        }

        StrStr s = new StrStr();
        int result = s.strStr(args[0], args[1]);
        System.out.println("result: " + result);
    }
}
