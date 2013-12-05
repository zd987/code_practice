/**
* Copyright ? Dec 5, 2013 
* LeetCode 9:22:39 PM
* Version 1.0
* All right reserved.
*
*/

package array.plusOne;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 9:22:39 PM
 * Version: 1.0
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int i, j, k, c = 1, n = digits.length;
        for(i = n - 1; i >= 0; --i){
            k = digits[i] + c;
            digits[i] = k % 10;
            c = k / 10;
        }
        k = c == 1 ? n + 1 : n;
        int[] re = new int[k];
        i = 0;
        if(c == 1) re[i++] = 1;
        for(j = 0; j < n; ++j){
            re[i + j] = digits[j];
        }
        return re;
    }
}