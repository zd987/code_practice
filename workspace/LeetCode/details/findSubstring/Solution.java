/**
* Copyright ? Dec 3, 2013 
* LeetCode 8:44:49 AM
* Version 1.0
* All right reserved.
*
*/

package details.findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 8:44:49 AM
 * Version: 1.0
 */
public class Solution {
	//WRONG ANSWER!
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        int i, j, k, ns = S.length(), nl = L.length, len = L[0].length();
        HashMap<String, Integer> m1 = new HashMap<String, Integer>();
        HashMap<String, Integer> m2 = new HashMap<String, Integer>();
        ArrayList<Integer> re = new ArrayList<Integer>();
        for(String str : L) {
        	Integer cnt = m1.get(str);
        	if(cnt == null) cnt = 0;
        	m1.put(str, cnt + 1);
        }
        for(i = 0; i <= ns - nl * len; ++i){
        	if(i == 13){
        		int asfd = 1;
        	}
            String ss = S.substring(i, i + len);
            Integer cnt = m1.get(ss);
            if(cnt != null){
                m2.clear();
                m2.put(ss, 1);
                k = 1;
                j = i + len;
                while(k != nl){
                    String str = S.substring(j, j + len); j += len;
                    Integer c1 = m1.get(str);
                    Integer c2 = m2.get(str);
                    if(c2 == null) c2 = 0;
                    if(c1 != null && c2 < c1) {
                    	m2.put(str, c2 + 1);
                    	++k;
                    } else break;
                }
                if(k == nl) re.add(i);
            }
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] L = {"fooo","barr","wing","ding","wing"};
		sol.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", L);
	}
}