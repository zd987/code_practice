import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            boolean[] f = new boolean[s.length() + 1];
            Arrays.fill(f, false);
            f[0] = true;
            int i, j, k; 
            for(i = 1; i <= s.length(); ++i){
                    ArrayList<Integer> pre = new ArrayList<Integer>();
                    list.add(pre); 
                    for(j = i - 1; j >= 0; --j){
                            if(f[j] && dict.contains(s.substring(j, i))){
                                    pre.add(j);
                                    f[i] = true;
                            }
                    }
            }
            ArrayList<String> re = new ArrayList<String>();
            ArrayList<String> cur = new ArrayList<String>();
            buildString(s, list, s.length(), re, cur);
            return re;
    }
    private void buildString(String s, ArrayList<ArrayList<Integer>> list, int pos, ArrayList<String> re, ArrayList<String> cur){
            int i, j, k;
            if(pos == 0){
                    StringBuilder sb = new StringBuilder();
                    sb.append(cur.get(cur.size() - 1));
                    for(i = cur.size() - 2; i >= 0; --i){
                            sb.append(" ");
                            sb.append(cur.get(i));
                    }
                    re.add(sb.toString());
                    return;
            }
            for(Integer p : list.get(pos - 1)){
                    cur.add(s.substring(p, pos));
                    buildString(s, list, p, re, cur);
                    cur.remove(cur.size() - 1);
            }
    }
    public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		Solution sol = new Solution();
		sol.wordBreak("ab", set);
	}
}