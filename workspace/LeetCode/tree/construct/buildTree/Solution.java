/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:29:31 AM
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
 * Create Time: Dec 4, 2013 8:29:31 AM
 * Version: 1.0
 */
public class Solution {
    private TreeNode r(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end){
        if(pre_start > pre_end) return null;
        TreeNode re = new TreeNode(preorder[pre_start]);
        int i, j, k;
        for(i = in_start; i <= in_end; ++i){
            if(inorder[i] == preorder[pre_start]) 
                break;
        }
        k = i - in_start;
        if(k > 0) re.left = r(preorder, inorder, pre_start + 1, pre_start + k, in_start, i - 1);
        if(i < in_end) re.right = r(preorder, inorder, pre_start + k + 1, pre_end, i + 1, in_end);
        return re;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return r(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
