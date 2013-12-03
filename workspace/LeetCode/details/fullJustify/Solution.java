/**
* Copyright ? Dec 3, 2013 
* LeetCode 9:01:38 PM
* Version 1.0
* All right reserved.
*
*/

package details.fullJustify;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 9:01:38 PM
 * Version: 1.0
 */
public class Solution {
	public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> re = new ArrayList<String>();
        int i, j, k, l, t, n = words.length, prev = 0, cnt; 
        if(n == 0){
            if(L == 0) {
                re.add("");
                return re;
            } else {
                char[] chs = new char[L];
                Arrays.fill(chs, ' ');
                re.add(new String(chs));
                return re;
            }
        }
        cnt = words[0].length();
        for(i = 1; i < n; ++i){
            if(i == n || cnt + words[i].length() + i - prev > L){
                k = i - prev - 1;
                int bc = L - cnt;
                StringBuilder sb = new StringBuilder();
                sb.append(words[prev]);
                if(k == 0) {
                    for(j = 0; j < bc; ++j) {
                        sb.append(' ');
                    }
                } else {
                    for(j = 1; j <= k; ++j){
                        for(l = 0; l < bc / k; ++l) sb.append(' ');
                        if(j <= bc % k) sb.append(' ');
                        sb.append(words[prev + j]);
                    }
                }
                re.add(sb.toString());
                prev = i; cnt = 0;
            }
            cnt += words[i].length();
        }
        StringBuilder sb = new StringBuilder();
        for(i = prev; i < n; ++i){
            sb.append(words[i]);
            sb.append(' ');
        }
        for(i = sb.length() - 1; i < L; ++i) sb.append(' ');
        re.add(sb.substring(0, L));
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] ss = {"a","b","c","d","e"};
		sol.fullJustify(ss, 1);
	}
}