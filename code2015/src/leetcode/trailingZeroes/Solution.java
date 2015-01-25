package leetcode.trailingZeroes;

/**
 * Created by zd987 on 2015/1/25.
 */
public class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        int k = 5;
        while(n / 5 > 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
}
