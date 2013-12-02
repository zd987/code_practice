/**
* Copyright ? Dec 2, 2013 
* LeetCode 8:35:55 PM
* Version 1.0
* All right reserved.
*
*/

package sorting.firstMissingPositive;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 8:35:55 PM
 * Version: 1.0
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        int i, j, k, n = A.length;
        for(i = 0; i < n; ++i){
            if(A[i] <= 0) A[i] = n + 1;
        }
        for(i = 0; i < n; ++i){
            k = Math.abs(A[i]);
            if(k <= n) {
                A[k - 1] = - Math.abs(A[k - 1]);
            }
        }
        for(i = 0; i < n; ++i){
            if(A[i] > 0) return i + 1;
        }
        return n + 1;
    }
}