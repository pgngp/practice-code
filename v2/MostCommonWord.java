class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.split("[ ,]");
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String maxStr = null;
        for (String word : words) {
            word = convert(word);
            if (word.length() == 0 || bannedSet.contains(word)) {
                continue;
            }
            
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (max < map.get(word)) {
                max = map.get(word);
                maxStr = word;
            }
        }
        
        return maxStr;
    }
    
    private String convert(String s) {
        if (s.length() == 0) {
            return "";
        }
        
        int i = 0;
        while (!Character.isAlphabetic(s.charAt(i))) {
            ++i;
        }
        
        int j = s.length() - 1;
        while (!Character.isAlphabetic(s.charAt(j))) {
            --j;
        }
        ++j;
        
        return s.substring(i, j).toLowerCase();
    }
}
