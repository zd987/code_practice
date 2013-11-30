/**
* Copyright ? Nov 27, 2013 
* LeetCode 11:56:16 PM
* Version 1.0
* All right reserved.
*
*/

package dp.minCut;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 27, 2013 11:56:16 PM
 * Version: 1.0
 */
public class Solution {
    public int minCut(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k, n = s.length();
        int[] f = new int[n];
        boolean[][] p = new boolean[n][n];
        for(i = 0; i < n; ++i){
            f[i] = i;
        }
        for(i = 0; i < n; ++i){
            for(j = 0; j <= i; ++j){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || p[j + 1][i - 1])){
                    p[j][i] = true;
                    f[i] = j == 0 ? 0 : Math.min(f[i], f[j - 1] + 1);
                }
            }
        }
        return f[n - 1];
    }
	public int minCut2(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k, n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] f = new int[n + 1];
        for(i = 0; i <= n; ++i){
            f[i] = n - 1 - i;
        }
        for(i = n - 1; i >= 0; --i){
            for(j = i; j < n; ++j){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || p[i + 1][j - 1])){
                    p[i][j] = true;
                    f[i] = Math.min(f[i], f[j + 1] + 1);
                }
            }
        }
        return f[0];
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "ab";
		System.out.println(sol.minCut(s));
	}
}