/**
* Copyright ? Dec 4, 2013 
* LeetCode 8:40:02 AM
* Version 1.0
* All right reserved.
*
*/

package tree.bst.numTrees;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 8:40:02 AM
 * Version: 1.0
 */
public class Solution {
    public int numTrees(int n) {
        int[]f = new int[n + 1];
        int i, j, k;
        f[0] = 1;
        f[1] = 1;
        for(i = 2; i <= n; ++i){
            f[i] = 0;
            for(j = 0; j <= i - 1; ++j){
                f[i] += f[j] * f[i - 1 - j];
            }
        }
        return f[n];
    }
}
