package leetcode.fractionToDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zd987 on 2015/1/29.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        boolean neg = false;
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) neg = true;
        long ln = numerator;
        long ld = denominator;
        ln = Math.abs(ln);
        ld = Math.abs(ld);
        long integeral = ln / ld;
        long fraction = ln % ld;
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int index = 0;
        if(fraction != 0) {
            fraction *= 10;
            map.put(fraction, index);
            while (fraction != 0) {
                if (fraction < ld) {
                    sb.append('0');
                } else {
                    long k = fraction / ld;
                    fraction = fraction % ld;
                    sb.append(Long.toString(k));
                }
                index++;
                fraction *= 10;
                if (map.containsKey(fraction)) {
                    break;
                } else {
                    map.put(fraction, index);
                }
            }
        }

        String re = neg ? "-" : "";
        if(fraction != 0) {
            index = map.get(fraction);
            return re + String.format("%d.%s(%s)", integeral, sb.substring(0, index), sb.substring(index));
        } else {
            if(sb.length() == 0) {
                return re + integeral + "";
            } else {
                return re + String.format("%d.%s", integeral, sb);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
    }
}
