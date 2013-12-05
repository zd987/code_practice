/**
* Copyright ? Dec 5, 2013 
* LeetCode 6:24:01 AM
* Version 1.0
* All right reserved.
*
*/

package string.strStr;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 6:24:01 AM
 * Version: 1.0
 */
public class Solution {
    void calc(String needle, int[] f){
        f[0] = 0;
        f[1] = 0;
        for(int i = 2; i <= needle.length(); ++i){
            int j = f[i - 1];
            while(true){
                if(needle.charAt(j) == needle.charAt(i - 1)){
                    f[i] = j + 1; break;
                }
                if(j == 0){
                    f[i] = 0; break;
                }
                j = f[j];
            }
        }
    }
    public String strStr(String haystack, String needle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(needle.length() == 0) return haystack;
        int[] f = new int[needle.length() + 1];
        calc(needle, f);
        int j = 0;
        for(int i = 0; i < haystack.length(); ++i){
            while(true){
                if(needle.charAt(j) == haystack.charAt(i)){
                    if(j + 1 == needle.length()){
                        return haystack.substring(i - j);
                    }
                    ++j;
                    break;
                } 
                if(j == 0) {
                    break;
                }
                j = f[j];
            }
        }
        return null;
    }
}