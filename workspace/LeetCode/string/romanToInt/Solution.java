/**
* Copyright ? Dec 5, 2013 
* LeetCode 7:18:38 AM
* Version 1.0
* All right reserved.
*
*/

package string.romanToInt;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 7:18:38 AM
 * Version: 1.0
 */
public class Solution {
    public int romanToInt(String s) {
        int i, j, k, n = s.length(), re = 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        k = 9999;
        for(i = 0; i < n; ++i){
            j = m.get(s.charAt(i));
            re += j;
            if(k < j) re -= 2 * k;
            k = j;
        }
        return re;
    }
}