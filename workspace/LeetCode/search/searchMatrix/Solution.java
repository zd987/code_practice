/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:43:01 PM
* Version 1.0
* All right reserved.
*
*/

package search.searchMatrix;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:43:01 PM
 * Version: 1.0
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i, j, k, m = matrix.length, n = matrix[0].length, mid, low ,high;
        low = 0; high = m * n - 1;
        while(low <= high){
            mid = (low + high) / 2;
            k = matrix[mid / n][mid % n];
            if(k == target) return true;
            else if(k > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}