/**
* Copyright ? Dec 1, 2013 
* LeetCode 8:50:36 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.uniquePathsWithObstacles;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 8:50:36 PM
 * Version: 1.0
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i, j, k, m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        if(obstacleGrid[0][0] == 1) return 0;
        f[0][0] = 1;
        for(i = 1; i < m; ++i) f[i][0] = obstacleGrid[i][0] == 1 ? 0 : f[i - 1][0];
        for(i = 1; i < n; ++i) f[0][i] = obstacleGrid[0][i] == 1 ? 0 : f[0][i - 1];
        for(i = 1; i < m; ++i){
            for(j = 1; j < n; ++j){
                f[i][j] = obstacleGrid[i][j] == 1 ? 0 : f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}