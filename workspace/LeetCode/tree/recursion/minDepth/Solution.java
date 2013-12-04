/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:23:45 PM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.minDepth;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:23:45 PM
 * Version: 1.0
 */
public class Solution {
    private int minH;
    private void dfs(TreeNode root, int curH){
        if(root == null) return;
        if(curH > minH) return;
        if(root.left == null && root.right == null) minH = Math.min(minH, curH);
        dfs(root.left, curH + 1);
        dfs(root.right, curH + 1);
    }
    public int minDepth(TreeNode root) {
        minH = Integer.MAX_VALUE;
        if(root == null) return 0;
        dfs(root, 1);
        return minH;
    }
}