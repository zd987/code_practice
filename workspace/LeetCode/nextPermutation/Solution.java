/**
* Copyright ? Dec 1, 2013 
* LeetCode 6:53:05 AM
* Version 1.0
* All right reserved.
*
*/

package nextPermutation;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 6:53:05 AM
 * Version: 1.0
 */
public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length < 2) return;
        int i, j = -1, k, n = num.length;
        for(i = n - 2; i >= 0; --i){
            if(num[i] < num[i + 1]) {
                for(j = i + 1; j < n; ++j){
                    if(num[j] <= num[i]) {
                        break;
                    }
                }
                --j;
                break;
            }
        }
        if(i >= 0) {
            k = num[i];
            num[i] = num[j];
            num[j] = k;
        }
        Arrays.sort(num, i + 1, n);
    }
}