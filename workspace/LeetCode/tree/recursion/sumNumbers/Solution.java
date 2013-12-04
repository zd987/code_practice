/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:53:52 PM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.sumNumbers;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:53:52 PM
 * Version: 1.0
 */
public class Solution {
    private int re;
    private void dfs(TreeNode root, int cur){
        int k = cur * 10 + root.val;
        if(root.left == null && root.right == null){
            re += k;
            return;
        }
        if(root.left != null) dfs(root.left, k);
        if(root.right != null) dfs(root.right, k);
    }
    public int sumNumbers(TreeNode root) {
        re = 0;
        if(root != null) dfs(root, 0);
        return re;
    }
}