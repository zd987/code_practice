/**
* Copyright ? Nov 27, 2013 
* LeetCode 11:26:50 PM
* Version 1.0
* All right reserved.
*
*/

package maxSubArray;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 27, 2013 11:26:50 PM
 * Version: 1.0
 */
public class Solution {
    public int maxSubArray2(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k = 0, re = Integer.MIN_VALUE;
        for(i = 0; i < A.length; ++i){
            k = Math.max(A[i] + k, A[i]);
            re = Math.max(re, k);
        }
        return re;
    }
    private int r(int[] A, int start, int end){
        if(start == end) return A[start];
        int i, k, left, right, mid, re;
        mid = (start + end) / 2;
        left = k = A[mid];
        for(i = mid - 1; i >= start; --i){
            k += A[i];
            left = Math.max(left, k);
        }
        right = k = A[mid + 1];
        for(i = mid + 2; i <= end; ++i){
            k += A[i];
            right = Math.max(right, k);
        }
        re = left + right; 
        if(mid >= start) {
            re = Math.max(re, r(A, start, mid));
        }
        if(mid + 1 <= end){
            re = Math.max(re, r(A, mid + 1, end));
        }
        return re;
    }
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return r(A, 0, A.length - 1);
    }
}