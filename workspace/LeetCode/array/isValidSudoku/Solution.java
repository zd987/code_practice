/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:53:35 PM
* Version 1.0
* All right reserved.
*
*/

package array.isValidSudoku;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:53:35 PM
 * Version: 1.0
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i, j, k;
        char ch;
        boolean[] f = new boolean[10];
        for(i = 0; i < 9; ++i){
            Arrays.fill(f, false);
            for(j = 0; j < 9; ++j){
                ch = board[i][j];
                if(ch >= '1' && ch <= '9'){
                    k = ch - '0';
                    if(f[k]) return false;
                    f[k] = true;
                }
            }
            Arrays.fill(f, false);
            for(j = 0; j < 9; ++j){
                ch = board[j][i];
                if(ch >= '1' && ch <= '9'){
                    k = ch - '0';
                    if(f[k]) return false;
                    f[k] = true;
                }
            }
        }
        for(i = 0; i < 9; i += 3){
            for(j = 0; j < 9; j += 3){
                Arrays.fill(f, false);
                for(int x = 0; x < 3; ++x){
                    for(int y = 0; y < 3; ++y){
                        ch = board[i + x][j + y];
                        if(ch >= '1' && ch <= '9'){
                            k = ch - '0';
                            if(f[k]) return false;
                            f[k] = true;
                        }
                    }
                }
            }
        }
        return true;
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
		sol.isValidSudoku(chs);
		int d = 20;
		d %= 3;
		System.out.println(Integer.MAX_VALUE);
	}
}