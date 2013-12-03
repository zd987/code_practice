/**
* Copyright ? Dec 3, 2013 
* LeetCode 7:57:14 AM
* Version 1.0
* All right reserved.
*
*/

package details.multiply;

import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 7:57:14 AM
 * Version: 1.0
 */
public class Solution {
    private int[] multiply(int[] a, int[] b){
        if(a.length > b.length) return multiply(b, a);
        int i, j, k, na = a.length, nb = b.length;
        int[] re = new int[na + nb];
        Arrays.fill(re, 0);
        for(i = 0; i < na; ++i){
            int c= 0, cur = a[i];
            for(j = 0; j < nb; ++j){
                k = c + cur * b[j] + re[i + j];
                re[i + j] = k % 10;
                c = k / 10;
            }
            re[i + j] = c;
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {9, 9};
		int[] b = {9, 9};
		//sol.multiply(a, b);
		System.out.println(sol.multiply("99", "99"));
	}
    public String multiply(String num1, String num2) {
        boolean neg = false;
        if(num1.charAt(0) == '-') {
            neg = !neg;
            num1 = num1.substring(1);
        }
        if(num2.charAt(0) == '-') {
            neg = !neg;
            num2 = num2.substring(1);
        }
        int i, j, k, na = num1.length(), nb = num2.length();
        int[] re = new int[na + nb];
        Arrays.fill(re, 0);
        for(i = 0; i < na; ++i){
            int c= 0, cur = num1.charAt(na - i - 1) - '0';
            for(j = 0; j < nb; ++j){
                int t = num2.charAt(nb - j - 1) - '0';
                k = c + cur * t + re[i + j];
                re[i + j] = k % 10;
                c = k / 10;
            }
            re[i + j] = c;
        }
        for(i = re.length - 1; i >= 0 && re[i] == 0; --i) ;
        StringBuilder sb = new StringBuilder();
        if(neg) sb.append('-');
        for(; i >= 0; --i) sb.append(re[i]);
        if(sb.length() == 0 || (sb.length() == 1 && sb.charAt(0) == '-')) return "0";
        return sb.toString();
    }
}