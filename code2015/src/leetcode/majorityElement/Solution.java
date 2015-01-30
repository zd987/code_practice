package leetcode.majorityElement;

/**
 * Created by zd987 on 2015/1/26.
 */
public class Solution {
    public int majorityElement(int[] num) {
        int k = num[0], cnt = 1;
        for(int i = 1; i < num.length; i++) {
            if(num[i] == k) {
                ++cnt;
            } else {
                cnt--;
                if(cnt < 0) {
                    k = num[i];
                    cnt = 1;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,2};
        System.out.println(new Solution().majorityElement(num));
    }
}
