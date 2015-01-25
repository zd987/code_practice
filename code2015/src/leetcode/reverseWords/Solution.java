package leetcode.reverseWords;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zd987 on 2014/12/9.
 */
public class Solution {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.split(" +"));
        if(list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int i = list.size() - 1; i >= 0; --i) {
            if(list.get(i).length() > 0) {
                if(first) {
                    first = false;
                } else {
                    sb.append(" ");
                }
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}