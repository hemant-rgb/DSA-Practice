class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }

    }

    Node head;
    Node tail;
    HashMap<Integer,Node>map;
    int capacity;


    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map = new HashMap<>();
        this.capacity = capacity;
        
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        Node first = head.next;
        head.next=node;
        node.prev=head;
        first.prev = node;
        node.next=first;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.value = value;
            insert(node);
            return;
        }

        if(map.size() == capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */