/**
* Copyright ? Nov 30, 2013 
* LeetCode 2:25:15 PM
* Version 1.0
* All right reserved.
*
*/

package bruteForce.subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 2:25:15 PM
 * Version: 1.0
 */
public class Solution {
	private void dfs(int[] S, int start, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(start == S.length){
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	tmp.addAll(cur);
            re.add(tmp);
            return;
        }
        dfs(S, start + 1, cur, re);
        cur.add(S[start]);
        dfs(S, start + 1, cur, re);
        cur.remove(cur.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        Arrays.sort(S);
        ArrayList<Integer> cur = new ArrayList<Integer> ();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>> ();
        dfs(S, 0, cur, re);
        return re;
    }
    public ArrayList<ArrayList<Integer>> subsets3(int[] S) {
        Arrays.sort(S);
        ArrayList<Integer> cur = new ArrayList<Integer> ();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>> ();
        re.add(cur);
        for(int i = 0; i < S.length; ++i){
            int k = re.size();
            for(int j = 0; j < k; ++j){
                cur = new ArrayList<Integer> ();
                cur.addAll(re.get(j));
                cur.add(S[i]);
                re.add(cur);
            }
        }
        return re;
    }
    public ArrayList<ArrayList<Integer>> subsets4(int[] S) {
        Arrays.sort(S);
        int i, j, k, n = S.length, cnt = 1 << n;
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>> ();
        for(i = 0; i < cnt; ++i){
            ArrayList<Integer> cur = new ArrayList<Integer> ();
            for(j = 0; j < n; ++j){
                if((i & (1 << j)) > 0){
                    cur.add(S[j]);
                }
            }
            re.add(cur);
        }
        return re;
    }
    private void dfs2(int[] num, int start, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        re.add(new ArrayList<Integer>(cur));
        for(int i = start; i < num.length; ++i){
            cur.add(num[i]);
            dfs2(num, i + 1, cur, re);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsets5(int[] S) {
        Arrays.sort(S);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        dfs2(S, 0, cur, re);
        return re;
    }
    private void dfs3(int[] num, int start, int k, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(k == 0){
            re.add(new ArrayList<Integer>(cur));    
        }
        for(int i = start; i < num.length; ++i){
            cur.add(num[i]);
            dfs3(num, i + 1, k - 1, cur, re);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= S.length; ++i){
            dfs3(S, 0, i, cur, re);
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] S = {1, 2, 3};
		sol.subsets(S);
	}
}