package leetcode.BSTIterator;

/**
 * Created by zd987 on 2015/1/25.
 */


import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode t = root;
        while(t != null) {
            st.push(t);
            t = t.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode ret = st.pop();
        TreeNode t = ret.right;
        while(t != null) {
            st.push(t);
            t = t.left;
        }
        return ret.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */