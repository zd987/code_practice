/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:25:32 PM
* Version 1.0
* All right reserved.
*
*/

package divideConquer.pow;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:25:32 PM
 * Version: 1.0
 */
public class Solution {
    public double pow(double x, int n) {
        if(n == 0) return 1.0;
        long ln = n;
        boolean neg = ln < 0;
        ln = Math.abs(ln);
        double re = 1.0;
        ArrayList<Double> f = new ArrayList<Double>();
        long k = 1;
        while(k <= ln){
            if((k & ln) > 0) re *= x;
            k = k << 1;
            x *= x;
        }
        if(neg) re = 1.0 / re;
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.pow(2, -4));
	}
}