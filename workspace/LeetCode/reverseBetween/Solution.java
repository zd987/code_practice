/**
* Copyright ? Nov 26, 2013 
* LeetCode 8:58:20 PM
* Version 1.0
* All right reserved.
*
*/

package reverseBetween;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 26, 2013 8:58:20 PM
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
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(m == n) return head;
        ListNode prev, post, cur, tmp, first, p;
        prev = null; cur = head;
        int i, j, k;
        for(i = 1; i < m; ++i){
            prev = cur;
            cur = cur.next;
        }
        first = cur;
        for(i = m; i < n; ++i){
            cur = cur.next;
        }
        post = cur.next;
        tmp = first; cur = first.next;
        while(cur.next != post){
            p = cur.next;
            cur.next = tmp;
            tmp = cur;
            cur = p;
        }
        cur.next = tmp;
        if(prev != null){
            prev.next = cur;
        } else {
            head = cur;
        }
        first.next = post;
        return head;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(m == n) return head;
        ListNode prev, post, cur, tmp, first, p;
        prev = null; cur = head;
        int i, j, k;
        for(i = 1; i < m; ++i){
            prev = cur;
            cur = cur.next;
        }
        first = cur;
        p = first; cur = cur.next;
        for(i = m; i < n; ++i){
            tmp = cur.next;
            cur.next = p;
            p = cur;
            cur = tmp;
        }
        first.next = cur;
        if(prev != null){
            prev.next = p;
        } else {
            head = p;
        }
        return head;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	ListNode p1 = new ListNode(1);
    	ListNode p2 = new ListNode(2);
    	ListNode p3 = new ListNode(3);
    	p1.next = p2;
    	p2.next = p3;
    	sol.reverseBetween(p1, 1, 3);
    }
}