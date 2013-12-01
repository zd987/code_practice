/**
* Copyright ? Dec 1, 2013 
* LeetCode 9:08:06 AM
* Version 1.0
* All right reserved.
*
*/

package bruteForce.combine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 9:08:06 AM
 * Version: 1.0
 */
public class Solution {
    private void r2(ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re, int n, int start, int k){
        if(k == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        if(start > n) return;
        r2(cur, re, n, start + 1, k);
        cur.add(start);
        r2(cur, re, n, start + 1, k - 1);
        cur.remove(cur.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> combine2(int n, int k) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        r2(cur, re, n, 1, k);
        return re;
    }
    private void r(ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> re, int n, boolean[] b, int k){
        if(k == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 1; i <= n; ++i){
            if(!b[i]){
                b[i] = true;
                cur.add(i);
                r(cur, re, n, b, k - 1);
                b[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        boolean[] b = new boolean[n + 1];
        Arrays.fill(b, false);
        r(cur, re, n, b, k);
        return re;
    }
}