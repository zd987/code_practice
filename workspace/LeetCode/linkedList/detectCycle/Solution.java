/**
* Copyright ? Dec 6, 2013 
* LeetCode 8:37:20 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.detectCycle;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 8:37:20 AM
 * Version: 1.0
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}