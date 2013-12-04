/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:29:05 PM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.maxDepth;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:29:05 PM
 * Version: 1.0
 */
public class Solution {
    private int maxH;
    private void dfs(TreeNode root, int curH){
        if(root == null) return;
        if(root.left == null && root.right == null) maxH = Math.max(maxH, curH);
        dfs(root.left, curH + 1);
        dfs(root.right, curH + 1);
    }
    public int maxDepth(TreeNode root) {
        maxH = 0;
        dfs(root, 1);
        return maxH;
    }
}