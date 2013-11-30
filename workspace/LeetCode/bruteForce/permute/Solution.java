/**
* Copyright ? Nov 30, 2013 
* LeetCode 5:26:56 PM
* Version 1.0
* All right reserved.
*
*/

package bruteForce.permute;

import java.util.*;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 5:26:56 PM
 * Version: 1.0
 */
public class Solution {
    private void r2(int[] num, boolean[] b, int k, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(k == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < num.length; ++i){
            if(!b[i]){
                b[i] = true;
                cur.add(num[i]);
                r2(num, b, k + 1, cur, re);
                cur.remove(cur.size() - 1);
                b[i] = false;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute2(int[] num) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        boolean[] b = new boolean[num.length];
        Arrays.fill(b, false);
        r2(num, b, 0, cur, re);
        return re;
    }
    private void r3(int[] num, int b, int k, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(k == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < num.length; ++i){
            if((1 << i & b) == 0){
                b = b | 1 << i;
                cur.add(num[i]);
                r3(num, b, k + 1, cur, re);
                cur.remove(cur.size() - 1);
                b = b & ~(1 << i);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute3(int[] num) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        int b = 0;
        r3(num, b, 0, cur, re);
        return re;
    }
    private void r(int[] num, int k, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re){
        if(k == num.length){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = k; i < num.length; ++i){
        	int t = num[i];
        	num[i] = num[k];
        	num[k] = t;
        	cur.add(num[k]);
            r(num, k + 1, cur, re);
            cur.remove(cur.size() - 1);
            t = num[i];
        	num[i] = num[k];
        	num[k] = t;
        }
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        r(num, 0, cur, re);
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] num = {0, 1};
		sol.permute(num);
	}
}
