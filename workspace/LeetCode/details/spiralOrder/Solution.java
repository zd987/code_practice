/**
* Copyright ? Dec 3, 2013 
* LeetCode 8:03:05 PM
* Version 1.0
* All right reserved.
*
*/

package details.spiralOrder;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 8:03:05 PM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return re;
        int i, j, k, x1, y1, x2, y2, m = matrix.length, n = matrix[0].length;
        x1 = 0; y1 = 0; x2 = m - 1; y2 = n - 1;
        while(x1 <= x2 && y1 <= y2){
            for(i = y1; i <= y2; ++i) re.add(matrix[x1][i]);
            for(i = x1 + 1; i <= x2; ++i) re.add(matrix[i][y2]);
            if(x1 != x2 && y1 != y2) {
                for(i = y2 - 1; i >= y1; --i) re.add(matrix[x2][i]);
                for(i = x2 - 1; i > x1; --i) re.add(matrix[i][y1]);
            }
            ++x1; ++y1; --x2; --y2;
        }
        return re;
    }
}