/**
* Copyright ? Dec 6, 2013 
* LeetCode 7:18:10 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.removeNthFromEnd;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 7:18:10 AM
 * Version: 1.0
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int i, j, k, N = 0;
        ListNode p, q;
        for(p = head; p != null; p = p.next) ++N;
        if(n == N) return head.next;
        for(i = 0, p = head; i < N - n - 1; ++i){ 
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}