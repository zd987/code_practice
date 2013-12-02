/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:15:27 AM
* Version 1.0
* All right reserved.
*
*/

package greedy.maxProfit;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:15:27 AM
 * Version: 1.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int i, j, min = Integer.MAX_VALUE, re = 0;
        for(i = 0; i < prices.length; ++i){
            re = Math.max(re, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return re;
    }
}