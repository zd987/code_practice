/**
* Copyright ? Nov 27, 2013 
* LeetCode 9:58:48 PM
* Version 1.0
* All right reserved.
*
*/

package maxProfit;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 27, 2013 9:58:48 PM
 * Version: 1.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k, n = prices.length, re = 0;
        int[] f = new int[n]; k = Integer.MAX_VALUE; j = 0;
        for(i = 0; i < n; ++i){
            if(prices[i] - k > j){
                j = prices[i] - k;
            }
            re = Math.max(re, j);
            f[i] = j;
            k = Math.min(k, prices[i]);
        }
        k = -1;
        for(i = n - 1; i > 0; --i){
            if(k - prices[i] + f[i - 1]> re){
                re = k - prices[i] + f[i - 1];
            }
            k = Math.max(k, prices[i]);
        }
        return re;
    }
    
    public static void main(String[] args){
    	int[] p = {1, 2};
    	Solution sol = new Solution();
    	sol.maxProfit(p);
    }
}
