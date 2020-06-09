/* https://leetcode.com/problems/is-subsequence/ */
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        
        int lastPos = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return false;
            }
            
            List<Integer> posList = map.get(s.charAt(i));
            int left = 0, right = posList.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (posList.get(mid) <= lastPos) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            if (posList.get(left) <= lastPos) {
                return false;
            }
            
            lastPos = posList.get(left);
        }
        
        return true;
    }
}
