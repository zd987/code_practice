/**
* Copyright ? Dec 5, 2013 
* LeetCode 11:47:57 PM
* Version 1.0
* All right reserved.
*
*/

package linkedList.addTwoNumbers;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 11:47:57 PM
 * Version: 1.0
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, prev = null, cur;
        int i, j, k = 0, c = 0;
        while(l1 != null && l2 != null){
            k = l1.val + l2.val + c;
            cur = new ListNode(k % 10);
            c = k / 10;
            if(prev == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            k = l1.val + c;
            cur = new ListNode(k % 10);
            c = k / 10;
            if(prev == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            l1 = l1.next;
        }
        while(l2 != null){
            k = l2.val + c;
            cur = new ListNode(k % 10);
            c = k / 10;
            if(prev == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            l2 = l2.next;
        }
        if(c > 0) {
	        cur = new ListNode(c);
	        if(prev == null) {
	            head = cur;
	        } else {
	            prev.next = cur;
	        }
        }
        return head;
    }
}