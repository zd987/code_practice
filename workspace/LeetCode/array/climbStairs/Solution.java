/**
* Copyright ? Dec 5, 2013 
* LeetCode 9:29:26 PM
* Version 1.0
* All right reserved.
*
*/

package array.climbStairs;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 9:29:26 PM
 * Version: 1.0
 */
public class Solution {
    public int climbStairs(int n) {
        if(n < 2) return 1;
        int[] f = new int[n + 1];
        int i, j, k;
        f[0] = 1; f[1] = 1;
        for(i = 2; i <= n; ++i){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}