package leetcode.findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zd987 on 2015/2/7.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> cm = new HashMap<Character, Integer>();
        cm.put('A', 0);
        cm.put('C', 1);
        cm.put('G', 2);
        cm.put('T', 3);
        List<String> ret = new ArrayList<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < s.length() - 10; i++) {
            int t = 0;
            for (int j = 0; j < 10; j++) {
                t = t * 4 + cm.get(s.charAt(i + j));
            }
            Integer cnt = map.get(t);
            if (null == cnt) {
                map.put(t, 1);
            } else if (cnt == 1) {
                ret.add(s.substring(i, i + 10));
                map.put(t, 2);
            } else {
                map.put(t, cnt + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
