class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        head.prev = null;

        tail.next = null;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node exist = map.get(key);
        if(exist == null) {
            return -1;
        }
        delete(exist);
        insert(exist);
        return exist.value;
    }
    
    public void put(int key, int value) {
        Node exist = map.get(key);
        if(exist != null) {
            delete(exist);
        } 
        if(map.size() == capacity) {
            delete(tail.prev);
        } 
        insert(new Node(key, value));

    }

    private void insert(Node node) {
        map.put(node.key, node);
        
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void delete(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    Node prev;
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }
}
