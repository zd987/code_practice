/**
* Copyright ? Nov 28, 2013 
* LeetCode 7:30:46 AM
* Version 1.0
* All right reserved.
*
*/

package maximalRectangle;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 28, 2013 7:30:46 AM
 * Version: 1.0
 */
public class Solution {
	public int maximalRectangle(char[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int i, j, k = 0, re = 0, m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(h, 0);
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            }
            for(j = 0; j < n; ++j){
                k = j - 1;
                while(k >= 0 && h[k] >= h[j]) k = l[k];
                l[j] = k;
            }
            for(j = n - 1; j >= 0; --j){
                k = j + 1;
                while(k < n && h[k] >= h[j]) k = r[k];
                r[j] = k;
            }
            for(j = 0; j < n; ++j){
                k = h[j] * (r[j] - l[j] - 1);
                re = Math.max(re, k);
            }
        }
        return re;
    }
    public static void main(String[] args) {
		char[][] m = new char[4][4];
		for(int i = 0; i < 4; ++i){
			Arrays.fill(m[i], '0');
		}
		Solution sol = new Solution();
		System.out.println(sol.maximalRectangle(m));
	}
    class A{
    	int A;
    	A(){}
    }
}