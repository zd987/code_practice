/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:47:22 AM
* Version 1.0
* All right reserved.
*
*/

package greedy.maxArea;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:47:22 AM
 * Version: 1.0
 */
public class Solution {
    public int maxArea2(int[] height) {
        int i, j, k, n = height.length, re = 0;
        if(n < 2) return 0;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = -1;
        for(i = 0; i < n; ++i){
            j = i - 1;
            while(j >= 0 && height[j] <= height[i]) j = l[j];
            l[i] = j;
        }
        r[n - 1] = n;
        for(i = n - 1; i >= 0; --i){
            j = i + 1;
            while(j < n && height[j] <= height[i]) j = r[j];
            r[i] = j;
        }
        for(i = 0; i < n; ++i){
            j = n - 1;
            while(j >= 0 && height[j] < height[i]) j = l[j];
            if(j >= 0) re = Math.max((j - i) * height[i], re);
            j = 0;
            while(j < n && height[j] < height[i]) j = r[j];
            if(j < n)  re = Math.max((i - j) * height[i], re);
        }
        return re;
    }
    public int maxArea(int[] height) {
        int i, j, k, n = height.length, re = 0;
        if(n < 2) return 0;
        int l = 0, r = n - 1;
        while(l < r){
            if(height[l] < height[r]) {
                re = Math.max(re, (r - l) * height[l++]);
            } else {
                re = Math.max(re, (r - l) * height[r--]);
            }
        }
        return re;
    }
}