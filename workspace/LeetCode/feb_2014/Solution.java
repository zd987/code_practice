package feb_2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    private void r(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] c, int index, int target){
        if(target == 0){
            ArrayList<Integer> t = new ArrayList<Integer>(cur);
            Collections.reverse(t);
            re.add(t);
            return;
        }
        for(int i = index; i >= 0; --i){
        	if(target < c[i]) break;
        	cur.add(c[i]);
        	r(re, cur, c, i, target - c[i]);
        	cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        r(re, cur, candidates, candidates.length - 1, target);
        return re;
    }
}