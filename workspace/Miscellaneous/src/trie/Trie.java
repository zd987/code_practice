/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 7:25:38 PM
* Version 1.0
* All right reserved.
*
*/

package trie;

import java.util.TreeSet;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 7:25:38 PM
 * Version: 1.0
 */
public class Trie {
	private Node root;
	public Trie(){
		root = new Node(' ');
	}
	public void insert(String word){
		if(search(word)) return;
		Node cur = root;
		for(int i = 0; i < word.length(); ++i){
			Node child = cur.subNode(word.charAt(i));
			if(child == null){
				Node tmp = new Node(word.charAt(i));
				cur.childList.add(tmp);
				child = tmp;
			}
			cur = child;
			cur.count++;
		}
		cur.isEnd = true;
	}
	public void delete(String word){
		if(search(word) == false) return ;
		Node cur = root;
		for(int i = 0; i < word.length(); ++i){
			Node child = cur.subNode(word.charAt(i));
			if(child.count == 1){
				cur.childList.remove(child);
				return;
			} else {
				child.count--;
				cur = child;
			}
		}
		cur.isEnd = false;
	}

	public boolean search(String word){
		Node cur = root;
		for(int i = 0; i < word.length(); ++i){
			Node tmp = cur.subNode(word.charAt(i));
			if(tmp == null) {
				return false;
			} else {
				cur = tmp;
			}
		}
		if(cur.isEnd) return true;
		return false;
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("ball");
		trie.insert("balls");
		trie.insert("sense");
		// testing deletion  
        System.out.println(trie.search("balls"));  
        System.out.println(trie.search("ba"));  
        trie.delete("balls");  
        System.out.println(trie.search("balls"));  
        System.out.println(trie.search("ball"));  
        TreeSet<Integer> ts = new TreeSet<Integer>();
	}
}
