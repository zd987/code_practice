/**
* Copyright ? Dec 4, 2013 
* LeetCode 7:04:42 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.isSymmetric;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 7:04:42 AM
 * Version: 1.0
 */
public class Solution {
    private boolean r(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val && r(left.left, right.right) && r(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return r(root.left, root.right);
    }
}