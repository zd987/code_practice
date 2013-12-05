/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:46:52 PM
* Version 1.0
* All right reserved.
*
*/

package array.removeElement;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:46:52 PM
 * Version: 1.0
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i, j, k, n = A.length; 
        for(i = 0, j = 0; i < n; ++i){
            if(A[i] != elem) A[j++] = A[i];
        }
        return j;
    }
}