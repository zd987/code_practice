/**
* Copyright ? Dec 1, 2013 
* LeetCode 11:20:32 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.solveSudoku;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 11:20:32 PM
 * Version: 1.0
 */
public class Solution {
	public class Solution {
	    class Pair{
	        int x, y, val;
	        public Pair(int x, int y){
	            this.x = x;
	            this.y = y;
	            this.val = 0;
	        }
	    }
	    public void solveSudoku(char[][] board) {
	        ArrayList<Pair> list = new ArrayList<Pair>();
	        int i, j, k;
	        for(i = 0; i < 9; ++i){
	            for(j = 0; j < 9; ++j){
	                if(board[i][j] == '.') list.add(new Pair(i, j));
	            }
	        }
	        k = 0;
	        boolean[] b = new boolean[10];
	        while(k >= 0 && k < list.size()){
	            Pair p = list.get(k);
	            board[p.x][p.y] = '.';
	            Arrays.fill(b, false);
	            for(i = 0; i < 9; ++i){
	                if(board[i][p.y] != '.') b[board[i][p.y] - '0'] = true;
	                if(board[p.x][i] != '.') b[board[p.x][i] - '0'] = true;
	            }
	            int x = p.x / 3, y = p.y / 3;
	            for(i = 0; i < 3; ++i){
	                for(j = 0; j < 3; ++j){
	                    if(board[3 * x + i][3 * y + j] != '.') b[board[3 * x + i][3 * y + j] - '0'] = true;
	                }
	            }
	            for(i = p.val + 1; i <= 9 && b[i]; ++i) ;
	            if(i <= 9) {
	                board[p.x][p.y] = (char) ('0' + i);
	                p.val = i;
	                ++k;
	            } else {
	                p.val = 0;
	                --k;
	            }
	        }
	    }
	}
    private void print(char[][] chs){
    	for(int i = 0; i < 9; ++i){
    		System.out.print(new String(chs[i])+ ", ");
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] ss = {

				"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."
				
		};
		char[][] chs = new char[9][9];
		for(int i = 0; i < 9; ++i){
			chs[i] = ss[i].toCharArray();
		}
		sol.solveSudoku(chs);
		System.out.println();
	}
}