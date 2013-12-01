/**
* Copyright ? Dec 1, 2013 
* LeetCode 9:57:15 AM
* Version 1.0
* All right reserved.
*
*/

package bfs.ladderLength;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 9:57:15 AM
 * Version: 1.0
 */
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int i, j, k, step = 0;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> v = new HashSet<String>();
        q.offer(start);
        while(!q.isEmpty()){
            boolean update = false;
            int size = q.size();
            ++step;
            for(i = 0; i < size; ++i){
            	String str = q.poll();
            	if(str.equals(end)) return step;
            	if(v.contains(str)) continue;
            	v.add(str);
                StringBuilder cur = new StringBuilder(str);
                for(j = 0; j < cur.length(); ++j){
                	char c = cur.charAt(j);
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                    	cur.setCharAt(j, ch);
                        String ns = cur.toString();
                    	if(dict.contains(ns)){
                        	update = true;
                        	q.offer(ns);
                        }
                    }
                    cur.setCharAt(j, c);
                }
            }
            if(!update) break;
        }
        return 0;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] ss = {"hot","dog","dot"};
		HashSet<String> dict = new HashSet<String>();
		for(String s : ss){
			dict.add(s);
		}
		sol.ladderLength("hot", "dog", dict);
	}
}