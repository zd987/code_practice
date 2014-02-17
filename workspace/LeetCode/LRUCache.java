import java.util.HashMap;

class Node{
    int val, key;
    Node prev, next;
    public Node(int key, int val){
    	this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
    @Override
    public String toString(){
    	return key + ":" + val;
    }
}
public class LRUCache {
    Node head, tail;
    int size, capacity;
    HashMap<Integer, Node> m;
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = null;
        tail = null;
        m = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        Node n = m.get(key);
        if(n == null) return -1;
        if(n != head){
            n.prev.next = n.next;
            if(n != tail) n.next.prev = n.prev;
            else tail = tail.prev;
            head.prev = n;
            n.prev = null;
            n.next = head;
            head = n;
        }
        return n.val;
    }
    
    public void set(int key, int value) {
        Node n = m.get(key);
        if(n != null){
            if(n != head){
                n.prev.next = n.next;
                if(n != tail) n.next.prev = n.prev;
                else tail = tail.prev;
                head.prev = n;
                n.prev = null;
                n.next = head;
                head = n; 
            }
            n.val = value;
        } else {
            n = new Node(key, value);
            m.put(key, n);
            if(size < capacity){
                if(size == 0){
                    head = n;
                    tail = n;
                } else {
                    head.prev = n;
                    n.next = head;
                    head = n;
                }
                ++size;
            } else {
            	m.remove(tail.key);
                if(capacity == 1){
                    head = n;
                    tail = n;
                } else {
                    tail = tail.prev;
                    tail.next.prev = null;
                    tail.next = null;
                    head.prev = n;
                    n.next = head;
                    head = n;
                }
            }
        }
    }
    public static void main(String[] args) {
		LRUCache l = new LRUCache(2);
		l.set(2, 1);
		l.set(1, 1);
		l.set(2, 3);
		l.set(4, 1);
		l.get(1);
		l.get(2);
	}
}