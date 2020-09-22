/* https://leetcode.com/problems/shortest-way-to-form-string/ */
class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int count = 0, t = 0;
        while (t < target.length()) {
            int prevT = t;
            for (int s = 0; s < source.length(); s++) {
                if (t < target.length() && source.charAt(s) == target.charAt(t)) {
                    t++;
                }
            }
            
            if (t == prevT) {
                return -1;
            }
            
            count++;
        }
        
        return count;
    }
}
