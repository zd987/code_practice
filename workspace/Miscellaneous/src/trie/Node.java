/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 7:21:59 PM
* Version 1.0
* All right reserved.
*
*/

package trie;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 7:21:59 PM
 * Version: 1.0
 */
public class Node {
	char content;
	boolean isEnd;
	List<Node> childList;
	int count;
	public Node(char c){
		childList = new LinkedList<Node>();
		isEnd = false;
		count = 0;
		content = c;
	}
	public Node subNode(char c){
		if(childList != null) {
			for(Node child : childList){
				if(child.content == c) {
					return child;
				}
			}
		}
		return null;
	}
}
