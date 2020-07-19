/* https://leetcode.com/problems/task-scheduler/ */
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // if there's no cooling period
        if (n == 0) {
            return tasks.length;
        }
        
        // calculate freq
        int[] freqArr = new int[26];
        for (char c : tasks) {
            freqArr[c - 'A']++;
        }
        
        // sort freq in desc order
        Arrays.sort(freqArr);
        
        // calculate idle time
        int maxFreq = freqArr[25];
        int idleTime = (maxFreq - 1) * n;
        for (int i = 24; i >= 0; i--) {
            if (freqArr[i] == 0) {
                break;
            }
            idleTime -= Math.min(freqArr[i], maxFreq - 1);
        }
        
        return Math.max(idleTime, 0) + tasks.length;
    }
}

/*
calculate frequencies and store in arr
sort arr
idleTime = (maxFreq - 1) * 2
for freq : 1..n-1
    idleTime -= min(freq, maxFreq - 1)
return numTasks + idleTime
*/
