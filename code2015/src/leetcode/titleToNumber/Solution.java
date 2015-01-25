package leetcode.titleToNumber;

/**
 * Created by zd987 on 2015/1/25.
 */
public class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        for(char c : s.toCharArray()) {
            ret = ret * 26 + (c - 'A' + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.titleToNumber("AA"));
    }
}