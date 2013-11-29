/**
* Copyright ? Nov 29, 2013 
* LeetCode 7:12:10 AM
* Version 1.0
* All right reserved.
*
*/

package numDecodings;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 29, 2013 7:12:10 AM
 * Version: 1.0
 */
public class Solution {
	public int numDecodings2(String s) {
        int i, j, k, n = s.length();
        if(n == 0) return 0;
        int[] f = new int[n + 1];
        f[n] = 1;
        for(i =n - 1; i >= 0; --i){
            if(s.charAt(i) == '0') {
                f[i] = 0;
                continue;
            }
            if(i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))){
                f[i] = f[i + 1] + f[i + 2];
            } else if(i < n - 1 && s.charAt(i + 1) == '0') {
                return 0;
            } else {
                f[i] = f[i + 1];
            }
        }
        return f[0];
    }
	public int numDecodings3(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return 0;
        int i, j, k, n = s.length();
        int[] f = new int[n + 2];
        f[n] = 1; 
        for(i = n -1; i >= 0; --i){
            if(s.charAt(i) == '0') f[i] = 0;
            else if(i == n - 1 || s.charAt(i) > '2') f[i] = f[i + 1];
            else if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) f[i] = f[i + 1] + f[i + 2];
            else f[i] = f[i + 1];
        }
        return f[0];
    }
	public int numDecodings(String s) {
        int i, j, k, n = s.length(), cur = 1, prev = 0;
        if(n == 0 || s.charAt(0) == '0') return 0;
        for(i = 0; i < n; ++i){
            if(s.charAt(i) == '0') cur = 0;
            if(i < 1 || !(s.charAt(i - 1) == '1' ||(s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) prev = 0;
            int tmp = cur;
            cur += prev;
            prev = tmp;
            if(prev + cur == 0) break;
        }
        return cur;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] f = new int[10][10];
		sol.numDecodings("110");
	}
}