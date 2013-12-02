/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:40:05 PM
* Version 1.0
* All right reserved.
*
*/

package search.searchInsert;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:40:05 PM
 * Version: 1.0
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
        int i, j, k, mid, n = A.length, low = 0, high = n - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}