/**
* Copyright ? Dec 4, 2013 
* LeetCode 7:52:23 PM
* Version 1.0
* All right reserved.
*
*/

package tree.bst.generateTrees;

import java.util.ArrayList;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 7:52:23 PM
 * Version: 1.0
 */
public class Solution {
    private ArrayList<TreeNode> r(int start, int cnt){
        ArrayList<TreeNode> re = new ArrayList<TreeNode>();
        if(cnt == 0) {
            re.add(null);
            return re;
        }
        int i, j, k;
        for(i = 0; i < cnt; ++i){
            ArrayList<TreeNode> left = r(start, i);
            ArrayList<TreeNode> right = r(start + i + 1, cnt - 1 - i);
            for(TreeNode l : left) {
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(start + i);
                    root.left = l;
                    root.right = r;
                    re.add(root);
                }
            }
        }
        return re;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        return r(1, n);
    }
}
