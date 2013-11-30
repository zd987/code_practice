/**
* Copyright ? Nov 30, 2013 
* LeetCode 1:39:29 PM
* Version 1.0
* All right reserved.
*
*/

package cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 1:39:29 PM
 * Version: 1.0
 */
 class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
 
public class Solution {
	private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> m){
        UndirectedGraphNode node2 = m.get(node);
        if(node2 != null) return node2;
        node2 = new UndirectedGraphNode(node.label);
        m.put(node, node2);
        for(UndirectedGraphNode n : node.neighbors){
            node2.neighbors.add(dfs(n, m));
        }
        return node2;
    }
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return dfs(node, m);
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode node2 = m.get(cur);
            if(node2 == null) {
                node2 = new UndirectedGraphNode(cur.label);
                m.put(node, node2);
            }
            for(UndirectedGraphNode n : cur.neighbors){
                UndirectedGraphNode n2 = m.get(n);
                if(n2 == null) {
                    q.offer(n);
                    n2 = new UndirectedGraphNode(n.label);
                    m.put(n, n2);
                }
                node2.neighbors.add(n2);
            }
        }
        return m.get(node);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);
		node.neighbors.add(node);
		sol.cloneGraph(node);
	}
}