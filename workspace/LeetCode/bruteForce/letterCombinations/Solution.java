/**
* Copyright ? Dec 1, 2013 
* LeetCode 9:36:26 AM
* Version 1.0
* All right reserved.
*
*/

package bruteForce.letterCombinations;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 9:36:26 AM
 * Version: 1.0
 */
public class Solution {
    private void dfs(String d, String[] s, ArrayList<String> re, StringBuilder sb){
        if(d.length() == 0){
            re.add(sb.toString());
            return;
        }
        int pos = d.charAt(0) - '0';
        for(int i = 0; i < s[pos].length(); ++i){
            sb.append(s[pos].charAt(i));
            dfs(d.substring(1), s, re, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public ArrayList<String> letterCombinations2(String digits) {
        String[] s = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> re = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(digits, s, re, sb);
        return re;
    }   
    
    public ArrayList<String> letterCombinations(String digits) {
        String[] s = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> re = new ArrayList<String>();
        re.add("");
        for(char ch : digits.toCharArray()){
        	int p = ch - '0';
        	char[] chs = s[p].toCharArray();
        	int m = chs.length;
        	int n = re.size();
        	int i, j, k;
        	for(i = 0; i < m - 1; ++i){
        		for(j = 0; j < n; ++j){
        			re.add(re.get(j));
        		}
        	}
        	for(i = 0; i < m; ++i){
        		for(j = 0; j < n; ++j){
        			re.set(i * n + j, re.get(i * n + j) + chs[i]);
        		}
        	}
        }
        return re;
    }
    
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.letterCombinations("23");
	}
}