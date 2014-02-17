package bfs.solve;

import java.util.LinkedList;
import java.util.Queue;

class Item{
    int x, y;
    public Item(int x, int y){
        this.x = x; 
        this.y = y;
    }
}
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int i, j, k, m = board.length, n = board[0].length;
        Queue<Item> q = new LinkedList<Item>();
        for(i = 0; i < m; ++i){
            if(board[i][0] == 'O') q.offer(new Item(i, 0));
            if(board[i][n - 1] == 'O') q.offer(new Item(i, n - 1));
        }
        for(i = 0; i < n; ++i){
            if(board[0][i] == 'O') q.offer(new Item(0, i));
            if(board[m - 1][i] == 'O') q.offer(new Item(m - 1, i));
        }
        while(!q.isEmpty()){
            Item it = q.poll();
            if(it.x < 0 || it.x >= m) continue;
            if(it.y < 0 || it.y >= n) continue;
            if(board[it.x][it.y] == 'O') {
                board[it.x][it.y] = 'P';
                q.offer(new Item(it.x - 1, it.y));
                q.offer(new Item(it.x + 1, it.y));
                q.offer(new Item(it.x, it.y - 1));
                q.offer(new Item(it.x, it.y + 1));
            }
        }
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(board[i][j] == 'P') board[i][j] = 'O';
            }
        }
    }
}