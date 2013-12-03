/**
* Copyright ? Dec 3, 2013 
* LeetCode 7:05:10 AM
* Version 1.0
* All right reserved.
*
*/

package details.minWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 7:05:10 AM
 * Version: 1.0
 */
public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int i, j, k = 0, ns = S.length(), nt = T.length(), start = -1, end = -1;
        Queue<Integer> q = new LinkedList<Integer>();
        for(i = 0; i < nt; ++i){
            Integer cnt = m.get(T.charAt(i));
            if(cnt == null) cnt = 0;
            m.put(T.charAt(i), cnt + 1);
        }
        k = m.size();
        for(i = 0, j = 0; i < ns; ++i) {
            char ch = S.charAt(i);
            Integer cnt = m.get(ch);
            if(cnt == null) continue;
            if(cnt == 1) --k;
            m.put(ch, cnt - 1);
            if(k == 0) {
            	while(j < i) {
            		char ch2 = S.charAt(j);
                    Integer cnt2 = m.get(ch2);
                    if(cnt2 != null) {
                    	m.put(ch2, cnt2 + 1);
                    	if(cnt2 == 0) {
                    		break;
                    	}
                    }
                    ++j;
            	}
                if(start < 0 || i - j < end - start){
                    start = j;
                    end = i;
                }
                ++k; ++j;
            }
        }
        return start < 0 ? "" : S.substring(start, end + 1);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.print(sol.minWindow("acbbaca", "aba"));
	}
}