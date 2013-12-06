/**
* Copyright ? Dec 6, 2013 
* LeetCode 6:29:16 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.partition;

import common.ListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 6:29:16 AM
 * Version: 1.0
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = null, p1 = null, h2 = null, p2 = null, prev = null, cur = head, tmp;
        while(cur != null){
            if(cur.val < x){
                if(p1 == null){
                    h1 = cur;
                } else {
                    p1.next = cur;
                }
                p1 = cur;
            } else {
                if(p2 == null){
                    h2 = cur;
                } else {
                    p2.next = cur;
                }
                p2 = cur;
            }
            tmp = cur;
            cur = cur.next;
            tmp.next = null;
        }
        if(p1 != null){
            p1.next = h2;
        }
        return h1 != null ?  h1 : h2;
    }
}