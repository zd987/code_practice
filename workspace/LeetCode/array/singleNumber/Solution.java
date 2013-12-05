/**
* Copyright ? Dec 5, 2013 
* LeetCode 11:02:50 PM
* Version 1.0
* All right reserved.
*
*/

package array.singleNumber;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 11:02:50 PM
 * Version: 1.0
 */
public class Solution {
    public int singleNumber(int[] A) {
        int i, j, k, n = A.length;
        k = A[0];
        for(i = 1; i < n; ++i) k = k ^ A[i];
        return k;
    }
}