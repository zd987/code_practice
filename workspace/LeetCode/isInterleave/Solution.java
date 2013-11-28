/**
* Copyright ? Nov 28, 2013 
* LeetCode 8:31:55 AM
* Version 1.0
* All right reserved.
*
*/

package isInterleave;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 28, 2013 8:31:55 AM
 * Version: 1.0
 */
public class Solution {
    class Item{
        int p1, p2, p3, hashCode;
        public Item(int p1, int p2, int p3){
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            hashCode = p1;
            hashCode = hashCode * 31 + p2;
            hashCode = hashCode * 31 + p3;
        }
        @Override
        public boolean equals(Object o){
            if(o == null) return this == null;
            if(o == this) return true;
            if(o instanceof Item){
                Item it = (Item) o;
                return this.p1 == it.p1 && this.p2 == it.p2 && this.p3 == it.p3;
            }
            return false;
        }
        @Override
        public int hashCode(){
            return hashCode;
        }
    }
    private boolean r(String s1, String s2, String s3, int p1, int p2, int p3, HashMap<Item, Boolean> m){
        Item it = new Item(p1, p2, p3);
        Boolean re = m.get(it);
        if(re != null) return re;
        if(p3 == 0) return true;
        re = false;
        if(p1 > 0 && s1.charAt(p1 - 1) == s3.charAt(p3 - 1)){
            re = r(s1, s2, s3, p1 - 1, p2, p3 - 1, m);
        }
        if(!re && p2 > 0 && s2.charAt(p2 - 1) == s3.charAt(p3 - 1)){
            re = r(s1, s2, s3, p1, p2 - 1, p3 - 1, m);
        }
        m.put(it, re);
        return re;
    }
    public boolean isInterleave2(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s3.length() != s1.length() + s2.length()) return false;
        HashMap<Item, Boolean> m = new HashMap<Item, Boolean> ();
        return r(s1, s2, s3, s1.length(), s2.length(), s3.length(), m);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k, n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n3 != n1 + n2) return false;
        boolean[][] f = new boolean[n1 + 1][n2 + 1];
        f[0][0] = true;
        for(i = 1; i <= n1; ++i){
            f[i][0] = f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for(i = 1; i <= n2; ++i){
            f[0][i] = f[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for(i = 1; i <= n1; ++i){
            for(j = 1; j <= n2; ++j){
                f[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j])
                    ||(s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]);
            }
        }
        return f[n1][n2];
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] f = new int[2][3];
		f[0][2] = 1;
		System.out.println(sol.isInterleave("aabc", "abad", "aabadabc"));
	}
}
