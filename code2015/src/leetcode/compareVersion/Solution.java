package leetcode.compareVersion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zd987 on 2015/1/30.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] va1 = version1.split("\\.");
        String[] va2 = version2.split("\\.");
        int k = Math.min(va1.length, va2.length);
        for(int i = 0; i < k; i++) {
            int v1 = Integer.parseInt(va1[i]);
            int v2 = Integer.parseInt(va2[i]);
            if(v1 < v2) {
                return -1;
            } else if(v1 > v2) {
                return 1;
            }
        }
        if(va1.length == va2.length) {
            return 0;
        } else if (va1.length < va2.length) {
            for(int i = k; i < va2.length; i++) {
                int v = Integer.parseInt(va2[i]);
                if(v > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            for(int i = k; i < va1.length; i++) {
                int v = Integer.parseInt(va1[i]);
                if(v > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1", "0"));
    }
}
