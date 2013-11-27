public boolean hasAllUnique(String s){
	Set<Character> set = new HashSet<Character>();
	int i;
	for(i = 0; i < s.length(); ++i){
		if(set.contains(s.charAt(i))){
			return false;
		}
		set.add(s.charAt(i));
	}
	return true;
}
public static boolean hasAllUnique(String s){
	boolean[] set = new boolean[256];
	int i;
	for(i = 0; i < 256; ++i){
		set[i] = false;
	}
	for(i = 0; i < s.length(); ++i){
		if(set[s.charAt(i)]){
			return false;
		}
	}
	return true;
}

public static isUniqueChars(String s){
	int checker = 0;
	for(int i = 0; i < s.length(); ++i){
		int val = s.charAt(i) - 'a';
		if((checker & (1 << val)) > 0){
			return false;
		}
		checker |= 1<< s.charAt(i);
	}
	return true;
}
public static String revert(char[] s){
	StringBuilder sb = new StringBuilder();
	for(int i
}
public static void removeDeplicates(char[] str){
	if(str == null) return;
	int len = str.length;
	if(len < 2) return;
	int tail = 1;
	for(int i = 0; i < len; ++i){
		int j;
		for(j = i + 1; j < tail; ++j){
			if(str[i] == str[j]) break;
		}
		if(j == tail){
			str[tail] = str[i];++tail;
		}
	}
	str[tail] = 0;
}
normal: abcdefg
all dup: aaa
null
continous dup: aaabbb

boolean isAnagrams(String s1, String s2){
	if(s1 == null || s2 == null) return false;
	if(s1.length() != s2.length()) return false;
	for(int i = 0; i < s1.length; ++i){
		if(s1.charAt(i) != s2.charAt(s1.length() - i - 1)){
			return false;
		}
	}
	return true;
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
	for(i = 1; i <= n - 1; ++i){
		j = k / fac.get(n - 1 - i);
		re.add(sb.charAt(j));
		sb.deleteCharAt(j);
	}
	return re.toString();
}

String[] pn = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
private void lcr(ArrayList<String> re, String cur, String digits){
	if(digits.length() == 0){
		re.add(cur);
		return;
	}
	for(int i = 0; i < digits.length(); ++i){
		int k = digits.charAt(i) - '0';
		for(int j = 0; j < pn[k].length(); ++j){
			lcr(re, cur + pn[k].charAt(j), digits.substring(i + 1));
		}
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
	while(q.next != null){
		q = q.next;
		p = p.next;
	}
	if(p == head){
		head = head.next;
	} else {
		p.next = p.next.next;
	}
	return head;
}
public boolean isValid(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	Stack<Character> stack = new Stack<Character>();
	//Map<Character, Character> left= new HashMap<Charater, Character>();
	Map<Character, Character> right= new HashMap<Charater, Character>();
	//left.put('(', ')');
	//left.put('[', ']');
	//left.put('{', '}');
	right.put(')', '(');
	right.put(']', '[');
	right.put('}', '{');
	for(int i = 0; i < s.length(); ++i){
		if(!right.contains(s.charAt(i)){
			stack.add(s.charAt(i));
		} else {
			if(stach.isEmpty()){
				return false;
			}
			ch = stack.pop();
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
	ArrayList<String> re = new ArrayList<Integer>();
	genPR(re, "", n, 0);
	return re;
}
class PQComparator<Integer>{
	int compare(ListNode o1, ListNode o2){
		return o1.val - o2.val;
	}
}
public ListNode mergeKLists(ArrayList<ListNode> lists) {
	// Start typing your Java solution below
	// DO NOT write main() function
	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), PQComparator<ListNode>);
	ListNode head, cur, prev
	head = null;
	if(lists == null){
		return head;
	}
	int i, j, k;
	for(ListNode node : lists){
		if(node != null){
			pq.offer(node);
		}
	}
	while(!pq.isEmpty()){
		ListNode cur = pq.poll();
		if(prev == null){
			head = cur;
		} else {
			prev.next = cur;
			prev = cur;
		}
		if(cur.next != null){
			pq.offer(cur.next);
		}
	}
	return head;
}
public ListNode swapPairs(ListNode head) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ListNode p1, p2, p3 = head;
	boolean first = true;
	while(p3 != null && p3.next != null){
		p1 = p3;
		p2 = p3.next;
		p3 = p2.next;
		p2.next = p1;
		p1.next = p3;
		if(first){
			first = false;
			head = p2;
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
		for(i = 0; i < k && end != null; ++i){
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
			prev.next = start;
			break;
		}
	}
	if(start == null){
		prev.next = start;
	}
}
int removeDuplicates(int A[], int n) {//c++
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
	int re = 0, k = 1;
	while(dividend > 0){
		while(dividend < divisor){
			divisor >> = 1;
			k >> = 1;
		}
		dividend -= divisor;
		re += k;
		divisor << = 1;
		k << = 1;
	}
	return re;
}
public ArrayList<Integer> findSubstring(String S, String[] L) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Integer> re = new ArrayList<Integer>();
	Map<String, Integer> m1 = new HashMap<String, Integer>();
	int i, j, k, len = L[0].length, n = L.length;
	for(i = 0; i < n; ++i){
		Integer count = m1.get(L[i]);
		if(count == null){
			m1.put(L[i], 1);
		} else {
			m1.put(L[i], count + 1);
		}
	}
	for(i = 0; i < S.length() - len * n; ++i){
		String tmp = S.substring(i, i + len);
		Integer count = m1.get(tmp);
		if(count != null){
			Map<String, Integer> m2 = new HashMap<String, Integer>(m1);
			m2.put(tmp, count - 1);
			for(j = 1; j < n; ++j){
				tmp = S.substring(i + j * len, i + (j + 1) * len));
				count = m2.get(tmp);
				if(count == null || count === 0){
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
	int i, j, k;
	for(i = num.length - 2; i >= 0; --i){
		if(num[i] < num[i + 1]){
			int low = i + 1, high = num.length;
			while(low < high){
				int mid = (low + high) / 2;
				if(num[mid] > num[i]){
					--high;
				} else if(num[mid] <= num[i]) {
					++low;
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
	Arrays.sort(num, i + 1, num.lenth);
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
		} else {
			if(!stack.isEmpty()){
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
		return isMath(s.substring(1), p.substring(1));
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