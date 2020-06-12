/* https://leetcode.com/problems/add-strings/ */
class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return null;
        } else if (num1 == null) {
            return num2;
        } else if (num2 == null) {
            return num1;
        }
        
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = (int) (num1.charAt(i) - '0') + (int) (num2.charAt(j) - '0') + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        
        while (i >= 0) {
            int sum = (int) (num1.charAt(i) - '0') + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        
        while (j >= 0) {
            int sum = (int) (num2.charAt(j) - '0') + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            j--;
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
