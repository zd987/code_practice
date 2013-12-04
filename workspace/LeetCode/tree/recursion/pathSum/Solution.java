/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:38:46 PM
* Version 1.0
* All right reserved.
*
*/

package tree.recursion.pathSum;

import java.util.ArrayList;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:38:46 PM
 * Version: 1.0
 */
public class Solution {
    private void dfs(TreeNode root, int sum, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(root.left == null && root.right == null && root.val == sum){
            cur.add(root.val);
            re.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        cur.add(root.val);
        if(root.left != null) {
            dfs(root.left, sum - root.val, cur, re);
        }
        if(root.right != null) {
            dfs(root.right, sum - root.val, cur, re);
        }
        cur.remove(cur.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        if(root == null) return re;
        dfs(root, sum, cur, re);
        return re;
    }
}