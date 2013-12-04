/**
* Copyright ? Dec 4, 2013 
* LeetCode 6:27:53 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.levelOrderBottom;
import java.util.*;
/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 6:27:53 AM
 * Version: 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = null;
        if(root == null) return re;
        q.offer(root);
        int i, j, k;
        while(!q.isEmpty()){
            k = q.size();
            cur = new ArrayList<Integer>();
            for(i = 0; i < k; ++i){
                root = q.poll();
                cur.add(root.val);
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
            re.add(cur);
        }
        Collections.reverse(re);
        return re;
    }
}
