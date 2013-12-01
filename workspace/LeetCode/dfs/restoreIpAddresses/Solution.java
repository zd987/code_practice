/**
* Copyright ? Dec 1, 2013 
* LeetCode 9:24:06 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.restoreIpAddresses;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 9:24:06 PM
 * Version: 1.0
 */
public class Solution {
	private void dfs(ArrayList<String> re, String s, ArrayList<String> cur, int k){
        if(s.length() == 0) return;
        if(k == 1) {
            if(s.length() > 3) return;
            if(s.length() > 1 && s.charAt(0) == '0') return;
            int n = Integer.parseInt(s);
            if(n > 255) return;
            re.add(String.format("%s.%s.%s.%s", cur.get(0), cur.get(1), cur.get(2), s));
            return;
        }
        if(s.charAt(0) == '0') {
            cur.add(s.substring(0, 1));
            dfs(re, s.substring(1), cur, k - 1);
            cur.remove(cur.size() - 1);
        } else {
            for(int i = 1; i <= 3 && i <= s.length() - k + 1; ++i){
                String ss = s.substring(0, i);
                int n = Integer.parseInt(ss);
                if(n > 255) continue;
                cur.add(ss);
                dfs(re, s.substring(i), cur, k - 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    public ArrayList<String> restoreIpAddresses2(String s) {
        ArrayList<String> re = new ArrayList<String>();
        ArrayList<String> cur = new ArrayList<String>();
        dfs(re, s, cur, 4);
        return re;
    }
    private ArrayList<String> helper(String s, int cnt){
        ArrayList<String> ans = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i <= Math.min(3, len); ++i){
            String s1 = s.substring(0, i), s2 = s.substring(i);
            int n = Integer.parseInt(s1);
            if(n >= 0 && n < 256 && (s.charAt(0) != '0' || s1.length() == 1)){
                if(cnt == 4 && i == len){
                    ans.add(s);
                } else if(cnt < 4){
                    for(String back : helper(s2, cnt + 1)){
                        ans.add(s1 + '.' + back);
                    }
                }
            }
        }
        return ans;
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        return helper(s, 1);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.restoreIpAddresses("1111");
	}
}