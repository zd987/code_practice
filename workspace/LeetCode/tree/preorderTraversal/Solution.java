/**
* Copyright ? Dec 3, 2013 
* LeetCode 10:57:28 PM
* Version 1.0
* All right reserved.
*
*/

package tree.preorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 10:57:28 PM
 * Version: 1.0
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> re = new ArrayList<Integer>();
        if(root == null) return re;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            re.add(n.val);
            if(n.right != null) s.push(n.right);
            if(n.left != null) s.push(n.left);
        }
        return re;
    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
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
                    re.add(root.val);
                    prev.right = root;
                    root = root.left;
                } else {
                    prev.right = null;
                    root = root.right;
                }
                
            }
        }
        return re;
    }
}