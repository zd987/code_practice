/**
* Copyright ? Dec 4, 2013 
* LeetCode 7:40:27 AM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.connect;

import common.TreeLinkNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 7:40:27 AM
 * Version: 1.0
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        
    }
}
