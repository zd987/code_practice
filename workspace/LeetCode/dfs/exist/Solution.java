/**
* Copyright ? Dec 2, 2013 
* LeetCode 6:18:58 AM
* Version 1.0
* All right reserved.
*
*/

package dfs.exist;

import java.util.HashSet;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 6:18:58 AM
 * Version: 1.0
 */
public class Solution {
    final class Pair{
        int x, y, c;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
            c = this.x * 31 + this.y;
        }
        @Override
        public boolean equals(Object o){
            if(o == this) return true;
            if(o == null) return false;
            if(o.getClass() != this.getClass()) return false;
            Pair p = (Pair) o;
            return this.x == p.x && this.y == p.y;
        }
        @Override
        public int hashCode() {return c;}
    }
    private boolean dfs(char[][] board, String word, int x, int y, HashSet<Pair> set){
        if(word.length() == 0) return true;
        if(x < 0 || x >= board.length) return false;
        if(y < 0 || y >= board[0].length) return false;
        Pair p = new Pair(x, y);
        if(!set.contains(p) && board[x][y] == word.charAt(0)) {
            String w = word.substring(1);
            set.add(p);
            if(dfs(board, w, x - 1, y, set) ||
                dfs(board, w, x + 1, y, set) ||
                dfs(board, w, x, y + 1, set) ||
                dfs(board, w, x, y - 1, set))
                return true;
            set.remove(p);
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board == null || board.length == 0 || board[0].length == 0) return  false;
        HashSet<Pair> set = new HashSet<Pair>();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(dfs(board, word, i, j, set)) return true;
            }
        }
        return false;
    }
}