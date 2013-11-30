/**
* Copyright ? Nov 28, 2013 
* LeetCode 10:39:18 PM
* Version 1.0
* All right reserved.
*
*/

package dp.minPathSum;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 28, 2013 10:39:18 PM
 * Version: 1.0
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k, m = grid.length, n = grid[0].length;
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(i == 0 && j == 0) {
                } else if(i == 0){
                    grid[i][j] += grid[i][j - 1];
                } else if(j == 0){
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}