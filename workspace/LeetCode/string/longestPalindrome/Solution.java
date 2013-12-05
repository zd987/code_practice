/**
* Copyright ? Dec 5, 2013 
* LeetCode 6:08:33 AM
* Version 1.0
* All right reserved.
*
*/

package string.longestPalindrome;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 6:08:33 AM
 * Version: 1.0
 */
public class Solution {
    public String longestPalindrome(String s) {
        int p, i, j, k, max = 0, n = s.length();
        String re = "";
        for(p = 0; p < n; ++p){
            k = 1; i = p - 1; j = p + 1;
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                --i;
                ++j;
                k += 2;
            }
            if(k > max){
            	max = k;
            	re = s.substring(i + 1, i + k + 1);
            }
            k = 0; i = p; j = p + 1;
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                --i;
                ++j;
                k += 2;
            }
            if(k > max){
            	max = k;
            	re = s.substring(i + 1, i + k + 1);
            }
        }
        return re;
    }
}