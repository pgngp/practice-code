/* https://leetcode.com/problems/add-binary/ */
class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        
        boolean carry = false;
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        while (j >= 0) {
            char ac = a.charAt(i), bc = b.charAt(j);
            if (ac == '1' && bc == '1') {
                if (carry) {
                    result.append("1");
                } else {
                    result.append("0");
                    carry = true;
                }
            } else if (ac == '1' || bc == '1') {
                if (carry) {
                    result.append("0");
                } else {
                    result.append("1");
                }
            } else {
                if (carry) {
                    result.append("1");
                    carry = false;
                } else {
                    result.append("0");
                }
            }
            i--;
            j--;
        }
        
        while (i >= 0) {
            char ac = a.charAt(i);
            if (ac == '1') {
                if (carry) {
                    result.append("0");
                } else {
                    result.append("1");
                }
            } else {
                if (carry) {
                    result.append("1");
                    carry = false;
                } else {
                    result.append("0");
                }
            }
            i--;
        }
        
        if (carry) {
            result.append("1");
        }
        
        return result.reverse().toString();
    }
}
