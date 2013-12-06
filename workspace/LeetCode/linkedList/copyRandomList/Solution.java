/**
* Copyright ? Dec 6, 2013 
* LeetCode 8:24:19 AM
* Version 1.0
* All right reserved.
*
*/

package linkedList.copyRandomList;

import java.util.HashMap;

import common.RandomListNode;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 6, 2013 8:24:19 AM
 * Version: 1.0
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head, q;
        while(p != null){
            q = new RandomListNode(p.label);
            m.put(p, q);
            p = p.next;
        }
        p = head;
        while(p != null){
            q = m.get(p);
            q.next = m.get(p.next);
            q.random = m.get(p.random);
            p = p.next;
        }
        return m.get(head);
    }
}