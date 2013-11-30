/**
* Copyright ? Nov 28, 2013 
* LeetCode 9:27:42 PM
* Version 1.0
* All right reserved.
*
*/

package dp.isScramble;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 28, 2013 9:27:42 PM
 * Version: 1.0
 */
public class Solution {
    class Item{
        String s1;
        String s2;
        int hashCode;
        public Item(String s1, String s2){
            this.s1 = s1;
            this.s2 = s2;
            hashCode = s1.hashCode() * 31 + s2.hashCode();
        }
        @Override
        public int hashCode(){
            return hashCode;
        }
        @Override
        public boolean equals(Object o){
            if(o == null) return this == null;
            if(o == this) return true;
            if(o instanceof Item){
                Item it = (Item)o;
                return this.s1.equals(it.s1) && this.s2.equals(it.s2);
            }
            return false;
        }
    }
    private boolean r(String s1, String s2, HashMap<Item, Boolean> m){
        Item it = new Item(s1, s2);
        Boolean re = m.get(it);
        if(re != null) return re;
        if(s1.equals(s2)) {
            m.put(it, true);
            return true;
        }
        re = false;
        int i, j, k;
        for(i = 0; i < s1.length() - 1; ++i){
            if((r(s1.substring(0, i + 1), s2.substring(0, i + 1), m) 
                && r(s1.substring(i + 1), s2.substring(i + 1), m))
            || (r(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1), m) 
                && r(s1.substring(i + 1), s2.substring(0, s2.length() - i - 1), m))) {
                re = true;
                break;
            } 
        }
        m.put(it, re);
        return re;
    }
    public boolean isScramble2(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s1.length() != s2.length()) return false;
        HashMap<Item, Boolean> m = new HashMap<Item, Boolean>();
        return r(s1, s2, m);
    }
    public boolean isScramble(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s1.length() != s2.length()) return false;
        int i, j, k, t, n = s1.length();
        boolean[][][] f = new boolean[n + 1][n][n];
        for(k = 0; k <= n; ++k){
            for(i = 0; i < n; ++i){
                for(j = 0; j < n; ++j){
                    if(k == 1){
                        f[1][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        f[k][i][j] = false;
                    }
                }
            }
        }
        for(k = 1; k <= n; ++k){
            for(i = 0; i <= n - k; ++i){
                for(j = 0; j <= n - k; ++j){
                    for(t = 1; t < k; ++t){
                        if((f[t][i][j] && f[k - t][i + t][j + t])
                        || (f[t][i][j +k - t] && f[k - t][i + t][j])){
                            f[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[n][0][0];
    }
}