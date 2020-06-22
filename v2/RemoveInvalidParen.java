class RemoveInvalidParen {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        
        helper(s, result, 0, 0, '(', ')');
        
        return result;
    }
    
    private void helper(String s, List<String> result, int iStart, int jStart, char openParen, char closeParen) {
        int numOpen = 0, numClose = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) {
                numOpen++;
            } else if (s.charAt(i) == closeParen) {
                numClose++;
            }
            
            if (numOpen < numClose) {
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == closeParen && (j == 0 || s.charAt(j - 1) != closeParen)) {
                        helper(s.substring(0, j) + s.substring(j + 1, s.length()), result, i, j, openParen, closeParen);
                    }
                }
                
                return;
            }
        }
        
        String reverse = new StringBuilder(s).reverse().toString();
        if (openParen == '(') {
            helper(reverse, result, 0, 0, ')', '(');
        } else {
            result.add(reverse);
        }
    }
}
