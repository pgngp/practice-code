/* https://leetcode.com/problems/decode-string/ */
class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        } 
        
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        
        int i = 0, count = 0;
        String result = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = (count * 10) + (c - '0');
            } else if (c == '[') {
                countStack.offerFirst(count);
                strStack.offerFirst(result);
                result = "";
                count = 0;
            } else if (c == ']') {
                int rep = countStack.pollFirst();
                StringBuilder sb = new StringBuilder(strStack.pollFirst());
                for (int j = 0; j < rep; j++) {
                    sb.append(result);
                }
                result = sb.toString();
            } else {
                result += c;
            }
            i++;
        }
        
        return result;
    }
}
