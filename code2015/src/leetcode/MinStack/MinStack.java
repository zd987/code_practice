package leetcode.MinStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zd987 on 2015/1/31.
 */
public class MinStack {
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> minList = new ArrayList<Integer>();

    public void push(int x) {
        list.add(x);
        if (minList.size() == 0) {
            minList.add(x);
        } else {
            minList.add(Math.min(x, minList.get(minList.size() - 1)));
        }
    }

    public void pop() {
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
        if (minList.size() > 0) {
            minList.remove(minList.size() - 1);
        }
    }

    public int top() {
        if (list.size() == 0) return 0;
        return list.get(list.size() - 1);
    }

    public int getMin() {
        if (minList.size() == 0) return 0;
        return minList.get(minList.size() - 1);
    }
}
