class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map =  new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insert(node);
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }
}