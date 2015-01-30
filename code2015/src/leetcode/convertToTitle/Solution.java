package leetcode.convertToTitle;

/**
 * Created by zd987 on 2015/1/28.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append((char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(26));
    }
}
