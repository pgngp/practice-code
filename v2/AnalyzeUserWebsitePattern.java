/* https://leetcode.com/problems/analyze-user-website-visit-pattern/ */
class AnalyzeUserWebsitePattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // create map for user -> visit (O(n)/O(n))
        Map<String, List<Pair<Integer, String>>> userVisitMap = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            userVisitMap.putIfAbsent(username[i], new ArrayList<>());
            userVisitMap.get(username[i]).add(new Pair<Integer, String>(timestamp[i], website[i]));
        }
        
        // store all 3-seq counts in a map (O(n)/O(n))
        Map<List<String>, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        List<String> maxList = null;
        for (String user : userVisitMap.keySet()) {
            Set<List<String>> set = new HashSet<>();
            List<Pair<Integer, String>> sites = userVisitMap.get(user);
            Collections.sort(sites, (a, b) -> (a.getKey() - b.getKey()));
            
            // create 3-seq
            for (int i = 0; i < sites.size() - 2; i++) {
                for (int j = i + 1; j < sites.size() - 1; j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        List<String> list = new ArrayList<>();
                        list.add(sites.get(i).getValue());
                        list.add(sites.get(j).getValue());
                        list.add(sites.get(k).getValue());
                        if (!set.contains(list)) {
                            set.add(list);
                            int count = countMap.getOrDefault(list, 0) + 1;
                            countMap.put(list, count);
                            if (maxCount < count) {
                                maxCount = count;
                                maxList = list;
                            } else if (maxCount == count) {
                                for (int x = 0; x < list.size(); x++) {
                                    int val = maxList.get(x).compareTo(list.get(x));
                                    if (val < 0) {
                                        break;
                                    } else if (val > 0) {
                                        maxList = list;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return maxList;
    }
}
