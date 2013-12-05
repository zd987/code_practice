/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:29:40 PM
* Version 1.0
* All right reserved.
*
*/

package array.threeSumClosest;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:29:40 PM
 * Version: 1.0
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int i, j, k = Integer.MAX_VALUE, n = num.length, re = 0;
        Arrays.sort(num);
        for(i = 0; i < n - 2; ++i){
            if(i > 0 && num[i - 1] == num[i]) continue;
            for(j = i + 1; j < n - 1; ++j){
                if(j > i + 1 && num[j - 1] == num[j]) continue;
                int low = j + 1, high = n - 1, mid = -1, t = target - num[i] - num[j];
                while(low <= high){
                    mid = (low + high) / 2;
                    if(num[mid] == t) break;
                    else if(num[mid] > t) high = mid - 1;
                    else low = mid + 1;
                }
                if(low <= high) return target;
                if(low > j && low < n){
                    int tmp = num[i] + num[j] + num[low];
                    if(Math.abs(tmp - target) < k) {
                        k = Math.abs(tmp - target);
                        re = tmp;
                    }
                } 
                if(high > j && high < n){
                    int tmp = num[i] + num[j] + num[high];
                    if(Math.abs(tmp - target) < k) {
                        k = Math.abs(tmp - target);
                        re = tmp;
                    }
                }
            }
        }
        return re;
    }
}