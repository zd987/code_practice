/**
* Copyright ? Nov 26, 2013 
* LeetCode 7:48:19 PM
* Version 1.0
* All right reserved.
*
*/

package sqrt;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 26, 2013 7:48:19 PM
 * Version: 1.0
 */
public class Solution {
	double eps = 0.000001;
    public int sqrt2(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	double d = 1.0;
        while(Math.abs(d * d - x) > eps){
            d = d - (d * d - x) / (2 * d);
        }
        return (int)d;
    }
    public int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(x == 1) return 1;
        double high, low;
        if(x > 1){
            low = 1; 
            high = x;
        } else {
            low = x;
            high = 1;
        }
        double mid = (high + low) / 2;
        while(Math.abs(mid * mid - x) > eps){
            if(mid * mid > x){
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        int re = (int)mid;
        if((long)(re + 1) * (re + 1) <= (long)x) ++re;
        return re;
    }
    public int sqrt3(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x <= 1) return x;
        long low = 1, high = x, mid;
        while(low <= high){
            mid = (low + high) / 2;
            long tmp = mid * mid;
            if(tmp == x){
                return (int)mid;
            } else if(tmp < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)high;
    }
	public static void main(String[] args){
		Solution sol = new Solution();
		sol.sqrt(4);
	}
}
