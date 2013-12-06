/**
* Copyright ? Dec 6, 2013 
* LeetCode 8:27:36 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.hasCycle;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 8:27:36 AM
 * Version: 1.0
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}