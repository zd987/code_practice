/**
* Copyright ? Dec 5, 2013 
* LeetCode 7:26:26 AM
* Version 1.0
* All right reserved.
*
*/

package string.countAndSay;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 7:26:26 AM
 * Version: 1.0
 */
public class Solution {
    public String countAndSay(int n) {
        int i, j, k, cnt;
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for(k = 2; k <= n; ++k){
            StringBuilder cur = new StringBuilder();
            cnt = 0;
            for(i = 0; i < sb.length(); ++i){
                if(i > 0 && sb.charAt(i - 1) != sb.charAt(i)) {
                    cur.append(cnt);
                    cur.append(sb.charAt(i - 1));
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            cur.append(cnt);
            cur.append(sb.charAt(sb.length() - 1));
            sb = cur;
        }
        return sb.toString();
    }
}