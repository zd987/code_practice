/**
* Copyright ? Nov 30, 2013 
* LeetCode 2:57:49 PM
* Version 1.0
* All right reserved.
*
*/

package bruteForce.subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 2:57:49 PM
 * Version: 1.0
 */
public class Solution {
	private void r(int[] num, int start, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re, HashMap<Integer, Integer> m){
        if(start == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        int i, cnt = m.get(num[start]);
        r(num, start + cnt, cur, re, m);
        for(i = 1; i <= cnt; ++i){
            cur.add(num[start]);
            r(num, start + cnt, cur, re, m);
        }
        for(i = 1; i <= cnt; ++i){
        	cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
        Arrays.sort(num);
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int i, j, k;
        for(i = 0; i < num.length; ++i){
            Integer cnt = m.get(num[i]);
            if(cnt == null) cnt = 0;
            m.put(num[i], cnt + 1);
        }
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        r(num, 0, cur, re, m);
        return re;
    }
    private void dfs(int[] num, int start, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        re.add(new ArrayList<Integer>(cur));
        for(int i = start; i < num.length; ++i){
            if(i != start && num[i - 1] == num[i]) continue;
            cur.add(num[i]);
            dfs(num, i + 1, cur, re);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup3(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        dfs(num, 0, cur, re);
        return re;
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        re.add(cur);
        int prev_size = 0;
        for(int i = 0; i < num.length; ++i){
            int size = re.size();
            for(int j = 0; j < size; ++j){
                if(i == 0 || num[i- 1] != num[i] || j >= prev_size){
                    cur = new ArrayList<Integer>(re.get(j));
                    cur.add(num[i]);
                    re.add(cur);
                }
            }
            prev_size = size;
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = {1, 2, 3};
		sol.subsetsWithDup(num);
	}
}