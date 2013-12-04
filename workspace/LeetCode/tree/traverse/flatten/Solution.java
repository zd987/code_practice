/**
* Copyright ? Dec 4, 2013 
* LeetCode 7:17:39 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.flatten;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 7:17:39 AM
 * Version: 1.0
 */
public class Solution {
    private TreeNode prev;
    private void r(TreeNode root){
        if(root == null) return;
        TreeNode right = root.right;
        if(prev != null) prev.right = root;
        prev = root;
        r(root.left);
        r(right);
        root.left = null;
    }
    public void flatten(TreeNode root) {
        prev = null;
        r(root);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		sol.flatten(t);
	}
}