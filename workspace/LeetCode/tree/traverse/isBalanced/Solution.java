/**
* Copyright ? Dec 4, 2013 
* LeetCode 7:09:33 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.isBalanced;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 7:09:33 AM
 * Version: 1.0
 */
public class Solution {
    private int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left, right;
        left = height(root.left);
        right = height(root.right);
        if(Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}