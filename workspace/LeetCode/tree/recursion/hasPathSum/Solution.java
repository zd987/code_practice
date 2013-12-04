/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:32:47 PM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.hasPathSum;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:32:47 PM
 * Version: 1.0
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        if(root.left != null && hasPathSum(root.left, sum - root.val)) return true;
        if(root.right != null && hasPathSum(root.right, sum - root.val)) return true;
        return false;
    }
}