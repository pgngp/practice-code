/* https://leetcode.com/problems/valid-number/ */
class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        s = s.trim();
        if (s.length() == 0 || (s.length() == 1 && s.charAt(0) == '.')) {
            return false;
        }
        
        int n = s.length();
        boolean decimalSeen = false;
        boolean lastCharWasE = false;
        boolean eSeen = false;
        boolean digitSeen = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // System.out.println("c: " + c);
            if (c == '+' || c == '-') {
                if (i > 0 && !lastCharWasE) {
                    return false;
                } else if (lastCharWasE) {
                    lastCharWasE = false;
                }
            } else if (c >= '0' && c <= '9') {
                lastCharWasE = false;
                digitSeen = true;
            } else if (c == '.') {
                if (eSeen || decimalSeen) {
                    return false;
                }
                decimalSeen = true;
            } else if (c == 'e') {
                if (!digitSeen || eSeen || i == 0) {
                    return false;
                }
                lastCharWasE = true;
                eSeen = true;
            } else {
                return false;
            }
        }
        
        if (!digitSeen || lastCharWasE || s.charAt(n - 1) == '-' || s.charAt(n - 1) == '+') {
            return false;
        }
        
        return true;
    }
    
    // public boolean isNumber(String s) {
    //     String regex = "^[+-]?(([0-9]+)|(\\.[0-9]+)|([0-9]+\\.)|([0-9]+\\.[0-9]+))(e[+-]?[0-9]+)?$";
    //     return s.trim().matches(regex);
    // }
}
