/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:22:50 AM
* Version 1.0
* All right reserved.
*
*/

package array.removeDuplicates;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:22:50 AM
 * Version: 1.0
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        int i, j = 0, n = A.length;
        for(i = 0; i < n; ++i){
            if(i > 0 && A[i - 1] == A[i]){
                continue;
            } else{
                A[j++] = A[i];
            }
        }
        return j;
    }
}