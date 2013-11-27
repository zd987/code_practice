/**
 * 20130902
 */
package first;
import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] re = new int[2];
        int i;
        for(i = 0; i < numbers.length; ++i){
            if(map.containsKey(target - numbers[i])) {
        		re[0] = map.get(target - numbers[i]) + 1;
        		re[1] = i + 1;
        		break;
        	} else {
        		map.put(numbers[i], i);
        	}
        }
    	return re;
    }
    
    private int findK(int A[], int aBegin, int aSize, int B[], int bBegin, int bSize, int k){
        if(aSize == 0) {
    		return B[bBegin + k - 1];
    	}
    	if(bSize == 0) {
    		return A[aBegin + k - 1];
    	}
    	if(k == 1) {
    		return Math.min(A[aBegin], B[bBegin]);
    	}
    	int pa, pb;
    	pa = Math.min(k, aSize) / 2; pa = Math.max(pa, 1);
    	pb = Math.min(k, bSize) / 2; pb = Math.max(pb, 1);
    	if(A[aBegin + pa - 1] < B[bBegin + pb - 1]){
    		return findK(A, aBegin + pa, aSize - pa, B, bBegin, bSize, k - pa);
    	} 
        else{//}	if(B[bBegin + pb - 1] < A[aBegin + pa - 1]){
    		return findK(A, aBegin, aSize, B, bBegin + pb, bSize - pb, k - pb);
    	}
    //	return findK(A, aBegin + pa, aSize - pa, B, bBegin + pb - 1, bSize - pb + 1, k - pa - pb + 1);
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
//        if((A.length + B.length) % 2 == 1){
//        	return findK(A, 0, A.length, B, 0, B.length, (A.length + B.length) / 2 + 1);
//        } else {
//        	double re1 = findK(A, 0, A.length, B, 0, B.length, (A.length + B.length) / 2);
//        	double re2 = findK(A, 0, A.length, B, 0, B.length, (A.length + B.length) / 2 + 1);
//        	return (re1 + re2) / 2;
//        }
    	return findMedian(A, B, Math.max(1, (A.length + B.length + 1) / 2 - B.length), Math.min(A.length, (A.length + B.length + 1) / 2));
    }
    
    private double findMedian(int A[], int B[], int left, int right){
    	//not work yet.
    	
    	if(left > right){
    		return findMedian(B, A, Math.max(1, (A.length + B.length + 1) / 2 - A.length), Math.min(B.length, (A.length + B.length + 1) / 2));
    	}
    	int i = (left + right) / 2;
    	int j = (A.length + B.length + 1) / 2 - i - 1;
    	if(j >= 0 && A[i] < B[j]) {
    		return findMedian(A, B, i + 1, right);
    	}
    	else if(j < B.length - 1 && A[i] > B[j + 1]) {
    		return findMedian(A, B, left, i - 1);
    	} else {
    		if((A.length + B.length) % 2 == 1){
    			return A[i];
    		} else if(i > 0){
    			return 0.5 * (A[i] + Math.max(A[i - 1], B[j]));
    		} else {
    			return 0.5 * (A[i] + B[j]);
    		}
    	}
    }
    
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i, start = 0, max = 0;
        for(i = 0; i < s.length(); ++i){
            if(!map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i), i);
        	} else {
        		start = Math.max(start, map.get(s.charAt(i)) + 1);
        		map.put(s.charAt(i), i);
        	}
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null, cur = null;
        int sum, c = 0;
        while(l1 != null && l2 != null){
        	sum = l1.val + l2.val + c;
        	if(cur == null){
        		cur = new ListNode(sum % 10);
        		head = cur;
        	} else{
            	cur.next = new ListNode(sum % 10);
            	cur = cur.next;
        	}
        	c = sum / 10;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1 != null){
        	sum = l1.val + c;
        	if(cur == null){
        		cur = new ListNode(sum % 10);
        		head = cur;
        	} else{
            	cur.next = new ListNode(sum % 10);
            	cur = cur.next;
        	}
        	c = sum / 10;
        	l1 = l1.next;
        }
        while(l2 != null){
        	sum = l2.val + c;
        	if(cur == null){
        		cur = new ListNode(sum % 10);
        		head = cur;
        	} else{
            	cur.next = new ListNode(sum % 10);
            	cur = cur.next;
        	}
        	c = sum / 10;
        	l2 = l2.next;
        }
        if(c > 0){
        	cur.next = new ListNode(c);
        }
        return head;
    }
    
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String re = "";
        for (int i = 0; i < s.length(); ++i){
        	int k, j;
        	k = i - 1; j = i + 1;
        	while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)){
        		--k; ++j;
        	}
        	if(j - k - 1 > re.length()) {
        		re = s.substring(k + 1, j);
        	}
        	k = i; j = i + 1;
        	while(k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)){
        		--k; ++j;
        	}
        	if(j - k - 1 > re.length()) {
        		re = s.substring(k + 1, j);
        	}
        }
        return re;
    }
    
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows == 1) {
    		return s;
    	}
    	int len = s.length();
        char[][] a = new char[nRows][len];
        int i, j = 0, k = 0;
        boolean down = true;
        for(i = 0; i < nRows; ++i){
        	for(j = 0; j < len; ++j){
        		a[i][j] = ' ';
        	}
        }
        j = 0;
        i = 0;
        while(i < s.length()){
        	if(down){
        		a[j][k] = s.charAt(i++);
        		++j;
        		if(j == nRows){
        			down = !down;
        			j -= 2;
        			++k;
        		}
        	} else {
        		if(nRows > 2){
        			a[j][k] = s.charAt(i++);
        			--j;
        			if(j == 0){
        				down = !down;
        				++k;
        			}
        		} else {
        			down = !down;
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < nRows; ++i){
        	for(j = 0; j < len; ++j){
        		if(a[i][j] != ' '){
        			sb.append(a[i][j]);
        		}
        	}
        }
        return sb.toString();
    }
    
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	boolean neg = x < 0;
    	if(neg){
    		x = -x;
    	}
        String s = new StringBuilder(new Integer(x).toString()).reverse().toString();
        if(neg){
        	s = "-" + s;
        }
        return Integer.parseInt(s);
    }
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int maxLen = new Integer(Integer.MIN_VALUE).toString().length();
        str = str.trim();
        if(str.length() > 0 && str.charAt(0) == '+'){
        	str = str.substring(1);
        }
        if(str.length() == 0) {
        	return 0;
        }
        int i = 0, start = 0;     
        if(str.charAt(0) == '-'){
        	++i; 
        	++start;
        }
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){        	
    		++i;
        } 
    	int num = 0;
        if(i > start){
        	if(i - start > maxLen){
        		if(str.charAt(0) == '-'){
        			return Integer.MIN_VALUE;
        		} else {
        			return Integer.MAX_VALUE;
        		}
        	}
        	try {
        		num = Integer.parseInt(str.substring(0, i));
        	} catch (NumberFormatException ex){
        		if(str.charAt(0) == '-'){
        			num = Integer.MIN_VALUE;
        		} else {
        			num = Integer.MAX_VALUE;
        		} 
        	}
        }
        return num;
    }
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0){
        	return false;
        }
        int k = 0, power = 1;
        while(x / power > 0){
        	power *= 10;
        	++k;
        	if(k == 10) {
        		break;
        	}
        }
        if(k == 10){
        	power = 1000000000;
        	if(x / power != x % 10) {
        		return false;
        	}
        	x = x % power;
        	x = x / 10;
        	k -= 2;
        }
        int i, lp = 1, lp2 = 1, left, right;
        for(i = 0; i < k - 1; ++i){
        	lp *= 10;
        }
        for(i  = 0; i < k / 2; ++i){
        	left = (x / lp) % 10;
        	right = (x / lp2) % 10;
        	if(left != right) {
        		return false;
        	}
        	lp /= 10;
        	lp2 *= 10;
        }
        return true;
    }
//    public boolean isMatch(String s, String p) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//    	int i;
//        if(p.length() == 0) {
//        	return s.length() == 0;
//        }
//        if(p.charAt(p.length() - 1) != '*'){
//        	return s.length() > 0 && (p.charAt(p.length() - 1) == s.charAt(s.length() - 1) || p.charAt(p.length() - 1) == '.')&& 
//        			isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
//        } else {
//        	if(p.charAt(p.length() - 2) != '.'){
//        		return (s.length() > 0 && p.charAt(p.length() - 2) == s.charAt(s.length() - 1) && isMatch(s.substring(0, s.length() - 1), p)) ||
//        				isMatch(s, p.substring(0, p.length() - 2));
////        		i = 0;
////        		while(i < s.length() && p.charAt(p.length() - 2) == s.charAt(s.length() - 1 - i)) {
////        			if(isMatch(s.substring(0, s.length() - 1 - i), p)){
////        				return true;
////        			}
////        			++i;
////        		}
////        		return isMatch(s.substring(0, s.length() - i), p.substring(0, p.length() - 2));
//        	} else {
//        		i = 2;
//        		while(i < p.length() && p.charAt(p.length() - 1 - i) == '*'){
//        			i += 2;
//        		}
//        		if(i >= p.length()){
//        			return true;
//        		}
//        		int j = 0;
//        		while(j < s.length()){
//        			if((s.charAt(s.length() - 1 - j) == p.charAt(p.length() - 1 - i) || p.charAt(p.length() - 1- i) == '.')&& 
//        					isMatch(s.substring(0, s.length() - 1 - j), p.substring(0, p.length() - 1 - i))){
//        				return true;
//        			}
//        			++j;
//        		}
//        		return false;
//        	}
//        }
//    }
    
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, re = 0,tmp;
        ArrayList<Integer> left, right;
        left = new ArrayList<Integer>();
        right = new ArrayList<Integer>();
        right.add(0);
        for(i = 1; i < height.length; ++i){
        	if(height[i] > height[right.get(right.size() - 1)]){
        		right.add(i);
        	}
        }
        left.add(height.length - 1);
        for(i = height.length - 2; i >= 0; --i){
        	if(height[i] > height[left.get(left.size() - 1)]){
        		left.add(i);
        	}
        }
        for(i = 0; i <right.size(); ++i){
        	for(j = 0; j < left.size() && left.get(j) > right.get(i); ++j){
        		if(height[left.get(j)] < height[right.get(i)]){
        			tmp = height[left.get(j)] * (left.get(j) - right.get(i));
        			re = Math.max(re, tmp);
        		} else {
        			tmp = height[right.get(i)] * (left.get(j) - right.get(i));
        			re = Math.max(re, tmp);
        			break;
        		}
        	}
        }
        return re;
    }
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
//    	Given an integer, convert it to a roman numeral.
//    	Input is guaranteed to be within the range from 1 to 3999.
		//Symbol	Value
		//I	1
		//V	5
		//X	10
		//L	50
		//C	100
		//D	500
		//M	1,000
    	String[] ro = {"CDM", "XLC", "IVX"};
    	int[] base = {100, 10, 1};
    	StringBuilder sb = new StringBuilder();
    	int i, j, k;
    	k = num / 1000;
    	if(k > 0){
    		for(i = 0; i < k; ++i){
    			sb.append('M');
    		}
    	}
    	num = num % 1000;
    	for(i = 0; i < base.length; ++i){
    		k = num / base[i];
    		if(k >= 1 && k <= 3){
    			for(j = 0; j < k; ++j){
    				sb.append(ro[i].charAt(0));
    			}
    		} else if(k == 4){
    			sb.append(ro[i].charAt(0));
    			sb.append(ro[i].charAt(1));
    		} else if(k >= 5 && k <= 8){
    			sb.append(ro[i].charAt(1));
    			for(j = 0; j < k - 5; ++j){
    				sb.append(ro[i].charAt(0));
    			}
    		} else if(k == 9){
    			sb.append(ro[i].charAt(0));
    			sb.append(ro[i].charAt(2));
    		}
    		num = num % base[i];
    	}
    	return sb.toString();
    }
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	//I	1
		//V	5
		//X	10
		//L	50
		//C	100
		//D	500
		//M	1,000
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int re = 0, i, j, k, last = 1000;
        for(i = 0; i < s.length(); ++i){
        	 k = m.get(s.charAt(i));
        	 re += k;
        	 if(k > last){
        		 re -= 2 * last;
        	 }
        	 last = k;
        }
        return re;
    }
    
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String s = "";
        int i, j, k = Integer.MAX_VALUE;
        for(String str : strs){
        	if(str.length() < k){
        		k = str.length();
        		s = str;
        	}
        }
        String re = "";
        for(i = 0; i < s.length(); ++i){
        	String prefix = s.substring(0, i + 1);
        	for(j = 0; j < strs.length; ++j){
        		if(!strs[j].startsWith(prefix)){
        			break;
        		}
        	}
        	if(j == strs.length) {
        		re = prefix;
        	} else {
        		break;
        	}
        }
        return re;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> n = new ArrayList<Integer>();
    	int i, j, k;
    	for(i = 0; i < num.length; ++i){
    		n.add(num[i]);
    	}
    	ArrayList<Integer> triple;
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	Collections.sort(n);
    	for(i = 0; i < n.size(); ++i){
    		if(i > 0 && n.get(i) == n.get(i - 1)) {
    			continue;
    		}
    		for(j = i + 1; j < n.size(); ++j){
    			if(j > i + 1 && n.get(j) == n.get(j - 1)) {
    				continue;
    			}
    			if(Collections.binarySearch(n.subList(j + 1, n.size()), 0 - n.get(i) - n.get(j)) >= 0){
    			//if(n.subList(j + 1, n.size()).contains(0 - n.get(i) - n.get(j))){
    				triple = new ArrayList<Integer>();
    				triple.add(n.get(i));
    				triple.add(n.get(j));
    				triple.add(0 - n.get(i) - n.get(j));
    				re.add(triple);
    			}
    		}
    	}
    	return re;
    }
    
    public int lowerBound(List<Integer> a, int key){
    	int low = 0, high = a.size() - 1;
    	while(low <= high){
    		int mid = (low + high) / 2;
    		int midVal = a.get(mid);
    		if(midVal == key){
    			return mid;
    		} else if(midVal < key){
    			low = mid + 1;
    		} else {
    			high = mid - 1;
    		}
    	}
    	return high;
    }
    
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> n = new ArrayList<Integer>();
    	int i, j, k, gap = Integer.MAX_VALUE, re = -1;
    	for(i = 0; i < num.length; ++i){
    		n.add(num[i]);
    	}
    	Collections.sort(n);
    	for(i = 0; i < n.size(); ++i){
    		if(i > 0 && n.get(i) == n.get(i - 1)) {
    			continue;
    		}
    		for(j = i + 1; j < n.size(); ++j){
    			if(j > i + 1 && n.get(j) == n.get(j - 1)) {
    				continue;
    			}
    			List<Integer> sn = n.subList(j + 1, n.size());
    			int lower = lowerBound(sn, target - n.get(i) - n.get(j));
    			if(lower >= 0 && lower < sn.size()){
    				k = Math.abs(target - sn.get(lower) - n.get(i) - n.get(j));
    				if(k < gap){
    					gap = k;
    					re = sn.get(lower) + n.get(i) + n.get(j);
    				}
    				if(gap == 0){
    					return target;
    				}
    			}
    			if(lower + 1 >= 0 && lower + 1 < sn.size()){
    				k = Math.abs(target - sn.get(lower + 1) - n.get(i) - n.get(j));
    				if(k < gap){
    					gap = k;
    					re = sn.get(lower + 1) + n.get(i) + n.get(j);
    				}
    				if(gap == 0){
    					return target;
    				}
    			}
    		}
    	}
    	return re;
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<Integer> tmp;
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	if(num.length < 4){
    		return re;
    	}
    	int i, j, low, high;
    	Arrays.sort(num);
    	for(i = 0; i < num.length - 3; ++i){
    		if(i > 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		for(j = i + 1; j < num.length - 2; ++j){
    			if(j > i + 1 && num[j] == num[j - 1]) {
    				continue;
    			}
    			low = j + 1; high = num.length - 1;
    			while(low < high){
    				int sum = num[i] + num[j] + num[low] + num[high];
    				if(sum > target){
    					--high;
    				} else if(sum < target){
    					++low;
    				} else {
    					tmp = new ArrayList<Integer>();
    					tmp.add(num[i]);
    					tmp.add(num[j]);
    					tmp.add(num[low]);
    					tmp.add(num[high]);
    					re.add(tmp);
    					++low;
    					--high;
    					while(low < high && num[low] == num[low - 1]){
    						++low;
    					}
    					while(low < high && num[high] == num[high + 1]){
    						--high;
    					}
    				}
    			}
    		}
    	}
    	return re;
    }
    
    public void permutation(String s){
    	permR("", s);
    }
    private void permR(String cur, String s){
    	if(s.length() == 0){
    		System.out.println(cur);
    		return;
    	}
    	for(int i = 0; i < s.length(); ++i){
    		permR(cur + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
    	}
    }
    public String getPermutation(int n, int k) {
    	// Start typing your C/C++ solution below
    	// DO NOT write int main() function
    	ArrayList<Integer> fac = new ArrayList<Integer>();
    	int i, j = 1;;
    	for(i = 1; i <= n - 1; ++i){
    		j *= i;
    		fac.add(j);
    	}
    	StringBuilder sb = new StringBuilder();
    	for(i = 1; i <= n; ++i){
    		sb.append(Integer.toString(i));
    	}
    	StringBuilder re = new StringBuilder();
    	--k;
    	for(i = 1; i <= n - 1; ++i){
    		j = k / fac.get(n - 1 - i);
    		k %= fac.get(n - 1 - i);
    		re.append(sb.charAt(j));
    		sb.deleteCharAt(j);
    	}
    	re.append(sb.charAt(0));
    	return re.toString();
    }
    
    String[] pn = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void lcr(ArrayList<String> re, String cur, String digits){
    	if(digits.length() == 0){
    		re.add(cur);
    		return;
    	}
		int k = digits.charAt(0) - '0';
		for(int j = 0; j < pn[k].length(); ++j){
			lcr(re, cur + pn[k].charAt(j), digits.substring(1));
		}
    }
    public ArrayList<String> letterCombinations(String digits) {
    	// Start typing your Java solution below
    	// DO NOT write main() function
    	ArrayList<String> re = new ArrayList<String>();
    	String cur = "";
    	lcr(re, cur, digits);
    	return re;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	// Start typing your Java solution below
    	// DO NOT write main() function
    	ListNode p, q;
    	p = head; q = head;
    	int i;
    	for(i = 0; i < n; ++i){
    		q = q.next;
    	}
    	if(q == null) {
    		return head.next;
    	}
    	while(q.next != null){
    		q = q.next;
    		p = p.next;
    	}
    	p.next = p.next.next;
    	return head;
    }
	
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Character> stack = new Stack<Character>();
		//Map<Character, Character> left= new HashMap<Charater, Character>();
		Map<Character, Character> right= new HashMap<Character, Character>();
		//left.put('(', ')');
		//left.put('[', ']');
		//left.put('{', '}');
		right.put(')', '(');
		right.put(']', '[');
		right.put('}', '{');
		for(int i = 0; i < s.length(); ++i){
			if(!right.containsKey(s.charAt(i))){
				stack.add(s.charAt(i));
			} else {
				if(stack.isEmpty()){
					return false;
				}
				char ch = stack.pop();
				if(right.get(s.charAt(i)) != ch){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	private void genPR(ArrayList<String> re, String cur, int left, int right){
		if(left == 0 && right == 0){
			re.add(cur);
			return;
		}
		if(left > 0){
			genPR(re, cur + "(", left - 1, right + 1);
		}
		if(right > 0){
			genPR(re, cur + ")", left, right - 1);
		}
	}
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> re = new ArrayList<String>();
		genPR(re, "", n, 0);
		return re;
	}
	
	class PQComparator implements Comparator<ListNode>{
		public int compare(ListNode o1, ListNode o2){
			return o1.val - o2.val;
		}
	}
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head, cur, prev;
		head = null; prev = null;
		if(lists == null || lists.isEmpty()){			
			return head;
		}
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new PQComparator());
		for(ListNode node : lists){
			if(node != null){
				pq.offer(node);
			}
		}
		while(!pq.isEmpty()){
			cur = pq.poll();
			if(cur.next != null){
				pq.offer(cur.next);
			}
			if(prev == null){
				head = cur;
			} else {
				prev.next = cur;
			}
			prev = cur;
		}
		return head;
	}
	
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode p1 = head, p2, prev = null, tmp;
		while(p1 != null && p1.next != null){
			p2 = p1.next;
			tmp = p2.next;
			p2.next = p1;
			if(prev == null){
				head = p2;
			} else {
				prev.next = p2;
			}
			prev = p1;
			p1 = tmp;
		}
		if(prev != null){
			if(p1 != null) {
				prev.next = p1;
			} else {
				prev.next = null;
			}
		}
		return head;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode prev = null, start = head, end, p, q, tmp;
		int i;
		while(start != null){
			end = start;
			for(i = 0; i < k - 1 && end != null; ++i){
				end = end.next;
			}
			if(end != null){
				if(prev != null){
					prev.next = end;
				} else {
					head = end;
				}
				prev = start; p = start; q = start.next;
				while(p != end){
					tmp = q.next;
					q.next = p;
					p = q;
					q = tmp;
				}
				start = q;
			} else {
				if(prev != null){
					prev.next = start;
				} 
				break;
			}
		}
		if(start == null && prev != null){
			prev.next = start;
		}
		return head;
	}
	
	int removeDuplicates(int A[], int n) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if(n == 0) return 0;
		int pos = 0, i;
		for(i = 1 ; i < n; ++i){
			if(A[i] == A[pos]){
				continue;
			}
			A[++pos] = A[i];
		}
		return pos + 1;
	}
	
	public int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i, k = 0;
		for(i = 0; i < A.length; ++i){
			if(A[i] != elem){
				A[k++] = A[i];
			}
		}
		return k;
	}
	
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int pos = haystack.indexOf(needle);
		if(pos == -1){
			return null;
		} else {
			return haystack.substring(pos);
		}
	}
	
	public int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		long re = 0, k = 1;
		boolean neg = false;
		long d1 = dividend, d2 = divisor;
		if((d1 < 0 && d2 >  0) || (d1 > 0 && d2 < 0)){
			neg = true;
		}
		d1 = Math.abs(d1);
		d2 = Math.abs(d2);
		while(d1 > 0){
			while(d1 < d2){
				d2 = d2 >> 1;
				k = k >> 1;
			}
			d1 -= d2;
			re += k;
			d2 = d2 << 1;
			k = k << 1;
		}
		if(neg){
			re = 0 - re;
		}
		return (int)re;
	}
    
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> re = new ArrayList<Integer>();
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		int i, j, k, len = L[0].length(), n = L.length;
		for(i = 0; i < n; ++i){
			Integer count = m1.get(L[i]);
			if(count == null){
				m1.put(L[i], 1);
			} else {
				m1.put(L[i], count + 1);
			}
		}
		for(i = 0; i <= S.length() - len * n; ++i){
			String tmp = S.substring(i, i + len);
			Integer count = m1.get(tmp);
			if(count != null){
				Map<String, Integer> m2 = new HashMap<String, Integer>(m1);
				m2.put(tmp, count - 1);
				for(j = 1; j < n; ++j){
					tmp = S.substring(i + j * len, i + (j + 1) * len);
					count = m2.get(tmp);
					if(count == null || count == 0){
						break;
					} else {
						m2.put(tmp, count - 1);
					}
				}
				if(j == n){
					re.add(i);
				}
			}
		}
		return re;
	}
	
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i, j = 0, k;
		for(i = num.length - 2; i >= 0; --i){
			if(num[i] < num[i + 1]){
				int low = i + 1, high = num.length - 1;
				while(low <= high){
					int mid = (low + high) / 2;
					if(num[mid] > num[i]){
						++low;
					} else if(num[mid] <= num[i]) {
						--high;
					}
				}
				j = high;
				break;
			}
		}
		if(i >= 0) {
			k = num[i];
			num[i] = num[j];
			num[j] = k;
		}
		Arrays.sort(num, i + 1, num.length);
		return;
	}
	
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i, j, k, re = 0, bonus = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(i = 0; i < s.length(); ++i){
			if(s.charAt(i) == '('){
				stack.push(bonus);
				bonus = 0;
			} else {
				if(!stack.isEmpty()){
					if(s.charAt(i - 1) != ')'){
						bonus = 0;
					}
					bonus += stack.pop() + 2;
					re = Math.max(bonus, re);
				} else {
					bonus = 0;
				}
			}
		}
		return re;
	}
	
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(p.length() == 0) return s.length() == 0;
		int i, j, k;
		if(s.length() == 0) {
			for(i = 0; i < p.length(); ++i){
				if(p.charAt(i) != '*'){
					return false;
				}
			}
			return true;
		}
		if(p.charAt(0) == '?'){
			return isMatch(s.substring(1), p.substring(1));
		} else if(p.charAt(0) == '*'){
			for(i = 1; i < p.length(); ++i){
				if(p.charAt(i) != '*'){
					break;
				}
			}
			if(i == p.length()) return true;
			for(j = 0; j < s.length(); ++j){
				if(isMatch(s.substring(j), p.substring(i))){
					return true;
				}
			}
			return false;
		} else {
			return s.charAt(0) == p.charAt(0) && 
			isMatch(s.substring(1), p.substring(1));
		}
	}
	
    public static void main(String[] args){
    	Solution sol = new Solution();   
    	System.out.println(sol.isMatch("aaa", "c*a*b"));
    }
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, low, high, mid;
        low = 0; high = A.length - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[low] == target){
                return low;
            }
            if(A[high] == target){
                return high;
            }
            if(A[mid] == target){
                return mid;
            } else if(A[mid] < target){
                if(A[high] > target || A[high] < A[mid]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if(A[low] < target || A[low] > A[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, low, high, mid;
        low = 0; high = A.length - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] <= target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        i = low;
        low = 0; high = A.length - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        j = high;
        int[] re = new int[2];
        if(i - 1 >= 0 && i - 1 < A.length && A[i - 1] == target){
            re[0] = j + 1;
            re[1] = i - 1;
        } else {
            re[0] = -1;
            re[1] = -1;
        }
        return re;
    }
}
public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low, high, mid;
        low = 0; high = A.length - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target){
                return mid;
            } else if(A[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(1);
        int i, j, k;
        for(i = 1; i < n; ++i){
            b.clear();
            k = 1;
            for(j = 1; j < a.size(); ++j){
                if(a.get(j - 1) == a.get(j)){
                    ++k;
                } else {
                    b.add(k);
                    b.add(a.get(j - 1));
                    k = 1;
                }
            }
            b.add(k);
            b.add(a.get(j - 1));
            a = b;
            b = new ArrayList<Integer>();
        }
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < a.size(); ++i){
            sb.append(new Integer(a.get(i)).toString());
        }
        return sb.toString();
    }
}
public class Solution {
    private void cR(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] candidates, int start, int target){
        if(target == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i < candidates.length; ++i){
            if(i > 0 && candidates[i] == candidates[i - 1]){
                continue;
            }
            if(target >= candidates[i]){
                cur.add(candidates[i]);
                cR(re, cur, candidates, i, target - candidates[i]);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cR(re, cur, candidates, 0, target);
        return re;
    }
}
public class Solution {
    private void cR(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] num, int start, int target){
        if(target == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i < num.length; ++i){
            if(target >= num[i]){
                cur.add(num[i]);
                cR(re, cur, num, i + 1, target - num[i]);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cR(re, cur, num, 0, target);
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        set.addAll(re);
        re.clear();
        re.addAll(set);
        return re;
    }
}
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k;
        for(i = 0; i < A.length; ++i){
            if(A[i] < 0){
                A[i] = 0;
            }
        }
        for(i = 0; i < A.length; ++i){
            k = Math.abs(A[i]);
            if(k > 0 && k <= A.length){
                if(A[k - 1] > 0){
                    A[k - 1] = 0 - A[k - 1];
                } else if(A[k - 1] == 0){
                    A[k - 1] = -k;
                }
            }
        }
        for(i = 0; i < A.length; ++i){
            if(A[i] >= 0){
                break;
            }
        }
        return i + 1;
    }
}
public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return 0;
        }
        int high = -1, hi = -1;
        int i, j, k, re = 0;
        for(i = 0 ; i < A.length; ++i){
            if(A[i] > high){
                high = A[i];
                hi = i;
            }
        }
        k = A[0];
        for(i = 1; i <= hi; ++i){
            if(A[i] <= k){
                re += k - A[i];
            } else {
                k = A[i];
            }
        }
        k = A[A.length - 1];
        for(i = A.length - 1; i >= hi; --i){
            if(A[i] <= k){
                re += k - A[i];
            } else {
                k = A[i];
            }
        }
        return re;
    }
}
public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p1, p2, i, j, k, sum, c;
        p1 = 0; p2 = 0;
        boolean neg = false;
        if(num1.charAt(p1) == '-') {
            neg = !neg;
            ++p1;
        }
        if(num2.charAt(p2) == '-'){
            neg = !neg;
            ++p2;
        }
        sum = 0; c = 0;
        int k1 = -1, k2 = -1;
        ArrayList<Integer> a = new ArrayList<Integer>(Collections.nCopies(num1.length() + num2.length(), 0));
        for(i = num1.length() - 1; i >= p1; --i){
            int n1 = num1.charAt(i) - '0';
            ++k1; k2 = -1;
            c = 0;
            for(j = num2.length() - 1; j >= p2; --j){
                ++k2;
                int n2 = num2.charAt(j) - '0';
                int tmp = n2 * n1 + c + a.get(k1 + k2);
                c = tmp / 10;
                a.set(k1 + k2, tmp % 10);
                
            }
            sum = a.get(k1 + k2 + 1) + c;
            a.set(k1 + k2 + 1, sum);
        }
        c = 0; sum = 0;
        for(i = 0; i < num1.length() + num2.length(); ++i){
            sum = a.get(i) + c;
            a.set(i, sum % 10);
            c = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        if(neg){
            sb.append('-');
        }
        boolean start = false;
        for(i = num1.length() + num2.length() - 1; i >= 0; --i){
            if(!start && a.get(i) == 0){
                continue;
            } else {
                start = true;
                sb.append(a.get(i));
            }
        }
        if(sb.length() == 0){
            sb.append(0);
        }
        return sb.toString();
    }
}
public class Solution {
    private void r(ArrayList<String[]> re, int [] cur, int p, int n){
        int i, j, k;
        if(p == n){
            String[] s = new String[n];
            char[] ch = new char[n];
            for(i = 0; i < n; ++i){
                ch[i] = '.';
            }
            for(i = 0; i < n; ++i){
                ch[cur[i] - 1] = 'Q';
                s[i] = new String(ch);
                ch[cur[i] - 1] = '.';
            }
            re.add(s);
            return;
        }
        boolean[] f = new boolean[n];
        for(i = 0; i < p; ++i){
            f[cur[i] - 1] = true;
            int b= cur[i] - 1 - i + p;
            if(b >= 0 && b < n) {
            	f[b] = true;
            }
            b = cur[i] - 1 + i - p;
            if(b >= 0 && b < n) {
            	f[b] = true;
            }
        }
        for(i = 1; i <= n; ++i){
            if(!f[i - 1]){
                cur[p] = i;
                r(re, cur, p + 1, n);
            }
        }
    }
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> re = new ArrayList<String[]>();
        int[] cur = new int[n];
        r(re, cur, 0, n);
        return re;
    }
}
public class Solution {
    private void r(ArrayList<String[]> re, int [] cur, int p, int n){
        int i, j, k;
        if(p == n){
            String[] s = new String[n];
            char[] ch = new char[n];
            for(i = 0; i < n; ++i){
                ch[i] = '.';
            }
            for(i = 0; i < n; ++i){
                ch[cur[i] - 1] = 'Q';
                s[i] = new String(ch);
                ch[cur[i] - 1] = '.';
            }
            re.add(s);
            return;
        }
        boolean[] f = new boolean[n];
        for(i = 0; i < p; ++i){
            f[cur[i] - 1] = true;
            int b= cur[i] - 1 - i + p;
            if(b >= 0 && b < n) {
            	f[b] = true;
            }
            b = cur[i] - 1 + i - p;
            if(b >= 0 && b < n) {
            	f[b] = true;
            }
        }
        for(i = 1; i <= n; ++i){
            if(!f[i - 1]){
                cur[p] = i;
                r(re, cur, p + 1, n);
            }
        }
    }
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> re = new ArrayList<String[]>();
        int[] cur = new int[n];
        r(re, cur, 0, n);
        return re.size();
    }
}
public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur = A[0], re = cur;
        for(int i = 1; i < A.length; ++i){
            if(cur < 0){
                cur = 0;
            }
            if(cur + A[i] > re){
                re = cur + A[i];
            }
            cur += A[i];
        }
        return re;
    }
}
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k;
        ArrayList<Integer> re = new ArrayList<Integer>();
        if(matrix.length == 0){
            return re;
        }
        int row_start = 0, row_end = matrix.length - 1, col_start = 0, col_end = matrix[0].length - 1;
        while(row_start <= row_end && col_start <= col_end){
            for(i = col_start; i <= col_end; ++i){
                re.add(matrix[row_start][i]);
            }
            for(i = row_start + 1; i <= row_end; ++i){
                re.add(matrix[i][col_end]);
            }
            if(row_start != row_end){
                for(i = col_end - 1; i >= col_start; --i){
                    re.add(matrix[row_end][i]);
                }
            }
            if(col_start != col_end){
                for(i = row_end - 1; i > row_start; --i){
                    re.add(matrix[i][col_start]);
                }
            }
            ++row_start; --row_end;
            ++col_start; --col_end;
        }
        return re;
    }
}
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k = 0;
        for(i = 0; i < A.length; ++i){
            if(k < i){
                return false;
            }
            k = Math.max(k, i + A[i]);
            if(k >= A.length - 1){
                return true;
            }
        }
        return false;
    }
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class Item implements Comparable<Item>{
        int val;
        int type;
        Item(int val, int type){
            this.val = val;
            this.type = type;
        }
        public int compareTo(Item o){
            if(this.val == o.val){
                return this.type - o.type;
            }
            return this.val - o.val;
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Item> items = new ArrayList<Item>();
        for(Interval it : intervals){
            items.add(new Item(it.start, 0));
            items.add(new Item(it.end, 1));
        }
        Collections.sort(items);
        ArrayList<Interval> re = new ArrayList<Interval>();
        int start_cnt = 0, start = 0;
        for(Item item : items){
            if(item.type == 0){
                if(start_cnt == 0){
                    start = item.val;
                }
                ++start_cnt;
            } else {
                --start_cnt;
                if(start_cnt == 0){
                    re.add(new Interval(start, item.val));
                }
            }
        }
        return re;
    }
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> re = new ArrayList<Interval>();
        int i, j, k = 0;
        for(i = 0; i < intervals.size(); ++i){
            if(k == 0){
                if(newInterval.end < intervals.get(i).start){
                    re.add(newInterval);
                    re.add(intervals.get(i));
                    k = 1;
                } else if(newInterval.start <= intervals.get(i).end){
                    newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                    newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                } else {
                    re.add(intervals.get(i));
                }
            } else {
                re.add(intervals.get(i));
            }
        }
        if(k == 0){
            re.add(newInterval);
        }
        return re;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = 0;
        ListNode p = head;
        while(p != null){
            ++len;
            p = p.next;
        }
        if(len == 0){
            return head;
        }
        n = n % len;
        if(n == 0){
            return head;
        }
        int i, j, k;
        p = head;
        for(i = 0; i < n; ++i){
            p = p.next;
        }
        ListNode q = head;
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        ListNode nHead = q.next;
        p.next = head;
        q.next = null;
        return nHead;
    }
}
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k, m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                f[i][j] = 0;
            }
        }
        if(obstacleGrid[0][0] != 0){
            return 0;
        }
        f[0][0] = 1;
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(obstacleGrid[i][j] != 0){
                    f[i][j] = 0;
                } else{
                    if(i > 0){
                        f[i][j] += f[i - 1][j];
                    }
                    if(j > 0){
                        f[i][j] += f[i][j - 1];
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k, l;
        ArrayList<Boolean> f = new ArrayList<Boolean>(Collections.nCopies(10, false));
        for(i = 0 ; i < 9; ++i){
            Collections.fill(f, false);
            for(j = 0; j < 9; ++j){
                if(board[i][j] != '.'){
                    k = board[i][j] - '0';
                    if(f.get(k)){
                        return false;
                    }
                    f.set(k, true);
                }
            }
            Collections.fill(f, false);
            for(j = 0; j < 9; ++j){
                if(board[j][i] != '.'){
                    k = board[j][i] - '0';
                    if(f.get(k)){
                        return false;
                    }
                    f.set(k, true);
                }
            }
        }
        for(l = 0; l < 9; l += 3){
            for(int l2 = 0; l2 < 9; l2 += 3){
                Collections.fill(f, false);
                for(i = 0; i < 3; ++i){
                    for(j = 0;j < 3; ++j){
                        if(board[i + l][j + l2] != '.'){
                            k = board[i + l][j + l2] - '0';
                            if(f.get(k)){
                                return false;
                            }
                            f.set(k, true);
                        }
                    }
                }
            }
        }
        return true;
    }
}
public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int i, j, k, m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                f[i][j] = grid[i][j];
            }
        }
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(i > 0 && j > 0){
                    f[i][j] += Math.min(f[i - 1][j], f[i][j - 1]);
                } else if(i > 0){
                    f[i][j] += f[i - 1][j];
                } else if(j > 0){
                    f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null, cur = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(cur == null){
                    cur = l1;
                    head = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }
            } else {
                if(cur == null){
                    cur = l2;
                    head = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
        }
        while(l1 != null){
           if(cur == null){
                cur = l1;
                head = l1;
                l1 = l1.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } 
        }
        while(l2 != null){
            if(cur == null){
                cur = l2;
                head = l2;
                l2 = l2.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lena = a.length(), lenb = b.length(), i, j, k, sum = 0, c = 0;
        int pa = lena - 1, pb = lenb - 1; 
        StringBuilder sb = new StringBuilder();
        while(pa >= 0 && pb >= 0){
            sum = a.charAt(pa) - '0' + b.charAt(pb) - '0' + c;
            sb.append(sum % 2);
            c = sum / 2;
            --pa;
            --pb;
        }
        while(pa >= 0){
            sum = a.charAt(pa) - '0' + c;
            sb.append(sum % 2);
            c = sum / 2;
            --pa;
        }
        while(pb >= 0){
            sum = b.charAt(pb) - '0' + c;
            sb.append(sum % 2);
            c = sum / 2;
            --pb;
        }
        if(c > 0){
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k, p = 0, q = s.length() - 1;
        while(p <= q && s.charAt(p) == ' ') ++p;
        while(q >= p && s.charAt(q) == ' ') --q;
        if(p <= q && (s.charAt(p) == '-' ||  s.charAt(p) == '+')) ++p;
        if(p > q) return false;
        boolean flag = false;
        while(p <= q && s.charAt(p) >= '0' && s.charAt(p) <= '9') { ++p; flag = true;}
        if(p > q) return flag;
        boolean flag2 = false;
        if(s.charAt(p) == '.'){
            ++p;
            while(p <= q && s.charAt(p) >= '0' && s.charAt(p) <= '9') { ++p; flag2 = true;}
            if(p > q) return flag || flag2;
        }
        if(!(flag || flag2)) return false;
        if(s.charAt(p) == 'e'){
            ++p;
            if(p <= q && (s.charAt(p) == '-' ||  s.charAt(p) == '+')) ++p;
            flag = false;
            while(p <= q && s.charAt(p) >= '0' && s.charAt(p) <= '9') { ++p; flag = true;}
            if(!flag) return false;
            if(p > q) return flag;
        }
        return false;
    }
}
public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> a = new ArrayList<Integer>();
        int i, j, k, sum = 0, c = 1;
        for(i = digits.length - 1; i >= 0; --i){
            sum = digits[i] + c;
            a.add(sum % 10);
            c = sum / 10;
        }
        if(c > 0){
            a.add(c);
        }
        int[] re = new int[a.size()];
        for(i = 0; i < a.size(); ++i){
            re[i] = a.get(a.size() - 1 - i);
        }
        return re;
    }
}
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> re = new ArrayList<String>();
        ArrayList<String> line = new ArrayList<String>();
        StringBuilder sb;
        int i, j, k = 0, l;
        for(i = 0; i < words.length; ++i){
            if(line.size() + k + words[i].length() > L){
                sb = new StringBuilder();
                sb.append(line.get(0));
                if(line.size() == 1) {
                    for(l = 0; l < L - k; ++l) sb.append(' ');
                } else {
                    int mod = (L - k) % (line.size() - 1);
                    int div = (L - k) / (line.size() - 1);
                    for(j = 1; j < line.size(); ++j){
                        if(mod > 0) {sb.append(' '); --mod;}
                        for(l = 0; l < div; ++l) sb.append(' ');
                        sb.append(line.get(j));
                    }
                }
                re.add(sb.toString());
                line.clear();
                k = 0;
            }
            line.add(words[i]);
            k += words[i].length();
        }
        sb = new StringBuilder();
        sb.append(line.get(0));
        for(i = 1; i < line.size(); ++i){
            sb.append(' ');
            sb.append(line.get(i));
        }
        int cnt = L - k - (line.size() - 1);
        for(l = 0; l < cnt; ++l) sb.append(' ');
        re.add(sb.toString());
        return re;
    }
}
public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x <= 1) return x;
        long low = 1, high = x, mid;
        while(low <= high){
            mid = (low + high) / 2;
            long tmp = mid * mid;
            if(tmp == x){
                return (int)mid;
            } else if(tmp < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)high;
    }
}
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] f = new int[3];
        f[0] = 1;
        f[1] = 1;
        int i, j, k;
        for(i = 2; i <= n; ++i){
            f[i % 3] = f[(i -1) % 3] + f[(i - 2) % 3];
        }
        return f[n % 3];
    }
}
public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k, start = -1, p = 0, len = path.length();
        Deque<String> s = new ArrayDeque<String>();
        String[] tokens = path.split("/");
        for(String token : tokens){
            if(token.equals("..")){
                if(!s.isEmpty()) s.pollLast();
            } else if(token.equals(".")){
                continue;
            } else if(token.length() > 0){
                s.add(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            String str = s.pollFirst();
            sb.append("/" + str);
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k, len1 = word1.length(), len2 = word2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for(i = 0; i <= len1; ++i){
            for(j = 0; j <= len2; ++j){
                f[i][j] = 0;
            }
        }
        for(i = 0; i <= len1; ++i){
            f[i][0] = i;
        }
        for(j = 0; j <= len2; ++j){
            f[0][j] = j;
        }
        for(i = 1; i <= len1; ++i){
            for(j = 1; j <= len2; ++j){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    int tmp = Math.min(f[i - 1][j], f[i][j  -1]);
                    tmp = Math.min(tmp, f[i - 1][j - 1]);
                    f[i][j] = tmp + 1;
                }
            }
        }
        return f[len1][len2];
    }
}
public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int i, j, k, m = matrix.length, n = matrix[0].length;
        boolean r0 = false, c0 = false;
        for(i = 0; i < m; ++i){
            if(matrix[i][0] == 0){
                c0 = true;
                break;
            }
        }
        for(j = 0; j < n; ++j){
            if(matrix[0][j] == 0){
                r0 = true;
                break;
            }
        }
        for(i = 1; i < m; ++i){
            for(j = 1; j < n; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(i = 1; i < m; ++i){
            if(matrix[i][0] == 0){
                for(j = 0; j < n; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(j = 1; j < n; ++j){
            if(matrix[0][j] == 0){
                for(i = 0; i < m; ++i){
                    matrix[i][j] = 0;
                }
            }
        }
        if(c0){
            for(i = 0; i < m; ++i){
                matrix[i][0] = 0;
            }
        }
        if(r0){
            for(j = 0; j < n; ++j){
                matrix[0][j] = 0;
            }
        }
        return;
    }
}
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m - 1, mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(matrix[mid][n - 1] == target) return true;
            else if(matrix[mid][n - 1] < target) low = mid + 1;
            else high = mid - 1;
        }
        if(low == m) return false;
        k = low;
        low = 0; high = n - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(matrix[k][mid] == target) return true;
            else if(matrix[k][mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return;
        int n = A.length;
        int i, j, k, tmp;
        j = 0; k = n - 1;
        for(i = 0; i <= k; ){
            if(A[i] == 0){
                tmp = A[j];
                A[j] = 0;
                A[i] = tmp;
                ++j;
                ++i;
            } else if(A[i] == 2){
                tmp = A[k];
                A[k] = 2;
                A[i] = tmp;
                --k;
            } else {
                ++i;
            }
        }
        return;
    }
}
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k = 0, cur = 0, re_start = -1, re_len = S.length() + 1;;
        Map<Character, Integer> m1 = new HashMap<Character, Integer>();
        Map<Character, Integer> m2 = new HashMap<Character, Integer>();
        for(i = 0; i < T.length(); ++i){
            Integer cnt = m1.get(T.charAt(i));
            if(cnt == null) {
                cnt = 1;
            } else {
                cnt = cnt + 1;
            }
            m1.put(T.charAt(i), cnt);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(i = 0; i < S.length(); ++i){
            Integer cnt0 = m1.get(S.charAt(i));
            if(cnt0 != null){
                q.offer(i);
                Integer cnt = m2.get(S.charAt(i));
                if(cnt == null){
                    cnt = 1;
                } else {
                    cnt = cnt + 1;
                }
                if(cnt <= cnt0) ++k;
                m2.put(S.charAt(i), cnt);
                if(k == T.length()){
                    while(m2.get(S.charAt(q.peek())) > m1.get(S.charAt(q.peek()))){
                        Integer pos = q.poll();
                        m2.put(S.charAt(pos), m2.get(S.charAt(pos)) - 1);
                    }
                	int start = q.peek();
                    if(i - start + 1 < re_len){
                        re_len = i - start + 1;
                        re_start = start;
                    }
                    Integer pos = q.poll();
                    m2.put(S.charAt(pos), m2.get(S.charAt(pos)) - 1);
                    --k;
                }
            }
        }
        if(re_start != -1){
            return S.substring(re_start, re_start + re_len);
        }
        return "";
    }
}
public class Solution {
    private void r(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int start, int end, int k){
        if(k == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        int i, j;
        for(i = start; i <= end - k + 1; ++i){
            cur.add(i);
            r(re, cur, i + 1, end, k - 1);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        r(re, cur, 1, n, k);
        return re;
    }
}
public class Solution {
    private void r(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] S, int start, int end, int k){
        if(k == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i <= end - k + 1; ++i){
            cur.add(S[i]);
            r(re, cur, S, i + 1, end, k - 1);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(S);
        for(int i = 0; i <= S.length; ++i){
            r(re, cur, S, 0, S.length - 1, i);
        }
        return re;
    }
}
public class Solution {
    class Pair{
        int x, y; 
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object o){
            if(o == this) return true;
            if(o instanceof Pair){
                Pair p = (Pair) o;
                return p.x == this.x && p.y == this.y;
            }
            return false;
        }
        public int hashCode(){
            return x ^ y;
        }
    }
    boolean check(Set<Pair> set, char[][] board, String word, int x, int y, int cur){
        if(cur == word.length()) return true;
        Pair p;
        set.add(new Pair(x, y));
        if(x > 0 && board[x - 1][y] == word.charAt(cur)){
            p = new Pair(x - 1, y);
            if(!set.contains(p)){
                if(check(set, board, word, x - 1, y, cur + 1)){
                    return true;
                }
            }
        } 
        if(y > 0 && board[x][y - 1] == word.charAt(cur)){
            p = new Pair(x, y - 1);
            if(!set.contains(p)){
                if(check(set, board, word, x, y - 1, cur + 1)){
                    return true;
                }
            }
        }
        if(x < board.length - 1 && board[x + 1][y] == word.charAt(cur)){
            p = new Pair(x + 1, y);
            if(!set.contains(p)){
                if(check(set, board, word, x + 1, y, cur + 1)){
                    return true;
                }
            }
        }
        if(y < board[0].length - 1 && board[x][y + 1] == word.charAt(cur)){
            p = new Pair(x, y + 1);
            if(!set.contains(p)){
                if(check(set, board, word, x, y + 1, cur + 1)){
                    return true;
                }
            }
        }
        set.remove(new Pair(x, y));
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word == null || word.length() == 0) return true;
        int i, j, k, m = board.length, n = board[0].length;
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(board[i][j] == word.charAt(0)){
                    Set<Pair> set = new HashSet<Pair>();
                    if(check(set, board, word, i, j, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j = 0, k = 0;
        for(i = 0; i < A.length; ++i){
            if(i == 0 || A[i - 1] != A[i]){
                k = 1;
                A[j++] = A[i];
            } else if(k < 2) {
                ++k;
                A[j++] = A[i];
            }
        }
        int[] re = new int[j];
        for(i = 0; i < j; ++i){
            re[i] = A[i];
        }
        A = re;
        return j;
    }
}
public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low, high, mid, i, j, k;
        low = 0; high = A.length - 1;
        while(low <= high){
            if(A[low] == target || A[high] == target) return true;
            mid = (low + high) / 2;
            if(A[mid] == target) return true;
            if(A[low] == A[high] && A[high] == A[mid]){
                for(i = low; i <= high; ++i){
                    if(A[i] == target) return true;
                }
                return false;
            } else if(A[mid] < target){
                if(A[high] > target || A[high] < A[mid]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if(A[low] < target || A[low] > A[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            if(cur.val == pre.val) {
                cur = cur.next;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }
        pre.next = null;
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return head;
        ListNode pre = null, cur = head;
        head = null;
        while(cur != null){
            boolean dup = false;
            while(cur.next != null && cur.next.val == cur.val){
                dup = true;
                cur = cur.next;
            }
            if(!dup){
                if(pre == null){
                    head = cur;
                } else {
                    pre.next = cur;
                }
                pre =cur;
            }
            cur = cur.next;
        }
        if(pre != null) pre.next = null;
        return head;
    }
}
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length == 0) return 0;
        int re = 0, i, j, k, n = height.length;
        int[] lh = new int[n];
        int[] rh = new int[n];
        lh[0] = -1;
        rh[n - 1] = n;
        for(i = 1; i < n; ++i){
            j = i - 1;
            while(j >= 0 && height[j] >= height[i]){
                j = lh[j];
            }
            lh[i] = j;
        }
        for(i = n - 2; i >= 0; --i){
            j = i + 1;
            while(j < n && height[j] >= height[i]){
                j = rh[j];
            }
            rh[i] = j;
        }
        for(i = 0; i < height.length; ++i){
            j = lh[i];
            k = rh[i];
            int len = k - j - 1;
            int area = len * height[i];
            re = Math.max(re, area);
        }
        return re;
    }
}
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, i, j, k, re = 0;
        int[] h = new int[n];
        int[] lh = new int[n];
        int[] rh = new int[n];
        for(j = 0; j < n; ++j) h[j] = 0;
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(matrix[i][j] != '0'){
                    h[j] += 1;
                } else {
                    h[j] = 0;
                }
            }
            lh[0] = -1;
            rh[n - 1] = n;
            for(j = 1; j < n; ++j){
                k = j - 1;
                while(k >= 0 && h[k] >= h[j]){
                    k = lh[k];
                }
                lh[j] = k;
            }
            for(j = n - 2; j >= 0; --j){
                k = j + 1;
                while(k < n && h[k] >= h[j]){
                    k = rh[k];
                }
                rh[j] = k;
            }
            for(j = 0; j < n; ++j){
                re = Math.max(re, h[j] * (rh[j] - lh[j] - 1));
            }
        }
        return re;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode low_head = null, low_cur = null, high_head = null, high_cur = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                if(low_cur == null){
                    low_head = cur;
                } else {
                    low_cur.next = cur;
                }
                low_cur = cur;
            } else {
                if(high_cur == null){
                    high_head = cur;
                } else {
                    high_cur.next = cur;
                }
                high_cur = cur;
            }
            cur = cur.next;
        }
        if(low_cur != null){
            head = low_head;
            low_cur.next = high_head;
        } else {
            head = high_head;
        }
        if(high_cur != null) high_cur.next = null;
        return head;
    }
}
public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null && s2 == null) return true;
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        String ss1 = String.valueOf(ch1);
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);
        String ss2 = String.valueOf(ch2);
        if(!ss1.equals(ss2)) return false;
        int i, j, k;
        for(i = 1; i < s2.length(); ++i){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && 
            isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && 
            isScramble(s1.substring(i), s2.substring(0, s2.length() - i))){
                return true;
            }
        }
        return false;
    }
}
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k = m + n - 1;
        i = m - 1; j = n - 1;
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while(i >= 0){
            A[k--] = A[i--];
        }
        while(j >= 0){
            A[k--] = B[j--];
        }
        return;
    }
}
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(0);
        if(n == 0) return cur;
        cur.add(1);
        if(n == 1) return cur;
        int i, j, k;
        for(i = 2; i <= n; ++i){
            k = cur.size();
            int base = 1 << (i - 1);
            for(j = k - 1; j >= 0; --j){
                cur.add(base + cur.get(j));
            }
        }
        return cur;
    }
}
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return 0;
        int i, j, k, n = s.length();
        int[] f = new int[n + 2];
        f[n] = 1; 
        for(i = n -1; i >= 0; --i){
            if(s.charAt(i) == '0') f[i] = 0;
            else if(i == n - 1 || s.charAt(i) > '2') f[i] = f[i + 1];
            else if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) f[i] = f[i + 1] + f[i + 2];
            else f[i] = f[i + 1];
        }
        return f[0];
    }
}
public class Solution {
    private void r(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int[] num, int start, int k){
        if(k == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i <= num.length - k; ++i){
            if(i > start && num[i - 1] == num[i]) continue;
            cur.add(num[i]);
            r(re, cur, num, i + 1, k - 1);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i = 0; i <= num.length; ++i){
            r(re, cur, num, 0, i);
        }
        return re;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pre = null, tail = null, cur = null, tmp = null;
        cur = head;
        int i, j, k;
        for(i = 1; i < m; ++i){
            pre = cur;
            cur = cur.next;
        }
        for(i = m - 1; i < n; ++i){
            cur = cur.next;
        }
        tail = cur;
        if(pre == null) cur = head;
        else cur = pre.next;
        ListNode p = tail;
        while(cur!= tail){
            tmp = cur.next;
            cur.next = p;
            p = cur;
            cur = tmp;
        }
        if(pre != null) pre.next = p;
        else head = p;
        return head;
    }
}
public class Solution {
    private void r(ArrayList<String> re, ArrayList<String> cur, String s){
        if(cur.size() == 4){
            if(s.length() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(cur.get(0));
                for(int i = 1; i < 4; ++i){
                    sb.append('.');
                    sb.append(cur.get(i));
                }
                re.add(sb.toString());
            }
            return;
        }
        for(int i = 1; i <= 3 && i <= s.length(); ++i){
            String str = s.substring(0, i);
            int n = Integer.parseInt(str);
            if(n > 255 || (str.charAt(0) == '0' && str.length() > 1)) break;
            cur.add(str);
            r(re, cur, s.substring(i));
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> re = new ArrayList<String>();
        ArrayList<String> cur = new ArrayList<String>();
        r(re, cur, s);
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Item{
        TreeNode node;
        int stage;
        Item(TreeNode node, int stage){
            this.node = node;
            this.stage = stage;
        }
    }
    private void r(ArrayList<Integer> re, TreeNode root){
        if(root == null) return;
        r(re, root.left);
        re.add(root.val);
        r(re, root.right);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> re = new ArrayList<Integer>();
        //r(re, root);
        Stack<Item> s = new Stack<Item>();
        s.push(new Item(root, 0));
        while(!s.isEmpty()){
            Item it = s.pop();
            if(it.node == null) continue;
            switch(it.stage){
            case 0:
                it.stage = 1;
                s.push(it);
                s.push(new Item(it.node.left, 0));
                break;
            case 1:
                re.add(it.node.val);
                s.push(new Item(it.node.right, 0));
            }
        }
        return re;
    }
}
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] h = new int[n + 1];
        int i, j, k;
        h[0] = 1;
        h[1] = 1;
        for(i = 2; i <= n; ++i){
            k = 0;
            for(j = 0; j <= i - 1; ++j){
                k += h[j] * h[i - 1 - j];
            }
            h[i] = k;
        }
        return h[n];
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    private ArrayList<TreeNode> r(int start, int end){
        int i, j, k;
        ArrayList<TreeNode> re = new ArrayList<TreeNode>();
        if(start > end){
            re.add(null);
        } else if(start == end){
            re.add(new TreeNode(start));
        } else {
            for(i = start; i <= end; ++i){
                ArrayList<TreeNode> left = r(start, i - 1);
                ArrayList<TreeNode> right = r(i + 1, end);
                for(j = 0; j < left.size(); ++j){
                    for(k = 0; k < right.size(); ++k){
                        TreeNode cur = new TreeNode(i);
                        cur.left = left.get(j);
                        cur.right = right.get(k);
                        re.add(cur);
                    }
                }
            }
        }
        return re;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return r(1, n);
    }
}
public class Solution {
    class Triple{
        int p1, p2, p3;
        Triple(int p1, int p2, int p3){
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }
        @Override
        public int hashCode(){
            return p1 ^ p2 ^ 3;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof Triple){
                Triple t = (Triple) o;
                return t.p1 == this.p1 && t.p2 == this.p2 && t.p3 == this.p3;
            }
            return false;
        }
    }
    private boolean r(String s1, String s2, String s3, int p1, int p2, int p3, Map<Triple, Boolean> m){
        Triple t = new Triple(p1, p2, p3);
        Boolean flag = m.get(t);
        if(flag != null){
            return flag;
        }
        if(p1 == s1.length()){
            flag = s3.substring(p3).equals(s2.substring(p2));
            m.put(t, flag);
            return flag;
        }
        if(p2 == s2.length()){
            flag = s3.substring(p3).equals(s1.substring(p1));
            m.put(t, flag);
            return flag;
        }
        if(s3.charAt(p3) == s1.charAt(p1) && r(s1, s2, s3, p1 + 1, p2, p3 + 1, m)){
            m.put(t, true);
            return true;
        }
        if(s3.charAt(p3) == s2.charAt(p2) && r(s1, s2, s3, p1, p2 + 1, p3 + 1, m)){
            m.put(t, true);
            return true;
        }
        m.put(t, false);
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s3.length() != s1.length() + s2.length()) return false;
        if(s3.length() == 0) return true;
        if(s1.length() == 0) return s3.equals(s2);
        if(s2.length() == 0) return s3.equals(s1);
        String sums = s1 + s2;
        char[] ch1 = sums.toCharArray();
        Arrays.sort(ch1);
        String sumss = String.valueOf(ch1);
        char[] ch3 = s3.toCharArray();
        Arrays.sort(ch3);
        String ss3 = String.valueOf(ch3);
        if(!ss3.equals(sumss)) return false;
        Map<Triple, Boolean> m = new HashMap<Triple, Boolean>();
        return r(s1, s2, s3, 0, 0, 0, m);
    }
}
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k;
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() == 0) return s3.equals(s2);
        if(s2.length() == 0) return s3.equals(s1);
        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
        for(i = 0; i <= s1.length(); ++i){
            for(j = 0; j <= s2.length(); ++j){
                f[i][j] = false;
            }
        }
        for(i = 1; i <= s1.length(); ++i){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                f[i][0] = true;
            } else {
                break;
            }
        }
        for(i = 1; i <= s2.length(); ++i){
            if(s2.charAt(i - 1) == s3.charAt(i - 1)){
                f[0][i] = true;
            } else {
                break;
            }
        }
        for(i = 1; i <= s1.length(); ++i){
            for(j = 1; j <= s2.length(); ++j){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j]){
                    f[i][j] = true;
                } else if(s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]){
                    f[i][j] = true;
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private boolean r(TreeNode root, int low, int high){
        if(root == null) return true;
        if(root.val >= low && root.val <= high){
            return r(root.left, low, root.val - 1) && r(root.right, root.val + 1, high);
        } else {
            return false;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return r(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void r(TreeNode root, TreeNode[] t, int[] n){
        if(root == null) return;
        if(root.left != null)
            r(root.left, t, n);
        if(t[0] != null && t[0].val > root.val){
            if(n[0] == 0) {
                t[1] = t[0]; 
                t[2] = root;
                ++n[0];
            } else if(n[0] == 1){
                t[2] = root;
                return;
            }
        }
        t[0] = root;
        r(root.right, t, n);
    }
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode[] t = new TreeNode[3];
        int[] n = new int[1];
        r(root, t, n);
        int tmp = t[1].val;
        t[1].val = t[2].val;
        t[2].val = tmp;
        return;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private boolean r(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return r(left.left, right.right) && r(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        return r(root.left, root.right);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return re;
        q.offer(root);
        ArrayList<Integer> cur;
        while(!q.isEmpty()){
            cur = new ArrayList<Integer>();
            int k = q.size();
            for(int i = 0; i < k; ++i){
                TreeNode node = q.poll();
                cur.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            re.add(cur);
        }
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        if(root == null) return re;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        int i, j, k;
        TreeNode t;
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            k = q.size();
            for(i = 0; i < k; ++i){
                t = q.poll();
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
                cur.add(t.val);
            }
            if(!flag) Collections.reverse(cur);
            flag = !flag;
            re.add(cur);
        }
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode r(int[] preorder, int[]inorder, int pstart, int pend, int istart, int iend){
        if(pstart > pend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        if(pstart == pend) return root;
        int i, j, k;
        for(i = istart; i <= iend; ++i){
            if(inorder[i] == preorder[pstart]) break;
        }
        int nleft = i - istart;
        int nright = iend - i;
        root.left = r(preorder, inorder, pstart + 1, pstart + nleft, istart, i - 1);
        root.right = r(preorder, inorder, pstart + nleft + 1, pend, i + 1, iend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return r(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode r(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend){
        if(istart > iend) return null;
        TreeNode root = new TreeNode(postorder[pend]);
        if(pstart == pend) return root;
        int i, j, k;
        for(i = istart; i <= iend; ++i){
            if(inorder[i] == postorder[pend]) break;
        }
        int nleft = i - istart;
        root.left = r(inorder, postorder, istart, i - 1, pstart, pstart + nleft - 1);
        root.right = r(inorder, postorder, i + 1, iend, pstart + nleft, pend - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length == 0) return null;
        return r(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return re;
        q.offer(root);
        int i, j, k;
        while(!q.isEmpty()){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            k = q.size();
            for(i = 0; i < k; ++i){
                TreeNode t = q.poll();
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
                cur.add(t.val);
            }
            re.add(cur);
        }
        Collections.reverse(re);
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode r(int[] num, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(num[start]);
        int i, j, k, mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = r(num, start, mid - 1);
        root.right = r(num, mid + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) return null;
        return r(num, 0, num.length - 1);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int h(TreeNode root){
        if(root == null) return 0;
        return Math.max(h(root.left), h(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        return Math.abs(h(root.left) - h(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        int left, right; 
        left = minDepth(root.left);
        right = minDepth(root.right);
        if(left == 0 && right == 0){
            return 1;
        }
        if(left == 0) return 1 + right;
        if(right == 0) return 1 + left;
        return 1 + Math.min(left, right);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Pair{
        TreeNode node;
        int sum;
        Pair(TreeNode node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return false;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(root, 0));
        int i, j, k;
        while(!q.isEmpty()){
            k = q.size();
            for(i = 0; i < k; ++i){
                Pair p = q.poll();
                TreeNode t = p.node;
                int nsum = p.node.val + p.sum;
                if(t.left == null && t.right == null && nsum == sum){
                    return true;
                }
                if(t.left != null) q.offer(new Pair(t.left, nsum));
                if(t.right != null) q.offer(new Pair(t.right, nsum));
            }
        }
        return false;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void r(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, TreeNode root, int sum){
        if(root == null) return;
        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            re.add(new ArrayList<Integer>(cur));
        } else {
            r(re, cur, root.left, sum - root.val);
            r(re, cur, root.right, sum - root.val);
        }
        cur.remove(cur.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        r(re, cur, root, sum);
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private boolean r(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return r(root.left, sum - root.val) || r(root.right, sum - root.val);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return r(root, sum);
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode pre = null;
    private void preorder(TreeNode root){
        if(root == null) return;
        if(pre != null) pre.right = root;
        TreeNode right = root.right;
        pre = root;
        preorder(root.left);
        root.left = null;
        preorder(right);
    }
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        preorder(root);
    }
}
public class Solution {
    class Pair{
        int si, ti;
        Pair(int si, int ti){
            this.si = si;
            this.ti = ti;
        }
        @Override
        public int hashCode(){
            return si ^ ti;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof Pair){
                Pair p = (Pair)o;
                return p.si == this.si && p.ti == this.ti;
            }
            return false;
        }
    }
    private int r(Map<Pair, Integer> m, String S, String T, int si, int ti){
        if(ti == T.length()){
            return 1;
        }
        Pair p = new Pair(si, ti);
        Integer cnt = m.get(p);
        if(cnt != null) return cnt;
        int i, j, k = 0;
        for(i = si; i < S.length(); ++i){
            if(S.charAt(i) == T.charAt(ti)){
                k += r(m, S, T, i + 1, ti + 1);
            }
        }
        m.put(p, k);
        return k;
    }
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Pair, Integer> m = new HashMap<Pair, Integer>();
        return r(m, S, T, 0, 0);
    }
}
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void r(TreeLinkNode root){
        if(root == null) return;
        if(root.left == null) return;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        else 
            root.right.next = null;
        r(root.left);
        r(root.right);
    }
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        root.next = null;
        r(root);
    }
}
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeLinkNode p, pnext, q, r;
        while(root != null){
            p = root; q = null;
            while(p != null){
                pnext = p.next;
                while(pnext != null && pnext.left == null && pnext.right == null) pnext = pnext.next;
                if(pnext != null){
                    if(pnext.left != null){
                        r = pnext.left;
                    } else {
                        r = pnext.right;
                    }
                } else {
                    r = null;
                }
                if(p.left != null){
                    if(q == null){
                        q = p.left;
                    }
                    if(p.right != null){
                        p.left.next = p.right;
                    } else {
                        p.left.next = r;
                    }
                }
                if(p.right != null){
                    if(q == null){
                        q = p.right;  
                    }
                    p.right.next = r;
                }
                p = pnext;
            }
            root = q;
        }
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> f1 = null, f2 = null;
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return re;
        int i, j, k;
        k = 0;
        for(i = 1; i <= numRows; ++i){
            if(i == 1){
                f1 = new ArrayList<Integer>();
                f1.add(1);
                re.add(f1);
            } else if(i == 2){
                f1 = new ArrayList<Integer>();
                f1.add(1);
                f1.add(1);
                re.add(f1);
            } else {
                f2 = f1;
                f1 = new ArrayList<Integer>();
                f1.add(1);
                for(j = 1; j < f2.size(); ++j){
                    f1.add(f2.get(j - 1) + f2.get(j));
                }
                f1.add(1);
                re.add(f1);
            }
        }
        return re;
    }
}
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> re = new ArrayList<Integer>();
        int i, j, k;
        for(i = 0; i <= rowIndex; ++i){
            re.add(1);
            for(j = i - 1; j >= 1; --j){
                re.set(j, re.get(j - 1) + re.get(j));
            }
        }
        return re;
    }
}
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j, k, re = Integer.MAX_VALUE;
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int m = triangle.size(), n = triangle.get(m - 1).size();
        ArrayList<Integer> cur = new ArrayList<Integer>(Collections.nCopies(n, 0));
        for(i = 0; i < triangle.size(); ++i){
            for(j = triangle.get(i).size() - 1; j >= 0; --j){
                if(j == 0) cur.set(j, triangle.get(i).get(j) + cur.get(j));
                else if(j == triangle.get(i).size() - 1) cur.set(j, triangle.get(i).get(j) + cur.get(j - 1));
                else cur.set(j, triangle.get(i).get(j) + Math.min(cur.get(j), cur.get(j - 1)));
            }
        }
        for(i = 0; i < n; ++i){
            re = Math.min(re, cur.get(i));
        }
        return re;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length < 2) return 0;
        int i, j, k, min = prices[0], re = 0;
        for(i = 1; i < prices.length; ++i){
            if(prices[i] - min > re){
                re = prices[i] - min;
            }
            min = Math.min(min, prices[i]);
        }
        return re;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length < 2) return 0;
        int i, j, k, re = 0;
        for(i = 1; i < prices.length; ++i){
            if(prices[i] > prices[i - 1]) re += prices[i] - prices[i - 1];
        }
        return re;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length < 2) return 0;
        int i, j, k = 0, re = 0, min, max, tmp = 0, n = prices.length;
        int[] l = new int[n];
        int[] r = new int[n];
        min = prices[0];
        l[0] = 0;
        for(i = 1; i < n; ++i){
            if(prices[i] - min > tmp) tmp = prices[i] - min;
            min = Math.min(min, prices[i]);
            l[i] = tmp;
        }
        max = prices[n - 1];
        tmp = 0;
        r[n - 1] = 0;
        for(i = n - 2; i >= 0; --i){
            if(max - prices[i] > tmp) tmp = max - prices[i];
            max = Math.max(max, prices[i]);
            r[i] = tmp;
        }
        re = 0;
        for(i = 0; i < n; ++i){
            re = Math.max(l[i] + r[i], re);
        }
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int re = 0;
    private int r(TreeNode root){
        if(root == null) return 0;
        int left = r(root.left);
        int right = r(root.right);
        re = Math.max(left + right + root.val, re);
        re = Math.max(left + root.val, re);
        re = Math.max(right + root.val, re);
        re = Math.max(root.val, re);
        return root.val + Math.max(0, Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        re = root.val;
        int tmp = r(root);
        return Math.max(tmp, re);
    }
}
public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(ch1 >= 'A' && ch1 <= 'Z') ch1 = (char)(ch1 - 'A' + 'a');
            if(ch2 >= 'A' && ch2 <= 'Z') ch2 = (char)(ch2 - 'A' + 'a');
            if(!((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= '0' && ch1 <= '9'))) {++i; continue;}
            if(!((ch2 >= 'a' && ch2 <= 'z') || (ch2 >= '0' && ch2 <= '9'))) {--j; continue;}
            if(ch1 == ch2){
                ++i;
                --j;
            } else {
                return false;
            }
        }
        return true;
    }
}
public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<String> q = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        q.offer(start);
        set.add(start);
        int n = start.length();
        int re = 1;
        while(!q.isEmpty()){
            ++re;
            int k = q.size();
            for(int i = 0; i < k; ++i){
                String w = q.poll();
                char[] chs = w.toCharArray();
                for(int j = 0; j < n; ++j){
                    char tmp = chs[j];
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                        chs[j] = ch;
                        if(chs[j] == tmp) continue;
                        String ts = String.valueOf(chs);
                        if(ts.equals(end)) return re;
                        if(dict.contains(ts) && !set.contains(ts)){
                            set.add(ts);
                            q.offer(ts);
                        }
                    }
                    chs[j] = tmp;
                }
            }
        }
        return 0;
    }
}
public class Solution {
    private void r(ArrayList<ArrayList<String>> re, ArrayList<String> cur, Map<String, ArrayList<String>> m, String w){
        ArrayList<String> list = m.get(w);
        if(list == null){
            ArrayList<String> tmp = new ArrayList<String>(cur);
            Collections.reverse(tmp);
            re.add(tmp);
            return;
        }
        for(String str : list){
            cur.add(str);
            r(re, cur, m, str);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<String> q = new LinkedList<String>();
        Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        boolean find = false;
        q.offer(start);
        m.put(start, null);
        int n = start.length();
        ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
        Set<String> set = new HashSet<String>();
        while(!q.isEmpty()){
            int k = q.size();
            set.clear();
            for(int i = 0; i < k; ++i){
                String w = q.poll();
                char[] chs = w.toCharArray();
                for(int j = 0; j < n; ++j){
                    char tmp = chs[j];
                    for(char ch = 'a'; ch <= 'z'; ++ch){
                        if(ch == tmp) continue;
                        chs[j] = ch;
                        String tw = String.valueOf(chs);
                        if(tw.equals(end)){
                            find = true;
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(tw);
                            list.add(w);
                            r(re, list, m, w);
                        } else if(dict.contains(tw)){
                            if (!m.containsKey(tw)){
                                q.offer(tw);
                                ArrayList<String> wl = new ArrayList<String>();
                                wl.add(w);
                                m.put(tw, wl);
                                set.add(tw);
                            } else if(set.contains(tw)){
                                m.get(tw).add(w);
                            }
                        }
                    }
                    chs[j] = tmp;
                }
            }
            if(find) break;
        }
        return re;
    }
}
public class Solution {
    private int getCount(Set<Integer> set, int start, boolean asc){
        int re = 0;
        while(set.contains(start)){
            set.remove(start);
            ++re;
            start = asc ? start + 1 : start - 1;
        }
        return re;
    }
    public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Set<Integer> set = new HashSet<Integer>();
        if(num.length == 0) return 0;
        int i, j, k, n = num.length, re = 0;
        for(i = 0; i < n; ++i){
            set.add(num[i]);
        }
        for(i = 0; i < n; ++i){
            if(set.contains(num[i])){
                re = Math.max(re, 1 + getCount(set, num[i] - 1, false) + getCount(set, num[i] + 1, true));
            }
        }
        return re;
    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int re = 0;
    private void r(StringBuilder sb, TreeNode root){
        sb.append(root.val);
        if(root.left == null && root.right == null){
            re += Integer.parseInt(sb.toString());
        } else {
            if(root.left != null) r(sb, root.left);
            if(root.right != null) r(sb, root.right);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        re = 0;
        StringBuilder sb = new StringBuilder();
        if(root != null) r(sb, root);
        return re;
    }
}
public class Solution {
    class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int i, j, k, m = board.length, n = board[0].length;
        Stack<Pair> s = new Stack<Pair>();
        for(i = 0; i < n; ++i) {
            if(board[0][i] == 'O') s.push(new Pair(0, i));
            if(board[m - 1][i] == 'O') s.push(new Pair(m - 1, i));
        }
        for(i = 1; i < m - 1; ++i) {
            if(board[i][0] == 'O') s.push(new Pair(i, 0));
            if(board[i][n - 1] == 'O') s.push(new Pair(i, n - 1));
        }
        while(!s.isEmpty()){
            Pair p = s.pop();
            board[p.x][p.y] = 'A';
            if(p.x - 1 >= 0 && board[p.x - 1][p.y] == 'O') s.push(new Pair(p.x - 1, p.y));
            if(p.x + 1 < m && board[p.x + 1][p.y] == 'O') s.push(new Pair(p.x + 1, p.y));
            if(p.y - 1 >= 0 && board[p.x][p.y - 1] == 'O') s.push(new Pair(p.x, p.y - 1));
            if(p.y + 1 < n && board[p.x][p.y + 1] == 'O') s.push(new Pair(p.x, p.y + 1));
        }
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for(i = 0; i < m; ++i){
            for(j = 0; j < n; ++j){
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }
}
public class Solution {
    private void r(ArrayList<ArrayList<String>> re, ArrayList<String> cur, String s){
        if(s.length() == 0){
            re.add(new ArrayList<String>(cur));
            return;
        }
        for(int i = 0; i < s.length(); ++i){
            int low = 0, high = i;
            while(low < high){
                if(s.charAt(low) != s.charAt(high)) break;
                ++low; --high;
            }
            if(low >= high){
                cur.add(s.substring(0, i + 1));
                r(re, cur, s.substring(i + 1));
                cur.remove(cur.size() - 1);
            }
        }
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
        ArrayList<String> cur = new ArrayList<String>();
        r(re, cur, s);
        return re;
    }
}
public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return 0;
        int n = s.length();
        int[] p = new int[n + 1];
        boolean[][] f = new boolean[n][n];
        int i, j, k;
        for(i = 0; i <= n; ++i){
            p[i] = n - i;
        }
        for(i = 0; i < n; ++i){
            for(j = 0; j < n; ++j){
                f[i][j] = false;
            }
        }
        for(i = n - 1; i >= 0; --i){
            for(j = i; j < n; ++j){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || f[i + 1][j - 1])){
                    f[i][j] = true;
                    p[i] = Math.min(p[i], 1 + p[j + 1]);
                }
            }
        }
        return p[0] - 1;
    }
} 	
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        Map<Integer, UndirectedGraphNode> m = new HashMap<Integer, UndirectedGraphNode>();
        while(!q.isEmpty()){
            UndirectedGraphNode n1 = q.poll();
            if(m.containsKey(n1.label)) continue;
            m.put(n1.label, new UndirectedGraphNode(n1.label));
            for(UndirectedGraphNode n2 : n1.neighbors){
                q.offer(n2);
            }
        }
        q.offer(node);
        Set<Integer> set = new HashSet<Integer>();
        while(!q.isEmpty()){
            UndirectedGraphNode n1 = q.poll();
            if(set.contains(n1.label)) continue;
            set.add(n1.label);
            UndirectedGraphNode nn1 = m.get(n1.label);
            for(UndirectedGraphNode n2 : n1.neighbors){
                nn1.neighbors.add(m.get(n2.label));
                q.offer(n2);
            }
        }
        return m.get(node.label);
    }
}
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int i, j, k, n = gas.length;
        int[] f = new int[n * 2];
        for(i = 0; i < n; ++i){
            f[i] = gas[i] - cost[i];
        }
        for(i = 0; i < n; ++i){
            f[n + i] = f[i];
        }
        k = f[0]; i = 0; j = 1;
        while(i < n){
            while(k < 0 && i < j){
                k -= f[i];
                ++i;
            }
            if(k >= 0 && j - i == n) break;
            k += f[j++];
        }
        if(i < n) return i;
        return -1;
    }
}
public class Solution {
    class Pair implements Comparable<Pair>{
        int pos, rating;
        Pair(int pos, int rating){
            this.pos = pos;
            this.rating = rating;
        }
        @Override
        public int compareTo(Pair o){
            return this.rating - o.rating;
        }
    }
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(ratings.length == 0) return 0;
        int i, j, k, re = 0, n = ratings.length;
        Pair[] p = new Pair[n];
        int[] f = new int[n];
        for(i = 0; i < n; ++i){
            p[i] = new Pair(i, ratings[i]);
            f[i] = 0;
        }
        Arrays.sort(p);
        for(i = 0; i < n; ++i){
            int tmp = 1;
            if(p[i].pos > 0 && ratings[p[i].pos - 1] < p[i].rating){
                tmp = Math.max(tmp, f[p[i].pos - 1] + 1);
            }
            if(p[i].pos < n - 1 && ratings[p[i].pos + 1] < p[i].rating){
                tmp = Math.max(tmp, f[p[i].pos + 1] + 1);
            }
            f[p[i].pos] = tmp;
            re += tmp;
        }
        return re;
    }
}
public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int re = A[0];
        for(int i = 1; i < A.length; ++i){
            re = re ^ A[i];
        }
        return re;
    }
}
public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Long> f = new ArrayList<Long>();
        long k, t, n = A.length;
        int i, j, cnt = 0;
        for(i = 0; i < n; ++i){
            k = (long) A[i];
            if(k < 0){ ++cnt; k = -k;}
            j = 0;
            while(k > 0){
                t = k % 3;
                if(f.size() > j) {
                    f.set(j, (f.get(j) + t) % 3);
                } else {
                    f.add(t);
                }
                k = k / 3;
                ++j;
            }
        }
        k = 1; 
        long re = 0;
        for(i = 0; i < f.size(); ++i){
            re += k * f.get(i);
            k *= 3;
        }
        if(cnt % 3 == 1) re = -re;
        return (int)re;
    }
}
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur, tmp;
        cur = head;
        m.put(null, null);
        while(cur != null){
            tmp = new RandomListNode(cur.label);
            m.put(cur, tmp);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            tmp = m.get(cur);
            tmp.next = m.get(cur.next);
            tmp.random = m.get(cur.random);
            cur = cur.next;
        }
        return m.get(head);
    }
}
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.length() == 0) return false;
        int i, j, k, n = s.length();
        boolean[][] f = new boolean[n][n];
        for(i = 0; i < n; ++i){
            for(j = 0; j < n; ++j){
                f[i][j] = false;
            }
        }
        for(i = 1; i <= n; ++i){
            for(j = 0; j <= n - i; ++j){
                if(dict.contains(s.substring(j, j + i))){
                    f[j][j + i - 1] = true;
                } else {
                    for(k = 1; k <= i - 1; ++k){
                        if(f[j][j + k - 1] && f[j + k][j + i - 1]){
                            f[j][j + i - 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][n - 1];
    }
}
public class Solution {
    private ArrayList<String> r(String s, ArrayList<ArrayList<Integer>> ways){
        ArrayList<String> re = new ArrayList<String>();
        for(int i : ways.get(s.length() - 1)){
            if(i == 0) {
                re.add(s);
            } else {
                String tmp = s.substring(i);
                for(String pre : r(s.substring(0, i), ways)){
                    re.add(pre + " " + tmp);
                } 
            }
        }
        return re;
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();
        int i, j, k, n = s.length();
        for(i = 1; i <= n; ++i){
            String str = s.substring(0, i);
            ArrayList<Integer> list = new ArrayList<Integer>();
            ways.add(list);
            if(dict.contains(str)){
                list.add(0);
            }
            for(j = i - 1; j > 0; --j){
                String tmp = s.substring(j, i);
                if(dict.contains(tmp) && ways.get(j - 1).size() > 0){
                    list.add(j);
                }
            }
        }
        return r(s, ways);
    }
}
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;
        if(p.length() >= 2 &&p.charAt(1) == '*'){
            int i = 0;
            while(i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
                if(isMatch(s.substring(i + 1), p.substring(2))) return true;
                ++i;
            }
            return isMatch(s, p.substring(2));
        } else {
            return s.length() >= 1 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
    }
}