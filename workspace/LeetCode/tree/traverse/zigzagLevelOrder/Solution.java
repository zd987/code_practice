/**
* Copyright ? Dec 4, 2013 
* LeetCode 6:32:24 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.zigzagLevelOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 6:32:24 AM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = null;
        if(root == null) return re;
        q.offer(root);
        int i, j = 0, k;
        while(!q.isEmpty()){
            k = q.size();
            cur = new ArrayList<Integer>();
            for(i = 0; i < k; ++i){
                root = q.poll();
                cur.add(root.val);
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
            if(j == 1) Collections.reverse(cur);
            j = 1 - j;
            re.add(cur);
        }
        return re;
    }
}