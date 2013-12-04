/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:22:06 AM
* Version 1.0
* All right reserved.
*
*/

package tree.construct.buildTree;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:22:06 AM
 * Version: 1.0
 */
public class Solution2 {
    private TreeNode r(int[] inorder, int[] postorder, int in_start, int in_end, int pos_start, int pos_end){
        if(in_start > in_end) return null;
        TreeNode re = new TreeNode(postorder[pos_end]);
        if(in_start == in_end) return re;
        int i, j, k;
        for(i = in_start; i <= in_end; ++i){
            if(inorder[i] == postorder[pos_end]) break;
        }
        k = i - in_start;
        if(k > 0) re.left = r(inorder, postorder, in_start, i - 1, pos_start, pos_start + k - 1);
        if(i < in_end) re.right = r(inorder, postorder, i + 1, in_end, pos_start + k, pos_end - 1);
        return re;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return r(inorder, postorder, 0, n - 1, 0, n - 1);
    }
}
