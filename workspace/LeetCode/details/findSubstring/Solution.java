/**
* Copyright ? Dec 3, 2013 
* LeetCode 8:44:49 AM
* Version 1.0
* All right reserved.
*
*/

package details.findSubstring;

import java.util.ArrayList;
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
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        ArrayList<Integer> re = new ArrayList<Integer>();
        for(String str : L) set1.add(str);
        for(i = 0; i <= ns - nl * len; ++i){
            String ss = S.substring(i, i + len);
            if(set1.contains(ss)){
                set2.clear();
                set2.add(ss);
                j = i + len;
                while(set2.size() != nl){
                    String str = S.substring(j, j + len); j += len;
                    if(set1.contains(str) && !set2.contains(str)) set2.add(str);
                    else break;
                }
                if(set2.size() == nl) re.add(i);
            }
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] L = {"foo","bar"};
		sol.findSubstring("barfoothefoobarman", L);
	}
}