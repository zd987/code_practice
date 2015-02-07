package leetcode.findMin;

/**
 * Created by zd987 on 2015/1/31.
 */
public class Solution {
    public int findMin(int[] num) {
        if (num.length == 1) return num[0];
        if (num.length == 2) return Math.min(num[0], num[1]);
        if (num[0] < num[num.length - 1]) return num[0];
        int left = 0, right = num.length - 1;
        int re = num[right];
        while (left < right) {
            int mid = (left + right) / 2;
            re = Math.min(re, num[mid]);
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else if (num[mid] < num[right]) {
                right = mid - 1;
            }
        }
        re = Math.min(re, num[left]);
        return re;
    }
}
