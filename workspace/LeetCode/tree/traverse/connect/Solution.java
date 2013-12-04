/**
* Copyright ? Dec 4, 2013 
* LeetCode 7:56:20 AM
* Version 1.0
* All right reserved.
*
*/

package tree.traverse.connect;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeLinkNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 7:56:20 AM
 * Version: 1.0
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null) return;
        q.offer(root);
        int i, j, k;
        while(!q.isEmpty()){
            k = q.size();
            TreeLinkNode prev = null;
            for(i = 0; i < k; ++i){
                root = q.poll();
                if(prev != null) {
                    prev.next = root;
                }
                prev = root;
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
        }
    }
}