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

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 5:52:12 PM
 * Version: 1.0
 */
public class Solution {
    private void r(int[] num, int k, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(k == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = k; i < num.length; ++i){
            if(i > k && num[i - 1] == num[i]) continue;
            int t = num[k];
            num[k] = num[i];
            num[i] = t;
            cur.add(num[k]);
            r(num, k + 1, cur, re);
            cur.remove(cur.size() - 1);
            t = num[k];
            num[k] = num[i];
            num[i] = t;
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	Arrays.sort(num);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        r(num, 0, cur, re);
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = {2, 1, 2, 1};
		sol.permuteUnique(num);
	}
}