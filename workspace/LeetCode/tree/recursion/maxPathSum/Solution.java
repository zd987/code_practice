/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:43:28 PM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.maxPathSum;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:43:28 PM
 * Version: 1.0
 */
public class Solution {
	private int re;
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left, right, cur;
        left = helper(root.left);
        right = helper(root.right);
        cur = Math.max(left, right);
        re = Math.max(root.val, re);
        re = Math.max(root.val + cur, re);
        re = Math.max(root.val + left + right, re);
        return cur > 0 ? cur + root.val : root.val;
    }
    public int maxPathSum(TreeNode root) {
        re = root == null ? 0 : root.val;
        helper(root);
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode t = new TreeNode(-3);
		sol.maxPathSum(t);
	}
}