/* https://leetcode.com/problems/my-calendar-ii/ */
class MyCalendarTwo {
    private List<int[]> calendar;
    private List<int[]> overlap;
    
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlap = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] event : overlap) {
            if (event[0] < end && start < event[1]) {
                return false;
            }
        }
        
        for (int[] event : calendar) {
            if (event[0] < end && start < event[1]) {
                overlap.add(new int[] {Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }
        calendar.add(new int[] {start, end});
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
