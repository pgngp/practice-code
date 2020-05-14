/* https://leetcode.com/problems/lfu-cache/ */

class LFUCache {
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoubleLinkedList> countMap;
    private int capacity;
    private int currentCount;
    private int min;
    
    // constructor
    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        this.capacity = capacity;
        currentCount = 0;
        min = 1;
    }
    
    // return's the given key's value
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        
        Node node = nodeMap.get(key);
        DoubleLinkedList list = countMap.get(node.count);
        list.remove(node);
        if (min == node.count && countMap.get(min).size() == 0) {
            min++;
        }
        
        node.count++;
        DoubleLinkedList list2 = countMap.get(node.count);
        if (list2 == null) {
            list2 = new DoubleLinkedList();
            countMap.put(node.count, list2);
        }
        list2.add(node);
        // System.out.println("get; (" + key + "," + node.val + "); " + "countMap: " + countMap + "\n");
        
        return node.val;
    }
    
    // puts the key-value pair into cache
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        } else if (nodeMap.containsKey(key)) {
            // if key exists in nodemap
            Node node = nodeMap.get(key);
            node.val = value;
            DoubleLinkedList list = countMap.get(node.count);
            list.remove(node);
            if (min == node.count && countMap.get(min).size() == 0) {
                min++;
            }
            node.count++;
            DoubleLinkedList list2 = countMap.getOrDefault(node.count, null);
            if (list2 == null) {
                list2 = new DoubleLinkedList();
                countMap.put(node.count, list2);
            }
            list2.add(node);
            
        } else if (currentCount < capacity) {
            // if current count < capacity
            min = 1;
            DoubleLinkedList list = countMap.getOrDefault(min, null);
            if (list == null) {
                list = new DoubleLinkedList();
                countMap.put(min, list);
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            list.add(node);
            currentCount++;
        } else {
            // if current count == capacity
            DoubleLinkedList list = countMap.get(min);
            Node node = list.removeFromFront();
            nodeMap.remove(node.key);
            min = 1;
            DoubleLinkedList list2 = countMap.get(min);
            Node node2 = new Node(key, value);
            nodeMap.put(key, node2);
            list2.add(node2);
        }
        // System.out.println("put; (" + key + "," + value + "); " + "countMap: " + countMap + "\n");
        // System.out.println("nodemap: " + nodeMap);
    }
    
    // node class
    public class Node {
        private int key;
        private int val;
        private int count;
        private Node prev;
        private Node next;
        
        // constructor
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
            this.prev = null;
            this.next = null;
        }
        
        // return string
        public String toString() {
            return "(" + key + "," + val + "," + count + ")";   
        }
    }
    
    // double-linked-list class
    public class DoubleLinkedList {
        private Node head;
        private Node tail;
        private int size;
        
        // constructor
        public DoubleLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        // add to end of list
        public void add(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }
        
        // remove given node
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }
        
        // remove from front of list
        public Node removeFromFront() {
            Node node = head.next;
            head.next = node.next;
            head.next.prev = head;
            size--;
            
            return node;
        }
        
        // returns size
        public int size() {
            return size;
        }
        
        // returns string
        public String toString() {
            Node node = head.next;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (node != tail) {
                sb.append("(").append(node.key).append(",").append(node.val).append("),");
                node = node.next;
            }
            sb.append("]");
            
            return sb.toString();
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
