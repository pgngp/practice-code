/**
 * https://leetcode.com/problems/utf-8-validation/
 */

public class Utf8Validation {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        if (n == 0) {
            return false;
        }

        int i = 0;
        while (i < n) {
            if ((data[i] >> 7) == 0) {
                // 1-byte
                ++i;
            } else if (
                    i < n - 1 
                    && (data[i] >> 5) == 0x6 
                    && (data[i + 1] >> 6) == 0x2
                ) {
                // 2-byte
                i += 2;
            } else if (
                    i < n - 2 
                    && (data[i] >> 4) == 0xE 
                    && (data[i + 1] >> 6) == 0x2 
                    && (data[i + 2] >> 6) == 0x2
                ) {
                // 3-byte
                i += 3;
            } else if (i < n - 3 
                    && (data[i] >> 3) == 0x1E 
                    && (data[i + 1] >> 6) == 0x2 
                    && (data[i + 2] >> 6) == 0x2 
                    && (data[i + 3] >> 6) == 0x2
                ) {
                // 4-byte
                i += 4;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] data = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            data[i] = Integer.parseInt(args[i]);
        }
        Utf8Validation uv = new Utf8Validation();
        boolean result = uv.validUtf8(data);
        System.out.println("result: " + result);
    }
}
