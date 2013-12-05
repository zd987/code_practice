/**
* Copyright ? Dec 5, 2013 
* LeetCode 9:11:26 PM
* Version 1.0
* All right reserved.
*
*/

package array.rotate;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 9:11:26 PM
 * Version: 1.0
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int i, j, k, t, n = matrix.length;
        if(n == 0) return;
        int x1 = 0, y1 = 0, x2 = n - 1, y2 = n - 1;
        while(x1 < x2){
            k = x2 - x1 + 1;
            for(i = 0; i < k - 1; ++i){
                t = matrix[x1][y1 + i];
                matrix[x1][y1 + i] = matrix[x2 - i][y1];
                matrix[x2 - i][y1] = matrix[x2][y2 - i];
                matrix[x2][y2 - i] = matrix[x1 + i][y2];
                matrix[x1 + i][y2] = t;
            }
            ++x1; ++y1; --x2; --y2;
        }
    }
}