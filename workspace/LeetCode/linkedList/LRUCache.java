/**
* Copyright ? Dec 6, 2013 
* LeetCode 9:36:52 PM
* Version 1.0
* All right reserved.
*
*/

package linkedList;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 9:36:52 PM
 * Version: 1.0
 */
class Node{
    int key, val;
    Node prev, next;
    public Node(int key, int val){
    	this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
public class LRUCache {
    Node head, tail;
    HashMap<Integer, Node> m;
    int c;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        c = capacity;
        m = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        Node n = m.get(key);
        if(n == null) return -1;
        if(n != tail) { 
            if(n.prev != null) n.prev.next = n.next;
            else head = n.next;
            if(n.next != null) n.next.prev = n.prev;
            n.prev = tail;
            tail.next = n;
            n.next = null;
            tail = n;
        }
        return n.val;
    }
    
    public void set(int key, int value) {
        Node n = m.get(key);
        if(n == null) {
            n = new Node(key, value);
            m.put(key, n);
            if(c > 0){
                --c;
                if(head == null){
                    head = n;
                    tail = n;
                } else {
                    n.prev = tail;
                    tail.next = n;
                    tail = n;
                }
            } else if(head == tail){
                m.put(head.key, null);
                head = n; 
                tail = n;
            } else {
                m.put(head.key, null);
                head.next.prev = null;
                head = head.next;
                n.prev = tail;
                tail.next = n;
                tail = n;
            }
        } else {
            n.val = value;
            if(n != tail){
                if(n.prev != null) n.prev.next = n.next;
                else head = n.next;
                if(n.next != null) n.next.prev = n.prev;
                n.prev = tail;
                tail.next = n;
                n.next = null;
                tail = n;
            }
        }
    }
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(2,1);
		cache.get(2);
		cache.set(3,2);
		cache.get(2);
	}
}