/**
* Copyright ? Dec 1, 2013 
* LeetCode 8:14:24 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.partition;

import java.util.*;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 8:14:24 PM
 * Version: 1.0
 */
public class Solution {
    private boolean isPalindrome(String s){
        if(s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }
    private ArrayList<ArrayList<String>> r(HashMap<String, ArrayList<ArrayList<String>>> m, String s){
        ArrayList<ArrayList<String>> re = m.get(s);
        if(re != null) return re;
        re = new ArrayList<ArrayList<String>>();
        if(isPalindrome(s)){
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add(s);
            re.add(tmp);
        }
        for(int i = 0; i < s.length() - 1; ++i){
        	String ll = s.substring(0, i + 1);
            if(!isPalindrome(ll)) continue;
            ArrayList<ArrayList<String>> right = r(m, s.substring(i + 1));
            for(ArrayList<String> rr : right){
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(ll);
                tmp.addAll(rr);
                re.add(tmp);
            }
        }
        m.put(s, re);
        return re;
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        HashMap<String, ArrayList<ArrayList<String>>> m = new HashMap<String, ArrayList<ArrayList<String>>>();
        return r(m, s);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		ArrayList<ArrayList<String>> re = sol.partition("aab");
		System.out.println(re);
	}
}