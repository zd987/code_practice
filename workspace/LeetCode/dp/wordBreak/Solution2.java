/**
* Copyright ? Nov 30, 2013 
* LeetCode 12:31:56 PM
* Version 1.0
* All right reserved.
*
*/

package dp.wordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 12:31:56 PM
 * Version: 1.0
 */
public class Solution2 {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int i, j, k, n = s.length();
        boolean[] f = new boolean[n + 1];
        boolean[][] prev = new boolean[n + 1][n + 1];
        f[0] = true;
        for(i = 1; i <= n; ++i){
            for(j = i - 1; j >= 0; --j){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    prev[j][i] = true;
                }
            }
        }
        ArrayList<String> re = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
		buildPath(s, prev, re, s.length(), list);
		return re;
    }
    private void buildPath(String s, boolean[][] prev, ArrayList<String> re, int cur, ArrayList<String> list){
        if(cur == 0){
            StringBuilder sb = new StringBuilder();
            for(int i = list.size() - 1; i >= 0; --i){
                sb.append(list.get(i));
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            re.add(sb.toString());
            return;
        }
        for(int i = 0; i <= cur; ++i){
            if(prev[i][cur]){
                list.add(s.substring(i, cur));
                buildPath(s, prev, re, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		ArrayList<String> re = sol.wordBreak(s, dict);
		for(String str: re){
			System.out.println(str);
		}
	}
}
