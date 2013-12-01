/**
* Copyright ? Dec 1, 2013 
* LeetCode 9:14:29 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.totalNQueens;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 9:14:29 PM
 * Version: 1.0
 */
public class Solution {
    int cnt;
    private void dfs(int[] f, boolean[] b, int row, int n){
        if(row == n) {
        	++cnt;
            return;
        }
        int i, j, k;
        for(i = 0; i < n; ++i){
        	if(!b[i]){
        		for(j = 0; j < row; ++j){
        			if(row - j == i - f[j] || row - j == f[j] - i) break;
        		}
        		if(j == row) {
        			f[row] = i;
        			b[i] = true;
        			dfs(f, b, row + 1, n);
        			b[i] = false;
        		}
        	}
        }
    }
    public int totalNQueens(int n) {
        cnt = 0;
        int i, j, k;
        int[] f = new int[n];
        boolean[] b = new boolean[n];
        Arrays.fill(b, false);
        dfs(f, b, 0, n);
        return cnt;
    }
}