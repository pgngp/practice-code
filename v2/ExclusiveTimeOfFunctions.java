/* https://leetcode.com/problems/exclusive-time-of-functions/ */
class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0) {
            return new int[0];
        }
        
        int[] resultArr = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        String[] items = logs.get(0).split(":");
        stack.offerFirst(Integer.parseInt(items[0]));
        int prev = Integer.parseInt(items[2]);
        
        for (int i = 1; i < logs.size(); i++) {
            items = logs.get(i).split(":");
            int id = Integer.parseInt(items[0]);
            String type = items[1];
            int pos = Integer.parseInt(items[2]);
            
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    resultArr[stack.peekFirst()] += pos - prev;
                }
                stack.offerFirst(id);
                prev = pos;
            } else {
                resultArr[stack.peekFirst()] += pos - prev + 1;
                stack.pollFirst();
                prev = pos + 1;
            }
        }
        
        return resultArr;
    }
}

/*
create a stack
create an int array
stack.offer(entry0)
prev = entry0's time
while entry = 1...
    if this is start entry
        if stack is not empty
            arr[stack[top]] += entry's time - prev
        stack.offer(entry)
    else
        arr[stack[top]] += entry's time - prev
        stack.pop()
    prev = entry's time

return arr

*/
