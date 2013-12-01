/**
* Copyright ? Dec 1, 2013 
* LeetCode 7:06:26 AM
* Version 1.0
* All right reserved.
*
*/

package getPermutation;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 7:06:26 AM
 * Version: 1.0
 */
public class Solution {
    public String getPermutation(int n, int k) {
    	int i, j, t, l;
    	--k;
    	StringBuilder sb = new StringBuilder();
    	int[] f = new int[10];
    	int[] num = new int[n + 1];
    	f[0] = 1; 
    	for(i = 1; i <= 9; ++i) f[i] = f[i - 1] * i;
    	for(i = 0; i <= n; ++i) num[i] = i;
    	for(t = n; t >= 1; --t){
    		l = k / f[t - 1];
    		k %= f[t - 1];
    		sb.append(num[l + 1]);
    		num[l + 1] = num[t];
    		Arrays.sort(num, 1, t);
    	}
        return sb.toString();
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.getPermutation(3, 5));
	}
}