/**
* Copyright ? Dec 5, 2013 
* LeetCode 10:58:36 PM
* Version 1.0
* All right reserved.
*
*/

package array.candy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 10:58:36 PM
 * Version: 1.0
 */
public class Solution {
    class Item implements Comparable<Item>{
        int pos, val;
        public Item(int pos, int val){
            this.pos = pos;
            this.val = val;
        }
        @Override
        public int compareTo(Item it){
            return this.val - it.val;
        }
    }
    public int candy(int[] ratings) {
        PriorityQueue<Item> q = new PriorityQueue<Item>();
        int i, j, k, n = ratings.length, re = 0;
        if(n == 0) return 0;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for(i = 0; i < n; ++i){
            q.offer(new Item(i, ratings[i]));
        }
        while(!q.isEmpty()){
            Item it = q.poll();
            i = it.pos;
            if(i > 0 && ratings[i - 1] < ratings[i]) f[i] = Math.max(f[i], f[i - 1] + 1);
            if(i < n - 1 && ratings[i + 1] < ratings[i]) f[i] = Math.max(f[i], f[i + 1] + 1);
        }
        for(i = 0; i < n; ++i) re += f[i];
        return re;
    }
}