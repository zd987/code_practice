/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:56:58 PM
* Version 1.0
* All right reserved.
*
*/

package sorting.mergeTwoLists;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:56:58 PM
 * Version: 1.0
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, p, q, cur, prev = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(prev == null) head = l1;
                else prev.next = l1;
                prev = l1; l1 = l1.next;
            } else {
                if(prev == null) head = l2;
                else prev.next = l2;
                prev = l2; l2 = l2.next;
            }
        }
        if(l1 != null){
            if(prev == null) head = l1;
            else prev.next = l1;
        }
        if(l2 != null){
            if(prev == null) head = l2;
            else prev.next = l2;
        }
        return head;
    }
}