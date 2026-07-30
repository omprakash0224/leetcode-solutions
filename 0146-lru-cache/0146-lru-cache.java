class LRUCache {
// Doubly Linked List Node Structure
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head aur tail node initialize kar rahe hain
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // Node ko dummy head ke aage insert karta hai (MRU Position)
    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Node ko current pointers se disconnect karta hai
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Node ko update hone par MRU position par lane ke liye
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToHead(node); // Access hone par MRU mark karo
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Existing key, update value and move to MRU
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Capacity check
            if (map.size() == capacity) {
                // Least Recently Used node (tail ke piche wali node) evict karo
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }

            // Nayi node create karke insert karo
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNodeToHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */