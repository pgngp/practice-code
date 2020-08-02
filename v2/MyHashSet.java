/* https://leetcode.com/problems/design-hashset/ */
class MyHashSet {
    private static final int SIZE = 5003;
    private List<List<Integer>> list;

    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int idx = key % SIZE;
        if (!contains(key)) {
            list.get(idx).add(key);   
        }
    }
    
    public void remove(int key) {
        int idx = key % SIZE;
        List<Integer> sublist = list.get(idx);
        for (int i = 0; i < sublist.size(); i++) {
            if (sublist.get(i) == key) {
                sublist.set(i, sublist.get(sublist.size() - 1));
                sublist.remove(sublist.size() - 1);
                break;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = key % SIZE;
        List<Integer> sublist = list.get(idx);
        for (int i = 0; i < sublist.size(); i++) {
            if (sublist.get(i) == key) {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
