/**
* Copyright ? Nov 30, 2013 
* LeetCode 5:52:12 PM
* Version 1.0
* All right reserved.
*
*/

package bruteForce.permuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 5:52:12 PM
 * Version: 1.0
 */
public class Solution {
	void pR2(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] num, boolean[] b){
        if(cur.size() == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < num.length; ++i){
            if(b[i]) continue;
            if(i > 0 && num[i - 1] == num[i] && !b[i - 1]) continue;
            cur.add(num[i]);
            b[i] = true;
            pR2(re, cur, num, b);
            cur.remove(cur.size() - 1);
            b[i] = false;
        }
    }
	void pR(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] num, int start){
        if(cur.size() == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = start; i < num.length; ++i){
            if(!set.contains(num[i])){
                cur.add(num[i]);
                num[i] = num[start];
                pR(re, cur, num, start + 1);
                num[i] = cur.get(cur.size() - 1);
                cur.remove(cur.size() - 1);
                set.add(num[i]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        pR(re, cur, num, 0);
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = {2, 1, 2, 1};
		sol.permuteUnique(num);
	}
}