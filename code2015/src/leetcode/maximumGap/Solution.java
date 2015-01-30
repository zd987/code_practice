package leetcode.maximumGap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zd987 on 2015/1/30.
 */
public class Solution {
    public int maximumGap(int[] num) {
        if(num.length < 2) return 0;
        if(num.length == 2) {
            return Math.abs(num[0] - num[1]);
        }
        int[] minArr = new int[num.length - 1];
        int[] maxArr = new int[num.length - 1];
        Arrays.fill(minArr, -1);
        Arrays.fill(maxArr, -1);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n : num) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double len = (max - min) / ((double)num.length - 1);
        for(int n : num) {
            double diff = n - min;
            int k = (int)(diff / len);
            if(k >= num.length - 1) k = num.length - 2;
            minArr[k] = minArr[k] == -1 ? n : Math.min(minArr[k], n);
            maxArr[k] = maxArr[k] == -1 ? n : Math.max(maxArr[k], n);
        }
        int re = Integer.MIN_VALUE;
        int pre = -1;
        for(int i = 0; i < num.length - 1; i++) {
            if(maxArr[i] != -1) {
                if(pre != -1) {
                    re = Math.max(re, minArr[i] - maxArr[pre]);
                }
                pre = i;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{100,3,2,1};
        System.out.println(s.maximumGap(a));
    }
}
