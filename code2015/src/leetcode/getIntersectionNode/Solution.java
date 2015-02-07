package leetcode.getIntersectionNode;

/**
 * Created by zd987 on 2015/1/31.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ca = 0, cb = 0;
        ListNode p = headA;
        while(p != null) {
            ca++;
            p = p.next;
        }
        p = headB;
        while(p != null) {
            cb++;
            p = p.next;
        }
        if(ca > cb) {
            int k = ca - cb;
            for(int i = 0; i < k; i++) {
                headA = headA.next;
            }
        }
        if(cb > ca) {
            int k = cb - ca;
            for(int i = 0; i < k; i++) {
                headB = headB.next;
            }
        }
        while(headA!= null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
