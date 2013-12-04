/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:06:06 PM
* Version 1.0
* All right reserved.
*
*/

package tree.bst.isValidBST;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:06:06 PM
 * Version: 1.0
 */
public class Solution {
    private boolean r(TreeNode root, int low, int high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return r(root.left, low, root.val) && r(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root) {
        return r(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
