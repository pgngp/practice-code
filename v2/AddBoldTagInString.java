/* https://leetcode.com/problems/add-bold-tag-in-string/ */
class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        // check input
        if (s == null || s.length() == 0) {
            return "";
        } else if (dict == null || dict.length == 0) {
            return s;
        }
        
        // mark chars that should be in bold
        int n = s.length();
        boolean[] bold = new boolean[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        
        // add bold tag
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
            } else {
                int j = i;
                while (j < n && bold[j]) {
                    j++;
                }
                sb.append("<b>");
                sb.append(s.substring(i, j));
                sb.append("</b>");
                i = j - 1;
            }
        }
        
        return sb.toString();
    }
}
