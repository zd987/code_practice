/**
* Copyright ? Dec 6, 2013 
* LeetCode 7:40:12 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.reverseKGroup;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 7:40:12 AM
 * Version: 1.0
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
        int i, j;
        ListNode dummy, prev, h, t, p, next, cur, tmp;
        dummy = new ListNode(-1);
        dummy.next = head;
        prev = dummy; next = head;
        while(next != null){
            h = next; t = h;
            for(i = 0; i < k - 1 && t != null; ++i){
                t = t.next;
            }
            if(t == null) break;
            prev.next = t;
            prev = h;
            next = t.next;
            p = next; cur = h;
            while(cur != next){
                tmp = cur.next;
                cur.next = p;
                p = cur;
                cur = tmp;
            }
            prev.next = next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode p = new ListNode(1);
		ListNode q = new ListNode(2);
		p.next = q;
		sol.reverseKGroup(p, 2);
		
	}
}