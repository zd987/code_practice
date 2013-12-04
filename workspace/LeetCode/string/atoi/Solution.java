/**
* Copyright ? Dec 4, 2013 
* LeetCode 11:27:26 PM
* Version 1.0
* All right reserved.
*
*/

package string.atoi;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 11:27:26 PM
 * Version: 1.0
 */
public class Solution {
	public int atoi(String str) {
        int i, j, k, n = str.length();
        long re = 0;
        boolean neg = false;
        for(i = 0; i < n; ++i) {
            if(str.charAt(i) != ' '){
                break;
            }
        }
        if(i == n) return 0;
        if(str.charAt(i) == '-'){
            neg = true;
            ++i;
        } else if(str.charAt(i) == '+'){
            ++i;
        }
        for(k = 0; i < n; ++i){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
            j = str.charAt(i) - '0';
            ++k;
            if(k > 11) break;
            re = re * 10 + j;
        }
        if(neg) re = -re;
        if(re > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(re < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)re;
    }
    public static void main(String[] args) {
    	long x = 2147483647 * 99;
		System.out.println((int)x);
	}
}