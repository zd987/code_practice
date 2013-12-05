/**
* Copyright ? Dec 5, 2013 
* LeetCode 10:00:25 PM
* Version 1.0
* All right reserved.
*
*/

package array.canCompleteCircuit;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 10:00:25 PM
 * Version: 1.0
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i, j, k = 0, n = gas.length, cnt;
        i = 0; j = 0; cnt = 0;
        while(i < n && cnt < n){
            ++cnt;
            k += gas[j] - cost[j];
            if(k < 0) {
                while(i <= j) {
                    k -= gas[i] - cost[i];
                    ++i;
                    --cnt;
                }
            }
            j = (j + 1) % n;
        }
        return cnt == n && k >= 0 ? i : -1;
    }
}