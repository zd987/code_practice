/**
* Copyright ? Dec 4, 2013 
* LeetCode 10:56:33 PM
* Version 1.0
* All right reserved.
*
*/

package string.isPalindrome;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 10:56:33 PM
 * Version: 1.0
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int i, j, k, n = s.length();
        i = 0; j = n - 1;
        char ch;
        HashMap<Character, Character> m = new HashMap<Character, Character>();
        for(ch = 'a'; ch <= 'z'; ++ch){
            m.put(ch, ch);
            m.put((char)(ch - 'a' + 'A'), ch);
        }
        for(ch = '0'; ch <= '9'; ++ch){
            m.put(ch, ch);
        }
        while(i < j){
            Character ch1 = m.get(s.charAt(i));
            if(ch1 == null) {
                ++i; 
                continue;
            }
            Character ch2 = m.get(s.charAt(j));
            if(ch2 == null){
                --j;
                continue;
            } 
            if(ch1 != ch2){
                return false;
            }
            ++i; --j;
        }
        return true;
    }
}