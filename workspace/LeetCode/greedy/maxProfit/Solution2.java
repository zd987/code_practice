/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:19:29 AM
* Version 1.0
* All right reserved.
*
*/

package greedy.maxProfit;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:19:29 AM
 * Version: 1.0
 */
public class Solution2 {
	public int maxProfit(int[] prices) {
        int i, j, k, re = 0;
        for(i = 0; i < prices.length; ++i){
            if(i > 0 && prices[i] > prices[i - 1]) {
                re += prices[i] - prices[i - 1];
            }
        }
        return re;
    }
}
