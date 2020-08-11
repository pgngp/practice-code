/* https://leetcode.com/problems/group-shifted-strings/ */
class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append(((s.charAt(i) - s.charAt(i - 1)) + 26) % 26);
            sb.append(",");
        }
        
        return sb.toString();
    }
}
