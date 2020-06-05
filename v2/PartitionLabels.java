/* https://leetcode.com/problems/partition-labels/ */
class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        // find last char positions
        int[] lastPos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastPos[S.charAt(i) - 'a'] = i;
        }
        
        // find partitions and add to list
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, lastPos[c - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = ++end;
            }
        }
        
        return result;
    }
}
