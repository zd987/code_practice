/**
* Copyright ? Dec 2, 2013 
* LeetCode 8:17:08 PM
* Version 1.0
* All right reserved.
*
*/

package sorting.insertionSortList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 8:17:08 PM
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
	public ListNode insertionSortList(ListNode head) {
        int i, j, k, n = 0; 
        ListNode p, t, prev, cur, prev2;
        p = head;
        t = new ListNode(-1);
        t.next = head;
        while(p != null) {
            p = p.next; 
            ++n;
        }
        for(i = 1; i < n; ++i){
            for(prev2 = t, p = t.next, j = 0; j < i; ++j) {
                prev2 = p;
                p = p.next;
            }
            for(prev = t, cur = t.next , j = 0; j < i; ++j){
                if(cur.val > p.val){
                    prev2.next = p.next;
                    p.next = cur;
                    prev.next = p;
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
        return t.next;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode p = new ListNode(4);
		ListNode head = p;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(1);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		sol.insertionSortList(head);
	}
}