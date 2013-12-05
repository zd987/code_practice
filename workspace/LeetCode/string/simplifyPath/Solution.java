/**
* Copyright ? Dec 5, 2013 
* LeetCode 7:40:06 AM
* Version 1.0
* All right reserved.
*
*/

package string.simplifyPath;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 7:40:06 AM
 * Version: 1.0
 */
public class Solution {
	public String simplifyPath(String path) {
        Deque<String> s = new ArrayDeque<String>();
        String[] tokens = path.split("/");
        for(String token : tokens){
            if(token.length() == 0 || token.equals(".")) continue;
            else if(token.equals("..")) {
            	if(!s.isEmpty()) s.removeLast();
            }
            else s.addLast(token);
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append("/");
            sb.append(s.removeFirst());
        }
        if(sb.length() == 0) sb.append('/');
        return sb.toString();
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.simplifyPath("/...");
	}
}
