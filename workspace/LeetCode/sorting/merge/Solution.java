/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:46:31 PM
* Version 1.0
* All right reserved.
*
*/

package sorting.merge;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:46:31 PM
 * Version: 1.0
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i, j, k;
        i = m - 1; j = n - 1; k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while(j >= 0){
            A[k--] = B[j--];
        }
    }
}