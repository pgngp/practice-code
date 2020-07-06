/* https://leetcode.com/problems/longest-string-chain/ */
class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());  // time: O(n logn)
        
        Map<String, Integer> distanceMap = new HashMap<>();  // space: O(n)
        int result = 0;
        for (String word : words) {  // time: O(n * m^2)
            if (word.length() == 1) {
                distanceMap.put(word, 1);
                continue;
            }
            
            int len = word.length();
            int currMax = 0;
            for (int i = 0; i < len; i++) {  // time: O(m^2)
                String parent = i == len - 1 ? word.substring(0, i) : word.substring(0, i) + word.substring(i + 1);
                currMax = Math.max(currMax, distanceMap.getOrDefault(parent, 0) + 1);
            }
            distanceMap.put(word, currMax);
            result = Math.max(result, currMax);
        }
        
        return result;
    }
}
