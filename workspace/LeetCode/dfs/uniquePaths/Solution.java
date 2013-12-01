/**
* Copyright ? Dec 1, 2013 
* LeetCode 8:46:02 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.uniquePaths;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 8:46:02 PM
 * Version: 1.0
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] f = new int[m][n];
        int i, j, k;
        for(i = 0; i < n; ++i) f[0][i] = 1;
        for(i = 0; i < m; ++i) f[i][0] = 1;
        for(i = 1; i < m; ++i){
            for(j = 1; j < n; ++j){
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}