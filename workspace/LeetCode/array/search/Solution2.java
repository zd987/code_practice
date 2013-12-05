/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:49:01 AM
* Version 1.0
* All right reserved.
*
*/

package array.search;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:49:01 AM
 * Version: 1.0
 */
public class Solution2 {
	public boolean search(int[] A, int target) {
        int i, j, k, n = A.length, low = 0, high = n - 1, mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target) return true;
            if(A[low] == A[mid] && A[high] == A[mid]){
                for(i = low + 1; i < high; ++i){
                    if(A[i] == target) return true;
                }
                return false;
            }
            if(A[mid] > target){
                if(A[low] <= target || A[low] > A[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if(A[high] >= target || A[high] < A[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }
}
