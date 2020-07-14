/* https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/ */
class LongestSubstrWithAtMostKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        
        int i = 0, j = 0, count = 0, max = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            if (count > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    count--;
                }
                i++;
            } else if (map.containsKey(s.charAt(j))) {
                max = Math.max(max, j - i);
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                if (map.get(s.charAt(j)) == 1) {
                    count++;
                }
                j++;
            } else {
                max = Math.max(max, j - i);
                map.put(s.charAt(j), 1);
                count++;
                j++;
            }
        }
        
        while (count > k) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if (map.get(s.charAt(i)) == 0) {
                count--;
            }
            i++;
        }
        max = Math.max(max, j - i);
        
        return max;
    }
}

/*
use 2 pointers: i and j
use a hashmap
use a count var
max = 0
while j < n
    if count > k
        map[s[i]]--
        if map[s[i]] == 0
            count--
        i++
    else if map contains s[j]
        max = max(max, j - i + 1)
        map[s[j]]++
        if map[s[j]] == 1
            count++
        j++
    else
        max = max(max, j - i + 1)
        map[s[j]] = 1
        count++
        j++
while count > k
    map[s[i]]--
    if map[s[i]] == 0
        count--
    i++
max = max(max, j - i)

return max
    
*/
