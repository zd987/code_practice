/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:12:37 AM
* Version 1.0
* All right reserved.
*
*/

package greedy.jump;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:12:37 AM
 * Version: 1.0
 */
public class Solution {
    public int jump(int[] A) {
        int i, j, k, last = 0, cur = 0, re = 0, n = A.length;
        for(i = 0; i < n; ++i){
            if(i > last) {
                last = cur;
                ++re;
            }
            cur = Math.max(cur, i + A[i]);
        }
        return re;
    }
}