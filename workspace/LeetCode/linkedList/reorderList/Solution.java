/**
* Copyright ? Dec 6, 2013 
* LeetCode 8:49:50 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.reorderList;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 8:49:50 AM
 * Version: 1.0
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h = null, cur = slow.next, tmp;
        slow.next = null;
        while(cur != null){
            tmp = cur.next;
            cur.next = h;
            h = cur;
            cur = tmp;
        }
        while(head != null && h != null){
            cur = head.next;
            tmp = h.next;
            head.next = h;
            h.next = cur;
            head = cur;
            h = tmp;
        }
    }
}