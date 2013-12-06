/**
* Copyright ? Dec 6, 2013 
* LeetCode 6:47:23 AM
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
 * Create Time: Dec 6, 2013 6:47:23 AM
 * Version: 1.0
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode p = head, c = head.next;
        while(c != null){
            if(c.val != p.val){
                p.next = c;
                p = c;
            }
            c = c.next;
        }
        p.next = null;
        return head;
        
    }
}