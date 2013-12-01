/**
* Copyright ? Dec 1, 2013 
* LeetCode 7:41:42 PM
* Version 1.0
* All right reserved.
*
*/

package bfs.solve;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 7:41:42 PM
 * Version: 1.0
 */
public class Solution {
    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int i, j, k, m = board.length, n = board[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        for(i = 0; i < m; ++i){
            if(board[i][0] == 'O') q.offer(new Pair(i, 0));
            if(board[i][n - 1] == 'O') q.offer(new Pair(i, n - 1));
        }
        for(i = 1; i < n; ++i){
            if(board[0][i] == 'O') q.offer(new Pair(0, i));
            if(board[m - 1][i] == 'O') q.offer(new Pair(m - 1, i));
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x, y = p.y;
            if(board[x][y] != 'O') continue;
            board[x][y] = '+';
            if(x > 0 && board[x - 1][y] == 'O') q.offer(new Pair(x - 1, y));
            if(x < m - 1 && board[x + 1][y] == 'O') q.offer(new Pair(x + 1, y));
            if(y > 0 && board[x][y - 1] == 'O') q.offer(new Pair(x, y - 1));
            if(y < n - 1 && board[x][y + 1] == 'O') q.offer(new Pair(x, y + 1));
        }
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                board[i][j] = board[i][j] == '+' ? 'O' : 'X';
            }
        }
    }
}
