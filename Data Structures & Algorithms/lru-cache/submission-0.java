public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
public class LRUCache {

    private int cap;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(Node node){
        Node curAfterHead = this.head.next;
        this.head.next = node;
        node.prev = head;

        node.next = curAfterHead;
        curAfterHead.prev = node;
    }
    
    public int get(int key) {
        if(!(cache.containsKey(key))) return -1;
        Node node = cache.get(key);
        removeNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            removeNode(cache.get(key));
        }
        Node n = new Node(key, value);
        cache.put(key, n);
        insertAfterHead(n);
        if(cache.size() > this.cap){
            cache.remove(this.tail.prev.key);
            removeNode(this.tail.prev);
        }
    }
}
