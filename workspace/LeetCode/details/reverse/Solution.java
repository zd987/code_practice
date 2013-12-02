/**
* Copyright ? Dec 2, 2013 
* LeetCode 9:17:41 PM
* Version 1.0
* All right reserved.
*
*/

package details.reverse;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 9:17:41 PM
 * Version: 1.0
 */
public class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        long re = x;
        re = Math.abs(re);
        while(x > 0){
            re = re * 10 + x % 10;
            x /= 10;
        }
        if(neg) re = -re;
        if(re < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(re > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)re;
    }
}