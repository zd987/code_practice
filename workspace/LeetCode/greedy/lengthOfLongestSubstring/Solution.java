/**
* Copyright ? Dec 2, 2013 
* LeetCode 7:36:50 AM
* Version 1.0
* All right reserved.
*
*/

package greedy.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 7:36:50 AM
 * Version: 1.0
 */
public class Solution {
    public int lengthOfLongestSubstring2(String s) {
        int i, j, k, n = s.length(), re = 0, start = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                for(j = start; j < i; ++j){
                    if(set.contains(ch)) {
                        set.remove(s.charAt(j));
                    } else {
                        break;
                    }
                }
                start = j;
            }
            set.add(ch);
            re = Math.max(re, i - start + 1);
        }
        return re;
    }
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i, start = 0, max = 0;
        for(i = 0; i < s.length(); ++i){
            if(!map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i), i);
        	} else {
        		start = Math.max(start, map.get(s.charAt(i)) + 1);
        		map.put(s.charAt(i), i);
        	}
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}