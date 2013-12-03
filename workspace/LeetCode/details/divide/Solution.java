/**
* Copyright ? Dec 3, 2013 
* LeetCode 8:42:16 PM
* Version 1.0
* All right reserved.
*
*/

package details.divide;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 8:42:16 PM
 * Version: 1.0
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = false;
        if((dividend < 0 && divisor > 0)|| (dividend > 0 && divisor < 0)) neg = true;
        long d1 = dividend, d2 = divisor, d, re = 0, k = 1;
        int i, j;
        d1 = Math.abs(d1);
        d2 = Math.abs(d2);
        d = d2;
        while(d1 >= d2){
            while(d1 < d && d > d2) {
                d = d >> 1;
                k = k >> 1;
            }
            d1 -= d;
            re += k;
            d = d << 1;
            k = k << 1;
        }
        if(neg) re = -re;
        return (int)re;
    }
}