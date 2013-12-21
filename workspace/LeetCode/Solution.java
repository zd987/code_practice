import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int i, j, k, ns = S.length(), nt = T.length(), len = -1, re_start = -1, start = 0, cnt = 0;
        for(i = 0; i < nt; ++i){
            Integer t = m.get(T.charAt(i));
            if(t == null){
                t = 0;
            }
            m.put(T.charAt(i), t + 1);
        }
        for(i = 0; i < ns; ++i){
            if(m.containsKey(S.charAt(i))){
                Integer t = m.get(S.charAt(i));
                m.put(S.charAt(i), t - 1);
                if(t > 0){
                    cnt++;
                    if(cnt == nt){
                        for(j = start; j <= i; ++j){
                            Integer tmp = m.get(S.charAt(j));
                            if(tmp != null){
                                ++tmp;
                                m.put(S.charAt(j), tmp);
                                if(tmp > 0){
                                    break;
                                }
                            }
                        }
                        if(len == -1 || i - j + 1 < len){
                            len = i - j + 1;
                            re_start = j;
                        }
                        cnt--;
                        start = j + 1;
                    }
                }
            }
        }
        if(re_start != -1){
            return S.substring(re_start, re_start + len);
        } else {
            return "";
        }
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
	}
}