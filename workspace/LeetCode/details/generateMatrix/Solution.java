/**
* Copyright ? Dec 3, 2013 
* LeetCode 8:09:06 PM
* Version 1.0
* All right reserved.
*
*/

package details.generateMatrix;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 8:09:06 PM
 * Version: 1.0
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] f = new int[n][n];
        int i, j, k = 1, x1 = 0, y1 = 0, x2 = n - 1, y2 = n - 1;
        while(x1 <= x2 && y1 <= y2){
            for(i = y1; i <= y2; ++i) f[x1][i] = k++;
            for(i = x1 + 1; i <= x2; ++i) f[i][y2] = k++;
            if(x1 != x2 && y1 != y2){
                for(i = y2 - 1; i >= y1; --i) f[x2][i] = k++;
                for(i = x2 - 1; i > x1; --i) f[i][y1] = k++;
            }
            ++x1; ++y1; --x2; --y2;
        }
        return f;
    }
}