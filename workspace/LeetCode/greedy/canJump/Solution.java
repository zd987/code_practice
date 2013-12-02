/**
* Copyright ? Dec 2, 2013 
* LeetCode 6:34:21 AM
* Version 1.0
* All right reserved.
*
*/

package greedy.canJump;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 6:34:21 AM
 * Version: 1.0
 */
public class Solution {
    public boolean canJump2(int[] A) {
        int reach = 0, i = 0, n = A.length;
        while(reach < n - 1 && i < n){
            if(A[i] == 0) break;
            reach += A[i];
            i += A[i];
        }        
        return reach >= n - 1;
    }
    public boolean canJump3(int[] A) {
        int i, j, k, n = A.length;
        boolean[] f = new boolean[n];
        Arrays.fill(f, false);
        if(A[0] == 0) return n == 1;
        f[0] = true;
        for(i = 1; i < n; ++i){
            for(j = i - 1; j >= 0; --j){
                if(f[j] && j + A[j] >= i) {
                    f[i] = true; break;
                }
            }
        }
        return f[n - 1];
    }
    public boolean canJump(int[] A) {
        int i, j, k = 0, n = A.length;
        for(i = 0; i <= k && k < n - 1; ++i){
            k = Math.max(k, i + A[i]);
        }
        return k >= n - 1;
    }
}
