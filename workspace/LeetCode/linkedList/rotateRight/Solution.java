/**
* Copyright ? Dec 6, 2013 
* LeetCode 6:57:08 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.rotateRight;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 6:57:08 AM
 * Version: 1.0
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return head;
        int i, j, k, N = 0;
        ListNode p, c, tail = head, prev;
        for(p = head; p != null; p = p.next) {
            ++N;
            tail = p;
        }
        n %= N;
        if(n == 0) return head;
        c = head;
        for(i = 0; i < n; ++i){
            c = c.next;
        }
        p = head; 
        while(c.next != null){
            p = p.next;
            c = c.next;
        }
        c.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}