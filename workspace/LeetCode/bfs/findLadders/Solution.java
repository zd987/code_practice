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
    private void r(ArrayList<ArrayList<String>> re, ArrayList<String> cur, String end, HashMap<String, ArrayList<String>> m){
        ArrayList<String> list = m.get(end);
        if(list == null){
            ArrayList<String> tmp = new ArrayList<String>(cur);
            Collections.reverse(tmp);
            re.add(tmp);
            return;
        }
        for(String str : list){
            cur.add(str);
            r(re, cur, str, m);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        int i, j, k;
        HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        HashSet<String> set = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        m.put(start, null);
        boolean find = false;
        ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
        while(!q.isEmpty()){
            int size = q.size();
            set.clear();
            for(i = 0; i < size; ++i){
                String w = q.poll();
                StringBuilder sb = new StringBuilder(w);
                for(j = 0; j < w.length(); ++j){
                    char c = w.charAt(j);
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                    	if(ch == c) continue;
                        sb.setCharAt(j, ch);
                        String tw = sb.toString();
                        ArrayList<String> list = m.get(tw);
                        if(end.equals(tw)){
                            find = true;
                            ArrayList<String> cur = new ArrayList<String>();
                            cur.add(end);
                            cur.add(w);
                            r(re, cur, w, m);
                        } else if(dict.contains(tw)){
                            if(!m.containsKey(tw)){
                                list = new ArrayList<String>();
                                m.put(tw, list);
                                list.add(w);
                                q.offer(tw);
                                set.add(tw);
                            }else if(set.contains(tw)){
                                list.add(w);
                            }
                        } 
                    }
                    sb.setCharAt(j, c);
                }
            }
            if(find) break;
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