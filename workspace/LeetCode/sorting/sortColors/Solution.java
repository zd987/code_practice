/**
* Copyright ? Dec 2, 2013 
* LeetCode 9:04:29 PM
* Version 1.0
* All right reserved.
*
*/

package sorting.sortColors;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 9:04:29 PM
 * Version: 1.0
 */
public class Solution {
    public void sortColors(int[] A) {
        int i, j, k, t, n = A.length;
        for(i = 0, j = 0, k = n - 1; j <= k; ){
            switch(A[j]){
            case 0:
                t = A[i];
                A[i] = A[j];
                A[j] = t;
                ++i;
            case 1:
                ++j;
                break;
            case 2:
                t = A[k];
                A[k] = A[j];
                A[j] = t;
                --k;
            }
        }
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {0};
		sol.sortColors(A);
		System.out.println();
	}
}
