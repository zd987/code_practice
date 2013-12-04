/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:08:45 PM
* Version 1.0
* All right reserved.
*
*/

package tree.bst.sortedArrayToBST;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:08:45 PM
 * Version: 1.0
 */
public class Solution {
    private TreeNode r(int[] num, int start, int end){
        if(start > end) return null;
        int i, j, k = (start + end) / 2;
        TreeNode re = new TreeNode(num[k]);
        re.left = r(num, start, k - 1);
        re.right = r(num, k + 1, end);
        return re;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        return r(num, 0, num.length - 1);
    }
}