/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:33:24 AM
* Version 1.0
* All right reserved.
*
*/

package array.search;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:33:24 AM
 * Version: 1.0
 */
public class Solution {
    public int search(int[] A, int target) {
        int i, j, k, n = A.length, low = 0, high = n - 1, mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target){
                if(A[low] <= target || A[low] > A[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if(A[high] >= target || A[high] < A[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}