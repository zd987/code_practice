package leetcode.calculateMinimumHP;

import java.util.Arrays;

/**
 * Created by zd987 on 2015/1/25.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[] f = new int[col + 1];
        for(int i = row - 1; i >= 0; i--) {
            for(int j = col - 1; j >= 0; j--) {
                int c = dungeon[i][j];
                if(i == row - 1 && j == col - 1) {
                    f[j] = Math.max(1, 1 - c);
                } else if(i == row - 1) {
                    f[j] = Math.max(1, f[j + 1] - c);
                } else if(j == col - 1) {
                    f[j] = Math.max(1, f[j] - c);
                } else {
                    int t = Math.min(f[j], f[j + 1]);
                    f[j] = Math.max(1, t - c);
                }
            }
        }
        return f[0];
    }
}