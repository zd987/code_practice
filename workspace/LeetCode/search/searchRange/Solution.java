/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:33:53 PM
* Version 1.0
* All right reserved.
*
*/

package search.searchRange;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:33:53 PM
 * Version: 1.0
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start, end, i, j, k, mid, low, high, n = A.length;
        low = 0; high = n - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid]>= target) high = mid - 1;
            else low = mid + 1;
        }
        start = low;
        low = 0; high = n - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid]> target) high = mid - 1;
            else low = mid + 1;
        }
        end = high;
        int[] re = new int[2];
        if(start > end) Arrays.fill(re, -1);
        else {
            re[0] = start;
            re[1] = end;
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {5, 7, 7, 8, 8, 10};
		System.out.println(sol.searchRange(A, 8));
	}
}