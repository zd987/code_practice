/**
* Copyright ? Dec 4, 2013 
* LeetCode 6:57:13 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.isSameTree;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 6:57:13 AM
 * Version: 1.0
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}