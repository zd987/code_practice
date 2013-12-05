/**
* Copyright ? Dec 5, 2013 
* LeetCode 9:50:33 PM
* Version 1.0
* All right reserved.
*
*/

package array.setZeroes;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 9:50:33 PM
 * Version: 1.0
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int i, j, k, m = matrix.length, n = matrix[0].length;
        boolean row = false, col = false;
        for(i = 0; i < m; ++i){
            if(matrix[i][0] == 0){
                col = true;
                break;
            }
        }
        for(j = 0; j < n; ++j){
            if(matrix[0][j] == 0) {
                row = true;
                break;
            }
        }
        for(i = 1; i < m; ++i){
            for(j = 1; j < n; ++j){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(i = 1; i < m; ++i){
            if(matrix[i][0] == 0){
                for(j = 1; j < n; ++j) matrix[i][j] = 0;
            }
        }
        for(j = 1; j < n; ++j){
            if(matrix[0][j] == 0){
                for(i = 1; i < m; ++i) matrix[i][j] = 0;
            }
        }
        if(row) {
            for(j = 0; j < n; ++j) matrix[0][j] = 0;
        }
        if(col) {
            for(i = 0; i < m; ++i) matrix[i][0] = 0;
        }
    }
}