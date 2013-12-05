/**
* Copyright ? Nov 26, 2013 
* LeetCode 11:36:28 PM
* Version 1.0
* All right reserved.
*
*/

package string.isMatch;

/**
 * Class Description: Wildcard Matching
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 26, 2013 11:36:28 PM
 * Version: 1.0
 */
public class Solution2 {
	public boolean isMatch2(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int ps = 0, pp = 0, i, j, k;
        boolean star = false;
        while(ps < s.length() && pp < p.length()){
            if(p.charAt(pp) == '*') {
                star = true;
                ++pp;
            } else {
                if(p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(ps)){
                    if(!star) {
                        ++ps; ++pp;
                    } else {
                        boolean flag = false;
                        for(i = 1; i + ps < s.length() && i + pp < p.length(); ++i){
                            if(p.charAt(pp + i) == '*') {
                                pp += i;
                                ps += i;
                                flag = true;
                                break;
                            } else {
                                if(p.charAt(pp + i) != '?' && p.charAt(pp + i) != s.charAt(ps + i)){
                                    flag = true;
                                    ++ps;
                                    break;
                                }
                            }
                        }
                        if(!flag){
                            if(i + ps == s.length()) {
                                while(i + pp < p.length() && p.charAt(i + pp) == '*') ++i;
                                return i + pp == p.length();
                            } else {
                                ++ps;
                            }
                        }
                    }
                } else {
                    if(!star) return false;
                    else ++ps;
                }
            }
        }
        if(ps == s.length()){
            while(pp < p.length() && p.charAt(pp) == '*') ++pp;
            return pp == p.length();
        }
        return p.length() > 0 && p.charAt(pp - 1) == '*';
    }
	
	public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		int ps = 0, pp = 0, is, ip;
        boolean star = false;
        for(is = 0, ip = 0; ps + is < s.length(); ++is, ++ip){
            if(pp + ip == p.length()) {
                if(!star) return false;
                else {ps++; is = -1; ip = -1;continue;}
            }
            switch(p.charAt(pp + ip)){
            case '?': break;
            case '*':
                star = true;
                ps += is;
                pp += ip;
                while(pp < p.length() && p.charAt(pp) == '*') ++pp;
                if(pp == p.length()) return true;
                is = -1; ip = -1;
                break;
            default:
                if(p.charAt(pp + ip) != s.charAt(ps + is)){
                    if(!star) return false;
                    else {ps++; is = -1; ip = -1;}
                }
            }
        }
        while(pp + ip < p.length() && p.charAt(pp + ip) == '*') ++ip;
        return pp + ip == p.length();
    }
	
	/**
	 * Method Description: 
	 * Author: zd987 
	 * Project Name: LeetCode
	 * Class Name: Solution2.java
	 * Version: 1.0
	 * Create Time: Nov 26, 2013 11:36:28 PM
	 * @param args void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 sol = new Solution2();
		System.out.println(sol.isMatch("hi", "*?"));
	}

}
