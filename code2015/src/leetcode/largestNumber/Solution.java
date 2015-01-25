package leetcode.largestNumber;

import java.util.*;

/**
 * Created by zd987 on 2015/1/25.
 */
public class Solution {
    public String largestNumber(int[] num) {
        Queue<String> queue = new PriorityQueue<String>(num.length, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.equals(o2)) {
                    return 0;
                }
                return - (o1 + o2).compareTo(o2 + o1);
            }
        });
        for(int i : num) {
            queue.offer(Integer.toString(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] num = {3,43,48,94,85,33,64,32,63,66};
        Solution s = new Solution();
        String ret = s.largestNumber(num);
        System.out.println(ret);
    }
}
