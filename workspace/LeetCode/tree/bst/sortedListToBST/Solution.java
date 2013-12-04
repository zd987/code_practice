/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:15:27 PM
* Version 1.0
* All right reserved.
*
*/

package tree.bst.sortedListToBST;

import common.ListNode;
import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:15:27 PM
 * Version: 1.0
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode prev, slow, fast;
        prev = null; slow = head; fast = head;
        while(fast != null && fast.next != null) {
            prev = slow; 
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev == null) {
            return new TreeNode(head.val);
        }
        prev.next = null;
        TreeNode re = new TreeNode(slow.val);
        re.left = sortedListToBST(head);
        re.right = sortedListToBST(slow.next);
        return re;
    }
}