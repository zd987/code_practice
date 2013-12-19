import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private void r(String start, ArrayList<ArrayList<String>> re, ArrayList<String> cur, 
        HashMap<String, ArrayList<String>> m, String word){
            if(word.equals(start)){
            	ArrayList<String> tmp = new ArrayList<String>(cur);
                Collections.reverse(tmp);
                re.add(tmp);
                return;
            }
            ArrayList<String> list = m.get(word);
            for(String s : list){
            	cur.add(s);
            	r(start, re, cur, m, s);
            	cur.remove(cur.size() - 1);
            }
        }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        boolean find = false;
        int i, j, k;
        HashSet<String> visited = new HashSet<String>();
        while(!q.isEmpty() && !find){
            int qsize = q.size();
            HashSet<String> cur = new HashSet<String>();
            for(k = 0; k < qsize; ++k){
                String str = q.poll();
                for(i = 0; i < str.length(); ++i){
                    char ch = str.charAt(i);
                    for(char c = 'a'; c <= 'z'; ++c){
                        if(c != ch){
                            StringBuilder sb = new StringBuilder(str);
                            sb.setCharAt(i, c);
                            String s = sb.toString();
                            if(s.equals(end)) find = true;
                            if((s.equals(end) || dict.contains(s)) && !visited.contains(s)){
                                ArrayList<String> list = m.get(s);
                                if(list == null){
                                    list = new ArrayList<String>();
                                    m.put(s, list);
                                }
                                list.add(str);
                                if(!cur.contains(s)){
                                    q.offer(s);
                                }
                                cur.add(s);
                            }
                        }
                    }
                }
            }
            visited.addAll(cur);
        }
        ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
        if(find){
	        ArrayList<String> cur = new ArrayList<String>();
	        cur.add(end);
	        r(start, re, cur, m, end);
        }
        return re;
    }
    public static void main(String[] args) {
		String start = "hot";
		String end = "dog";
		String[] ar = {"hot","dog"};
		HashSet<String> dict = new HashSet<String>();
		for(String s : ar) dict.add(s);
		Solution sol = new Solution();
		sol.findLadders(start, end, dict);
	}
}