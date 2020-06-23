/* https://leetcode.com/problems/break-a-palindrome/submissions/ */
class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        
        char[] arr = palindrome.toCharArray();
        boolean updated = false;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                updated = true;
                break;
            }
        }
        
        if (!updated) {
            arr[n - 1] = 'b';
        }
        
        return String.valueOf(arr);
    }
}
