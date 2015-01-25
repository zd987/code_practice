package leetcode.maxProduct;

/**
 * Created by zd987 on 2014/12/9.
 */
public class Solution {
    public int maxProduct(int[] A) {
        long max = A[0];
        long positive = 0, negative = 0;
        if(A[0] > 0) {
            positive = A[0];
        } else {
            negative = A[0];
        }
        for(int i = 1; i < A.length; ++i) {
            if(A[i] == 0) {
                max = Math.max(max, 0);
                positive = 0;
                negative = 0;
            } else if(A[i] > 0) {
                positive = Math.max(positive * A[i], A[i]);
                negative = negative * A[i];
            } else {
                long tmp = negative;
                negative = Math.min(positive * A[i], A[i]);
                positive = tmp * A[i];
            }
            if(positive > 0) {
                max = Math.max(positive, max);
            }
        }
        return (int)max;
    }
}
