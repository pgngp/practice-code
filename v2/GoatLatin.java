/* https://leetcode.com/problems/goat-latin/ */
class GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = word.charAt(0);
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                sb.append(word).append("ma");
            } else {
                sb.append(word.substring(1)).append(c).append("ma");
            }
            
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            
            if (i < words.length - 1) {
                sb.append(" ");   
            }
        }
        
        return sb.toString();
    }
}
