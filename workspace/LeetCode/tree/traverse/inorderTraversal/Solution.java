/**
* Copyright ? Dec 4, 2013 
* LeetCode 6:19:00 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.inorderTraversal;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 6:19:00 AM
 * Version: 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        if(root == null) return re;
        while(root != null){
            if(root.left == null) {
                re.add(root.val);
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while(prev.right != null && prev.right != root) prev = prev.right;
                if(prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    re.add(root.val);
                    prev.right = null;
                    root = root.right;
                }
                
            }
        }
        return re;
    }
}