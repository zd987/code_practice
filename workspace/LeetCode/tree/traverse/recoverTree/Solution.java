/**
* Copyright ? Dec 4, 2013 
* LeetCode 6:47:07 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.recoverTree;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 6:47:07 AM
 * Version: 1.0
 */
public class Solution {
    private TreeNode t1, t2, prev;
    private void r(TreeNode root){
        if(root == null) return;
        r(root.left);
        if(prev != null && prev.val > root.val){
            if(t1 == null) t1 = prev;
            t2 = root;
        }
        prev = root;
        r(root.right);
    }
    public void recoverTree(TreeNode root) {
        t1 = null;
        t2 = null;
        prev = null;
        r(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }
}