/**
* Copyright ? Dec 3, 2013 
* LeetCode 11:37:58 PM
* Version 1.0
* All right reserved.
*
*/

package tree.postorderTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 11:37:58 PM
 * Version: 1.0
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        if(root == null) return re;
        s.push(root);
        while(!s.isEmpty()){
            root = s.pop();
            if(root.left == null && root.right == null) {
                re.add(root.val);
                continue;
            }
            if(!set.contains(root)){
                set.add(root);
                s.push(root);
                if(root.right != null) s.push(root.right);
                if(root.left != null)  s.push(root.left);
            } else {
                re.add(root.val);
            }
        }
        return re;
    }
}