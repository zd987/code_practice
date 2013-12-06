/**
* Copyright ? Dec 6, 2013 
* LeetCode 7:26:33 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.swapPairs;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 7:26:33 AM
 * Version: 1.0
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode prev = null, cur = head, next, t;
        while(cur != null && cur.next != null){
            t = cur.next;
            next = t.next;
            t.next = cur;
            cur.next = next;
            if(prev == null) head = t;
            else prev.next = t;
            prev = cur;
            cur = next;
        }
        return head;
    }
}
