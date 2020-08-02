/* https://leetcode.com/problems/evaluate-division/ */
class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create map (time: O(V + E); space: O(V + E))
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numer = equation.get(0);
            String denom = equation.get(1);
            double val = values[i];
            
            map.putIfAbsent(numer, new HashMap<>());
            map.get(numer).put(denom, val);
            map.putIfAbsent(denom, new HashMap<>());
            map.get(denom).put(numer, 1 / val);
        }
        
        // queries (time: O(Q * (V + E)); space: O(V + E))
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String numer = query.get(0);
            String denom = query.get(1);
            
            if (!map.containsKey(numer) || !map.containsKey(denom)) {  // numer or denom not exists
                result[i] = -1.0;
            } else if (numer.equals(denom)) {  // numer == denom
                result[i] = 1.0;
            } else if (map.get(numer).containsKey(denom)) {  // numer has denom
                result[i] = map.get(numer).get(denom);
            } else {  // everything else
                Set<String> seen = new HashSet<>();
                result[i] = getDenomMultiplier(numer, denom, map, seen, 1.0);
            }
        }
        
        return result;
    }
    
    // dfs (time: O(V + E); space: O(V + E))
    private double getDenomMultiplier(String numer, String denom, Map<String, Map<String, Double>> map, Set<String> seen, double prev) {
        if (numer.equals(denom)) {
            return prev;
        }
        
        seen.add(numer);
        double retVal = -1.0;
        for (Map.Entry<String, Double> entry : map.get(numer).entrySet()) {
            String key = entry.getKey();
            double val = entry.getValue();
            if (seen.contains(key)) {
                continue;
            }
            retVal = getDenomMultiplier(key, denom, map, seen, prev * val);
            if (retVal != -1.0) {
                break;
            }
        }
        seen.remove(numer);
        
        return retVal;
    }
}
