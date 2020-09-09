/* https://leetcode.com/problems/longest-happy-string/ */
class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        if (a > 0) {
            pq.offer(new Pair<>('a', a));   
        }
        
        if (b > 0) {
            pq.offer(new Pair<>('b', b));   
        }
        
        if (c > 0) {
            pq.offer(new Pair<>('c', c));   
        }
        
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Pair<Character, Integer> pair1 = pq.poll();
            char pair1Char = pair1.getKey();
            int pair1Count = pair1.getValue();
            
            Pair<Character, Integer> pair2 = pq.poll();
            char pair2Char = pair2.getKey();
            int pair2Count = pair2.getValue();
            
            if (pair1Count > 1) {
                sb.append(pair1Char).append(pair1Char);
                pair1Count -= 2;
            } else {
                sb.append(pair1Char);
                pair1Count--;
            }
            
            if (pair2Count > 1) {
                if (pair1Count <= pair2Count) {
                    sb.append(pair2Char).append(pair2Char);
                    pair2Count -= 2;
                } else {
                    sb.append(pair2Char);
                    pair2Count--;
                }
            } else {
                sb.append(pair2Char);
                pair2Count--;
            }
            
            if (pair1Count > 0) {
                pq.offer(new Pair<>(pair1Char, pair1Count));
            }
            
            if (pair2Count > 0) {
                pq.offer(new Pair<>(pair2Char, pair2Count));
            }
        }
        
        if (pq.size() == 1) {
            Pair<Character, Integer> pair = pq.poll();
            if (pair.getValue() >= 2) {
                sb.append(pair.getKey()).append(pair.getKey());
            } else {
                sb.append(pair.getKey());
            }
        }
        
        return sb.toString();
    }
}
