//给定前序遍历和中序遍历，构造二叉树
struct BinaryTreeNode {
	int m_nValue;
	BinaryTreeNode *m_pLeft, *m_pRight;
}
BinaryTreeNode* Construct(int *preOrder, int *inOrder, int length) {
	if (preOrder == NULL || inOrder == NULL || length == 0) 
		return;
	return ConstructCore(preOrder, preOrder + length - 1, 
						 inOrder, inOrder + length - 1);
}
BinaryTreeNode* ConstructCore(int *startPreOrder, int *endPreOrder, 
							  int *startInOrder, int *endInOrder) {
	int rootValue = startPreOrder[0];
	BinaryTreeNode *root = new BinaryTreeNode();
	root->m_nValue = rootValue;
	root->m_pLeft = root->m_pRight = NULL;
	if (startPreOrder == endPreOrder) {
		if (startInOrder == endInOrder && *startPreOrder == *startInOder) {
			return root;
		} else {
			throw std::exception("Invalid sequence.");
		}
	}
	int *rootInOrder = startInOrder;
	while(rootInOrder <= endInOrder && *rootInOrder != rootValue)
		rootInOrder++;
	if (rootInOrder == endInOrder && *rootInOrder != rootValue) {
		throw std::exception("Invalid sequence.");
	}
	int leftLength = rootInOrder - startInOrder;
	int *leftPreOrderEnd = startPreOrder + leftLength;
	if (leftLength > 0) {
		root->m_pLeft = ConstructCore(startPreOrder + 1, leftPreOrderEnd,
									  startInOrder, rootInOrder - 1);
	}
	if (leftLength < endPreOrder - startPreOrder) {
		root->m_pRight = ConstructCore(leftPreOrderEnd + 1, endPreOrder,
									   rootInOrder + 1, endInOrder);
	}
	return root;
}

//这么简单的字典序全排列
void Print1ToMaxOfNDigits(int n) {
	if (n < 0)
		return;
	char *number = new char[n + 1];
	number[n] = '\0';
	for (int i = 0; i < 10; ++i) {
		number[0] = i + '0';
		Print1ToMaxOfNDigitsRecursively(number, n, 0);
	}
	delete number[];
}
void Print1ToMaxOfNDigitsRecursively(char *number, int length, int index) {
	if (index == length - 1) {
		PrintNumber(number);
		return;
	}
	for (int i = 0; i < 10; ++i) {
		number[index + 1] = i + '0';
		Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
	}
}

//合并升序链表，递归
ListNode *Merge(ListNode *pHead1, ListNode *pHead2) {
	if (pHead1 == NULL)
		return pHead2;
	if (pHead2 == NULL)
		return pHead1;
	ListNode *pMergeHead = NULL;
	if (pHead1->value < pHead2->value) {
		pMergeHead = pHead1;
		pMergeHead->next = Merge(pHead1->next, pHead2);
	} else {
		pMergeHead = pHead2;
		pMergeHead->next = Merge(pHead1, pHead2->next);
	}
	return pMergeHead;
}
//合并升序链表，非递归
ListNode *Merge(ListNode *pHead1, ListNode *pHead2) {
	ListNode *pMergeHead = NULL;
	ListNode *pMergeNode = NULL;
	while(pHead1 != NULL && pHead2 != NULL) {
		if (pHead1->value < pHead2->value) {
			if (pMergeNode == NULL) {
				pMergeHead = pHead1;
				pMergeNode = pHead1;
			} else {
				pMergeNode->next = pHead1;
				pMergeNode = pMergeNode->next;
			}
			pHead1 = pHead1->next;
		} else {
			if (pMergeNode == NULL) {
				pMergeHead = pHead2;
				pMergeNode = pHead2;
			} else {
				pMergeNode->next = pHead2;
				pMergeNode = pMergeNode->next;
			}
			pHead1 = pHead2->next;
		}
	}
	if (pHead1 == NULL) {
		if (pMergeNode == NULL) {
			pMegeHead = pHead2;
		} else {
			pMergeNode->next = pHead2;
		}
	} else {
		if (pMergeNode == NULL) {
			pMegeHead = pHead1;
		} else {
			pMergeNode->next = pHead1;
		}
	}
	return pMergeHead;
}

//二叉树 B是否是A的子树判断
bool HasSubTree(BinaryTreeNode *pRoot1, BinaryTreeNode *pRoot2) {
	if (pRoot2 == NULL)
		return true;
	if (pRoot1 == NULL)
		return false;
	bool result = false;
	if (pRoot1->value == pRoot2)
		result = DoesTree1HasTree2(pRoot1, pRoot2);
	if (!result) 
		result = HasSubTree(pRoot1->left, pRoot2);
	if (!result)
		result = HasSubTree(pRoot1->right, pRoot2);
	return result;
}
bool DoesTree1HasTree2(BinaryTreeNode *pRoot1, BinaryTreeNode *pRoot2) {
	if (pRoot2 == NULL)
		return true;
	if (pRoot1 == NULL)
		return false;
	if (pRoot1->value != pRoot2->value)
		return false;
	return DoesTree1HasTree2(pRoot1->left, pRoot2->left)
		&& DoesTree1HasTree2(pRoot1->right, pRoot2->right);
}

//顺时针打印矩阵
//使用了全局二维数组，如果直接传参数 int **a,函数里需要手动寻址访问数组元素
int a[30][30];
void printNum(int n_start, int row_start, int row_end, 
			  int col_start, int col_end) {
	int i, j;
	if(row_start > row_end || col_start > col_end) 
		return;
	for(i = col_start; i <=col_end; i++) {
		a[row_start][i] = n_start++;
	}
	for(i = row_start + 1; i <= row_end; i++) {
		a[i][col_end] = n_start++;
	}
	for(i = col_end - 1; i >= col_start; i--) {
		a[row_end][i] = n_start++;
	}
	for(i = row_end - 1; i > row_start; i--) {
		a[i][col_start] = n_start++;
	}
	printNum(n_start, row_start + 1, row_end - 1, 
		col_start + 1, col_end - 1);
}
//调用
int row_start, row_end, col_start, col_end;
row_start = col_start = 1;
row_end = col_end = 10;
printNum(1, row_start, row_end, col_start, col_end);

//栈的压入、弹出序列
bool IsPopOrder(const int *pPush, const int *pPop, int nLength) {
	bool bPossible = false;
	if (pPush != NULL && pPop != NULL || nLength > 0) {
		const int *pNextPush = pPush;
		const int *pNextPop = pPop;
		std::stack<int> stackData;
		while(pNextPop - pPop < nLength) {
			while(stackData.empty() || stackData.top() != *pNextPop) {
				if (pNextPush - pPush == nLength)
					break;
				stackData.push(*pNextPush);
				pNextPush++;
			}
			if(stackData.top() != pNextPop)
				break;
			stackData.pop();
			pNextPop++;
		}
		if(stackData.empty() && pNextPop - pPop == nLength)
			bPossible = true;
	}
	return bPossible;
}

//数对之差的最大值
int solve(int array[], int n)
{
	int min_v = array[n-1], ans = 0;
	for (int i = n - 2; i >= 0; --i)
	ans = max(ans, array[i] - min_v), min_v = min(min_v, array[i]);
	return ans;
}

//            10
//         /      \
//        6        15
//       /\        /\
//      4  8     12  16
//               / \
//              11 14

//二叉搜索树转换成双向链表
void Convert(BinaryTreeNode *pNode, BinaryTreeNode **pLastNode) {
	if (pNode == NULL)
		return;
	Convert(pNode->left, pLastNode);
	pNode->left = *pLastNode;
	if (*pLastNode != NULL) 
		(*pLastNode)->right = pNode;
	pLastNode = pNode;
	Convert(pNode->right, pLastNode);
}
BinaryTreeNode* ConvertToList(BinaryTreeNode *pRoot) {
	BinaryTreeNode *pLastNode = NULL;
	Convert(pRoot, &pLastNode);
	BianryTreeNode *pHead = pRoot;
	while(pHead != NULL && pHead->left != NULL)
		pHead = pHead->left;
	return pHead;
}


int InversePairsCore(int *data, int *copy, int start, int end) {
	if (start == end) {
		copy[start] = data[start];
		return 0;
	}
	int length = (end - start) / 2;
	int left = InversePairsCore(copy, data, start, start + length);
	int right = InversePairsCore(copy, data, start + length + 1, end);
	int i = start + length;
	int j = end;
	int indexCopy = end;
	int count = 0;
	while(i >= start && j >= start + length + 1) {
		if(data[i] > data[j]) {
			copy[indexCopy--] = data[i--];
			count += j - start - length;
		} else {
			copy[indexCopy--] = data[j--];
		}
	}
	for (; i >= start; --i) 
		copy[indexCopy--] = data[i];
	for (; j >= start + length + 1; --j)
		copy[indexCopy--] = data[j];
	return left + right + count;
}
int InversePairs(int *data, int length) {
	if (data == NULL || length < 0) 
		return 0;
	int *copy = new int[length];
	for (int i = 0; i < length; ++i)
		copy[i] = data[i];
	int count = InversePairsCore(data, copy, 0, length - 1);
	delete []copy;
	return count;
}

int GetUglyNumbers(int index) {
	if(index <= 0)
		return 0;
	int *pUglyNumbers = new int[index];
	pUglyNumbers[0] = 1;
	int nextUglyIndex = 1;
	int *pMultiply2 = pUglyNumbers;
	int *pMultiply3 = pUglyNumbers;
	int *pMultiply5 = pUglyNumbers;
	while(nextUglyIndex < index) {
		int min = Min(*pMultiply2 * 2, *pMultiply3 * 3, *pMultiply5 * 5);
		pUlgyNumbers[nextUglyIndex] = min;
		while(*pMultiply2 * 2 <= pUglyNumbers[nextUglyIndex])
			++pMultiply2;
		while(*pMultiply3 * 3 <= pUglyNumbers[nextUglyIndex])
			++pMultiply3;  		while(*pMultiply5 * 5 <= pUglyNumbers[nextUglyIndex])
			++pMultiply5;
		++nextUglyIndex;
	}
	int ugly = pUglyNumbers[nextUglyIndex - 1];
	delete[] pUglyNumbers;
	return ugly;
}
int Min(int number1, int number2, int number3) {
	int min = (number1 < number2) ? number1 : number2;
	min = (min < number3) ? min: number3;
	return min;
}
//遍历二叉树，返回树的深度
int TreeDepth(BinaryTreeNode *pRoot) {
	if(pRoot == NULL)
		return 0;
	int nLeft = TreeDepth(pRoot->m_pLeft);
	int nRight = TreeDepth(pRoot->m_pRight);
	return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
}

//位运算实现加法
int Add(int num1, int num2) {
	int sum, carry;
	do {
		sum = num1 ^ num2;
		carry = (num1 & num2) << 1;
		num1 = sum;
		num2 = carry;
	} while (num2 != 0);
	return num1;
}
//atoi
enum Status {kValid = 0, kInvalid};
int g_nStatus = kValid;
int StrToInt(const char *str) {
	g_nStatus = kInvalid;
	long long num = 0;
	if (str != NULL && *str != '\0') {
		bool minus = false;
		if(*str == '+')
			str++;
		else if (*str == '-'){
			minus = true;
			str++;
		}
		if (*str != '\0') {
			num = StrToIntCore(str, minus);
		}
	}
	return (int)num;
}
long long StrToIntCore(const char *digit, bool minus) {
	long long num = 0;
	while (*digit != '\0') {
		if (*digit >= '0' && *digit <= '9') {
			int flag = minus ? -1 : 1;
			num = num * 10 + flag * (*digit - '0');				
			if ((!minus && num > 0x7FFFFFFFF) 
				|| (minus && num < (signed int)0x800000000)) {
				num = 0;
				break;
			}
			digit++;
		} else {
			num = 0; 
			break;
		}
	} 
	if (*digit == '\0') {
		g_nStatus = kValid;
	}
	return num;
}
int atoi(char *str) {
	g_nStatus = kInvalid;
	int num = 0;
	if(str != NULL){
		bool minus = false;
		if 
		while(*str != '\0'){
			if (*str >= '0' && *str <= '9') {
				num = num * 10 + (*str - '0');
				str++;
			} else {
				num = 0;
				break;
			}			
		}
		if (*str == '\0') {
			g_nStatus = kValid;
			if (minus)
				num = 0 - num;
		}
	}
	return num;
}
#define EPS 0.000001
double mysqrt1(double target) {
	double low = 0.0, high, mid, gap = EPS + 1, tmp;
	int count = 0;
	high = (1.0 > target) ? 1.0 : target;
	while(low < high && gap > EPS) {
		mid = (low + high) / 2;
		tmp = mid * mid;
		gap = fabs(tmp - target);
		if (tmp > target) {
			high = mid - EPS;
		} else {
			low = mid + EPS;
		}
		++count;
	}
	return mid;
}
double mysqrt2(double target) {
	double guess = target, gap = EPS + 1;
	int count = 0;
	while(gap > EPS) {
		guess = guess - (guess * guess - target) / (2 * guess);
		++count;
		printf("count=%3d, re=%.6lf\n", count, guess);
	}
	return guess;
}
typedef map<Node*, Node*> NodeMap;
Node * copy_recursive(Node *cur, NodeMap & nodeMap) {
	if(cur == null) return null;
	NodeMap::iterator i = nodeMap.find(cur);
	if(i != nodeMap.end()) {
		return i->second;
	}
	Node *node = new Node;
	nodeMap[cur] = node;
	node->ptr1 = copy_recursive(cur->ptr1, nodeMap);
	node->ptr2 = copy_recursive(cur->ptr2, nodeMap);
	return node;
}
Node* copy_structure(Node* root) {
	NodeMap nodeMap;
	return copy_recursive(root, nodeMap);
}
class smart_pointer{
public:
	smart_pointer(void *ptr) {
		this->ptr = ptr;
		count = new int(0);
	}
	~smart_pointer() {
		if(this->count > 0) {
			this->count--;
		} else {
			delete ptr;
			delete count;
		}
	}
	smart_pointer& operator =(smart_pointer& other) {
		this->ptr = other->ptr;
		this->count = other->count;
		this->count++;
	}
private:
	void *ptr;
	int *count;
}
template<typename T>
class SmartPointer{
public:
	SmartPointer(T * ptr) {
		ref = ptr;
		ref_count = (unsigned *)malloc(sizeof(unsigned));
		*ref_count = 1;
	}
	SmartPointer(SmartPointer<T> & sptr) {
		ref = sptr.ref;
		ref_count = sptr.ref_count;
		++*ref_count;
	}
	SmpartPointer<T> & operator =(SmartPointer & sptr) {
		if(this != &sptr) {
			ref = sptr.ref;
			ref_count = sptr.ref_count;
			++*ref_count;
		}
		return *this;
	}
	~SmartPointer() {
		--*ref_count;
		if(*ref_count == 0) {
			delete ref;
			free(ref_count);
			ref = NULL;
			ref_count = NULL;
		}
	}
	T getVale() {return *ref;}
protected:
	T *ref;
	unsigned * ref_count;
}
void * aligned_malloc(size_t required_bytes, size_t alignment) {
	void *p1;
	void **p2;
	int offset = alignment - 1 + sizeof(void *);
	if((p1 = (void *)malloc(required_bytes + offset)) == NULL) {
		return NULL;
	}
	p2 = (void **)(((size_t)(p1) + offset) & ~(alignment - 1));
	p2[-1] = p1;
	return p2;
}
void aligned_free(void *p){
	free (((void **)p)[-1]);
}
#include <malloc.h>
int ** my2DAlloc(int rows, int cols) {
	int header = rows * sizeof(int);
	int data = rows * cols * sizeof(int);
	int **rowptr = (int**)malloc(header + data);
	int *buf = (int*)(rowptr + rows);
	int k;
	for(k = 0; k < rows; ++k) {
		rowprt[k] = buf + k * cols;
	}
	return rowptr;
}
int getMax(int a, int b)
{
	int c = a - b;
	int k = (c >> 31) & 0x1;
	return a - k * c;
}
int mapN(char ch){
	switch(ch) {
	case 'R':return 0;
	case 'Y':return 1;
	case 'G':return 2;
	case 'B':return 3;
	}
}
int min(int a, int b) {
	return a < b ? a : b;
}
public static void print_hits(char[] guess, char[] solution) {
	int hits = 0, pseudo_hits = 0, i, j;
	int colors[2][4];
	for(i = 0; i < 2; ++i) {
		for(j = 0;j < 4; ++j){
		 colors[i][j] = 0;
		}
	}
	for(i = 0; i < 4; ++i) {
		if(guess[i] == solution[i]) {
			++hits;
		}
		colors[0][mapN(guess[i])]++;
		colors[1][mapN(solution[i])]++;
	}
	for(i = 0; i < 4; ++i) {
		pseudo_hits += min(colors[0][i], colors[1][i]);
	}
	pseudo_hits -= hits;
	System.out.println("Hits: " + hits + "; Pseudo hits: " + pseudo_hits);
}
public static void printNum(int n){
	String[] tens={"Ten", "Eleven", "Twelve", "Thirteen", "Forteen", "Fifteen",
		"Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String[] ty = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
		"Eighty", "Ninety"};
	String[] ones={"One", "Two", "Three", "Four", "Five", "Six", "Seven",
		"Eight", "Nine"};
	String[] ex={"Hundred", "Thousand"};
	int[] e10 = {1, 10, 100, 1000, 10000, 100000};
	int i, h[6], count = 0;
	while(n > 0) {
		h[count++] = n % 10;
		n /= 10;
	}
	for(i = count; i < 6; ++i){
		h[i] = 0;
	}
	StringBuilder sb = new StringBuilder();
	for(i = 3; i >= 0; i -= 3) {
		if(h[i + 2] > 0) {
			sb.append(ones[h[i + 2] - 1]);
			if(h[i + 1] > 0 || h[i + 1] > 0) {
				sb.append(" and ");
			}
		}
		if(h[i + 1] > 2) {
			sb.append(ty[h[i + 1] - 2] + " ");
			if (h[i] > 0) {
				sb.append(ones[h[i] - 1] + " ");
			}
		} else if(h[i + 1] == 1) {
			sb.append(tens[h[0] + " ");
		} else {
			if (h[i] > 0) {
				sb.append(ones[h[i] - 1] + " ");
			}
		}
		if(i == 3 && sb.length > 0) {
			sb.append(" Thousand,");
		}
	}
}
public static void LIS(int[] a, int n) {
	int begin = 0, end = 0, cur = a[0], max = a[0], new_begin = 1, i, j, k;
	for(i = 1; i < n; ++i) {
		cur += a[i];
		if(cur > 0) {
			if(cur > max) {
				max = cur;
				begin = new_bein;
				end = i;
			}
		} else {
			new_begin = i;
			cur = 0;
		}
	}
	for(i = begin; i <= end; ++i) {
		System.out.println(a[i] + " ");
	}
}
public static int rand7() {
	static int[][] a = {
		{1, 2, 3, 4, 5},
		{6, 7, 1, 2, 3},
		{4, 5, 6, 7, 1},
		{2, 3, 4, 5, 6},
		{7, 0, 0, 0, 0}};
	int x, y, re = 0;
	while(re == 0) {
		x = random5();
		y = random5();
		re = a[x][y];
	}
	return re;
}
public static void shuffleArray(int[] cards) {
	int temp, index;
	for(int i = cards.length - 1; i >= 0; --i) {
		index = (int)(Math.radom() * i);
		temp = cards[i];
		cards[i] = cards[index];
		cards[index] = temp;
	}
}

class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
    	sort(num.begin(), num.end());
		vector<int>::iterator it1, it2;
		int b1, b2;
		for(it1 = num.begin(); it1 != num.end() && (*it1) <= 0; ++it1) {
			if(it1 != num.begin() && b1 == *it1) continue;
			for(it2 = it1 + 1; it2 != num.end() && (*it1 + *it2) <= 0; ++it2) {
				if((it2 != it1 + 1 )&& b2 == *it2) continue;
				if (binary_search(it2 + 1, num.end(), -(*it1 + *it2))) {
					vector<int> *tmp = new vector<int>();
					tmp->push_back(*it1);
					tmp->push_back(*it2);
					tmp->push_back(-(*it1 + *it2));
					re.push_back(*tmp);
				}
				b2 = *it2;
			}
			b1 = *it1;
		}
		return re;
    }
};
class Solution {
public:
    int bsearch(vector<int> &num, int low, int high, int target) {
    	int mid;
		while(low <= high) {
			mid = (low + high) / 2;
			if (num[mid] == target) {
				return mid;
			} else if(num[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}
	int threeSumClosest(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(num.begin(), num.end());
		int i, j, re, index, tmp, t2;
		bool first = true;
		for(i = 0; i < num.size() - 2; ++i) {
			for(j = i + 1; j < num.size() - 1; ++j) {
				index = bsearch(num, j + 1, num.size() - 1, target - num[i] - num[j]);
				if(index <= j) index = j + 1;
				if(index < num.size()) {
					tmp = num[i] + num[j] + num[index];
					if(tmp == target) {
						return target;
					} else {
						if(index < num.size() - 1) {
							t2 = num[i] + num[j] + num[index + 1];
							if (fabs(static_cast<double>(t2 - target)) < fabs(static_cast<double>(tmp - target))) {
								tmp = t2;
							}
						}
						if(first) {
							re = tmp;
							first = false;
						} else if (fabs(static_cast<double>(tmp - target)) < fabs(static_cast<double>(re - target))) {
							re = tmp;
						}
					}
				}
			}
		}
		return re;
    }
};
class Solution {
public:
    string addBinary(string a, string b) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string::reverse_iterator ita, itb;
    	ita = a.rbegin();
		itb = b.rbegin();
		string re;
		int carry = 0, da, db, sum;
		while(ita != a.rend() && itb != b.rend() ){
			da = *ita - '0';
			db = *itb - '0';
			sum = da + db + carry;
			carry = sum / 2;
			sum &= 0x1;
			re.push_back('0' + sum);
			++ita;
			++itb;
		}
		while(ita != a.rend()) {
			da = *ita - '0';
			sum = da + carry;
			carry = sum / 2;
			sum &= 0x1;
			re.push_back('0' + sum);
			++ita;
		}
		while(itb != b.rend()) {
			db = *itb - '0';
			sum = db + carry;
			carry = sum / 2;
			sum &= 0x1;
			re.push_back('0' + sum);
			++itb;
		}
		if(carry != 0) {
			re.push_back('1');
		}
		reverse(re.begin(), re.end());
		return re;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int c = 0, sum;
        ListNode *p, *head, *tmp;
        head = NULL;
        while(l1 != NULL && l2 != NULL) {
            sum = l1->val + l2->val + c;
            c = sum / 10;
            tmp = new ListNode(sum % 10);
            if(head == NULL) {
                head = tmp;
            } else {
                p->next = tmp;                
            }
            p = tmp;
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1 != NULL) {
            sum = l1->val + c;
            c = sum / 10;
            tmp = new ListNode(sum % 10);
            if(head == NULL) {
                head = tmp;
            } else {
                p->next = tmp;
            }
            p = tmp;
            l1 = l1->next;
        }
        while(l2 != NULL) {
            sum = l2->val + c;
            c = sum / 10;
            tmp = new ListNode(sum % 10);
            if(head == NULL) {
                head = tmp;
            } else {
                p->next = tmp;
            }
            p = tmp;
            l2 = l2->next;
        }
        if(c != 0) {            
            tmp = new ListNode(c);
            p->next = tmp;
        }
        return  head;
    }
};
class Solution {
public:
    struct item{    	
        string str;
        int id;
        item(string &str, int id):str(str), id(id) {}
		bool operator <(const item & other) const{
			return str.compare(other.str) < 0;
		}
    };
    vector<string> anagrams(vector<string> &strs) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
		vector<item> v;
        int *flag = new int[strs.size()];
        memset(flag, 0, sizeof(int) * strs.size());
        int i;
        for(i = 0; i < strs.size(); ++i) {
			item ti(strs[i], i);
			sort(ti.str.begin(), ti.str.end());
			v.push_back(ti);
        }
        sort(v.begin(), v.end());
        for(i = 1; i < v.size(); ++i) {
			if(v[i].str.compare(v[i - 1].str) == 0) {
                if(!flag[i]) {
					re.push_back(strs[v[i].id]);
					flag[i] = 1;
                }
				if(!flag[i - 1]) {
					re.push_back(strs[v[i - 1].id]);
					flag[i - 1] = 1;
				}
            }
        }
        return re;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int height(TreeNode *root) {
        if(root == NULL) return 0;
        int lh, rh, h;
        lh = height(root->left);
        rh = height(root->right);
        h = lh > rh ? lh : rh;
        return h + 1;
    }
    bool isBalanced(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int lh, rh;
        if(root == NULL) return true;
        lh = height(root->left);
        rh = height(root->right);
        return abs(lh - rh) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }
};
/**
 * 中序遍历非递归
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        stack<TreeNode*> s;
        TreeNode *cur = root;
        while(cur != NULL ||!s.empty()) {
            while(cur != NULL) {
                s.push(cur);
                cur = cur->left;
            }
            if(!s.empty()) {
                cur = s.top();
                s.pop();
                re.push_back(cur->val);
                cur = cur->right;
            }
        }
        return re;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        queue<TreeNode*> q[2];
        TreeNode *p;
        int index = 0; 
        if(root == NULL) return re;
        q[0].push(root);
        while(!q[0].empty()||!q[1].empty()){
            vector<int> v;
            while(!q[index].empty()){
                p = q[index].front();
                v.push_back(p->val);
                q[index].pop();
                if(p->left != NULL) {
                    q[1 - index].push(p->left);
                }
                if(p->right != NULL) {
                    q[1 - index].push(p->right);
                }
            }
            index = 1 - index;
            re.push_back(v);
        }
        return re;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        queue<TreeNode*> q[2];
        TreeNode *p;
        int index = 0; 
        if(root == NULL) return re;
        q[0].push(root);
        while(!q[0].empty()||!q[1].empty()){
            vector<int> v;
            while(!q[index].empty()){
                p = q[index].front();
                v.push_back(p->val);
                q[index].pop();
                if(p->left != NULL) {
                    q[1 - index].push(p->left);
                }
                if(p->right != NULL) {
                    q[1 - index].push(p->right);
                }
            }
            index = 1 - index;
    		re.push_back(v);
        }
		reverse(re.begin(), re.end());
        return re;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        queue<TreeNode*> q[2];
        TreeNode *p;
        int index = 0; 
        if(root == NULL) return re;
        q[0].push(root);
        while(!q[0].empty()||!q[1].empty()){
            vector<int> v;
            while(!q[index].empty()){
                p = q[index].front();
                v.push_back(p->val);
                q[index].pop();
                if(p->left != NULL) {
                    q[1 - index].push(p->left);
                }
                if(p->right != NULL) {
                    q[1 - index].push(p->right);
                }
            }
    		if(index == 1) {
				reverse(v.begin(), v.end());
			}
            index = 1 - index;
			re.push_back(v);
        }
        return re;
    }
};
class Solution {
public:
    int climbStairs(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0) return 1;
        if(n == 1) return 1;
        int i, t[3];
        t[0] = 1, t[1] = 1;
        for(i = 2; i <= n; ++i) {
            t[i % 3] = t[(i + 2) % 3] + t[(i + 1) % 3];
        }
        return t[(i + 2) % 3];
    }
};
class Solution {
public:
    void update(vector<vector<int> > &vold, vector<vector<int> >&vnew, int c){
    	vector<vector<int> > tmp = vold;
		int i;
		if(tmp.size() == 1 && tmp[0][0] == 0) {
			tmp[0].clear();
		}
		for(i = 0; i < tmp.size(); ++i) {
		      tmp[i].push_back(c);
		}
		vnew.insert(vnew.end(), tmp.begin(), tmp.end());
    }
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<vector<int> > >  re(target + 1);
        int i, j, c;
		vector<int> re00;
		re00.push_back(0);
		re[0].push_back(re00);
        sort(candidates.begin(), candidates.end());
        for(i = 0; i < candidates.size(); ++i) {
            c = candidates[i];
            for(j = c; j <= target; ++j) {
                update(re[j - c], re[j], c);
            }
        }
        return re[target];
    }
};
class Solution {
public:
    void update(vector<vector<int> > &vold, vector<vector<int> >&vnew, int c){
        vector<vector<int> > tmp = vold;
		int i;
		if(tmp.size() == 1 && tmp[0][0] == 0) {
			tmp[0].clear();
		}
		for(i = 0; i < tmp.size(); ++i) {
		      tmp[i].push_back(c);
		}
		vnew.insert(vnew.end(), tmp.begin(), tmp.end());
    }
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<vector<int> > >  re(target + 1);
        map<vector<int>, bool> dict;
        int i, j, c;
    	vector<int> re00;
		re00.push_back(0);
		re[0].push_back(re00);
        sort(num.begin(), num.end());
        for(i = 0; i < num.size(); ++i) {
            c = num[i];
            for(j = target; j >= c; --j) {
                update(re[j - c], re[j], c);
            }
        }
        vector<vector<int> > dr;
        for(i = 0; i < re[target].size(); ++i) {
            if(dict.find(re[target][i]) == dict.end()) {
                dr.push_back(re[target][i]);
                dict[re[target][i]] = true;
            }
        }
        return dr;
    }
};
class Solution {
public:
    void combineR(vector<bool> &flag, vector<vector<int> > &re, int n, int k ,int index,
        vector<int> tmp) {
        if(index > k) {
            re.push_back(tmp);
        } else {
            int i, init;
            if(tmp.size() == 0) {
                init = 0;
            } else {
                init = tmp.back();
            }
            for(i = init + 1; i <= n; ++i) {
                if(!flag[i]) {
                    flag[i] = true;
                    tmp.push_back(i);
                    combineR(flag, re, n, k, index + 1, tmp);
                    tmp.pop_back();
                    flag[i] = false;
                }
               
            }
        }
    }
    vector<vector<int> > combine(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<bool> flag(n + 1, false);
        vector<vector<int> > re;
        vector<int> tmp;
        combineR(flag, re, n, k, 1, tmp);
        return re;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *buildR(vector<int> &inorder, int ibegin, int iend, 
        vector<int> &postorder, int pbegin, int pend) {
            if(ibegin < 0 || iend == inorder.size() || ibegin > iend ||
                pbegin < 0 || pend == postorder.size() || pbegin > pend) return NULL; 
            int index = ibegin;
            while(index <= iend && inorder[index] != postorder[pend]) ++index;
            TreeNode *root = new TreeNode(postorder[pend]);
            int left_size = index - ibegin;
            root->left = buildR(inorder, ibegin, index - 1,
                postorder, pbegin, pbegin + left_size - 1);
            root->right = buildR(inorder, index + 1, iend,
                postorder, pbegin + left_size, pend - 1);
        return root;    
    }
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return buildR(inorder, 0, inorder.size() - 1, 
            postorder, 0, postorder.size() - 1);
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    struct item {
        int ibegin, iend, pbegin, pend;
        TreeNode *parent;
        bool left;
        item(int ibegin, int iend, int pbegin, int pend,
            TreeNode *parent, bool left):
            ibegin(ibegin), iend(iend), pbegin(pbegin), pend(pend),
            parent(parent), left(left){}
    };
    TreeNode *buildR(vector<int> &inorder, int ibegin, int iend, 
        vector<int> &postorder, int pbegin, int pend) {
            stack<item> s;
            s.push(item(ibegin, iend, 
                pbegin, pend, NULL, false));
            TreeNode *cur = NULL;
            TreeNode *root = NULL;
            while(!s.empty()) {
                item it = s.top(); s.pop();
                ibegin = it.ibegin; iend = it.iend;
                pbegin = it.pbegin; pend = it.pend;
                if(ibegin < 0 || iend == inorder.size() || ibegin > iend ||
                    pbegin < 0 || pend == postorder.size() || pbegin > pend) {
                    cur = NULL;        
                } else {
                    int index = ibegin;
                    while(index <= iend && inorder[index] != postorder[pend]) ++index;
                    cur = new TreeNode(postorder[pend]);
                    int left_size = index - ibegin;
                    s.push(item(ibegin, index - 1, 
                        pbegin, pbegin + left_size - 1, cur, true));
                    s.push(item(index + 1, iend,
                        pbegin + left_size, pend - 1, cur, false));
                }
    			if(it.parent == NULL) {
                    root = cur;
                } else {
                    if(it.left) {
                        it.parent->left = cur;
                    } else {
                        it.parent->right = cur;
                    }
                }
            }                           
        return root;    
    }
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return buildR(inorder, 0, inorder.size() - 1, 
            postorder, 0, postorder.size() - 1);
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *buildR(vector<int> &inorder, int ibegin, int iend, 
        vector<int> &preorder, int pbegin, int pend) {
            if(ibegin < 0 || iend == inorder.size() || ibegin > iend ||
                pbegin < 0 || pend == preorder.size() || pbegin > pend) return NULL; 
            int index = ibegin;
            while(index <= iend && inorder[index] != preorder[pbegin]) ++index;
            TreeNode *root = new TreeNode(preorder[pbegin]);
            int left_size = index - ibegin;
            root->left = buildR(inorder, ibegin, index - 1,
                preorder, pbegin + 1, pbegin + left_size);
            root->right = buildR(inorder, index + 1, iend,
                preorder, pbegin + left_size + 1, pend);
        return root;    
    }
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return buildR(inorder, 0, inorder.size() - 1, preorder, 0, preorder.size() - 1);
    }
};
class Solution {
public:
    int min(int a, int b) {
        return a < b ? a : b;
    }
    int maxArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int l, h, max = -1, tmp, t2;
        l = 0, h = height.size() - 1;
        while(l < h) {
            tmp = min(height[l], height[h]);
            t2 = tmp * (h - l);
            if(max == -1 || max < t2) {
                max = t2;
            }
            if(height[l] == tmp) {
                while(height[l] <= tmp && l < h) ++l;
            } else {
                while(height[h] <= tmp && l < h) --h;
            }
        }
        return max;
    }
};
class Solution {
public:
    int lengthOfLastWord(const char *s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string str(s);
    	int p1, p2, p3, p4;
		p1 = str.find_first_of(' ');
		if(p1 == -1) return str.length();
		p2 = str.find_first_not_of(' ', p1);
		if(p2 == -1) {
			return p1;
		}
		p3 = str.find_last_not_of(' ');
		p4 = str.find_last_of(' ', p3);
		return p3 - p4;
    }
};
class Solution {
public:
    void letterR(vector<string> &re, string &digits, int index, char c[10][5], 
    	string cur) {
		if(index == digits.length()) {
			re.push_back(cur);
			return;
		}
		int i, ni;
		ni = digits[index] - '0';
		for(i = 0; i < strlen(c[ni]); ++i) {
			cur.append(1, c[ni][i]);
			letterR(re, digits, index + 1, c, cur);
			cur.erase(cur.length() - 1);
		}
	}
	vector<string> letterCombinations(string digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
        char c[10][5] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int i;
		string cur;
		letterR(re, digits, 0, c, cur);
		return re;
    }
};
class Solution {
public:
    string intToRoman(int num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function 
        int i = 0, cur;
    	char ch[4][3] = {"IV", "XL", "CD", "M"};
		string re, tmp;
		vector<string> v;
		while(num > 0) {
			cur = num % 10;
			num /= 10;
			tmp.clear();
			if(cur >= 1 && cur <= 3) {
				tmp.append(cur, ch[i][0]);
			} else if(cur == 4) {
				tmp.append(ch[i]);
			} else if(cur == 5) {
				tmp.append(1, ch[i][1]);
			} else if(cur >= 6 && cur <= 8) {
				tmp.append(1, ch[i][1]);
				tmp.append(cur - 5, ch[i][0]);
			} else if(cur == 9){
				tmp.append(1, ch[i][0]);
				tmp.append(1, ch[i+ 1][0]);
			}
			v.push_back(tmp);
			++i;
		}
		for(i = v.size() - 1; i >= 0; --i) {
			re +=  v[i];
		}
        return re;
    }
};
class Solution {
public:
    struct TriplePair{
    	int p1, p2, p3;
        TriplePair(){}
		TriplePair(int p1, int p2, int p3):p1(p1), p2(p2), p3(p3) {}
		bool operator()(const TriplePair * t1, const TriplePair *t2) const {
			return t1->p1 < t2->p1 || t1->p2 < t2->p2 || t1->p3 < t2->p3;
		}
	};
    bool isR(string &s1, string &s2, string &s3, int p1, int p2, int p3, 
		map<TriplePair*, bool, TriplePair> &dict) {
		TriplePair *tp = new TriplePair(p1, p2, p3);
		if(dict.find(tp) != dict.end()) {
			return dict[tp];
		}
		bool re = false, complete = false;
        while(p1 < s1.size() & p2 < s2.size() && p3 < s3.size()) {
            if(s1[p1] == s3[p3] && s2[p2] == s3[p3]) {
                bool b1 = isR(s1, s2, s3, p1 + 1, p2, p3 + 1, dict);
                bool b2 = isR(s1, s2, s3, p1, p2 + 1, p3 + 1, dict);
				re = b1 || b2;
				complete = true;
				break;
            }
            if(s1[p1] == s3[p3]) {
                ++p1;
                ++p3;
            } else if(s2[p2] == s3[p3]) {
                ++p2;
                ++p3;
            } else {
				re = false;
				complete = true;
				break;
            }
        }
        if(!complete && p1 < s1.size() && p3 < s3.size()) {
            if(s1.size() - p1 != s3.size() - p3) {
				re = false;
				complete = true;
            } else {
                while(p1 < s1.size() && p3 < s3.size()) {
                    if(s1[p1++] != s3[p3++]) {
                        re = false;
						complete = true;
						break;
                    }
                }
            }
        }
        if(!complete && p2 < s2.size() && p3 < s3.size()) {
            if(s2.size() - p2 != s3.size() - p3) {
                re = false;
				complete = true;
            } else {
                while(p2 < s2.size() && p3 < s3.size()){
                    if(s2[p2++] != s3[p3++]){
                        re = false;
						complete = true;
						break;
                    }
                }
            }
        }
        if(!complete) {
    		if(p1 == s1.size() && p2 == s2.size() && p3 == s3.size()) {
				re = true;
			} else {
				re = false;
			}
		}
		dict.insert(make_pair(tp, re));
		return re;
    }
    bool isInterleave(string s1, string s2, string s3) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function  
		map<TriplePair*, bool, TriplePair> dict;
        return isR(s1, s2, s3, 0, 0, 0, dict);
    }
};
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, l, r, h, re = 0, tmp;
        vector<int> left(height.size()), right(height.size());
        for(i = 0; i < height.size(); ++i) {
            h = height[i];
            l = i - 1;
            while(l >= 0 && height[l] >= h) l = left[l];
            left[i] = l;
        }
    	for(i = height.size() - 1; i >= 0; --i) {
			h = height[i];
			r = i + 1;
			while(r < height.size() && height[r] >= h) r = right[r];
			right[i] = r;
		}
		for(i = 0; i < height.size(); ++i) {
			tmp = (right[i] - left[i] - 1) * (height[i]);
			re = max(re, tmp);
		}
        
        return re;
    }
};
class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(strs.size() == 0) return "";
        string minStr, re;
        re = "";
        vector<string> v;
        int i, j, k;
        minStr = strs[0];
        for(i = 1; i < strs.size(); ++i) {
            if(strs[i].length() < minStr.length()) {
                minStr = strs[i];
            }
        }
        for(i = 1; i <= minStr.length(); ++i) {
            v.push_back(minStr.substr(0, i));
        }
        for(i = 0; i < v.size(); ++i) {
            for(j = 0; j <strs.size(); ++j) {
                if(strs[j].compare(0, v[i].length(), v[i]) != 0) {
                    break;
                }
            }
            if(j == strs.size() && v[i].length() > re.length()) {
                re = v[i];
            }
        }
        return re;
    }
};
class Solution {
public:
    void calc(string & s, int l, int r, int &begin, int &len) {
        while(l >=0 && r < s.length()) {
            if(s[l] == s[r]) {
                --l;
                ++r;
            } else {
                break;
            }
        }
        int tmp = r - l - 1;
        if(tmp > len) {
            begin = l + 1;
            len = tmp;
        }
    }
    string longestPalindrome(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(s.length() == 0) return "";
        int i, l , r, tmp, begin = 0, len = 0;
        string re = "";
        for(i = 0; i < s.length(); ++i) {
            calc(s, i - 1, i + 1, begin, len);
            calc(s, i, i + 1, begin, len);
        }
        return s.substr(begin, len);
    }
};
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m[26], i, j, tmp, btmp, re = 0, begin = 0;
        for(i = 0; i < 26; ++i) {
            m[i] = -1;
        }
        tmp = 0;
        for(i = 0; i < s.length(); ++i) {
            j = s[i] - 'a';
            if(m[j] < 0) {
                m[j] = i;                    
                tmp = i - begin + 1;
                re = max(re, tmp);
            } else {
                tmp = i - begin;
                btmp = m[j] + 1;
    			if(btmp > begin) {
					begin = btmp;
				} else {
    			    ++tmp;   
				}
                re = max(re, tmp);
                m[j] = i;
            }
        }
        return re;
    }
};
class Solution {
public:
    
    int longestValidParentheses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<pair<int, int> > st;
        int re = 0, i, j, len, curBonus = 0;
        for(i = 0; i < s.length(); ++i) {
            if(s[i] == '(') {
                st.push(make_pair(i, curBonus));
                curBonus = 0;
            } else {
                curBonus = 0;
                if(!st.empty()) {
                    pair<int, int> p = st.top();
                    st.pop();
                    len = i - p.first + 1;
                    curBonus = len + p.second;
                    if(curBonus > re) {
                        re = curBonus;
                    }
                }
            }
        }
        return re;
    }
};
class Solution {
public://still error! of the final test case.
    int maximalRectangle(vector<vector<char> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<pair<pair<int, int>, vector<pair<int, int> > > > > v;
    	vector<pair<pair<int, int>, vector<pair<int, int> > > > rv;
		vector<pair<int, int> > pv;
		vector<pair<int, int> >::iterator it;
        int re = 0, i, j, k, cols, t, r, c, tmp, tr;
        for(i = 0; i < matrix.size(); ++i) {
            cols = matrix[i].size();
            rv.clear();
            v.push_back(rv);
            for(j = 0; j < cols; ++j) {    
				if(i == 1 && j == 5) {
					int safd = 1;
				}
                t = matrix[i][j] - '0';
                pair<int, int> p = make_pair(i, j);
                pair<int, int> q = make_pair(i, j);
				pv.clear();
				tr = 0;
                if(t == 1) {
                    tr = max(tr, 1);
                    if(i != 0 && matrix[i - 1][j] == '1') {
                        p.first = v[i - 1][j].first.first;
						tmp = i - p.first + 1;
                        if(tmp > tr) {
							pv.clear();
                            q.first = p.first;
							pv.push_back(make_pair(p.first, j));
                            tr = tmp;
                        } else if(tmp == tr) {
							pv.push_back(make_pair(p.first, j));
						}
                    }
                    if(j != 0 && matrix[i][j - 1] == '1') {
                        p.second = v[i][j - 1].first.second;
						tmp = j - p.second + 1;
                        if(tmp > tr) {
							pv.clear();
                            q.second = p.second;
							pv.push_back(make_pair(i, p.second));
                            tr = tmp;
                        } else {
							pv.push_back(make_pair(i, p.second));
						}
                    }
                    if(i > 0 && j > 0 && matrix[i - 1][j - 1] == '1') {
						for(it = v[i - 1][j - 1].second.begin(); it != v[i - 1][j - 1].second.end(); ++it) {
							r = max(it->first, p.first);
							c = max(it->second, p.second);
							while(r < i && c < j && matrix[r][c] == '0') {++r; ++c;}
							int x1, x2;
						//	x1 = max(v[r][c].
							tmp = (i - r + 1) * (j - c + 1);
							if(tmp > tr) {
								pv.clear();
								q.first = r;
								q.second = c;
								pv.push_back(make_pair(r, c));
								tr = tmp;
							} else {
								pv.push_back(make_pair(r, c));
							}
						}                        
                    }
                }
				if(tr == 1) {
					pv.push_back(make_pair(i, j));
				}
				re = max(re, tr);
                v[i].push_back(make_pair(p, pv));
            }
        }
        return re;
    }
};
class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) 
    {
        if(matrix.size() == 0) 
            return 0;
        vector<vector<int> > auxillary;
        for(int i = 0; i < matrix.size(); ++i) 
        {
            vector<int> temp;
            for(int j = 0; j < matrix[i].size(); ++j) 
            {
                temp.push_back(matrix[i][j] - '0');
            }
            auxillary.push_back(temp);
        }
        for(int i = 1; i < auxillary.size(); ++i) 
        {
            for(int j = 0; j < auxillary[i].size(); ++j) 
            {
                if(auxillary[i][j] == 1)
                    auxillary[i][j] = auxillary[i-1][j] + 1;
            }
        }
        
        int maxArea = 0;
        for(int i = 0; i < auxillary.size(); ++i) 
        {
            maxArea = max(maxArea, largestRectangleArea(auxillary[i]));
        }
        return maxArea;
    }
    
private:
    int largestRectangleArea(vector<int> &height) {
        stack<int> stack_;
        int maxArea = 0;
        int i = 0;
        while(i < height.size()) 
        {
            if(stack_.empty() || height[i] >= stack_.top()) 
            {
                stack_.push(height[i]);
                i++;
            }
            else 
            {
                int count = 0;
                while(!stack_.empty() && stack_.top() > height[i]) 
                {
                    count++;
                    int top = stack_.top();
                    stack_.pop();
                    maxArea = max(maxArea, top * count);
                }
                for(int j = 0; j < count + 1; ++j) 
                {
                    stack_.push(height[i]);
                }
                i++;
            }
        }
        
        int count = 0;
        while(!stack_.empty()) 
        {
            count++;
            maxArea = max(maxArea, stack_.top() * count);
            stack_.pop();
        }
        return maxArea;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) return 0;
        return 1 + max(maxDepth(root->left), maxDepth(root->right));
    }
};
class Solution {
public:
    int maxSubArray(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int curSum = 0, maxSum = A[0], i;
        for(i = 0; i < n; ++i) {
            if(curSum + A[i] >= 0) {
                curSum += A[i];
                if(curSum > maxSum) {
                    maxSum = curSum;
                }
            } else {
                if(maxSum < 0 && A[i] > maxSum) {
                    maxSum = A[i];
                }
                curSum = 0;
            }
        }
        return maxSum;
    }
};
class Solution {
public://divide and conqur
    int maxR(int A[], int begin, int end) {
        int mid = (begin + end) / 2;
        int i, j, tmp, re, rl, rr;
        if(begin == end) return A[begin];
        rl = maxR(A, begin, mid);
        rr = maxR(A, mid + 1, end);
        int left = 0, right = 0, t = 0;
        for(i = mid; i >= begin; --i) {
            t += A[i];
            if(t > left) left = t;
        }
        t = 0;
        for(i = mid + 1; i <= end; ++i) {
            t += A[i];
            if(t > right) right = t;
        }
        if(left == 0 && right == 0) {
            re = A[mid];
        } else {
            re = left + right;
        }
        //re = left + right;
        tmp = max(rl, rr);
        return max(re, tmp);
    }
    int maxSubArray(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return maxR(A, 0, n - 1);
    }
};
class Solution {
public:
    int findR(int A[], int m, int B[], int n, int k) {
        if(m == 0) {
            return B[k - 1];
        }
        if(n == 0) {
            return A[k - 1];
        }
        int mida, midb;
        m = min(m, k);
        n = min(n, k);
        mida = (m - 1) / 2;
        midb = (n - 1) / 2;
        if(A[mida] > B[midb]) {
    		if(k - 1 - midb == 0) {
				return B[midb];
			}
            if(midb == 0) {
                ++midb;
            }                 
            return findR(A, m, B + midb, n - midb, k - midb);
           
        } else {
			if(k - 1 - mida == 0) {
				return A[mida];
			}
            if(mida == 0) {
                ++mida;
			}
            return findR(A + mida, m - mida, B, n, k - mida);      
        }
    }
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int k = (m + n) / 2;
        int flag = (m + n) % 2;
        if(flag) {
            return findR(A, m, B, n, k + 1);
        } else {
            int left = findR(A, m, B, n, k);
			int right = findR(A, m, B, n, k + 1);
			return 0.5 * (left + right);
        }
    }
};
/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
 
bool cmp2(const Interval &a, const Interval &b) {
    return a.start < b.start;
}
class Solution {
public:
	vector<Interval> merge(vector<Interval> &intervals) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		vector<Interval> re;
		if(intervals.size() == 0) return re;
		sort(intervals.begin(), intervals.end(), cmp2);
		Interval cur = intervals[0];
		int i; 
		for(i = 1; i < intervals.size(); ++i) {
			if(intervals[i].start <= cur.end) {
                if(intervals[i].end > cur.end) {
                    cur.end = intervals[i].end;
                }				
			} else {
				re.push_back(cur);
				cur = intervals[i];
			}
		}
        re.push_back(cur);
		return re;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct cmp3{    
	bool operator()(const ListNode * a, const ListNode * b) const {
		return a->val > b->val;
	}
};
class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        priority_queue<ListNode*, vector<ListNode *>, cmp3> pq;
    	int i;
		for(i = 0; i < lists.size(); ++i) {
			if(lists[i] != NULL) {
				pq.push(lists[i]);
			}			
		}
		ListNode *node, *head, *prev;
		head = NULL;
		while(!pq.empty()) {
			node = pq.top();
            pq.pop();
			if(node->next != NULL) {
				pq.push(node->next);
			}
			if(head == NULL) {
    			head = node;
			} else {
				prev->next = node;				
			}
			prev = node;
		}
		return head;
    }
};
class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int end = m + n - 1, i = m - 1, j = n - 1;
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) {
                A[end--] = A[i--];
            } else {
                A[end--] = B[j--];
            }
        }
        while(i >= 0) {
            A[end--] = A[i--];
        }
        while(j >= 0) {
            A[end--] = B[j--];
        }
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *head = NULL, *p = l1, *q = l2, *prev, *cur;
        while(p != NULL && q != NULL) {
            if(p->val < q->val) {
                cur = p;
                p = p->next;
            } else {
                cur = q;
                q = q->next;
            }
            if(head == NULL) {
                head = cur;
            } else {
                prev->next = cur;
            }
            prev = cur;
        }
        if(p != NULL) {
            if(head == NULL) {
                head = p;
            } else {
                prev->next = p;
            }
        }
        if(q != NULL) {
            if(head == NULL) {
                head = q;
            } else {
                prev->next = q;
            }
        }
        return head;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) return 0;
        int left = minDepth(root->left);
        int right = minDepth(root->right);
        if(left == 0) return 1 + right;
        if(right == 0) return 1 + left;
        return 1 + min(left, right);
    }
};
class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> v;
        int i, j;
        for(i = 0; i < grid.size(); ++i) {
            v.clear();
            for(j = 0; j < grid[i].size(); ++j) {
                v.push_back(0);
            }
            re.push_back(v);
        }
        for(i = 0; i < grid.size(); ++i) {
            for(j = 0; j < grid[i].size(); ++j) {
                if(i == 0 && j ==0) {
                    re[i][j] = grid[i][j];
                } else if(i == 0) {
                    re[i][j] = re[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    re[i][j] = re[i - 1][j] + grid[i][j];
                } else {
                    re[i][j] = min(re[i - 1][j], re[i][j - 1]) + grid[i][j];
                }                 
            }
        }
        return re[grid.size() -1][grid[0].size() - 1];
    }
};
class Solution {
public:
    string minWindow(string S, string T) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m[256], f[256], i, j, k, minLen = S.length() + 1, cnt, begin;
        int re;
		deque<int> q;
		for(i = 0; i < 256; ++i) {
			m[i] = 0;
			f[i] = 0;
		}
		for(i = 0; i < T.length(); ++i) {
			++m[T[i]];
		}
		cnt = 0;
		for(i = 0; i < S.length(); ++i) {
			if(m[S[i]] > 0) {							
				q.push_back(i);
				if(f[S[i]] < m[S[i]]) {
					++cnt;
				}
				++f[S[i]];
				while(cnt == T.length() && f[S[q.front()]] >= m[S[q.front()]]) {
					if(i - q.front() + 1 < minLen) {
						minLen = i - q.front() + 1;
						re = q.front();
					}
					if(f[S[q.front()]] == m[S[q.front()]]) {
						--cnt;
					} 
					--f[S[q.front()]];
					q.pop_front();
				}
			}
		}
        if(minLen > S.length()) return "";
		return S.substr(re, minLen);
    }
};
class Solution {
public:
    string multiply(string num1, string num2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        reverse(num1.begin(), num1.end());
    	reverse(num2.begin(), num2.end());
		vector<int> re(num1.length() + num2.length(), 0);
		int i, j, c, d1, d2;
		for(i = 0; i < num1.length(); ++i) {
			d1 = num1[i] - '0';
			for(j = 0; j < num2.length(); ++j) {
				d2 = num2[j] - '0';
				re[i + j] += d1 * d2;
				re[i + j + 1] += re[i + j] / 10;
				re[i + j] %= 10;
			}
		}
		string sre;
		bool first = true;
		for(i = re.size() - 1; i >= 0; --i) {
			if(first && re[i] == 0) {
				continue;
			} else {
				first = false;
				sre.append(1, re[i] + '0');
			}
		}
        if(sre.length() == 0) sre = "0";
		return sre;
    }
};
class Solution {
public:
    bool check(vector<int> &cur, int row, int col) {
        int i, j, k;
        for(i = 0; i < row; ++i) {
            if(col - cur[i] == row - i || col - cur[i] == i - row) {
                return false;
            }
        }
        return true;
    }
    void solveQR(vector<vector<string> > &re, vector<int> &cur, vector<bool> &flag, int index, int n){  
        int i, j, k;
        if(index == n) {
            vector<string> v;
            string r;
            for(i = 0; i < n; ++i) {
                r.clear();
                for(j = 0; j < n; ++j) {
                    if(j != cur[i]) {
                        r.push_back('.');
                    } else {
                        r.push_back('Q');
                    }
                }
                v.push_back(r);
            }
            re.push_back(v);
            return;
        }
        for(i = 0; i < n; ++i) {
            if(!flag[i] && check(cur, index, i)) {
                flag[i] = true;
                cur.push_back(i);
                solveQR(re, cur, flag, index + 1, n);
                cur.pop_back();
                flag[i] = false;
            }
        }
    }
    vector<vector<string> > solveNQueens(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<string> > re;
        vector<int> cur;
        vector<bool> flag(100, false);
        solveQR(re, cur, flag, 0, n);
        return re;
    }
};
class Solution {
public:
    bool check(vector<int> &cur, int row, int col) {
        int i, j, k;
        for(i = 0; i < row; ++i) {
            if(col - cur[i] == row - i || col - cur[i] == i - row) {
                return false;
            }
        }
        return true;
    }
    void solveQR(int &re, vector<int> &cur, vector<bool> &flag, int index, int n){  
        int i, j, k;
        if(index == n) {
            ++re;
            return;
        }
        for(i = 0; i < n; ++i) {
            if(!flag[i] && check(cur, index, i)) {
                flag[i] = true;
                cur.push_back(i);
                solveQR(re, cur, flag, index + 1, n);
                cur.pop_back();
                flag[i] = false;
            }
        }
    }
    
    int totalNQueens(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int re = 0;
        vector<int> cur;
        vector<bool> flag(100, false);
        solveQR(re, cur, flag, 0, n);
        return re;
    }
};
class Solution {
public:
    void nextPermutation(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k;
        for(i = num.size() - 1; i >= 1; --i) {
            if(num[i] > num[i - 1]) {
                k = i;
                for(j = i + 1; j < num.size(); ++j) {
                    if(num[j] > num[i - 1] && num[j] < num[k]) {
                        k = j;
                    } 
                }
                break;
            }
        }
        if(i >= 1) {
            swap(num[k], num[i -1]);
        }
        sort(num.begin() + i, num.end());
    }
};
class Solution {
public:
    bool isPalindrome(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(x < 0) return false;
        int power = 1;
        int i, j, k = 0, y = x, low, high;
        while(y > 0) {
            y /= 10;
            power *= 10;
            ++k;
        }        
        int lp = 10, lp2 = 1;
        if(k == 10) {
            power = 1000000000;
            if(x / power != x % 10) return false;
            --k;
            lp *= 10;
            lp2 *= 10;
        }
        int p2 = power / 10;
        for(i = 0; i < k / 2; ++i) {
            low = (x % lp) / lp2;
            high = (x % power) / p2;
            if(low != high) {
                return false;
            }
            lp *= 10;
            lp2 *= 10;
            power /= 10;
            p2 /= 10;
        }
        return true;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *partition(ListNode *head, int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *head1 = NULL, *head2 = NULL, *p1 = NULL, *p2 = NULL, *cur;
        cur = head;
        while(cur != NULL) {
            if(cur->val < x) {
                if(head1 == NULL) {
                    head1 = cur;
                } else {
                    p1->next = cur;
                }
                p1 = cur;
            } else {
                if(head2 == NULL) {
                    head2 = cur;
                } else {
                    p2->next = cur;
                }
                p2 = cur;
            }
            cur = cur->next;
        }
        if(p1 != NULL) {
            p1->next = head2;
        }
        if(p2 != NULL) {
            p2->next = NULL;
        }
        if(head1 != NULL) {
            return head1;
        } else {
            return head2;
        }
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool hasPathSum(TreeNode *root, int sum) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) return false;
        if(root->left == NULL && root->right == NULL && root->val == sum) return true;
        return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void pathSumR(TreeNode *root, int sum, vector<vector<int> > &re, vector<int> &cur) {
        if(root == NULL) return;
        if(root->left == NULL && root->right == NULL && root->val == sum) {
            cur.push_back(root->val);
            re.push_back(cur);
            cur.pop_back();
            return;
        }
        cur.push_back(root->val);
        pathSumR(root->left, sum - root->val, re, cur);
        pathSumR(root->right, sum - root->val, re, cur);
        cur.pop_back();
    }
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        pathSumR(root, sum, re, cur);
        return re;
    }
};
class Solution {
public:
    void getPermR(int n, int k, int index, vector<int> &cur, vector<bool> &flag, string &re, 
        bool &complete, int &cnt){
        int i, j;
        if(index == n) {
            ++cnt;
            if(cnt == k) {
                for(i = 0; i < n; ++i) {
                    re.push_back('0' + cur[i]);
                }
                complete = true;
            }
            return;
        }
        int start = 1;
        if(index == 0 && n > 2) {
            int a[10];
            a[0] = 1;
            a[1] = 1;
            for(i = 2; i <= n; ++i) {
                a[i] = a[i - 1] * i;
            }
            if(k > a[n - 1]) {
                start = (k - 1) / a[n - 1] + 1;
                k = (k - 1) % a[n - 1] + 1;    
            }            
        }
        for(i = start; i <= n; ++i) {
            if(complete) {
                return;
            }
            if(!flag[i]) {
                flag[i] = true;
                cur.push_back(i);
                getPermR(n, k, index + 1, cur, flag, re, complete, cnt);
                flag[i] = false;
                cur.pop_back();
            }
        }
    }
    string getPermutation(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> cur;
        vector<bool> flag(10, false);
        string re;
        bool complete = false;
        int cnt = 0;
        getPermR(n, k, 0, cur, flag, re, complete, cnt);
        return re;
    }
};
class Solution {
public:
    void permuteR(vector<vector<int> > &re, vector<int> &num, vector<int> &cur, 
        int index, vector<bool> &f){
        int i, j, k;
        if(index == num.size()) {
            re.push_back(cur);
            return;
        }
        for(i = 0; i < num.size(); ++i) {
            if(!f[i]) {
                f[i] = true;
                cur.push_back(num[i]);
                permuteR(re, num, cur, index + 1, f);
                f[i] = false;
                cur.pop_back();
            }
        }
    }
    
    vector<vector<int> > permute(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<bool> f(num.size(), false);
        vector<int> cur;
        permuteR(re, num, cur, 0, f);
        return re;
    }
};
class Solution {
public:
    void permuteUR(vector<vector<int> > &re, vector<int> &num, int index,
        map<vector<int>, bool> &m) {
        int i, j, k;
        if(index == num.size() - 1) {
            if(m.find(num) == m.end()) {
                re.push_back(num);   
                m.insert(make_pair(num, true));
            }
            return;
        }
        permuteUR(re, num, index + 1, m);
        for(i = index + 1; i < num.size(); ++i) {
            if(num[i] != num[index]) {
                swap(num[i], num[index]);
                permuteUR(re, num, index + 1, m);
                swap(num[i], num[index]);
            }
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        map<vector<int>, bool> m;
        permuteUR(re, num, 0, m);
        return re;
    }
};
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        reverse(digits.begin(), digits.end());
        int i;
        ++digits[0];
        for(i = 0; i < digits.size(); ++i) {
            if(digits[i] >= 10) {
                ++digits[i + 1];
                digits[i] %= 10;
            } else {
                break;
            }
        }
        if(i == digits.size()) {
            digits.push_back(1);
        }
        reverse(digits.begin(), digits.end());
        return digits;
    }
};
class Solution {
public:
    double pow(double x, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0) return 1.0;
        vector<double> v;
        bool neg = n < 0;
        long long k = abs(static_cast<long long>(n));
        int i;
        double re = x;
        while(k > 0) {
            if(k & 1 == 1) {
                v.push_back(re);
            }
            re *= re;
            k >>= 1;
        }        
        re = 1.0;
        for(i = 0; i < v.size(); ++i) {
            re *= v[i];
        }
        if(v.size() == 0) {
            re = 0.0;
        }
        if(neg) {
            re = 1 / re;
        }
        return re;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void midOrder(TreeNode *root, vector<TreeNode*> &v) {
        if(root == NULL) return;
        midOrder(root->left, v);
        v.push_back(root);
        midOrder(root->right, v);
    }
    void recoverTree(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<TreeNode*> v;
        midOrder(root, v);
        int i, j, min, index, tmp;
        for(i = 1; i < v.size(); ++i) {
            if(v[i]->val < v[i - 1]->val) {
                index = i; min = v[i]->val;
                for(j = i + 1; j < v.size(); ++j) {
                    if(v[j]->val < min) {
                        min = v[j]->val;
                        index = j;
                    }
                }
                break;
            }
        }
        tmp = v[i - 1]->val;
        v[i - 1]->val = v[index]->val;
        v[index]->val = tmp;
        return;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void midOrder(TreeNode *root, vector<TreeNode*> &v, TreeNode *&pre) {
        if(root == NULL) return;
        midOrder(root->left, v, pre);
        if(v.size() == 0) {
            if(pre != NULL) {
                if(pre->val > root->val) {
                    v.push_back(pre);
                    v.push_back(root);
                }
            }
        } else {
            if(v[1]->val > root->val) {
                v[1] = root;
            }
        }
        pre = root;
        midOrder(root->right, v, pre);
    }
    void recoverTree(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<TreeNode*> v;
        TreeNode *pre;
        int tmp;
        pre = NULL;
        midOrder(root, v, pre);
        tmp = v[0]->val;
        v[0]->val = v[1]->val;
        v[1]->val = tmp;
        return;
    }
};
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(*p == NULL) return NULL == *s;
        if(*(p + 1) != '*') {
            if (*s == *p || *p == '.' && *s != NULL) {
                return isMatch(s + 1, p + 1);
            }
            return false;
        } else {
            while(*s == *p || *p == '.' && *s != NULL) {
                if(isMatch(s, p + 2)) {
                    return true;
                }
                ++s;
            }
            return isMatch(s, p + 2);
        }
    }
};
class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0) return 0;
        int i, k = 0;
        for(i = 1; i < n; ++i) {
            if(A[i] == A[k]) {
                continue;
            } else {
                A[++k] = A[i];
            }
        }
        return k + 1;
    }
};
class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0) return 0;
        int i, j= 1, k = 0;
        for(i = 1; i < n; ++i) {
            if(A[i] == A[k]) {
                if(j < 2) {                     
                    A[++k] = A[i];
                    ++j;   
                } else {
                    continue;
                }
            } else {
                A[++k] = A[i];
                j = 1;
            }
        }
        return k + 1;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(head == NULL) return head;
        ListNode *pre, *cur;
        pre = head;
        cur = pre->next;
        while(cur != NULL) {
            if(cur->val != pre->val) {
                pre->next = cur;
                pre = cur;
            }
            cur = cur->next;
        }
        pre->next = NULL;
        return head;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *nhead = NULL, *pre, *cur, *cur2;
        if(head == NULL) return NULL;
        pre = NULL;
        cur = head;
        while(cur != NULL) {
            cur2 = cur->next;
            while(cur2 != NULL && cur2->val == cur->val) {
                cur2 = cur2->next;
            }
            if(cur2 == cur->next) {
                if(pre == NULL) {
                    nhead = cur;
                } else {
                    pre->next = cur;
                }
                pre = cur;
            }
            cur = cur2;
        }
        if(pre != NULL) {
            pre->next = NULL;
        }
        return nhead;
    }
};
class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k = 0;
        for(i = 0; i < n; ++i) {
            if(A[i] != elem) {
                A[k++] = A[i];
            }
        }
        return k;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *p, *q, *pre;
        p = head;
        q = head;
        int i;
        for(i = 0; i < n; ++i) {
            q = q->next;
        }
        pre = NULL;
        while(q != NULL) {
            pre = p;
            p = p->next;
            q = q->next;
        }
        if(pre == NULL) {
            head = head->next;
        } else {
            pre->next = pre->next->next;
        }
        return head;
    }
};
double sqrt1(double target, double precision) {
	int count = 0;
	double low = 0.0, high = target, guess = (low + high) / 2;
	while(abs(guess * guess - target) > precision && count < 1000) {
		if(guess * guess > target) {
			high = guess;
		} else {
			low = guess;
		}
		guess = (low + high) / 2;
	}
	printf("count = %d, result = %.2lf\n", count, guess);
	return guess;
}
class Solution {
public:
    void restoreR(vector<string> &re, vector<int> &a, int index, string &s) {
        int i, j, k, cur;
        if(index == 4) {
            int len = s.length() - a[index - 1] - 1;
            if(len > 0 && len <= 3) {
    			if(s[a[index - 1] + 1] == '0' && a[index - 1] + 1 != s.length() - 1 ) {
					return;
				}
                cur = atoi(s.substr(a[index - 1] + 1).c_str());
                if(cur >= 0 && cur <= 255) {
                    string retmp;
                    j = 1;
                    for(i = 0; i < s.length(); ++i) {
                        retmp.push_back(s[i]);
                        if(i == a[j]) {
                            retmp.push_back('.');
                            ++j;
                        }
                    }
					re.push_back(retmp);
                }
            }
            return;
        }
		
		if(a[index - 1] + 1 >= s.length()) {
			return;
		}
		int max = 4;
        if(s[a[index - 1] + 1] == '0') {
            max = 2;
        }
        for(i = 1; i < max; ++i) {
			if(a[index - 1] + i >= s.length()) {
				return;
			}
			string tmp = s.substr(a[index - 1] + 1, i);
            cur = atoi(tmp.c_str());
            if(cur <= 255) {
                a[index] = a[index - 1] + i;
                restoreR(re, a, index + 1, s);
            }
        }
    }
    vector<string> restoreIpAddresses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
        vector<int> a(5, 0);
		a[0] = -1;
        restoreR(re, a, 1, s);
		return re;
    }
};
class Solution {
public:
    int reverse(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int neg = x < 0 ? -1 : 1;
        x = abs(x);
        int re = 0;
        while(x > 0) {
            re = re * 10 + x % 10;
            x /= 10;            
        }
        return neg * re;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(m == n) return head;
        ListNode *pre = NULL, *cur, *tmp, *nhead, *ntail, *start;
        int i, j, k;
        cur = head;
        for(i = 1; i < m; ++i) {
            pre = cur;
            cur = cur->next;
        }
        nhead = pre;
        start = cur;
        for(j = m; j <= n; ++j) {
            tmp = cur->next;
            cur->next = pre;
            pre = cur;
            cur = tmp;
        }
        if(start != cur) {   
            start->next = cur;
            if(nhead == NULL) {
                head = pre;
            } else {            
               nhead->next = pre;
            }
        }
        return head;
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(k == 1) return head;
        ListNode *pre, *cur, *test, *tmp, *nhead = NULL, *tail, *first;
        test = head;
        pre = NULL; 
        cur = head;
        tail = NULL;
        int i, j;
        while(test != NULL) {
            first = test;
            for(i = 0; i < k; ++i) {
                if(test != NULL) {
                    test = test->next;
                } else {
                    break;
                }
            }
            if(i == k) {
                pre = NULL;
                for(j = 0; j < k; ++j) {
                    tmp = cur->next;
                    cur->next = pre;
                    pre = cur;
                    cur = tmp;
                }
                if(tail != NULL) {
                    tail->next = pre;
                } else {
                    nhead = pre;
                }
                tail = first;
            } else {
                if(tail == NULL) {
                    nhead = head;
                } else {
                    tail->next = first;
                }   
                break;
            }
        }
        return nhead;    
    }
};
class Solution {
public:
    int romanToInt(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        char ch[4][3] = {"IV", "XL", "CD", "M"};
        int d[4];
        int i, j, k;
        for(i = 0; i < 4; ++i) {
            d[i] = 0;
        }
        i = 0;
        if(s[i] == 'M') {
            j = 0;
            for(; i < s.length(); ++i) {
                if(s[i] != 'M') {
                    break;
                }
            }
            d[3] = i - j;
        }
        for(k = 2; k >= 0; --k) {
            if(s[i] == ch[k][0]) {
                j = i;
                for(; i < s.length(); ++i) {
                    if(s[i] != ch[k][0]) {
                        break;
                    }
                }
                d[k] = i - j;
                if(d[k] == 1) {
                    if(s[i] == ch[k + 1][0]) {
                        d[k] = 9;
                        ++i;
                    } else if(s[i] == ch[k][1]) {
                        d[k] = 4;
                        ++i;
                    }
                }
            } else if(s[i] == ch[k][1]) {
                d[k] = 5;
                ++i;
                j = i;
                for(; i < s.length(); ++i) {
                    if(s[i] != ch[k][0]) {
                        break;
                    }
                }
                if(s[i - 1] == ch[k][0]) {
                    d[k] += i - j;      
                } 
            }
        }
        int re = 1000 * d[3] + 100 * d[2] + 10 * d[1] + d[0];
        return re;
    }
};
class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, tmp, n = matrix.size();
        for(i = 0; i < n / 2; ++i) {
            k = n % 2 ? n / 2 + 1: n / 2;
            for(j = 0; j < k; ++j) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(head == NULL) return NULL;
        if (k == 0) return head;
        ListNode *p = head, *q = head;
        int i, j, cnt = 0;
        while(p != NULL) {
            p = p->next;
            ++cnt;
            if(cnt == k) {
                break;
            }
        }
        if(p == NULL) {
            k %= cnt;
            if(k == 0) {
                return head;
            }
            p = head;
            cnt = 0;
            while(p != NULL) {
                p = p->next;
                ++cnt;
                if(cnt == k) {
                    break;
                }
            }
        }
        while(p->next != NULL) {
            q = q->next;
            p = p->next;
        }
        ListNode *nhead = q->next;
        q->next = NULL;
        p->next = head;
        return nhead;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSameTree(TreeNode *p, TreeNode *q) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(p == NULL && q == NULL) return true;
        else if(p == NULL || q == NULL) return false;
        else if(p->val == q->val) {
            return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
        } else {
            return false;
        }
    }
};
class Solution {
public:
	bool isScramble(string s1, string s2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		if(s1.compare(s2) == 0) return true;
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1 && s1[0] != s2[0]) return false;
        int n = s1.length(), i;
        string a1, a2, b1, b2, c1, c2, d1, d2;
        for(i = 1; i <= n / 2; ++i) {
            a1 = s1.substr(0, i); 
            b1 = s1.substr(i);
            a2 = s2.substr(0, i);
            b2 = s2.substr(i);
            c1 = s1.substr(0, n - i);
            d1 = s1.substr(n - i);
            c2 = s2.substr(0, n - i);
            d2 = s2.substr(n - i);
            if(isScramble(a1, a2) && isScramble(b1, b2)) {
                return true;
            }
            if(isScramble(a1, d2) && isScramble(b1, c2)) {
                return true;
            }
            if(isScramble(d1, a2) && isScramble(c1, b2)) {
                return true;
            }
            if(isScramble(d1, d2) && isScramble(c1, c2)) {
                return true;
            }
        }
        return false;
    }
};
bool isSR(string &s1,string &s2, int index, map<pair<string, string>, bool> &m) {
		pair<string, string> p = make_pair(s1, s2);
		pair<string, string> q = make_pair(s2, s1);
		if(m.find(p) != m.end()) {
			return m[p];
		} 
		if(m.find(q) != m.end()) {
			return m[q];
		}
		if(s1.length() == 1 && s2.length() == 1) {
            if(s1[0] == s2[0]) {
				m.insert(make_pair(p, true));
                return true;
            } else {
				m.insert(make_pair(p, false));
                return false;
            }
        }
        if(s1.compare(s2) == 0) {
			m.insert(make_pair(p, true));
			return true;
		}
        int i, j, k, len;
        string ss1, ss2, st, ss3, ss4;
        for(i = 1; i < s1.length(); ++i) {
			if(i < index) {
				ss1 = s1.substr(0, i);
				ss2 = s2.substr(0, i);
				ss3 = s1.substr(i);
				ss4 = s2.substr(i);
				st = ss4 + ss2;
				k = index - i;
				if(isSR(ss1, ss2, index, m) && isSR(ss3, ss4, k, m)){
					m.insert(make_pair(p, true));
					return true;        
				}
				len = ss4.length();
				ss1 = s1.substr(0, len);
				ss3 = s1.substr(len);
				if(isSR(ss1, ss4, k, m) && isSR(ss3, ss2, index, m)){
					m.insert(make_pair(p, true));
					return true;
				}
			} else {
				break;
			}
        }
		m.insert(make_pair(p, false));
        return false;
	}
	//this could not pass the large test case. sigh
	bool isScramble2(string s1, string s2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		int len = s1.length();
		map<pair<string, string>, bool> m;
		return isSR(s1, s2, len, m);
    }
	
class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, low, high, mid, m, n;
        m = matrix.size();
        n = matrix[0].size();
        low = 0; high = m - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                break;
            } else if(matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(low > high) {
            return false;
        }
        low = 0; high = n - 1;
        k = mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(matrix[k][mid] == target) {
                return true;
            } else if(matrix[k][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
};
class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int low, high, mid, i, j, k, begin = -1, end = -1;
        low = 0; high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                begin = mid;
                high = mid - 1;
            } else if(A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low = 0; high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                end = mid;
                low = mid + 1;
            } else if(A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        vector<int> re;
        re.push_back(begin);
        re.push_back(end);
        return re;
    }
};
class Solution {
public:
    int search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int low, high, mid, i, j, k;
        low = 0; high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[low] == target) return low;
            if(A[high] == target) return high;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] > target) {
                if(A[low] < target || A[low] > A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(A[high] > target || A[high] < A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
};
class Solution {
public:
    bool search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int low, high, mid, i, j, k;
        low = 0; high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[low] == target) return true;
            if(A[high] == target) return true;
            if(A[mid] == target) {
                return true;
            } else {
                while(low <= high && A[low] == A[high]) {
                    ++low;
                    --high;
                } 
                if(low > high) {
                    return false;
                }
                if(A[low] == target) return true;
                if(A[high] == target) return true;
                if(A[mid] > target) {
                    if(A[low] < target || A[low] > A[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if(A[high] > target || A[high] < A[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }            
        }
        return false;
    }
};
class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int low, high, mid, i, j, k;
        low = 0; high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};
class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, m, n;
        bool r1 = false, c1 = false;
        m = matrix.size();
        n = matrix[0].size();
        for(i = 0; i < m; ++i) {
            for(j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0; 
                    if(i == 0) {
                        r1 = true;
                    }
                    if(j == 0) {
                        c1 = true;
                    }
                }
            }
        }
        for(i = 1; i < m; ++i) {
            if(matrix[i][0] == 0) {
                for(j = 0; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }            
        }
        for(j = 1; j < n; ++j) {
            if(matrix[0][j] == 0) {
                for(i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(r1) {
            for(j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }
        if(c1) {
            for(i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
};
class Solution {
public:
    string simplifyPath(string path) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string re;
        int i, j, k;
        deque<string> s;
        i = 0; j = -1;
        while(i < path.length()) {
            if(path[i] == '/') {
                if(j != -1 && j + 1 != i) {
                    s.push_back(path.substr(j + 1, i - j - 1));                   
                }
                j = i;
            } else if(path[i] == '.') {
                if(path[i + 1] == '.') {
                    if(s.size() > 0) {
                        s.pop_back();
                    }
                    ++i;
                }
                j = -1;
            }
            ++i;
        }
        if(j != -1 && j != path.length() - 1) {
            s.push_back(path.substr(j + 1));
        }
        while(s.size() > 0) {
            re += "/" + s.front();
            s.pop_front();
        }
        if(re.length() == 0) re = "/";
        return re;
    }
};
class Solution {
public:
    void sortColors(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int l = 0, r = n - 1, i = 0;
        while(i <= r) {
            if(A[i] == 0) {
                swap(A[i], A[l]);
                ++i;
                ++l;
            } else if(A[i] == 2) {
                swap(A[i], A[r]);
                --r;
            } else {
                ++i;
            }
        }
    }
};
class Solution {
public:
    void spiralR(vector<int> &re, vector<vector<int> > &matrix, 
        int rstart, int rend, int cstart, int cend) {
        int i, j, k;
        if(rstart > rend || cstart > cend) {
            return;
        }
        for(i = cstart; i <= cend; ++i) {
            re.push_back(matrix[rstart][i]);
        }
        for(i = rstart + 1; i <= rend; ++i) {
            re.push_back(matrix[i][cend]);
        }
        if(rend != rstart) {
            for(i = cend - 1; i >= cstart; --i) {
                re.push_back(matrix[rend][i]);
            }   
        }
        if(cend != cstart) {
            for(i = rend - 1; i > rstart; --i) {
                re.push_back(matrix[i][cstart]);
            }   
        }
        spiralR(re, matrix, rstart + 1, rend - 1, cstart + 1, cend - 1);
    }
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        int m, n;
        m = matrix.size();
        if(m == 0) return re;
        n = matrix[0].size();
        spiralR(re, matrix, 0, m - 1, 0, n - 1);
        return re;
    }
};
class Solution {
public:
    void genMR(vector<vector<int> > &re, int rstart, int rend, int cstart, int cend, int index) {
        int i, j, k;
        if(rstart > rend || cstart > cend) {
            return;
        }
        for(i = cstart; i <= cend; ++i) {
            re[rstart][i] = index++;
        }
        for(i = rstart + 1; i <= rend; ++i) {
            re[i][cend] = index++;
        }
        if(rend != rstart) {
            for(i = cend - 1; i >= cstart; --i) {
                re[rend][i] = index++;   
            }
        }
        if(cstart != cend) {
            for(i = rend - 1; i > rstart; --i) {
                re[i][cstart] = index++;
            }
        }
        genMR(re, rstart + 1, rend - 1, cstart + 1, cend - 1, index); 
    }
    vector<vector<int> > generateMatrix(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> row(n);
        int i;
        for(i = 0; i < n; ++i) {
            re.push_back(row);
        }
        genMR(re, 0, n - 1, 0, n - 1, 1);
        return re;
    }
};
class Solution {
public:
    int sqrt1(int x, double eps) {
        int cnt = 0;
        double low, high, guess, target, tmp;
        target = static_cast<double>(x);
        low = 0.0;
        high = target;
        guess = high;
        while(low < high && cnt < 1000) {
            tmp = guess * guess;
            ++cnt;
            if(abs(tmp - target) < eps) {
                break;
            } else if(tmp > target) {
                high = guess;
            } else {
                low = guess;
            }
            guess = (low + high) / 2;
        }
        return floor(guess);
    }
    int sqrt2(int x, double eps) {
        int cnt = 0;
        double guess, target, tmp;
        target = static_cast<double>(x);
        guess = target;
        while(abs(guess * guess - target) > eps && cnt < 1000) {
            guess = guess - (guess * guess - target) / (2 * guess);
            ++cnt;
        }
        return floor(guess);
    }
    int sqrt(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        double eps = 0.000001;
        return sqrt1(x, eps);
    }
};
class Solution {
public:
    int atoi(const char *str) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int sign = 1;
        long long re = 0;
        while(*str != NULL && *str == ' ') {
            ++str;
        }
        if(*str == NULL) {
            return 0;
        }
        if(*str == '+') {
            sign = 1;
            ++str;
        } else if(*str == '-') {
            sign = -1;
            ++str;
        }
        while(*str >= '0' && *str <= '9') {
            re = re * 10 + *str - '0';
            ++str;
            if(re > INT_MAX) {
                break;
            }
        }
        re *= sign;
        if(re > INT_MAX) {
            return INT_MAX;
        } else if(re < INT_MIN) {
            return INT_MIN;
        } else {
            return re;
        }
    }
};
class Solution {
public:
    void subsetsR(vector<vector<int> > &re, vector<int> &cur, 
        vector<int> &S, int index, int n, vector<bool> &used, int start) {
        int i, j, k;
        if(index == n) {
            re.push_back(cur);
            return;
        }
        for(i = start; i < S.size(); ++i) {
            if(!used[i]) {
                used[i] = true;
                cur.push_back(S[i]);
                subsetsR(re, cur, S, index + 1, n, used, i + 1);
                used[i] = false;
                cur.pop_back();
            }
        }
    }
    vector<vector<int> > subsets(vector<int> &S) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(S.begin(), S.end());
        int i; 
        vector<vector<int> > re;
        vector<int> cur;
        re.push_back(cur);
        vector<bool> used;
        for(i = 1; i <= S.size(); ++i) {
            used.assign(S.size(), false);
            subsetsR(re, cur, S, 0, i, used, 0); 
        } 
        return re;
    }
};
class Solution {
public:
    void dfs(vector<vector<int> > &re, vector<int> &cur, vector<int> &digits, 
        vector<int> &count, int index) {
        int i, j, k;
        if(index == count.size()) {
            re.push_back(vector<int>());
            for(i = 0; i < cur.size(); ++i) {
                for(j = 0; j < cur[i]; ++j) {
                    re.back().push_back(digits[i]);
                }
            }
            return;
        }
        for(i = 0; i <= count[index]; ++i) {
            cur[index] = i;
            dfs(re, cur, digits, count, index + 1);
        }
    }
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur(S.size());
        vector<int> digits;
        vector<int> count;
        sort(S.begin(), S.end());
        int i, j, k;
        for(i = 0; i < S.size(); ++i) {
            if(digits.empty() || digits.back() != S[i]) {
                digits.push_back(S[i]);
                count.push_back(0);
            }
            ++count.back();
        }
        dfs(re, cur, digits, count, 0);   
        return re;
    }
};
class Solution {
public:
    bool check(string &S, vector<string> &L, vector<bool> used, int start_pos,
        int cnt) {
    	if(cnt == L.size()) return true;
        bool re = false;
        int i, j, k;
        for(i = 0; i < L.size(); ++i) {
            if(i > 0 && !used[i - 1] && !used[i] && L[i].compare(L[i - 1]) == 0) continue;
            if(!used[i]) {
                if(S.compare(start_pos, L[i].length(), L[i]) == 0) {
                    used[i] = true;
                    re = check(S, L, used, start_pos + L[i].length(), cnt + 1);
                    if(re) {
                        return re;
                    }
                    used[i] = false;
                }
            }
        }
        return false;
    }
	//this solution could not pass the final one test case.
    vector<int> findSubstring(string S, vector<string> &L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        vector<bool> m(S.length(), false);
        vector<bool> used;
        sort(L.begin(), L.end());
        int i, j, k, sumLen = 0;
        for(i = 0; i < L.size(); ++i) {
            sumLen += L[i].length();
        }
        for(i = 0; i < L.size(); ++i) {
            if(i > 0 && L[i].compare(L[i - 1]) == 0) continue;
            j = S.find(L[i], 0);
            while(j != -1) {
                if(!m[j] && j + sumLen <= S.length()) {                    
                    used.assign(L.size(), false);
                    used[i] = true;
                    if(check(S, L, used, j + L[i].length(), 1)) {
                        re.push_back(j);
                        m[j] = true;
                    }   
                }
                j = S.find(L[i], j + 1);
            }
        }
        return re;
    }
};
class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<string, int> words;
        map<string, int> curStr;
        int i, j, k;
        for(i = 0; i < L.size(); ++i) {
            ++words[L[i]];
        }
        int M = L.size();
        vector<int> re;
        if(M <= 0) {
            return re;
        }
        int N = L[0].size();
        string str;
        for(i = 0; i <= (int)S.length() - N * M; ++i) {
            curStr.clear();
            for(j = 0; j < M; ++j) {
                str = S.substr(i + N * j, N);
                if(words.find(str) == words.end()) {
                    break;
                }
                ++curStr[str];
                if(curStr[str] > words[str]) {
                    break;
                }
            }
            if(j == M) {
                re.push_back(i);
            }
        }
        return re;
    }
};
class Solution {
public:
    void solveSudoku(vector<vector<char> > &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, x, y;
        vector<vector<char> > b = board;
        map<pair<int, int>, deque<int> > m;
        deque<int> dq;
        pair<int, int> pos = make_pair(0, 0);
        vector<bool> bs;
        while(true) {
    		if(board[pos.first][pos.second] != '.') {
				pos.second++;
				if(pos.second == 9) {
					pos.first++;
					pos.second = 0;
				}
				continue;
			}
            if(m.find(pos) == m.end()) {
				bs.assign(10, false);
                for(i = 0; i < 9; ++i) {
                    if(b[pos.first][i] != '.') {
                        bs.at(b[pos.first][i] - '0') = true;
                    }
                    if(b[i][pos.second] != '.') {
                        bs.at(b[i][pos.second] - '0') = true;
                    }
                }
                x = pos.first / 3 * 3;
                y = pos.second / 3 * 3;
                for(i = 0; i < 3; ++i) {
                    for(j = 0; j < 3; ++j) {
                        if(b[x + i][y + j] != '.') {
                            bs.at(b[x + i][y + j] - '0')= true;
                        }
                    }
                }
                dq.clear();
                for(i = 1; i <= 9; ++i) {
                    if(!bs.at(i)) {
                        dq.push_back(i);
                    }
                }
                m[pos] = dq;
            }
            if(m[pos].size() > 0) {
                b[pos.first][pos.second] = m[pos].front() + '0';
                m[pos].pop_front();
                for(i = 0; i < 9; ++i) {
                    for(j = 0; j < 9; ++j) {
                        if(((i == pos.first && j > pos.second) || i > pos.first) 
                            && b[i][j] == '.') {
                                break;
                            }
                    }
					if(j < 9) {
						break;
					}
                }
                if(i == 9) {
                    board = b;
                    return;
                } else {
                    pos = make_pair(i, j);
                }
            } else {
                b[pos.first][pos.second] = '.';
                m.erase(pos);
                for(i = 8; i >= 0; --i) {
                    for(j = 8; j >= 0; --j) {
                        if(((i == pos.first && j < pos.second) || i < pos.first)
                            && board[i][j] == '.') {
                                break;
                            }
                    }
					if(j >= 0) {
						break;
					}
                }
                pos = make_pair(i, j);
            }
        }
    }
};
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *pre, *cur, *t, *p, *q, *nhead = head;
        p = NULL;
        pre = head;
        while(pre != NULL) {
            cur = pre->next;
            if(cur != NULL) {
                t = cur->next;
                cur->next = pre;
                pre->next = t;
                if(p != NULL) {
                    p->next = cur;
                } else {
                    nhead = cur;
                }
                p = pre;
                pre = t;
            } else {
                break;
            }
        }
        return nhead;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isS(TreeNode *r1, TreeNode *r2) {
        if(r1 == NULL && r2 == NULL) {
            return true;
        } else if(r1 == NULL || r2 == NULL) {
            return false;
        }
        if(r1->val != r2->val) {
            return false;
        }
        return isS(r1->left, r2->right) && isS(r1->right, r2->left);
    }
    bool isSymmetric(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) {
            return true;
        }
        return isS(root->left, root->right);
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) {
            return true;
        }
        queue<TreeNode*> q;
        TreeNode *r1, *r2;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()) {
            r1 = q.front(); q.pop();
            r2 = q.front(); q.pop();
            if(r1 == NULL && r2 == NULL) {
                continue;
            } else if(r1 == NULL || r2 == NULL) {
                return false;
            }
            if(r1->val != r2->val) {
                return false;
            }
            q.push(r1->left);
            q.push(r2->right);
            q.push(r1->right);
            q.push(r2->left);
        }
        return true;
    }
};
class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
        vector<int> cur;
        vector<int> space;
        string line;
        int i, j, k, len = 0, space_len;
        for(i = 0; i < words.size(); ++i) {
            if(len  == 0) {
                len = words[i].length();
                cur.push_back(i);
            } else {
                if(len + words[i].length() + cur.size() > L) {
                    k = max(1, (int)cur.size() - 1);
                    space.assign(k, 0);
                    space_len = L - len;
                    j = 0;
                    while(space_len > 0) {
                        ++space[j++];
                        if(j >= cur.size() - 1) {
                            j = 0;
                        }
                        --space_len;
                    }               
                    line.clear();
                    line.append(words[cur[0]]);
                    line.append(space[0], ' ');
                    for(j = 1; j < cur.size(); ++j) {
                        line.append(words[cur[j]]);
                        if(j != cur.size() - 1) {
                            line.append(space[j], ' ');
                        }
                    }
                    re.push_back(line);
                    cur.clear();
                    len = 0;
                }
                len += words[i].length();
                cur.push_back(i);
            }
        }
    	if(len > 0) {        
            if(cur.size() > 1) {
                space_len = 1;
            } else {
                space_len = (L - len);         
            } 
            line.clear();
            line.append(words[cur[0]]);
            line.append(space_len, ' ');
            for(j = 1; j < cur.size(); ++j) {
                line.append(words[cur[j]]);
                if(j != cur.size() - 1) {
                    line.append(space_len, ' ');
                }
            }
            if(L - line.length() > 0) {
                line.append(L - line.length(), ' ');   
            }
			re.push_back(line);
        }
        if(re.size() == 0) {
            line.clear();
            line.append(L, ' ');
            re.push_back(line);
        }
        return re;
    }
};
class Solution {
public:
    int trapR(int A[], int n, int begin, int end) {
        if(begin == end) return 0;
        int i, j, k, left, right, v = 0;
        left = begin; right = end;
        if(A[left] < A[right]) {
            v += A[left++];
            while(left < right && A[left] < A[begin]) {
                v += A[left];
                ++left;
            }
            return max(0, A[begin] * (left - begin) - v) + trapR(A, n, left, right);
        } else if(A[left] == A[right]) {
            while(left < right && A[left] <= A[begin]) {
                v += A[left];
                ++left;
            }
            return max(0, A[begin] * (left - begin) - v) + trapR(A, n, left, right);
        }else {
            v += A[right--];
            while(left < right && A[right] < A[end]) {
                v += A[right];
                --right;
            }
            return max(0, A[end] * (end - right) - v) + trapR(A, n, left, right);
        }
    }
    int trap(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0) return 0;
        return trapR(A, n, 0, n - 1);
    }
};
class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, n;
        n = triangle.size();
        vector<int> re(n, INT_MAX);
        re[0] = triangle[0][0];
        for(i = 1; i < n; ++i) {
            for(j = i; j >= 1; --j) {
                re[j] = min(re[j], re[j - 1]) + triangle[i][j];            
            }
            re[0] = re[0] + triangle[i][0];
        }
        k = re[0];
        for(i = 1; i < n; ++i) {
            k = min(k, re[i]);
        }
        return k;
    }
};
class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        multimap<int, int> m;
        int i, j;
        for(i = 0; i < numbers.size(); ++i) {
            m.insert(make_pair(numbers[i], i));
        }
        vector<int> re;
        multimap<int, int>::iterator it;
        for(i = 0; i < numbers.size(); ++i) {
            it = m.find(target - numbers[i]);
            if(it != m.end() && it->second != i) {
                re.push_back(min(i, it->second) + 1);
                re.push_back(max(i, it->second) + 1);
                break;
            }
        }
        return re;
    }
};
class Solution {
public:
    int numTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int a[] = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};//, 6564120420};//, 24466267020, 91482563640, 343059613650, 1289904147324, 4861946401452};
        return a[n];
    }
};
class Solution {
public:
    int numTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<long long> h(n + 1);
        h[0] = 1;
        long long  i, j, k;
        for(i = 1; i <= n; ++i) {
            h[i] = (4 * i - 2) * h[i - 1] / (i + 1);
        }
        return h[n];
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<TreeNode *> generateTR(int start, int end) {
        int i, j, k;
    	vector<TreeNode *> re, lv, rv;
        TreeNode *node, *nr;
        node = new TreeNode(-1);
        for(i = start; i <= end; ++i) {
            node->val = i;
			lv.clear(); lv.push_back(NULL);
			rv.clear(); rv.push_back(NULL);
			if(start < i) {
				lv = generateTR(start, i - 1);
			}
			if(i < end) {
				rv = generateTR(i + 1, end);
			}
			for(j = 0; j < lv.size(); ++j) {
				for(k = 0; k <rv.size(); ++k) {
					nr = new TreeNode(i);
					nr->left = lv[j];
					nr->right = rv[k];
					re.push_back(nr);
				}
			}
        }
		return re;
    }
    vector<TreeNode *> generateTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<TreeNode *> re;
		int cnt = 0;
		if(n == 0) {
			re.push_back(NULL);
		} else {
			re = generateTR(1, n);
		}
		return re;
    }
};
class Solution {
public:
    int uniquePaths(int m, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > f(m);
        int i, j, k;
        for(i = 0; i < m; ++i) {
            f[i] = vector<int>(n);
            f[i][0] = 1;
        }
        for(i = 0; i < n; ++i) {
            f[0][i] = 1;
        }
        for(i = 1; i < m; ++i) {
            for(j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
};
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m, n;
        m = obstacleGrid.size();
        n = obstacleGrid[0].size();
        vector<vector<int> > f(m);
        int i, j, k;
        for(i = 0; i < m; ++i) {
            f[i] = vector<int>(n, 0);
        }
        if(obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            f[0][0] = 1;
        }
        for(i = 0; i < m; ++i) {
            for(j = 0; j < n; ++j) {
                if(obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {                     
                    if(i > 0 && obstacleGrid[i - 1][j] != 1) {
                        f[i][j] += f[i - 1][j];
                    }
                    if(j > 0 && obstacleGrid[i][j - 1] != 1) {
                        f[i][j] += f[i][j - 1];
                    }   
                }
            }
        }
        return f[m - 1][n - 1];
    }
};
class Solution {
public:
    bool isNumber(const char *s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        const char *low, *high;
        int i, j, k, len;
        len = strlen(s);
        low = s; 
        high = s + len - 1;
        bool flag = false;
        while(low <= high && *low == ' ') {
            ++low;
        }
        while(low <= high && *high == ' ') {
            --high;
        }
        if(*low == '+' || *low == '-') {
            ++low;
        }
        while(*low >= '0' && *low <= '9') {
            ++low;
            flag = true;
        }
        if(*low == '.') {
            ++low;
            while(*low >= '0' && *low <= '9') {
                ++low;
                flag = true;
            }
        }
        if(*low == 'e') {
            if(!flag) {
                return false;
            }
            flag = false;
            ++low;
            if(*low == '+' || *low == '-') {
                ++low;
            }
            while(*low >= '0' && *low <= '9') {
                ++low;
                flag = true;
            }
        }
        if(low <=high) {
            return false;
        }
        return flag;
    }
};
class Solution {
public:
    bool isValid(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<char, char> m;
        m.insert(make_pair(')', '('));
        m.insert(make_pair(']', '['));
        m.insert(make_pair('}', '{'));
        stack<char> st;
        char ch;
        int i, j, k;
        for(i = 0; i < s.length(); ++i) {
            if(s[i] == '(' || s[i] == '[' || s[i] == '{') {
                st.push(s[i]);
            } else {
                ch = m[s[i]];
                while(!st.empty() && st.top() != ch) {
                    st.pop();
                }
                if(st.empty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.empty();
    }
};
class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, x, y;
        vector<bool> bs, bs2;
        for(i = 0; i < 9; ++i) {
            bs.assign(10, false);
            bs2.assign(10, false);
            for(j = 0; j < 9; ++j) {
                if(board[i][j] != '.') {
                    k = board[i][j] - '0';
                    if(bs[k]) {
                        return false;
                    } else {
                        bs[k] = true;
                    }
                }
                if(board[j][i] != '.') {
                    k = board[j][i] - '0';
                    if(bs2[k]) {
                        return false;
                    } else {
                        bs2[k] = true;
                    }
                }
            }
        }
        for(x = 0; x < 9; x += 3) {
            for(y = 0; y < 9; y += 3) {
                bs.assign(10, false);
                for(i = 0; i < 3; ++i) {
                    for(j = 0; j < 3; ++j) {
                        if(board[x + i][y + j] != '.') {
                            k = board[x + i][y + j] - '0';
                            if(bs[k]) {
                                return false;
                            } else {
                                bs[k] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
};
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isValidR(TreeNode *root, TreeNode *&pre) {
        if(root == NULL) {
            return true;
        }
        bool re = false;
        re = isValidR(root->left, pre);
        if(!re) {
            return false;
        }
        if(pre != NULL && pre->val >= root->val) {
            return false;
        }
        pre = root;
        return isValidR(root->right, pre);
    }
    bool isValidBST(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL;
        return isValidR(root, pre);
    }
};
class Solution {
public:
//TLE for large test case.
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return false;
        if(*p == NULL) return NULL == *s;
        if(*s == *p || *p == '?') {
            if(*s != NULL) {                 
                return isMatch(s + 1, p + 1);   
            }
        } else if(*p == '*') {
            while(*p == '*') {
                ++p;
            }
            if(*p == NULL) {
                return true;
            }
            while(*s != NULL) {
                if(isMatch(s, p)) {
                    return true;
                }
                ++s;
            }     
        }        
        return false;
    }
};
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i;
        bool star = false;
    	bool stopFroLoop = false;
        while(true) {
			stopFroLoop = false;
            for(i = 0; s[i]; ++i) {
                switch(p[i]) {
                case '?':
                    break;
                case '*':
                    star = true;
                    s += i;
                    p += i;
                    while(*p == '*') {
                        ++p;
                    }
                    if(*p == NULL) {
                        return true;
                    }
					stopFroLoop = true;
                    break;
                default:
                    if(s[i] != p[i]) {
                        if(star) {
                            ++s;
							stopFroLoop = true;
                        } else {
                            return false;
                        }
                    }
                }
				if(stopFroLoop) {
					break;
				}
            }
            if(!stopFroLoop) {
                break;
            }
        }
        while(p[i] == '*') {
            ++i;
        }
        return p[i] == NULL;
    }
};
class Solution {
public:
    bool checkR(vector<vector<char> > &board, string& word, int wi, int x, int y, int m, int n,
        set<pair<int, int> > s) {
        if(board[x][y] != word[wi]) {
            return false;
        }
        if(wi == word.length() - 1) {
            return true;
        }
        s.insert(make_pair(x, y));
        if(x - 1 >= 0 && s.find(make_pair(x - 1, y)) == s.end()) {
            if(checkR(board, word, wi + 1, x - 1, y, m, n, s)) {
                return true;
            }
        }
        if(x + 1 < m && s.find(make_pair(x + 1, y)) == s.end()) {
            if(checkR(board, word, wi + 1, x + 1, y, m, n, s)) {
                return true;
            }
        }        
        if(y - 1 >= 0&& s.find(make_pair(x, y - 1)) == s.end()) {
            if(checkR(board, word, wi + 1, x, y - 1, m, n, s)) {
                return true;
            }
        }
        if(y + 1 < n && s.find(make_pair(x, y + 1)) == s.end()) {
            if(checkR(board, word, wi + 1, x, y + 1, m, n, s)) {
                return true;
            }
        }
        s.erase(make_pair(x, y));
        return false;
    }
    bool exist(vector<vector<char> > &board, string word) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m, n, i, j, k;
        m = board.size();
        n = board[0].size();
        set<pair<int, int> > s;
        for(i = 0; i < m; ++i) {
            for(j = 0; j < n; ++j) {
                if(checkR(board, word, 0, i, j, m, n, s)) {
                    return true;
                }
            }
        }
        return false;
    }
};
class Solution {
public:
    string convert(string s, int nRows) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(nRows == 1) {
            return s;
        }
        vector<string> v;
        string str;
        int i = 0, j, k;
        k = 1;
        while(i < s.length()) {
            if(k) {
                v.push_back(s.substr(i, nRows));
                i += nRows;
            } else {
                if(nRows > 2) {
                    str = s.substr(i, nRows - 2);
                    int num = 1;
                    if(str.length() != nRows - 2) {
                        num = nRows - 2 - str.length() + 1;
                    }
                    str.append(num, ' ');
                    reverse(str.begin(), str.end());
                    v.push_back(str + " ");
                    i += nRows - 2;
                }
            }
            k = 1 - k;
        }
        string re;
        for(j = 0; j < nRows; ++j) {
    		for(i = 0; i < v.size(); ++i) {
                if(j < v[i].size() && v[i][j] != ' ') {
                    re.push_back(v[i][j]);
                }
            }
        }
        return re;
    }
};
#include <iostream>
#include <queue>
#include <vector>
#include <set>
using namespace std;
int main() {
	int N, K, i, j, k, cnt = 0, l, tmp, qsize;
	bool find = false;
	vector<pair<int, int> > moves;
	set<vector<int> > s;
	scanf("%d%d", &N, &K);
	vector<int> cur(N), final(N), peg(K);
	for(i = 0; i < N; ++i) {
		scanf("%d", &cur[i]);
	}
	for(i = 0; i < N; ++i) {
		scanf("%d", &final[i]);
	}
	queue<vector<int> > q;
	queue<vector<pair<int, int> > > q2;
	q.push(cur);
	s.insert(cur);
	q2.push(vector<pair<int, int> >());
	while(cnt <= 7) {
		++cnt;
		qsize = q.size();
		for(i = 0; i < qsize; ++i) {
			cur = q.front(); q.pop();
			peg.assign(K, N + 1);
			for(j = 0; j < cur.size(); ++j) {
				if(peg[cur[j] - 1] == N + 1) {
					peg[cur[j] - 1] = j;
				}
			}
			moves = q2.front(); q2.pop();
			for(j = 0; j < K; ++j) {
				for(k = 0; k < K; ++k) {
					if(k != j && 
						(moves.size() == 0 || (j + 1 != moves[moves.size() - 1].second || k + 1 != moves[moves.size() - 1].first))
						&& peg[j] < peg[k]) {
						tmp = cur[peg[j]];
						cur[peg[j]] = k + 1;
						moves.push_back(make_pair(j + 1, k + 1));
						if(s.find(cur) == s.end()){
							s.insert(cur);
							find = true;
							for(l = 0; l < N; ++l) {
								if(final[l] != cur[l]) {
									find = false;
									break;
								}
							}
							if(find) {
								printf("%d\n", cnt);
								for(l = 0; l < moves.size(); ++l) {
									printf("%d %d\n", moves[l].first, moves[l].second);
								}
								return 0;
							}
							q.push(cur);
							q2.push(moves);
						} 
						moves.pop_back();
						cur[peg[j]] = tmp;
					}
				}
			}
		}
	}
	return 0;
}