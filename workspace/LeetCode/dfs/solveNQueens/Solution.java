/**
* Copyright ? Dec 1, 2013 
* LeetCode 8:56:39 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 8:56:39 PM
 * Version: 1.0
 */
public class Solution {
    private void dfs(ArrayList<String[]> re, int[] f, boolean[] b, int row, int n){
        if(row == n) {
        	char[] chs = new char[n];
        	Arrays.fill(chs, '.');
            String[] ans = new String[n];
            for(int i = 0; i < n; ++i){
            	chs[f[i]] = 'Q';
            	ans[i] = new String(chs);
            	chs[f[i]] = '.';
            }
            re.add(ans);
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
        			dfs(re, f, b, row + 1, n);
        			b[i] = false;
        		}
        	}
        }
    }
    public ArrayList<String[]> solveNQueens(int n) {
        int i, j, k;
        int[] f = new int[n];
        boolean[] b = new boolean[n];
        Arrays.fill(b, false);
        ArrayList<String[]> re = new ArrayList<String[]>();
        dfs(re, f, b, 0, n);
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solveNQueens(4);
	}
}