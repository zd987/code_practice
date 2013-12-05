/**
* Copyright ? Dec 5, 2013 
* LeetCode 11:24:23 PM
* Version 1.0
* All right reserved.
*
*/

package array.singleNumber;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 11:24:23 PM
 * Version: 1.0
 */
public class Solution2 {
	public int singleNumber(int[] A) {
        int i, j, k, t, n = A.length, re= 0;
        int[] f = new int[32];
        Arrays.fill(f, 0);
        for(i = 0; i < n; ++i){
            k = A[i]; t = 0;
            while(k != 0){
                j = k & 1;
                k = k >>> 1;
                f[t] = (f[t] + j) % 3;
                ++t;
            }
        }
        for(i = 0; i < 32; ++i){
            re = re | (f[i] << i);
        }
        return re;
    }
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] A = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		sol.singleNumber(A);
	}
}
