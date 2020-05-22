/* https://leetcode.com/problems/sort-characters-by-frequency/ */
class SortCharsByFreq {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        } 
        
        // create map to keep counts
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int maxFreq = Collections.max(countMap.values());
        
        // create buckets
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }
        
        // put chars from map to buckets
        for (char c : countMap.keySet()) {
            buckets.get(countMap.get(c)).add(c);
        }
        
        // create string from the buckets
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i > 0; i--) {
            for (char c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}
