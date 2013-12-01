/**
* Copyright ? Dec 1, 2013 
* LeetCode 9:54:43 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 9:54:43 PM
 * Version: 1.0
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> dfs(int[] c, int start, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i = start; i < c.length; ++i){
            if(c[i] == target) {
                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(c[i]);
                ans.add(cur);
                return ans;
            } else if(c[i] < target) {
                for(ArrayList<Integer> back : dfs(c, i, target - c[i])) {
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(c[i]);
                    cur.addAll(back);
                    ans.add(cur);
                }
            }
        }
        return ans;
    } 
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, 0, target);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] c = {2,3,6,7};
		ArrayList<ArrayList<Integer>> re = sol.combinationSum(c, 7);
		System.out.println(re);
	}
}