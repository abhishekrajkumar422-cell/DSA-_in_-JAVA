import java.util.HashMap;

class LRUCache {

    // Doubly Linked List Node Definition
    class Node {
        int key, val;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private HashMap<Integer, Node> m = new HashMap<>();
    private int limit;

    // Constructor
    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // Helper method to add a node right after the dummy head
    private void addNode(Node newNode) {
        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;
    }

    // Helper method to delete a node from the doubly linked list
    private void delNode(Node oldNode) {
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    // Get value corresponding to the key if present, and update access state
    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1;
        }

        Node ansNode = m.get(key);
        int ans = ansNode.val;

        m.remove(key);
        delNode(ansNode);

        addNode(ansNode);
        m.put(key, ansNode);

        return ans;
    }

    // Put key-value pair into the cache
    public void put(int key, int val) {
        if (m.containsKey(key)) {
            Node oldNode = m.get(key);
            delNode(oldNode);
            m.remove(key);
        }

        if (m.size() == limit) {
            // Delete least recently used (LRU) data right before the dummy tail
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }

        Node newNode = new Node(key, val);
        addNode(newNode);
        m.put(key, newNode);
    }
}