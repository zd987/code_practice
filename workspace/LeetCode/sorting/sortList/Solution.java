/**
* Copyright ? Dec 2, 2013 
* LeetCode 8:47:10 PM
* Version 1.0
* All right reserved.
*
*/

package sorting.sortList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 8:47:10 PM
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
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        for(ListNode p = head; l1 != null || l2 != null; p = p.next){
            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if(v1 < v2){
                p.next = l1; l1 = l1.next;
            } else {
                p.next = l2; l2 = l2.next;
            }
        }
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(h2);
        return merge(l1, l2);
    }
}