/**
* Copyright ? Dec 6, 2013 
* LeetCode 6:51:00 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.deleteDuplicates;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 6:51:00 AM
 * Version: 1.0
 */
public class Solution2 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode h = null, p = null, prev = head, cur = head.next;
        while(cur != null){
            if(cur.val != prev.val){
                if(prev.next == cur){
                    if(p == null) h = prev;
                    else p.next = prev;
                    p = prev;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        if(prev.next == null){
            if(p == null) h = prev;
            else p.next = prev;
            p = prev;
        }
        if(p != null) p.next = null;
        return h;
    }
}
