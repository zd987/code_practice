/**
* Copyright ? Dec 1, 2013 
* LeetCode 10:27:52 AM
* Version 1.0
* All right reserved.
*
*/

package bfs.findLadders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 10:27:52 AM
 * Version: 1.0
 */
public class Solution {
	private void r(ArrayList<ArrayList<String>> re, ArrayList<String> cur, String start, String end, 
        HashMap<String, HashSet<String>> m, HashSet<String> visited){
        if(end.equals(start)) {
        	ArrayList<String> tmp = new ArrayList<String>(cur);
        	Collections.reverse(tmp);
            re.add(tmp);
            return;
        }
        if(visited.contains(end)) return;
        visited.add(end);
        for(String s : m.get(end)){
        	cur.add(s);
        	r(re, cur, start, s, m, visited);
        	cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        int i, j, k, step = 0;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> v = new HashSet<String>();
        HashSet<String> vv = new HashSet<String>();
        HashMap<String, HashSet<String>> m = new HashMap<String, HashSet<String>>();
        q.offer(start);
        boolean found = false;
        while(!q.isEmpty()){
            boolean update = false;
            int size = q.size();
            ++step;
            vv.clear();
            for(i = 0; i < size; ++i){
            	String str = q.poll();
            	if(v.contains(str)) continue;
            	v.add(str);
                StringBuilder cur = new StringBuilder(str);
                for(j = 0; j < cur.length(); ++j){
                	char c = cur.charAt(j);
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                    	if(ch == c) continue;
                    	cur.setCharAt(j, ch);
                        String ns = cur.toString();
                    	if(dict.contains(ns)){
                    	    if(ns.equals(end)) {
                    			found = true;
                    		}
                        	update = true;
                        	HashSet<String> prev = m.get(ns);
                        	if(prev == null){
                        	    prev = new HashSet<String>();
                        	    prev.add(str);    
                        	    m.put(ns, prev);
                        	    vv.add(ns);
                        	} else if(vv.contains(ns)) {
                        	    prev.add(str);    
                        	}
                        	q.offer(ns);
                        }
                    }
                    cur.setCharAt(j, c);
                }
            }
            if(found || !update) break;
        }
		ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
        if(found){
    		ArrayList<String> curr = new ArrayList<String>();
    		curr.add(end);
    		HashSet<String> visited = new HashSet<String>();
    		r(re, curr, start, end, m, visited);
        }
		return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] ss = {"a","b","c"};
		HashSet<String> dict = new HashSet<String>();
		for(String s : ss){
			dict.add(s);
		}
		sol.findLadders("a", "c", dict);
	}
}