/**
* Copyright ? Dec 1, 2013 
* LeetCode 10:19:30 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 10:19:30 PM
 * Version: 1.0
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> helper(int[] num, int start, int target){
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        for(int i = start; i < num.length; ++i){
            if(i > start && num[i - 1] == num[i]) continue;
            if(num[i] > target) break;
            if(num[i] == target){
                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(num[i]); re.add(cur);
                return re;
            } 
            for(ArrayList<Integer> back : helper(num, i + 1, target - num[i])){
                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(num[i]); cur.addAll(back); re.add(cur);
            }
        }
        return re;
    }
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return helper(num, 0, target);
    }
}