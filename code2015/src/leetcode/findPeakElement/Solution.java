package leetcode.findPeakElement;

/**
 * Created by zd987 on 2015/1/31.
 */
public class Solution {
    public int findPeakElement(int[] num) {
        int low = 0, high = num.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(num[mid] > get(num, mid - 1) && num[mid] < get(num, mid + 1)) {
                return mid;
            } else if(num[mid] < get(num, mid - 1)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    private int get(int[] num, int k) {
        if(k < 0 || k >= num.length) return Integer.MIN_VALUE;
        return num[k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[]{1, 2};
        System.out.println(s.findPeakElement(num));
    }
}
