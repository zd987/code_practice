/**
* Copyright ? Dec 4, 2013 
* LeetCode 9:45:06 PM
* Version 1.0
* All right reserved.
*
*/

package stack.largestRectangleArea;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 9:45:06 PM
 * Version: 1.0
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        int i, j, k, n = height.length, re = 0;
        if(n == 0) return 0;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = -1;
        for(i = 1; i < n; ++i){
            j = i - 1;
            while(j >= 0 && height[j] >= height[i]) j = l[j];
            l[i] = j;
        }
        r[n - 1] = n;
        for(i = n - 2; i >= 0; --i){
            j = i + 1;
            while(j < n && height[j] >= height[i]) j = r[j];
            r[i] = j;
        }
        for(i = 0; i < n; ++i){
            k = height[i] * (r[i] - l[i] - 1);
            re = Math.max(re, k);
        }
        return re;
    }
}