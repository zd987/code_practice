/**
* Copyright ? Dec 5, 2013 
* LeetCode 9:04:47 PM
* Version 1.0
* All right reserved.
*
*/

package array.trap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 9:04:47 PM
 * Version: 1.0
 */
public class Solution {
    public int trap(int[] A) {
        int n = A.length, i = 0, j = n - 1, k, re = 0;
        while(i < j){
            k = Math.min(A[i], A[j]);
            if(A[i] == k) {
                ++i;
                while(i < j && A[i] <= k) {
                    re += k - A[i];
                    ++i;
                }
            } else {
                --j;
                while(i < j && A[j] <= k){
                    re += k - A[j];
                    --j;
                }
            }
        }
        return re;
    }
}