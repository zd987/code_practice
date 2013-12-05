/**
* Copyright ? Dec 5, 2013 
* LeetCode 7:06:57 AM
* Version 1.0
* All right reserved.
*
*/

package string.intToRoman;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 7:06:57 AM
 * Version: 1.0
 */
public class Solution {
    public String intToRoman(int num) {
        String[] m = {"IV", "XL", "CD", "M"};
        int i, j, k = 0;
        String re = "";
        while(num > 0){
            j = num % 10;
            StringBuilder sb = new StringBuilder();
            if(j >= 1 && j <= 3){
                for(i = 0; i < j; ++i) sb.append(m[k].charAt(0));
            } else if(j == 4){
                sb.append(m[k].charAt(0));
                sb.append(m[k].charAt(1));    
            } else if(j >= 5 && j <= 8){
                sb.append(m[k].charAt(1));
                for(i = 6; i <= j; ++i) sb.append(m[k].charAt(0));
            } else if(j == 9){
                for(i = j; i < 10; ++i) sb.append(m[k].charAt(0));
                sb.append(m[k + 1].charAt(0));
            }
            re = sb.toString() + re;
            ++k;
            num /= 10;
        }
        return re;
    }
    public static void main(String[] args) {
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		int x = m.get("ds");
		System.out.println(x);
	}
}