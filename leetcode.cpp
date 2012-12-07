class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        sort(num.begin(), num.end());
        int i, j, k;
        for(i = 0; i < num.size() && num[i] <= 0; ++i) {
            if(i > 0 && num[i - 1] == num[i]) {
                continue;
            }
            for(j = i + 1; j < num.size() && num[i] + num[j] <= 0; ++j) {
                if(j > i + 1 && num[j - 1] == num[j]) {
                    continue;
                }
                if(binary_search(num.begin() + j + 1, num.end(), 0 - num[i] - num[j])) {
                    cur.clear();
                    cur.push_back(num[i]);
                    cur.push_back(num[j]);
                    cur.push_back(0 - num[i] - num[j]);
                    re.push_back(cur);
                }
            }
        }
        return re;
    }
};
class Solution {
public:
    int bsearch(vector<int> &num, int low, int high, int key) {
        int mid, i, j, k;
        while(low <= high) {
            mid = (low + high) / 2;
            if(num[mid] == key) {
                return mid;
            } else if(num[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    int threeSumClosest(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(num.begin(), num.end());
        int i, j, k, key, re = -1, gap = INT_MAX, tmp;
        for(i = 0; i < num.size() - 2; ++i) {
            if(i > 0 && num[i - 1] == num[i]) {
                continue;
            }
            for(j = i + 1; j < num.size() - 1; ++j) {
                if(j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                key = target - num[i] - num[j];
                k = bsearch(num, j + 1, num.size() - 1, key);
                if(k > j && abs(num[k] - key) < gap) {
                    gap = abs(num[k] - key);
                    re = num[i] + num[j] + num[k];
                }
                if(k + 1 < num.size() && abs(num[k + 1] - key) < gap) {
                    gap = abs(num[k + 1] - key);
                    re = num[i] + num[j] + num[k + 1];
                }            
                if(re == target) {
                    return re;
                }
            }
        }
        return re;
    }
};
class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, low, high, a, b, c, d;
        vector<vector<int> > re;
        vector<int> v;
        sort(num.begin(), num.end());
        set<string> s;
        string str;
        if(num.size() < 4) {
            return re;
        }
        for(i = 0; i < num.size() - 3; ++i) {
            a = num[i];
            for(j = i + 1; j < num.size() - 2; ++j) {
                b = num[j];
                low = j + 1; high = num.size() - 1;
                while(low < high) {
                    c = num[low];
                    d = num[high];
                    if(a + b + c + d > target) {
                        --high;
                    } else if (a + b + c + d < target) {
                        ++low;
                    } else {
                        str.clear();
                        str += a;
                        str += "#";
                        str += b;
                        str += "#";
                        str += c;
                        str += "#";
                        str += d;
                        str += "#";
                        if(s.find(str) == s.end()) {
                            v.clear();
                            v.push_back(a);
                            v.push_back(b);
                            v.push_back(c);
                            v.push_back(d);
                            re.push_back(v);
                            s.insert(str);
                        }
                        ++low;
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
        string re;
        int i, j, k, lenmin, c = 0, lena, lenb;
        lena = a.length();
        lenb = b.length();
        lenmin = min(lena, lenb);
        for(i = 1; i <= lenmin; ++i) {
            j = a[lena - i] - '0' + b[lenb - i] - '0' + c;
            c = j >> 1;
            j &= 1;
            re.push_back(j + '0');
        }
        if(lena > lenmin) {
            for(i = lenmin + 1; i <= lena; ++i) {                    
                j = a[lena - i] - '0' + c;
                c = j >> 1;
                j &= 1;
                re.push_back(j + '0');
            }
        }
        if(lenb > lenmin) {
            for(i = lenmin + 1; i <= lenb; ++i) {                    
                j = b[lenb - i] - '0' + c;
                c = j >> 1;
                j &= 1;
                re.push_back(j + '0');
            }
        }
        if(c != 0) {
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
        ListNode *head = NULL, *pre = NULL, *cur;
        int i, j, k, c = 0;
        while(l1 != NULL && l2 != NULL) {
            j = l1->val + l2->val + c;
            c = j / 10;
            j %= 10;
            cur = new ListNode(j);
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1 != NULL) {
            j = l1->val + c;
            c = j / 10;
            j %= 10;
            cur = new ListNode(j);
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
            l1 = l1->next;
        }
        while(l2 != NULL) {
            j = l2->val + c;
            c = j / 10;
            j %= 10;
            cur = new ListNode(j);
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
            l2 = l2->next;
        }
        if(c > 0) {            
            cur = new ListNode(c);
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
        }
        return head;
    }
};
class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k;
        map<string, vector<string> > m;
        vector<string> v;
        string ss;
        for(i = 0; i < strs.size(); ++i) {
            ss = strs[i];
            sort(ss.begin(), ss.end());
            m[ss].push_back(strs[i]);
        }
        map<string, vector<string> >::iterator it;
        for(it = m.begin(); it != m.end(); ++it) {
            if(it->second.size() > 1) {
                for(i = 0; i < it->second.size(); ++i) {
                    v.push_back((it->second)[i]);
                }
            }
        }
        return v;
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
        if(root == NULL) {
            return 0;
        }
        return max(height(root->left), height(root->right)) + 1; 
    }
    bool isBalanced(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) {
            return true;
        }
        if(abs(height(root->left) - height(root->right)) <= 1) {
            return isBalanced(root->left) && isBalanced(root->right);
        } 
        return false;
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
 struct info{
    TreeNode *root;
    info* parent;
    info(TreeNode *root, int index, info* parent){
        this->root = root;
        this->index = index;
        this->parent = parent;
    	h[0] = -1;
		h[1] = -1;
    }
    int h[2], index;
};
class Solution {
public:
    bool isBalanced(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<info*> st;
        info* si, *ti;
        si = new info(root, -1, NULL);
        st.push(si);
        while(!st.empty()) {
            ti = st.top(); st.pop();
            if(ti->root == NULL) {
                if(ti->parent != NULL) {
                    ti->parent->h[ti->index] = 0;                       
                }
                continue;
            }
            if(ti->h[0] == -1) {
                st.push(ti);
                si = new info(ti->root->left, 0, ti); 
                st.push(si);
            } else if(ti->h[1] == -1) {
                st.push(ti);
                si = new info(ti->root->right, 1, ti);
                st.push(si);
            } else {
                if(abs(ti->h[0] - ti->h[1]) > 1) {
                    return false;
                }
                if(ti->parent != NULL) {
                    ti->parent->h[ti->index] = max(ti->h[0], ti->h[1]) + 1;
                }
                continue;
            }            
        }
        return true;
    }
};
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(prices.size() < 2) {
            return 0;
        }
        int i, j, k, low = prices[0], re = 0;
        for(i = 1; i < prices.size(); ++i) {
            if(prices[i] - low > re) {
                re = prices[i] - low;
            }
            if(prices[i] < low) {
                low = prices[i];
            }
        }
        return re;
    }
};
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, re = 0;
        if(prices.size() < 2) {
            return 0;
        }
        for(i = 1; i < prices.size(); ++i) {
            if(prices[i] > prices[i - 1]) {
                re += prices[i] - prices[i - 1];
            }
        }
        return re;
    }
};
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> v(prices.size(), 0);
        int i, j, k, cur = 0, re = 0;
        if(prices.size() < 2) {
            return 0;
        }
        k = prices[0];
        for(i = 1; i < prices.size(); ++i) {
            if(prices[i] - k > cur) {
                cur = prices[i] - k;
            }
            if(prices[i] < k) {
                k = prices[i];
            }
            v[i] = cur;
            re = max(cur, re);
        }
        k = prices[prices.size() - 1];
        cur = 0;
        for(i = prices.size() - 2; i > 1; --i) {
            if(k - prices[i] > cur) {
                cur = k - prices[i];
            }
            if(prices[i] > k) {
                k = prices[i];
            }
            if(cur + v[i - 1] > re) {
                re = cur + v[i - 1];
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
    void inorderR(vector<int> &re, TreeNode *root) {
        if(root == NULL) {
            return;
        }
        inorderR(re, root->left);
        re.push_back(root->val);
        inorderR(re, root->right);
    }
    vector<int> inorderTraversal(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        inorderR(re, root);
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
    struct SnapShotStruct{
        TreeNode *root;
        int stage;
    };
    vector<int> inorderTraversal(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        vector<int> re;
        stack<SnapShotStruct> st;
        SnapShotStruct cur, newSnap;
        cur.root = root;
        cur.stage = 0;
        st.push(cur);
        while(!st.empty()) {
            cur = st.top(); st.pop();
            switch(cur.stage) {
            case 0:
                if(cur.root == NULL) {
                    continue;
                }
                cur.stage = 1;
                st.push(cur);
                newSnap.root = cur.root->left;
                newSnap.stage = 0;
                st.push(newSnap);
                break;
            case 1:
                re.push_back(cur.root->val);
                newSnap.root = cur.root->right;
                newSnap.stage = 0;
                st.push(newSnap);
                break;
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
    vector<int> inorderTraversal(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *cur = root, *pre = NULL;
        vector<int> re;
        while(cur != NULL) {
            if(cur->left == NULL) {
                re.push_back(cur->val);
                cur = cur->right;
            } else{
                pre = cur->left;
                while(pre->right != NULL && pre->right != cur) pre = pre->right;
                if(pre->right == NULL) {
                    pre->right = cur;
                    cur = cur->left;
                } else {
                    pre->right = NULL;
                    re.push_back(cur->val);
                    cur = cur->right;
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
    vector<vector<int> > levelOrder(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> row;
        queue<TreeNode*> q;
        if(root == NULL) {
            return re;
        }
        q.push(root);
        int i, j, k, qsize;
        while(!q.empty()) {
            qsize = q.size();
            row.clear();
            for(i = 0; i < qsize; ++i) {
                root = q.front(); q.pop();
                row.push_back(root->val);
                if(root->left != NULL) {
                    q.push(root->left);
                }
                if(root->right != NULL) {
                    q.push(root->right);
                }
            }
            re.push_back(row);
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
        vector<int> row;
        queue<TreeNode*> q;
        if(root == NULL) {
            return re;
        }
        q.push(root);
        int i, j, k, qsize;
        while(!q.empty()) {
            qsize = q.size();
            row.clear();
            for(i = 0; i < qsize; ++i) {
                root = q.front(); q.pop();
                row.push_back(root->val);
                if(root->left != NULL) {
                    q.push(root->left);
                }
                if(root->right != NULL) {
                    q.push(root->right);
                }
            }
            re.push_back(row);
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
    int maxPSR(TreeNode *root, int &re) {
        if(root == NULL) {
            return 0;
        }
        int l, r, lr;
        l = maxPSR(root->left, re);
        r = maxPSR(root->right, re);
        lr = max(l, r);
        re = max(root->val + l + r, re);
        re = max(root->val + lr, re);
        re = max(root->val, re);
        return max(root->val, root->val + lr);
    }
    int maxPathSum(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int re = INT_MIN;
        int sm = maxPSR(root, re);
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
struct SnapShotStruct {
    TreeNode *root;
    int l, r;
    int stage;
};
class Solution {
public:
    int maxPathSum(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int re = INT_MIN, retVal = 0, lr;
        SnapShotStruct curSnap, newSnap;
        stack<SnapShotStruct> st;
        curSnap.root = root;
        curSnap.l = 0;
        curSnap.r = 0;
        curSnap.stage = 0;
        st.push(curSnap);
        while(!st.empty()) {
            curSnap = st.top(); st.pop();
            switch(curSnap.stage) {
            case 0:
                if(curSnap.root == NULL) {
                    retVal = 0;
                    continue;
                }
                curSnap.stage = 1;
                st.push(curSnap);
                newSnap.root = curSnap.root->left;
                newSnap.stage = 0;
                newSnap.l = 0;
                newSnap.r = 0;
                st.push(newSnap);
                break;
            case 1:
                curSnap.l = retVal;
                curSnap.stage = 2;
                st.push(curSnap);
                newSnap.root = curSnap.root->right;
                newSnap.stage = 0;
                newSnap.l = 0;
                newSnap.r = 0;
                st.push(newSnap);
                break;
            case 2:
                curSnap.r = retVal;
                lr = max(curSnap.l, curSnap.r);
                re = max(curSnap.root->val + curSnap.l + curSnap.r, re);
                re = max(curSnap.root->val + lr, re);
                re = max(curSnap.root->val, re);
                retVal = max(curSnap.root->val, curSnap.root->val + lr);
                break;
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
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> row;
        queue<TreeNode*> q;
        if(root == NULL) {
            return re;
        }
        q.push(root);
        int i, j, k = 0, qsize;
        while(!q.empty()) {
            qsize = q.size();
            row.clear();
            for(i = 0; i < qsize; ++i) {
                root = q.front(); q.pop();
                row.push_back(root->val);
                if(root->left != NULL) {
                    q.push(root->left);
                }
                if(root->right != NULL) {
                    q.push(root->right);
                }
            }
            if(k) {
                reverse(row.begin(), row.end());
            }
            k = 1 - k;
            re.push_back(row);
        }
        return re;
    }
};
class Solution {
public:
    int climbStairs(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0 || n == 1) {
            return 1;
        }
        int i, j, k, r[3];
        r[0] = 1;
        r[1] = 1;
        for(i = 2; i <= n; ++i) {
            r[i % 3] = r[(i - 1 + 3) %3] + r[(i - 2 + 3) % 3];
        }
        return r[n % 3];
    }
};
class Solution {
public:
    void combR(vector<vector<int> > &re, vector<int> &candidates, int target, 
    vector<int> &cur, int index) {
        int i, j, k;
        if(target == 0) {
            re.push_back(cur);
			return;
        }
        for(i = index; i < candidates.size(); ++i) {
            if(candidates[i] > target) {
                break;
            }
            cur.push_back(candidates[i]);
            combR(re, candidates, target - candidates[i], cur, i);
            cur.pop_back();        
        }
    }
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        combR(re, candidates, target, cur, 0);
        return re;
    }
};
class Solution {
public:
    struct snap {
        int i, target, stage;  
    };
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        stack<snap> st;
        snap curs, tmps;
        curs.target = target;
        curs.stage = 0;
        curs.i = 0;
        st.push(curs);
        while(!st.empty()) {
            curs = st.top(); st.pop();
            switch(curs.stage) {
            case 0:
                if(curs.target == 0) {
                    re.push_back(cur);
                    continue;
                }
                if(curs.i >= candidates.size()) {
                    continue;
                }
                if(candidates[curs.i] > curs.target) {
                    continue;
                }
                cur.push_back(candidates[curs.i]);
                curs.stage = 1;
                st.push(curs);
                tmps.target = curs.target - candidates[curs.i];
                tmps.stage = 0;
                tmps.i = curs.i;
                st.push(tmps);
                break;
            case 1:
                cur.pop_back();
                curs.stage = 0;
                ++curs.i;
                st.push(curs);
                break;
            }
        }
        return re;
    }
};
class Solution {
public:
    void combR(vector<vector<int> > &re, vector<int> &candidates, int target, 
    vector<int> &cur, int index, set<vector<int> > &s) {
        int i, j, k;
        if(target == 0) {
            if(s.find(cur) == s.end()) {
                re.push_back(cur);
                s.insert(cur);    
            }
        	return;
        }
        for(i = index; i < candidates.size(); ++i) {
            if(candidates[i] > target) {
                break;
            }
            cur.push_back(candidates[i]);
            combR(re, candidates, target - candidates[i], cur, i + 1, s);
            cur.pop_back();        
        }
    }
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        set<vector<int> > s;
        vector<int> cur;
        sort(num.begin(), num.end());
        combR(re, num, target, cur, 0, s);
        return re;
    }
};
class Solution {
public:
    void combineR(vector<vector<int> > &re, vector<int> &cur, int n, int k, int index, int cnt) {
        int i, j;
        if(cnt == k) {
            re.push_back(cur);
            return;
        }
        for(i = index; i <= n; ++i) {
            cur.push_back(i);
            combineR(re, cur, n, k, i + 1, cnt + 1);
            cur.pop_back();
        }
    }
    struct snap {
        int index, cnt, stage;  
    };
    vector<vector<int> > combine(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
    //    combineR(re, cur, n, k, 1, 0);
        stack<snap> st;
        snap curSnap, newSnap;
        curSnap.index = 1;
        curSnap.cnt = 0;
        curSnap.stage = 0;
        st.push(curSnap);
        while(!st.empty()) {
            curSnap = st.top(); st.pop();
            switch(curSnap.stage) {
            case 0:
                if(curSnap.cnt == k) {
                    re.push_back(cur);
                    continue;
                }
                if(curSnap.index > n) {
                    continue;
                }
                cur.push_back(curSnap.index);
                curSnap.stage = 1;
                st.push(curSnap);
                newSnap.index = curSnap.index + 1;
                newSnap.cnt = curSnap.cnt + 1;
                newSnap.stage = 0;
                st.push(newSnap);
                break;
            case 1:
                cur.pop_back();
                ++curSnap.index;
                curSnap.stage = 0;
                st.push(curSnap);
                break;
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
    TreeNode* buildR(vector<int> &inorder, vector<int> &postorder, 
    int ibegin, int iend, int pbegin, int pend) {
        if(ibegin > iend || pbegin > pend) {
            return NULL;
        }
        TreeNode *root = new TreeNode(postorder[pend]);
        if(pbegin == pend) {
    		return root;
		}
		int i, j, k;
        for(i = ibegin; i <= iend; ++i) {
            if(inorder[i] == postorder[pend]) {
                break;
            }
        }
        root->left = buildR(inorder, postorder, ibegin, i - 1, 
        pbegin, pbegin + i - ibegin - 1);
        root->right = buildR(inorder, postorder, i + 1, iend,
        pbegin + i - ibegin, pend - 1);
		return root;
    }
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return buildR(inorder, postorder, 0, inorder.size() - 1,
        0, postorder.size() - 1);
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
    TreeNode *buildR2(vector<int> &preorder, vector<int> &inorder,
    int pbegin, int pend, int ibegin, int iend) {
        if(pbegin > pend || ibegin > iend) {
            return NULL;
        }
        TreeNode *root = new TreeNode(preorder[pbegin]);
        if(pbegin == pend) {
            return root;
        }
        int i;
        for(i = ibegin; i <= iend; ++i) {
            if(inorder[i] == preorder[pbegin]) {
                break;
            }
        }
        root->left = buildR2(preorder, inorder, pbegin + 1, pbegin + i - ibegin, 
        ibegin, i - 1);
        root->right = buildR2(preorder, inorder, pbegin + i - ibegin + 1, pend,
        i + 1, iend);
        return root;
    }
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return buildR2(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
    }
};
class Solution {
public:
    int maxArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, l, h, re = 0;
        l = 0; h = height.size() - 1;
        while(l < h) {
            k = min(height[l], height[h]);
            re = max(re, k * (h - l));
            while(height[l] <= k && l < h) {
                ++l;
            }
            while(height[h] <= k && l < h) {
                --h;
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
    TreeNode* sortedR(vector<int> &num, int begin, int end) {
        int i, j, k, mid;
        if(begin > end) {
            return NULL;
        }
        mid = (begin + end) / 2; // begin + (end - begin) / 2;
        TreeNode *root = new TreeNode(num[mid]);
        if(begin == end) {
            return root;
        }
        root->left = sortedR(num, begin, mid - 1);
        root->right = sortedR(num, mid + 1, end);
        return root;
    }
    TreeNode *sortedArrayToBST(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return sortedR(num, 0, num.size() - 1);
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
    TreeNode* sortedR(vector<int> &num, int begin, int end) {
        int i, j, k, mid;
        if(begin > end) {
            return NULL;
        }
        mid = (begin + end) / 2;
        TreeNode *root = new TreeNode(num[mid]);
        if(begin == end) {
            return root;
        }
        root->left = sortedR(num, begin, mid - 1);
        root->right = sortedR(num, mid + 1, end);
        return root;
    }
    TreeNode *sortedArrayToBST(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        return sortedR(num, 0, num.size() - 1);
    }
    TreeNode *sortedListToBST(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> v;
        ListNode *p = head;
        while(p) {
            v.push_back(p->val);
            p = p->next;
        }
        return sortedArrayToBST(v);
    }
};
class Solution {
public:
    string countAndSay(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
       // return "";
        int i, j = 0, k, cnt;
        vector<int> v[2];
        v[0].push_back(1);
        for(i = 0; i < n; ++i) {
            v[1 - j].clear();
            cnt = 0;
            for(k = 0; k < v[j].size(); ++k) {
                if(k == 0 || v[j][k - 1] == v[j][k]) {
                    ++cnt;
                } else {
                    v[1 - j].push_back(cnt);
                    v[1 - j].push_back(v[j][k - 1]);
                    cnt = 1;
                }
            }
            v[1 - j].push_back(cnt);
            v[1 - j].push_back(v[j][k - 1]);
            j = 1 - j;
        }
        j = 1 - j;
        string re;
        for(i = 0; i < v[j].size(); ++i) {
            re.push_back('0' + v[j][i]);
        }
        return re;
    }
};
class Solution {
public:
    int numDecodings(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, re = 0;
        vector<int> f(s.length() + 1, 0);
        if(s.length() == 0) {
            return 0;
        }
        f[s.length()] = 1;
        for(i = s.length() - 1; i >= 0; --i) {
            if(s[i] > '0') {
                f[i] += f[i + 1];  
                if(i + 1 < s.length()) {
                    k = (s[i] - '0') * 10 + s[i + 1] - '0';
                    if(k <= 26) {
                        f[i] += f[i + 2];
                    }
                }
            }
        }
        return f[0];
    }
};
class Solution {
public:
    int numDR(string &S, string &T, int si, int ti, map<pair<int, int>, int> &m ) {
        int i, j, k = 0;
        if(ti == T.length()) {
            return 1;
        }
        pair<int, int> p = make_pair(si, ti);
        if(m.find(p) != m.end()) {
            return m[p];
        }
    	int lens = S.length();
		int lent = T.length();
		int len = lens - lent + ti + 1;
        for(i = si; i < len; ++i) {
            if(S[i] == T[ti]) {
                k += numDR(S, T, i + 1, ti + 1, m);
            }
        }
        m[p] = k;
        return k;
    }
    int numDistinct(string S, string T) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<pair<int, int>, int > m;
        return numDR(S, T, 0, 0, m);
    }
};
class Solution {
public:
    int divide(int dividend, int divisor) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        long long i, j, k, re = 0;
        long long d1, d2;
        d1 = dividend;
        d2 = divisor;
        int flag = 1;
        if((d1 > 0 && d2 < 0 ) || (d1 < 0 && d2 > 0))  {
            flag = -1;
        }
        if(d1 < 0) d1 *= -1;
        if(d2 < 0) d2 *= -1;
        //return 0;
        k = 1;
        stack<long long> sd, sa;
        while(true) {
            while(d1 < d2 && !sd.empty()) {
                d2 = sd.top(); sd.pop();
                k = sa.top(); sa.pop();
            }
            if(d1 < d2) {
                break;
            }
            re += k;
            d1 -= d2;
            if(d2 * 2 <= d1) {                    
                sd.push(d2);
                sa.push(k);
                d2 *= 2;
                k *= 2;   
            }
        }
        return re * flag;
    }
};
class Solution {
public:
    int minDistance(string word1, string word2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > f;
        int i, j, k, t;
        for(i = 0; i <= word1.length(); ++i) {
            f.push_back(vector<int>(word2.length() + 1, 0));
        }
        for(i = 0; i <= word1.length(); ++i) {
            f[i][0] = i;
        }
        for(j = 0; j <= word2.length(); ++j) {
            f[0][j] = j;
        }
        for(i = 1; i <= word1.length(); ++i) {
            for(j = 1; j <= word2.length(); ++j) {
                if(word1[i - 1] == word2[j - 1]) {
                    t = f[i - 1][j - 1];
                } else {
                    t = f[i - 1][j - 1] + 1;
                }
                t = min(t, f[i - 1][j] + 1);
                t = min(t, f[i][j - 1] + 1);
                f[i][j] = t;
            }
        }
        return f[word1.length()][word2.length()];
    }
};
class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k;
        if(n == 0) {
            return 1;
        }
        for(i = 0; i < n; ++i) {
            if(A[i] < 0) {
                A[i] = 0;
            }
        }
        for(i = 0; i < n; ++i) {
            k = abs(A[i]);
            if(k > 0 && k <= n) {
                if(A[k - 1] == 0) {
                    A[k - 1] = -k;
                } else if (A[k - 1] > 0){
                    A[k - 1] *= -1;
                }
            }
        }
        for(i = 0; i < n; ++i) {
            if(A[i] >= 0) {
                return i + 1;
            }
        }
        return n + 1;
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
    void preorder(TreeNode *root, TreeNode *&pre) {
        if(root == NULL) {
            return;
        }
        TreeNode *right = root->right;
        if(pre != NULL) {
            pre->right = root;
        }
        pre = root;
        preorder(root->left, pre);
        preorder(right, pre);
        root->left = NULL;
    }
    void flatten(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL;
        preorder(root, pre);
    }
};
class Solution {
public:
    void genR(vector<string> &re, vector<char> &cur, int left, int right) {
        int i, j, k;
        if(left == 0 && right == 0) {
            string str;
            for(i = 0; i < cur.size(); ++i) {
                str.push_back(cur[i]);
            }
            re.push_back(str);
            return;
        }
        if(left > 0) {
            cur.push_back('(');
            genR(re, cur, left - 1, right + 1);
            cur.pop_back();
        }
        if(right > 0) {
            cur.push_back(')');
            genR(re, cur, left, right - 1);
            cur.pop_back();
        }
    }
    vector<string> generateParenthesis(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
        vector<char> cur;
        genR(re, cur, n, 0);
        return re;
    }
};
class Solution {
public:
    void grayR(vector<int> &re, int n, int &x) {
        if(n == 1) {
            re.push_back(x);
            x ^= 1;
            re.push_back(x);
            return;
        }
        grayR(re, n - 1, x);
        x ^= 1 << (n - 1);
        grayR(re, n - 1, x);
    }
    vector<int> grayCode(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        if(n == 0) {
            re.push_back(0);
            return re;
        }
    	int x = 0;
        grayR(re, n, x);
        return re;
    }
};
class Solution {
public:
    vector<int> grayCode(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        re.push_back(0);
        int i, j, k, d;
        for(i = 0; i < n; ++i) {
            k = re.size();
            d = 1 << i;
            for(j = k - 1; j >= 0; --j) {
                re.push_back(re[j] ^ d);
            }
        }
        return re;
    }
};
class Solution {
public:
    void calc(vector<int> &f, char *needle, int lenn) {
        int i, j, k;
        f[0] = 0;
        k = 0;
        for(i = 1; i < lenn; ++i) {
            while(k > 0 && needle[k] != needle[i]) {
                k = f[k - 1];
            }
            if(needle[k] == needle[i]) {
                ++k;
            }
            f[i] = k;
        }
    }
    char *strStr(char *haystack, char *needle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, lenh, lenn;
        lenh = strlen(haystack);
        lenn = strlen(needle);
        vector<int> f(lenn);
        if(lenn == 0) return haystack;
        calc(f, needle, lenn);
        k = 0;
        for(i = 0; i < lenh; ++i) {
            while(k > 0 && needle[k] != haystack[i]) {
                k = f[k - 1];
            }
            if(needle[k] == haystack[i]) {
                ++k;
            }
            if(k == lenn) {
                return haystack + i - lenn + 1;
            }
        }
        return NULL;
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

class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k;
        vector<Interval> re;
        int merge = 0;
        for(i = 0; i < intervals.size(); ++i) {
            switch(merge) {
            case 0:
                if(newInterval.start > intervals[i].end) {
                    re.push_back(intervals[i]);
                } else if(newInterval.end < intervals[i].start) {
                    re.push_back(newInterval);
                    re.push_back(intervals[i]);
                    merge = 2;
                } else {
                    merge = 1;
                    newInterval.start = min(intervals[i].start, newInterval.start);
                    newInterval.end = max(intervals[i].end, newInterval.end);
                }
                break;
            case 1:
                if(newInterval.end >= intervals[i].start) {
                    newInterval.end = max(newInterval.end, intervals[i].end);
                } else {
                    merge = 2;
                    re.push_back(newInterval);
                    re.push_back(intervals[i]);
                }
                break;
            case 2:
                re.push_back(intervals[i]);
            }
        }
        if(merge < 2) {
            re.push_back(newInterval);
        }
        return re;
    }
};
class Solution {
public:
    string intToRoman(int num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        char ch[4][4] = {"IV", "XL", "CD", "M"};
        int i, j, k, h[4];
        string str;
        k = 0;
        while(num > 0) {
            h[k++] = num % 10;
            num /= 10;
        }
        for(i = k - 1; i >= 0; --i) {
            if(h[i] == 9) {
                str.append(1, ch[i][0]);    
                str.append(1, ch[i + 1][0]);
            } else if(h[i] >= 5) {
                str.append(1, ch[i][1]);
                str.append(h[i] - 5, ch[i][0]);
            } else if(h[i] == 4){
                str.append(1, ch[i][0]);
                str.append(1, ch[i][1]);
            } else {
                str.append(h[i], ch[i][0]);
            }
        }
        return str;
    }
};
class Solution {
public:
    bool isIR(string &s1, string &s2, string &s3, int i1, int i2, int i3,
        map<pair<int, pair<int, int> >, bool> &m) {
        if(i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
            return true;
        }
        pair<int, pair<int, int> > p = make_pair(i1, make_pair(i2, i3));
        if(m.find(p) != m.end()) {
            return m[p];
        }
        bool flag = false;
        if(i1 < s1.length() && s3[i3] == s1[i1]) {
            flag = isIR(s1, s2, s3, i1 + 1, i2, i3 + 1, m);
        }
        if(!flag && i2 < s2.length() && s3[i3] == s2[i2]) {
            flag = isIR(s1, s2, s3, i1, i2 + 1, i3 + 1, m);
        }      
        m[p] = flag;
        return flag;
    }
    bool isInterleave(string s1, string s2, string s3) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        map<pair<int, pair<int, int> >, bool> m;
        return isIR(s1, s2, s3, 0, 0, 0, m);
    }
};
class Solution {
public:
    bool canJump(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k = 0;
        for(i = 0; i < n; ++i) {
            if(k >= i) {
                k = max(k, i + A[i]);
            }
        }
        return k >= n - 1;
    }
};
class Solution {
public:
    int jump(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k = 0, l = 0;
        vector<int> f(n, -1);
        f[0] = 0;
        for(i = 0; i < n; ++i) {
            k = i + min(A[i], n - 1 - i);
            for(j = l; j <= k; ++j) {
                if(f[j] < 0) {
                    f[j] = f[i] + 1; 
                }
            }            
            l = max(l, i + A[i]);
        }
        return f[n - 1];
    }
};
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(height.size() == 0) {
            return 0;
        }
        int i, j, k, re = 0;
        vector<int> lh(height.size()), rh(height.size());
        lh[0] = -1;
        rh[height.size() - 1] = height.size();
        for(i = 1; i < height.size(); ++i) {
            j = i - 1;
            while(j >= 0 && height[j] >= height[i]){
                j = lh[j];
            }
            lh[i] = j;
        }
        for(i = height.size() - 2; i >= 0; --i) {
            j = i + 1;
            while(j < height.size() && height[j] >= height[i]) {
                j = rh[j];
            }
            rh[i] = j;
        }
        for(i = 0; i < height.size(); ++i) {
            j = i - 1; k = i + 1;
            while(j >= 0 && height[j] >= height[i]) {
                j = lh[j];
            }
            while(k < height.size() && height[k] >= height[i]) {
                k = rh[k];
            }
            re = max(re, (k - j - 1) * height[i]);
        }
        return re;
    }
};
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, size = height.size(), re = 0;
        if(size == 0) return re;
        vector<int> lh(size), rh(size);
        lh[0] = -1; rh[size - 1] = size;
        for(i = 1; i < size; ++i) {
            j = i - 1;
            while(j >= 0 && height[j] >= height[i]) j = lh[j];
            lh[i] = j;
        }
        for(i = size - 2; i >= 0; --i) {
            j = i + 1;
            while(j < size && height[j] >= height[i]) j = rh[j];
            rh[i] = j;
        }
        for(i = 0; i < size; ++i) {
            re = max(re, height[i] * (rh[i] - lh[i] - 1));
        }
        return re;
    }
};
class Solution {
public:
    int lengthOfLastWord(const char *s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j = -1, re = 0, len = strlen(s);
        for(i = 0; i < len; ++i) {
            if(s[i] == ' ') {
                if(j != -1) {
                    re = i - j;
                }
                j = -1;
            } else {
                if(j == -1) {
                    j = i;
                }
            }
        }
        if(j != -1) {
            return i - j;
        } else {
            return re;
        }
    }
};
char ch[10][5] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
class Solution {
public:    
    void lcR(vector<string> &re, string &digits, string &cur, int index) {
        int i, j, k, len;
        if(index == digits.size()) {
            re.push_back(cur);
            return;
        }
        k = digits[index] - '0';
        len = strlen(ch[k]);
        for(i = 0; i < len; ++i) {
            cur.push_back(ch[k][i]);
            lcR(re, digits, cur, index + 1);
            cur.erase(cur.size() - 1);
        }
    }
    vector<string> letterCombinations(string digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
        string cur;
        lcR(re, digits, cur, 0);
        return re;
    }
};
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        char ch[10][5] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int total[10] = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        int i, j, k, n = digits.size();
        vector<string> re;
        vector<int> cur(n, 0);
        string str;
        while(true) {
            str = "";
            for(i = 0; i < n; ++i) {
                str.append(1, ch[digits[i] - '0'][cur[i]]);
            }
            re.push_back(str);
            k = n - 1;
            while(k >= 0) {
                if(cur[k] < total[digits[k] - '0'] - 1) {
                    ++cur[k];
                    break;
                } else {
                    cur[k] = 0; --k;
                }
            }
            if(k < 0) break;
        }
        return re;
    }
};
class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string sm, re;
        int i, j, k, len = UINT_MAX;
        bool flag;
        for(i = 0; i < strs.size(); ++i) {
            if(strs[i].length() < len) {
                sm = strs[i];
                len = strs[i].length();
            }
        }
        for(i = 1; i <= sm.length(); ++i) {
            flag = true;
            for(j = 0; j < strs.size(); ++j) {
                if(sm.compare(0, i, strs[j], 0, i) != 0) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                break;
            } else {
                re = sm.substr(0, i);
            }
        } 
        return re;
    }
};
class Solution {
public:
    string longestPalindrome(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, len = 0, begin;
        string re;
        for(i = 0; i < s.length(); ++i) {
            j = 1;
            while(i - j >= 0 && i + j < s.length() && s[i - j] == s[i + j]) {
                ++j;
            }
            if((j - 1) * 2 + 1 > len) {
                len = (j - 1) * 2 + 1;
                begin = i - j + 1;
            }
            j = 1;
            while(i - j + 1 >= 0 && i + j < s.length() && s[i - j + 1] == s[i + j]) {
                ++j;
            }
            if((j - 1) * 2 > len) {
                len = (j - 1) * 2;
                begin = i - j + 2;
            }
        }
        return s.substr(begin, len);
    }
};
class Solution {
public:
    string preProcess(string &s) {
        int n = s.length();
        if(n == 0) {
            return "^$";
        }
        string ret = "^";
        for(int i = 0; i < n; ++i) {
            ret += "#" + s.substr(i, 1);
        }
        ret += "#$";
        return ret;
    }
    string longestPalindrome(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i;
        string T = preProcess(s);
        int n = T.length();
        vector<int> P(n, 0);
        int C = 0, R = 0;
        for(i = 1; i < n - 1; ++i) {
            int i_mirror = 2 * C - i;
            P[i] = R > i ? min(R - i, P[i_mirror]) : 0;
            while(T[i + P[i] + 1] == T[i - P[i] - 1]) {
                ++P[i];
            }
            if(P[i] > R) {
                R = P[i];
                C = i;
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for(i = 1; i < n - 1; ++i) {
            if(P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        return s.substr((centerIndex - 1 - maxLen) / 2, maxLen);
    }
};
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<char, int> dict;
        map<char, int>::iterator it;
        int i, j, k, begin = 0, re =1;
        if(s.length() == 0) {
            return 0;
        }
        dict[s[0]] = 0;
        for(i = 1; i < s.length(); ++i) {
            it = dict.find(s[i]);
            if( it != dict.end() && it->second >= begin) {
                if(i - begin > re) {
                    re = i - begin;
                }
                begin = max(begin, dict[s[i]]) + 1;
            }            
            dict[s[i]] = i;
        }
        if(i - begin > re) {
            re = i - begin;
        }
        return re;
    }
};
class Solution {
public:
    int longestValidParentheses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, left = 0, cnt = 0, re = 0;
        stack<int> st;
        for(i = 0; i < s.length(); ++i) {
            if(s[i] == '(') {
                st.push(0);
            } else {
                k = 0;
    			j = -1;
                while(!st.empty()) {
                    j = st.top(); st.pop();
                    if(j > 0) {
                        k += j;
                    } else {
						break;
					}
                }
                if(j == 0) {
                    ++k;
					j = -1;
                    while(!st.empty()) {
                        j = st.top(); st.pop();
                        if(j > 0) {
                            k += j;
                        } else {
							break;
						}
                    }
                    if(j == 0) {
                        st.push(j);
                    }
                    st.push(k);
                }
                re = max(re, k);
            }
        }
        return re * 2;
    }
};
class Solution {
public:
    int longestValidParentheses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<pair<int, int> > st;
        pair<int, int> p;
        int i, j, k, curBonus = 0, re = 0;
        for(i = 0; i < s.length(); ++i) {
            if(s[i] == '(') {
                st.push(make_pair(i, curBonus));
                curBonus = 0;
            } else {
                curBonus = 0;
                if(!st.empty()) {                    
                    p = st.top(); st.pop();
                    curBonus = p.second + i - p.first + 1;
                    re = max(re, curBonus);
                } 
            }
        }
        return re;
    }
};
class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, cur, re = 0, hm;
        if(matrix.size() == 0) {
            return 0;
        }
        vector<int> h(matrix[0].size());
        for(i = 0; i < matrix.size(); ++i) {
            for(j = 0; j < matrix[0].size(); ++j) {
                if(matrix[i][j] == '1') {
                    if(i > 0 && matrix[i - 1][j] == '1') {
                        ++h[j];
                    } else {
                        h[j] = 1;
                    }
                    hm = h[j];
                    for(k = j; k >= 0; --k) {
                        hm = min(hm, h[k]);
                        if(hm > 0) {
                            cur = hm * (j - k + 1);
                            re = max(re, cur);
                        } else {
                            break;
                        }
                    }
                } else {
                    h[j] = 0;
                }
            }
        }
        return re;
    }
};
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, size = height.size(), re = 0;
        if(size == 0) return re;
        vector<int> lh(size), rh(size);
        lh[0] = -1; rh[size - 1] = size;
        for(i = 1; i < size; ++i) {
            j = i - 1;
            while(j >= 0 && height[j] >= height[i]) j = lh[j];
            lh[i] = j;
        }
        for(i = size - 2; i >= 0; --i) {
            j = i + 1;
            while(j < size && height[j] >= height[i]) j = rh[j];
            rh[i] = j;
        }
        for(i = 0; i < size; ++i) {
            re = max(re, height[i] * (rh[i] - lh[i] - 1));
        }
        return re;
    }
    int maximalRectangle(vector<vector<char> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(matrix.size() == 0 || matrix[0].size() == 0) return 0;
        int i, j, k, m = matrix.size(), n = matrix[0].size(), re = 0;
        vector<int> h(n, 0);
        for(i = 0; i < m; ++i) {
            for(j = 0; j < n; ++j) {
                h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            }
            re = max(re, largestRectangleArea(h));
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
    int maxDepth(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) {
            return 0;
        }
        queue<TreeNode*> q;
        q.push(root);
        int i, j, k, level = 0, qsize;
        while(!q.empty()) {
            ++level;
    		qsize = q.size();
            for(i = 0; i < qsize; ++i) {
                root = q.front(); q.pop();
                if(root->left) {
                    q.push(root->left);
                }
                if(root->right) {
                    q.push(root->right);
                }
            }
        }
        return level;
    }
};
class Solution {
public:
    int maxSubArray(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, cur = 0, sum = 0, re = 0;
        for(i = 0; i < n; ++i) {
            if(cur + A[i] >= 0) {
                cur += A[i];
                if(cur > sum) {
                    sum = cur;
                }
            } else {
                cur = 0;
            }
        }
        if(sum == 0) {
            re = INT_MIN;
            for(i = 0; i < n; ++i) {
                if(A[i] == 0) {
                    return 0;
                }
                re = max(A[i], re); 
            }
            sum = re;
        }
        return sum;
    }
};
class Solution {
public:
    int findMR(int A[], int B[], int astart, int aend, int bstart, int bend, int kk) {
        int i, j, k, ma, mb;
        if(astart > aend) {
            return B[bstart + kk - 1];
        }
        if(bstart > bend) {
            return A[astart + kk - 1];
        }
        aend = min(aend, astart + kk - 1);
        bend = min(bend, bstart + kk - 1);
        ma = astart + (aend - astart - 1) / 2;
        mb = bstart + (bend - bstart - 1) / 2;
        if(A[ma] <= B[mb]) {
            if(ma == aend) {
        		if(kk < 2 || B[bstart + kk - 2] < A[ma]) {
            	        return A[ma];
        		    } else {
            	        return B[bstart + kk - 2];   
        		    }
            } else {
                return findMR(A, B, ma + 1, aend, bstart, bend, kk - (ma - astart + 1));
            }
        } else {
            if(mb == bend) {
                if(kk < 2 || A[astart + kk - 2] < B[mb]) {
                        return B[mb]; 
                    } else {
                        return A[astart + kk - 2];
                    }
            } else {
                return findMR(A, B, astart, aend, mb + 1, bend, kk - (mb - bstart + 1));
            }
        }
    }
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		int left, right;
        if((m + n) % 2 == 0) {
            left = findMR(A, B, 0, m - 1, 0, n - 1, (m + n) / 2);
            right = findMR(A, B, 0, m - 1, 0, n - 1, (m + n) / 2 + 1);
			return 0.5 * (left + right);
        } else {
            return findMR(A, B, 0, m - 1, 0, n - 1, (m + n + 1) / 2);
        }
    }
};
class Solution {
public:
    int findK(int A[], int m, int B[], int n, int k) {
        int begin = max(0, k - n);
        int end = min(m, k);
        while(begin < end) {
            int l = begin + (end - begin) / 2;
            if(l < m && k > l && A[l] < B[k - l - 1]) {
                begin = l + 1;
            } else if(l > 0 && k - l < n && A[l - 1] > B[k - l]) {
                end = l;
            } else {
                begin = l;
                break;
            }
        }
        if(begin == 0) {
            return B[k - 1];
        } else if(begin == k) {
            return A[k - 1];
        } else {
            return max(A[begin - 1], B[k - begin - 1]);
        }
    }
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if((m + n) & 1) {
            return findK(A, m, B, n, (m + n + 1) / 2);
        } else {
            double left = findK(A, m, B, n, (m + n) / 2);
            double right = findK(A, m, B, n, (m + n) / 2 + 1);
            return (left + right) / 2;
        }
        return 0.0;
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
bool cmp(const Interval a, const Interval b) {
    return a.start < b.start;
}
class Solution {
public:
    vector<Interval> merge(vector<Interval> &intervals) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(intervals.begin(), intervals.end(), cmp);
        vector<Interval> re;
        if(intervals.size() == 0) {
            return re;
        }
        Interval t;
        t.start = intervals[0].start;
        t.end = intervals[0].end;
        int i, j, k;
        for(i = 1; i < intervals.size(); ++i) {
            if(t.end < intervals[i].start) {
                re.push_back(t);
                t.start = intervals[i].start;
                t.end = intervals[i].end;
            } else {
                t.end = max(t.end, intervals[i].end);
            }
        }
        re.push_back(t);
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
struct MyLess{
    bool operator() (const ListNode *x, const ListNode *y) const {
        return x->val > y->val;
    }  
};
class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        priority_queue<ListNode*, vector<ListNode*>, MyLess> q;
        ListNode *head = NULL, *cur, *pre = NULL;
        int i, j, k;
        for(i = 0; i < lists.size(); ++i) {
            if(lists[i] != NULL) {
                q.push(lists[i]);
            }
        }
        while(!q.empty()) {
            cur = q.top(); q.pop();
            if(cur->next != NULL) {
                q.push(cur->next);
            }
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
        }
        return head;
    }
};
class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i = m - 1, j = n - 1, k = m + n - 1;;
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while(i >= 0) {
            A[k--] = A[i--];
        }
        while(j >= 0) {
            A[k--] = B[j--];
        }
        return;
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
        ListNode *head = NULL, *pre = NULL, *cur;
        while(l1 != NULL && l2 != NULL) {
            if(l1->val < l2->val) {
                cur = l1;
                l1 = l1->next;
            } else {
                cur = l2;
                l2 = l2->next;
            }
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
        }
        while(l1 != NULL) {
            cur = l1;
            l1 = l1->next;
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
        }
        while(l2 != NULL) {
            cur = l2;
            l2 = l2->next;
            if(head == NULL) {
                head = cur;
            }
            if(pre != NULL) {
                pre->next = cur;
            }
            pre = cur;
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
        if(root == NULL) {
            return 0;
        }
        int left, right;
        left = minDepth(root->left);
        right = minDepth(root->right);
        if(left == 0 && right == 0) {
            return 1;
        }
        if(left == 0) {
            return 1 + right;
        }
        if(right == 0) {
            return 1 + left;
        }
        return 1 + min(left, right);
    }
};
class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k;
        for(i = 0; i < grid.size(); ++i) {
            for(j = 0; j < grid[0].size(); ++j) {
                k = -1;
                if(i > 0) {
                    k = grid[i - 1][j];
                }
                if(j > 0) {
                    k = k == -1 ? grid[i][j - 1] : min(k, grid[i][j - 1]);
                }
                k = k == -1 ? 0 : k;
                grid[i][j] += k;
            }
        }
        return grid[grid.size() - 1][grid[0].size() - 1];
    }
};
class Solution {
public:
    string minWindow(string S, string T) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<char, int> m;
        map<char, int>::iterator it;
        deque<int> dq;
        int i, j, k, cnt = 0, begin = -1, len, tbegin;
        char ch;
        for(i = 0; i < T.length(); ++i) {
            ++m[T[i]];
            ++cnt;
        }
        for(i = 0; i < S.length(); ++i) {
            it = m.find(S[i]);
            if(it != m.end()) {
                if(begin == -1) {
                    begin = i;
                }
                if(it->second > 0) {
                    --cnt;
                }
                --(it->second);
                dq.push_back(i);
                if(cnt == 0) {
                    len = i - begin + 1;
                    while(true) {
                        if(dq.size() == 0) {
                            return S.substr(begin, len);
                        }
                        tbegin = dq.front(); dq.pop_front();
                        it = m.find(S[tbegin]);
    					++(it->second);
                        if(it->second > 0) {
							if(dq.back() - tbegin + 1 < len) {
								len = dq.back() - tbegin + 1;
								begin = tbegin;
							}
							ch = S[tbegin];
							tbegin = dq.front();
                            break;
                        }
                    }
                    ++i;
                    break;
                }
            }
        }
        for(; i < S.length(); ++i) {
			it = m.find(S[i]);
			if(it != m.end()) {
				--(it->second);
				dq.push_back(i);
			}
            if(S[i] == ch) {
                if(i - tbegin + 1 < len) {
                    len = i - tbegin + 1;
                    begin = tbegin;
                }
               // dq.push_back(i);
               // --m[S[i]];
                 while(true) {
                    if(dq.size() == 0) {
                        return S.substr(begin, len);
                    }
                    tbegin = dq.front(); dq.pop_front();
                    it = m.find(S[tbegin]);
					++(it->second);
                    if(it->second > 0) {
						if(dq.back() - tbegin + 1 < len) {
							len = dq.back() - tbegin + 1;
							begin = tbegin;
						}
						ch = S[tbegin];
						tbegin = dq.front();
                        break;
                    }
                }
                tbegin = dq.front();    
            }
        }
        if(begin == -1 || cnt != 0) {
            return "";
        }
        return S.substr(begin, len);
    }
};
class Solution {
public:
    string 	multiply(string num1, string num2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re(num1.length() + num2.length() + 1, 0);
        reverse(num1.begin(), num1.end());
        reverse(num2.begin(), num2.end());
        int i, j, k, c;
        for(i = 0; i < num1.length(); ++i) {
            k = num1[i] - '0';
            for(j = 0; j < num2.length(); ++j) {
                re[i + j] += k * (num2[j] - '0');
                re[i + j + 1] += re[i + j] / 10;
                re[i + j] %= 10;
            }
        }
        reverse(re.begin(), re.end());
        string str;
        bool first = true;
        for(i = 0; i < re.size(); ++i) {
            if(first && re[i] == 0) {
                continue;
            } else {
                first = false;
            }
            str.push_back('0' + re[i]);
        }
        if(str == "") {
            str = "0";
        }
        return str;
    }
};
class Solution {
public:
    vector<vector<string> > re;
    vector<int> cur;
    vector<bool> f;
    int n;
    void updateRe() {
        vector<string> v;
        string str;
        char ch;
        for(int i = 0; i < n; ++i) {
            str = "";
            for(int j = 0; j < n; ++j) {
                ch = j == cur[i] ? 'Q' : '.';
                str.push_back(ch);
            }
            v.push_back(str);
        }
        re.push_back(v);
        return;
    }
    bool check(int index, int k) {
        int i, j;
        for(i = 0; i < index; ++i) {
            if(abs(index - i) == abs(k - cur[i])) {
                return false;
            }
        }
        return true;
    }
    void qR(int index) {
        int i, j, k;
        if(index == n) {
            updateRe();
            return;
        }
        for(i = 0; i < n; ++i) {
            if(!f[i] && check(index, i)) {
    			cur.push_back(i);
                f[i] = true;
                qR(index + 1);
				cur.pop_back();
                f[i] = false;
            }
        }
    }
    struct snap{
        int index, stage, i;  
    };
    vector<vector<string> > solveNQueens(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		re.clear();
        f.assign(n, false);
		this->n = n;
     //   qR(0);
        stack<snap> st;
        snap curSnap, newSnap;
        curSnap.index = 0;
        curSnap.stage = 0;
        curSnap.i = 0;
        st.push(curSnap);
        while(!st.empty()) {
            curSnap = st.top(); st.pop();
            switch(curSnap.stage) {
            case 0:
                if(curSnap.index == n) {
                    updateRe();
                    continue;
                }
                for(int i = curSnap.i; i < n; ++i) {   
                    if(!f[i] && check(curSnap.index, i)) {
                        cur.push_back(i);
                        f[i] = true;
                        curSnap.i = i;
                        curSnap.stage = 1;
                        st.push(curSnap);
                        newSnap.stage = 0;
                        newSnap.index = curSnap.index + 1;
                        newSnap.i = 0;
                        st.push(newSnap);
                        break;
                    }
                }
                break;
            case 1:   
                cur.pop_back();
                f[curSnap.i] = false;
                ++curSnap.i;
                curSnap.stage = 0;
                st.push(curSnap);
                break;
            }
        }
        return re;
    }
};
class Solution {
public:
    vector<vector<string> > re;
    vector<int> cur;
    vector<bool> f;
    int n, cnt;
    void updateRe() {
        vector<string> v;
        string str;
        char ch;
        for(int i = 0; i < n; ++i) {
            str = "";
            for(int j = 0; j < n; ++j) {
                ch = j == cur[i] ? 'Q' : '.';
                str.push_back(ch);
            }
            v.push_back(str);
        }
        re.push_back(v);
        return;
    }
    bool check(int index, int k) {
        int i, j;
        for(i = 0; i < index; ++i) {
            if(abs(index - i) == abs(k - cur[i])) {
                return false;
            }
        }
        return true;
    }
    void qR(int index) {
        int i, j, k;
        if(index == n) {
            ++cnt;
            return;
        }
        for(i = 0; i < n; ++i) {
            if(!f[i] && check(index, i)) {
        		cur.push_back(i);
                f[i] = true;
                qR(index + 1);
				cur.pop_back();
                f[i] = false;
            }
        }
    }
    struct snap{
        int index, stage, i;  
    };
    int totalNQueens(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        this->cnt = 0;
        f.assign(n, false);
    	this->n = n;
        qR(0);
        return cnt;
    }
};
class Solution {
public:
    void nextPermutation(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k;
        if(num.size() < 2) {
            return;
        }
        for(i = num.size() - 2; i >= 0; --i) {
            if(num[i] < num[i + 1]) {
                k = i + 1;
                for(j = i + 2; j < num.size(); ++j) {
                    if(num[j] > num[i] && num[j] < num[k]) {
                        k = j;
                    }
                }
                break;
            }
        }
        if(i >= 0) {
            swap(num[i], num[k]);
        }
        sort(num.begin() + i + 1, num.end());
    }
};
class Solution {
public:
    bool isPalindrome(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(x < 0) {
            return false;
        }
        int i, j, k, d = 1, cnt = 1;
        k = x / 10;
        while(k > 0) {
            d *= 10;
            k /= 10;
            ++cnt;
        }
        for(i = 0; i < cnt / 2; ++i) {
            j = x % 10; 
            k = x / d;
            if(j != k) {
                return false;
            }
            x = (x % d) / 10;
            d /= 100;
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
        if(head == NULL) {
            return head;
        }
        ListNode *leftHead = NULL, *leftPre = NULL;
        ListNode *rightHead = NULL, *rightPre = NULL, *cur = head;
        while(cur != NULL) {
            if(cur->val < x) {
                if(leftHead == NULL) {
                    leftHead = cur;
                } 
                if(leftPre != NULL) {
                    leftPre->next = cur;
                }
                leftPre = cur;
            } else {
                if(rightHead == NULL) {
                    rightHead = cur;
                }
                if(rightPre != NULL) {
                    rightPre->next = cur;
                }
                rightPre = cur;
            }
            cur = cur->next;
        }
        if(leftPre != NULL) {
            leftPre->next = rightHead;
        }
        if(rightPre != NULL) {
            rightPre->next = NULL;
        }
        if(leftHead != NULL) {
            return leftHead;
        } else {
            return rightHead;
        }
    }
};
class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> v;
        if(numRows == 0) {
            return re;
        }
        v.push_back(1);
        re.push_back(v);
        if(numRows == 1) {
            return re;
        }
        int i, j, k;
        for(i = 1; i < numRows; ++i) {            
            for(j = v.size() - 1; j > 0; --j) {
                v[j] += v[j - 1];
            }
            v.push_back(1);
            re.push_back(v);
        }
        return re;
    }
};
class Solution {
public:
    vector<int> getRow(int rowIndex) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> v;
        v.push_back(1);
        if(rowIndex == 0) {
            return v;
        }
        int i, j, k;
        for(i = 1; i <= rowIndex; ++i) {            
            for(j = v.size() - 1; j > 0; --j) {
                v[j] += v[j - 1];
            }
            v.push_back(1);
        }
        return v;
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
        if(root == NULL) {
            return false;
        }
        if(root->left == NULL && root->right == NULL && root->val == sum) {
            return true;
        }
        return hasPathSum(root->left,sum - root->val) ||
            hasPathSum(root->right, sum - root->val);
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
    void psR(vector<vector<int> > &re, vector<int> &cur, TreeNode *root, int sum) {
        if(root == NULL) {
            return;
        }
        cur.push_back(root->val);
        if(root->left == NULL && root->right == NULL && root->val == sum) {
            re.push_back(cur);
        } else {
            psR(re, cur, root->left, sum - root->val);
            psR(re, cur, root->right, sum - root->val);
        }
        cur.pop_back();
    }
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        psR(re, cur, root, sum);
        return re;
    }
};
class Solution {
public:
    void genR(vector<int> &re, vector<bool> &f, int n, int index, int &cnt, int k) {
        int i, j;
        if(index == n) {
            ++cnt;
            return;
        }
        for(i = 1; i <= n; ++i) {
            if(!f[i]) {
                f[i] = true;
                re.push_back(i);
                genR(re, f, n, index + 1, cnt, k);
                f[i] = false;
                re.pop_back();
                if(cnt == k) {
                    return;
                }
            }
        }
    }
    string getPermutation(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        vector<bool> f(n + 1, false);
        int i,j, cnt = 0, lk = 1;
        for(i = 1; i < n; ++i) {
            lk *= i;
        }
        j = (k - 1) / lk;
        k = (k - 1) % lk + 1;
        re.push_back(j + 1);
        f[j + 1] = true;
        genR(re, f, n, 1, cnt, k);
        string str;
        for(i = 0; i < n; ++i) {
            str.push_back(re[i] + '0');
        }
        return str;
    }
};
class Solution {
public:
    void pR(vector<vector<int> > &re, vector<int> &cur, vector<int> &num,
    vector<bool> &f, int index) {
        int i, j, k;
        if(index == num.size()) {
            re.push_back(cur);
            return;
        }
        for(i = 0; i < num.size(); ++i) {
            if(!f[i]) {
                f[i] = true;
                cur.push_back(num[i]);
                pR(re, cur, num, f, index + 1);
                f[i] = false;
                cur.pop_back();
            }
        }
    }
    vector<vector<int> > permute(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        vector<bool> f(num.size(), false);
        pR(re, cur, num, f, 0);
        return re;
    }
};
class Solution {
public:
    void pR(vector<vector<int> > &re, vector<int> &num, int end) {
        if(end < 0) {
            re.push_back(num);
            return;
        }
        for(int i = end; i >= 0; --i) {
            swap(num[i], num[end]);
            pR(re, num, end - 1);
            swap(num[i], num[end]);
        }
    }
    vector<vector<int> > permute(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        pR(re, num, num.size() - 1);
        return re;
    }
};
class Solution {
public:
    void puR(vector<vector<int> > &re, vector<int> &num, int end,
    set<vector<int> > &dict) {
        int i, j, k;
        if(end < 0) {
            if(dict.find(num) == dict.end()) {
                re.push_back(num);
                dict.insert(num);
            }
            return;
        }
        puR(re, num, end - 1, dict);
        for(i = end - 1; i >= 0; --i) {
            if(num[i] != num[end]) {
                swap(num[i], num[end]);
                puR(re, num, end - 1, dict);
                swap(num[i], num[end]);
            }
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        set<vector<int> > dict;
        puR(re, num, num.size() - 1, dict);
        return re;
    }
};
class Solution {
public:
    void puR(vector<vector<int> > &re, vector<int> &cur, vector<int> &num, 
    vector<bool> &f, int index) {
        int i, j, k;
        if(index == num.size()) {
            re.push_back(cur);
            return;
        }
        for(i = 0; i < num.size(); ++i) {
            if(i > 0 && num[i] == num[i - 1] && f[i - 1]) {
                continue;
            } else if(!f[i]){
                f[i] = true;
                cur.push_back(num[i]);
                puR(re, cur,num, f, index + 1);
                f[i] = false;
                cur.pop_back();
            }
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(num.begin(), num.end());
        vector<vector<int> > re;
        vector<int> cur;
        vector<bool> f(num.size(), false);
        puR(re, cur, num, f, 0);
        return re;
    }
};
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        int i, j = 0, k, c = 0;
        digits[digits.size() - 1]++;
        for(i = digits.size() - 1; i >= 0; --i) {
            j = digits[i] + c;
            re.push_back(j % 10);
            c = j / 10;
        }
        if(c) {
            re.push_back(c);
        }
        reverse(re.begin(), re.end());
        return re;
    }
};
/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) {
            return;
        }
        if(root->left != NULL) {
            root->left->next = root->right;
            if(root->next != NULL) {
                root->right->next = root->next->left;
            }
            connect(root->left);
            connect(root->right);
        }
    }
};
/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeLinkNode *p;
        while(root != NULL) {
            p = root;
            while(p != NULL && p->left != NULL) {
                p->left->next = p->right;
                if(p->next != NULL) {
                    p->right->next = p->next->left;
                }
                p = p->next;
            }
            root = root->left;
        }
        return;
    }
};
/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeLinkNode *p, *pnext, *next, *rnext;
        while(root != NULL) {
            p = root; rnext = NULL;
            while(p != NULL) {
                pnext = p->next;
                while(pnext != NULL && pnext->left == NULL && pnext->right == NULL) {
                    pnext = pnext->next;
                }
                if(pnext != NULL) {
                    if(pnext->left != NULL) {
                        next = pnext->left;
                    } else if(pnext->right != NULL) {
                        next = pnext->right;
                    }
                } else {
                    next = NULL;
                }
                if(p->left != NULL) {
                    if(rnext == NULL) {
                        rnext = p->left;
                    }
                    if(p->right != NULL) {
                        p->left->next = p->right;
                    } else {
                        p->left->next = next;
                    }
                }
                if(p->right != NULL) {
                    if(rnext == NULL) {
                        rnext = p->right;
                    }
                    p->right->next = next;
                }
                p = pnext;
            }
            root = rnext;
        }
    }
};
class Solution {
public:
    double pow(double x, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n == 0) {
            return 1;
        }
        bool neg = n < 0;
        int i, j, k;
        n = abs(n);
        vector<int> f;
        while(n > 0) {
            f.push_back(n & 1);
            n = n >> 1;
        }
        double re = 1.0;
        for(i = 0; i < f.size(); ++i) {
            if(f[i]) {
                re *= x;
            }
            x *= x;
        }
        return neg ? 1.0 / re : re;
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
    void inorder(TreeNode *root, TreeNode *&pre, bool &find) {
        if(root == NULL) {
            return;
        }
        inorder(root->left, pre, find);
    	if(find) {
			return;
		}
        if(pre != NULL && pre->val > root->val) {
			find = true;
            return;
        }
        pre = root;
        inorder(root->right, pre, find);
    }
    void inorder2(TreeNode *root, TreeNode *&p, bool &find) {
        if(root == NULL) {
            return;
        }
        inorder2(root->right, p, find);
		if(find) {
			return;
		}
        if(p != NULL && p->val < root->val) {
            find = true;
			return;
        }
        p = root;
        inorder2(root->left, p, find);
    }
    void recoverTree(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL, *p = NULL;
		bool find = false;
        inorder(root, pre, find);
		find =false;
        inorder2(root, p, find);
        int tmp = pre->val;
        pre->val = p->val;
        p->val = tmp;
        return;        
    }
};
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(*p == NULL && *s == NULL) {
            return true;
        } else if(*p == NULL && *s != NULL) {
            return false;
        } else if(*s == NULL && *p != NULL) {
            return *(p + 1) == '*' && isMatch(s, p + 2);
        }
        if(*(p + 1) == '*') {
            if(*p == '.') {
                return isMatch(s + 1, p) || isMatch(s, p + 2);
            } else {
                return (*s == *p && isMatch(s + 1, p))
                || isMatch(s, p + 2);
            }
        } else {
            return (*p == '.' || *p == *s) &&
            isMatch(s + 1, p + 1);
        }
    }
};
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(*p == NULL) return *s == NULL;
        if(*(p + 1) != '*') {
            return ((*p == '.' || *p == *s) && *s != NULL) && isMatch(s + 1, p + 1);
        } else {
            while((*p == '.' || *p == *s) && *s != NULL) {
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
        int i, j, k = -1;
        for(i = 0; i < n; ++i) {
            if(i == 0 || A[i] != A[k]) {
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
        int i, j = 1, k = 0, cnt = 1;
        for(i = 1; i < n; ++i){
            if(A[i] == A[k]) {
                if(j < 2) {
                    A[++k] = A[i];
                    ++j;                    
                    ++cnt;
                }
            } else {
                A[++k] = A[i];
                j = 1;
                ++cnt;
            }
        }
        return cnt;
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
        if(head == NULL) {
            return head;
        }
        ListNode *pre = head, *cur = head->next;
        while(cur) {
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
        ListNode *nhead = NULL, *pre = NULL, *cur = head, *next;
        int cnt = 0;
        while(cur) {
            next = cur->next;
            while(cur->next && cur->next->val == cur->val) {
                cur = cur->next;
            }   
            if(next == cur->next) {
                if(nhead == NULL) {
                    nhead = cur;
                }
                if(pre != NULL) {
                    pre->next = cur;
                }
                pre = cur;
            }
            cur = cur->next;
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
        int i = 0, j, k = n - 1;
        while(i <= k) {
            while(i <= k && A[i] != elem) {
                ++i;
            }
            while(i <= k && A[k] == elem) {
                --k;
            }
            if(i <= k) {
                swap(A[i], A[k]);
                --k;
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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *fast, *slow, *pre = NULL, *nhead = head;;
        fast = head;
        int i, j, k, cnt = 0;
        while(fast) {
            fast = fast->next;
            ++cnt;
            if(cnt == n) {
                break;
            }
        }
        if(cnt == n) {
            slow = head;
            while(fast) {
                fast = fast->next;
                pre = slow;
                slow = slow->next;
            }
            if(pre == NULL) {
                nhead = nhead->next;
            } else {
                pre->next = slow->next;
            }
        }
        return nhead;
    }
};
class Solution {
public:
    int atoi(string s) {
        int re = 0, i;
        if(s.length() > 1 && s[0] == '0') {
            return 400;
        }
        for(i = 0; i < s.length(); ++i) {
            re = re * 10 + s[i] - '0';
        }
        return re;
    }
    vector<string> restoreIpAddresses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> re;
        string cur;
        int i, j, k, t, a, b, c, d;
        if(s.length() > 12) {
            return re;
        }
        for(i = 1; i <= 3; ++i) {
            for(j = 1; j <= 3; ++j) {
                for(k = 1; k <= 3; ++k) {
                    if(i + j + k >= s.length()) {
                        continue;
                    }
                    a = atoi(s.substr(0, i));
                    b = atoi(s.substr(i, j));
                    c = atoi(s.substr(i + j, k));
                    d = atoi(s.substr(i + j + k));
                    if(a < 256 && b < 256 && c < 256 && d < 256) {
                        cur = s.substr(0, i) + "."
                        + s.substr(i, j) + "."
                        + s.substr(i + j, k) + "."
                        + s.substr(i + j + k);
                        re.push_back(cur);
                    }
                }
            }
        }
        return re;
    }
};
class Solution {
public:
    int reverse(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int sign = x < 0 ? -1 : 1;
        long long lx = x, ll = 0;
        int i, j, k;
        lx = (long long)fabs((double)lx);
        while(lx > 0) {
            ll = ll * 10 + lx % 10;
            lx /= 10;
        }
        return sign * ll;
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
        ListNode *nhead = head, *rhead, *frontEnd, *behindHead, *pre, *cur, *tmp;
        int i, j, k;
        cur = head; pre = NULL;
        for(i = 2; i <= m; ++i) {
            pre = cur;
            cur = cur->next;
        }
        rhead = cur;
        frontEnd = pre;
        for(i = m; i <= n; ++i) {
            tmp = cur->next;
            cur->next = pre;
            pre = cur;
            cur = tmp;
        }
        rhead->next = cur;
        if(frontEnd != NULL) {
            frontEnd->next = pre;
        } else {
            nhead = pre;
        }
        return nhead;
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
        ListNode *nhead = head, *frontEnd = NULL, *pre, *cur, *tmp, *probe, *rhead;
        int i, j, cnt, t;
        cur = head;
        while(true) {
            cnt = 0;
            probe = cur;
            while(probe) {
                probe = probe->next;
                ++cnt;
                if(cnt == k) {
                    break;
                }
            }
            if(cnt == k) {
                rhead = cur;
                for(i = 0; i <k; ++i) {
                    tmp = cur->next;
                    cur->next = pre;
                    pre = cur;
                    cur = tmp;
                }
                rhead->next = cur;
                if(frontEnd != NULL) {
                    frontEnd->next = pre;
                } else {
                    nhead = pre;
                }
                frontEnd = rhead;
            } else {
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
        map<char, int> m;
        m['I'] = 1;
        m['V'] = 5;
        m['X'] = 10;
        m['L'] = 50;
        m['C'] = 100;
        m['D'] = 500;        
        m['M'] = 1000;
        int i, j, k, re = 0;
        for(i = 0; i < s.length(); ++i) {
            re += m[s[i]];
            j = i - 1;
            while(j >= 0 && m[s[j]] < m[s[i]]) {
                re -= 2 * m[s[j]];
                --j;
            }
        }
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
            for(j = i; j < n - i - 1; ++j) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
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
        if(head == NULL || k == 0) {
            return head;
        }
        ListNode *p = head, *fast, *prevEnd, *nhead;
        int i, j, cnt = 0;
        while(p) {
            ++cnt;
            p = p->next;
        }
        k %= cnt;
        if(k == 0) {
            return head;
        }
        fast = head;
        for(i = 0; i < k; ++i) {
            fast = fast->next;
        }
        prevEnd = head;
        while(fast->next) {
            fast = fast->next;
            prevEnd = prevEnd->next;
        }
        nhead = prevEnd->next;
        prevEnd->next = NULL;
        fast->next = head;
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
        if(p == NULL && q == NULL) {
            return true;
        } else if(p == NULL || q == NULL) {
            return false;
        }
        return p->val == q->val &&
        isSameTree(p->left, q->left) &&
        isSameTree(p->right, q->right);
    }
};
class Solution {
public:
    bool isScramble(string s1, string s2) {
        if(s1.compare(s2) == 0) {
            return true;
        }
        string ss1, ss2;
        ss1 = s1; ss2 = s2;
        sort(ss1.begin(), ss1.end());
        sort(ss2.begin(), ss2.end());
        if(ss1.compare(ss2) != 0) {
            return false;
        }
        int i, j, k, len = s1.length();
        for(i = 1; i < s1.length(); ++i) {
            if((isScramble(s1.substr(0, i), s2.substr(0, i)) &&
            isScramble(s1.substr(i), s2.substr(i)))
            ||
            (isScramble(s1.substr(i), s2.substr(0, len - i)) &&
            isScramble(s1.substr(0, i), s2.substr(len - i)))) {
                return true;
            }
        }
        return false;
    }
};
class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, m = matrix.size(), n = matrix[0].size();
        i = 0; j = n - 1;
        while(i < m && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                --j;
            } else {
                ++i;
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
        int i, j, k, mid, low = 0, high = n - 1, begin, end;
        bool find = false;
        vector<int> re;
        for(i = 0; i < 2; ++i) {
            low = 0; high = n - 1;
            while(low <= high) {
                mid = (low + high) / 2;
                if(A[mid] == target) {
                    find = true;
                    if(i == 0) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if(A[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if(high >= 0 && high < n && A[high] == target) {
                re.push_back(high);
            } else {
    			high = i ? high - 1 : high + 1;
				re.push_back(high);
			}
        }
        if(!find) {
            re.assign(2, -1);
        }
        return re;
    }
};
class Solution {
public:
    int search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, mid, low = 0, high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[low] == target) {
                return low;
            }
            if(A[high] == target) {
                return high;
            }
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] < target) {
                if(A[high] > target || A[high] < A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if(A[low] < target || A[low] > A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
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
        int i, j, k, mid, low = 0, high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[low] == target) {
                return true;
            }
            if(A[high] == target) {
                return true;
            }
            if(A[mid] == target) {
                return true;
            } else if(A[high] == A[low] && A[high] == A[mid]) {
                for(i = low + 1; i < high; ++i) {
                    if(A[i] == target) {
                        return true;
                    }
                }
                return false;
            } else if(A[mid] < target) {
                if(A[high] > target || A[high] < A[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if(A[low] < target || A[low] > A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
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
        int i, j, k, mid, low = 0, high = n - 1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
        int i, j, k;
        bool row = false, column = false;;
        if(matrix.size() == 0 || matrix[0].size() == 0) return;
        for(i = 0; i < matrix.size(); ++i) {
            for(j = 0; j < matrix[0].size(); ++j) {
                if(matrix[i][j] == 0) {
                    if(i == 0) row = true;
                    if(j == 0) column = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(i = 1; i < matrix.size(); ++i) {
            if(matrix[i][0] == 0) {
                for(j = 0; j < matrix[0].size(); ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(j = 1; j < matrix[0].size(); ++j) {
            if(matrix[0][j] == 0) {
                for(i = 0; i < matrix.size(); ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(column) {
            for(i = 1; i < matrix.size(); ++i) {
                matrix[i][0] = 0;
            }
        }
        if(row) {
            for(j = 1; j < matrix[0].size(); ++j) {
                matrix[0][j] = 0;
            }
        }
        return;
    }
};
class Solution {
public:
    string simplifyPath(string path) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<string> st;
        string re, cur;
        int i, j, k = -1;
        for(i = 0; i <= path.length(); ++i) {
            if(i == path.length() || path[i] == '/') {
                if(k == -1 || k == i) {
                } else {
                    cur = path.substr(k, i - k);
                    if(cur.compare(".") == 0) {
                    } else if(cur.compare("..") == 0) {
                        if(!st.empty()) {
                            st.pop();
                        }
                    } else {
                        st.push(cur);
                    }
                }
                k = i + 1;
            }
        }
        while(!st.empty()) {
            re = "/" + st.top() + re; 
            st.pop();
        }
        if(re.length() == 0) {
            re = "/";
        }
        return re;
    }
};
class Solution {
public:
    void sortColors(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, i0, i2, left, right;
        i0 = 0; i2 = n - 1; left = 0; right = n - 1;
        while(left <=right) {
            while(left <= right && A[left] != 2) {
                if(A[left] == 0) {
                    swap(A[i0++], A[left]);
                }
                ++left;
            }
    		if(left > right) {
				break;
			}
            while(left <= right && A[right] != 0) {
                if(A[right] == 2) {
                    swap(A[i2--], A[right]);
                }
                --right;
            }
			if(left > right) {
				break;
			}
			if(A[left] == 2) {
                swap(A[left], A[i2--]);
			}
            if(A[right] == 0) {
                swap(A[right], A[i0++]);
            }
			left = max(i0, left);
			right = min(i2, right);
        }
        return;
    }
};
class Solution {
public:
    void sortColors(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int left = 0, pleft = 0, right = n - 1;
        while(pleft <= right) {
            while(pleft <= right && A[pleft] != 2) {
                if(A[pleft] == 0) {
                    swap(A[pleft], A[left++]);
                }
                ++pleft;
            }
            if(pleft <= right) {
                swap(A[pleft], A[right--]);
            } else {
                break;
            }
        }
    }
};
class Solution {
public:
    void sortColors(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i = 0, l = 0, r = n - 1;
        while(i <= r) {
            if(A[i] == 0) {
                swap(A[l++], A[i++]);
            } else if(A[i] == 2) {
                swap(A[r--], A[i]);
            } else {
                ++i;
            }
        }
    }
};
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> re;
        if(matrix.size() == 0 || matrix[0].size() == 0) {
            return re;
        }
        int istart = 0, iend = matrix.size() - 1, jstart = 0, jend = matrix[0].size() - 1;
        int i, j, k;
        while(istart <= iend && jstart <= jend) {
            for(i = jstart; i <= jend; ++i) {
                re.push_back(matrix[istart][i]);
            }
            for(i = istart + 1; i <= iend; ++i) {
                re.push_back(matrix[i][jend]);
            }
            if(iend != istart) {
                for(i = jend - 1; i >= jstart; --i) {
                    re.push_back(matrix[iend][i]);
                }
            }
            if(jend != jstart) {
                for(i = iend - 1; i > istart; --i) {
                    re.push_back(matrix[i][jstart]);
                }
            }
            ++istart; --iend; ++jstart; --jend;
        }
        return re;
    }
};
class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > matrix;
        int istart = 0, iend = n - 1, jstart = 0, jend = n - 1;
        int i, j, k = 1;
        for(i = 0; i < n; ++i) {
            matrix.push_back(vector<int>(n));
        }
        while(istart <= iend && jstart <= jend) {
            for(i = jstart; i <= jend; ++i) {
                matrix[istart][i] = k++;
            }
            for(i = istart + 1; i <= iend; ++i) {
                matrix[i][jend] = k++;
            }
            if(iend != istart) {
                for(i = jend - 1; i >= jstart; --i) {
                    matrix[iend][i] = k++;
                }
            }
            if(jend != jstart) {
                for(i = iend - 1; i > istart; --i) {
                    matrix[i][jstart] = k++;
                }
            }
            ++istart; --iend; ++jstart; --jend;
        }
        return matrix;
    }
};
class Solution {
public:
    int sqrt(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(x == 0 || x == 1) {
            return x;
        }
        long long target = x, low = 0, high = x - 1, mid;
        int i, j, k;
        while(low <= high) {
            mid = (low + high) / 2;
            if(mid * mid == x) {
                return mid;
            } else if(mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
};
class Solution {
public:
    int atoi(const char *str) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, sign = 1;
        long long re = 0;
        while(*str == ' ') {
            ++str;
        }
        if(*str == '-') {
            sign = -1;
            ++str;
        }
        if(*str == '+') {
            ++str;
        }
        while(*str >= '0' && *str <= '9') {
            re = re * 10 + *str - '0';
            ++str;
        }        
        if(sign == -1 && -re < INT_MIN) {
            return INT_MIN;
        }
        if(sign == 1 && re > INT_MAX) {
            return INT_MAX;
        }
        return re * sign;
    }
};
class Solution {
public:
    void subR(vector<vector<int> > &re, vector<int> &S, vector<int> &cur, int index) {
        int i, j, k;
        if(index == S.size()) {
            return;
        }
        for(i = index; i < S.size(); ++i) {
            cur.push_back(S[i]);
            re.push_back(cur);
            subR(re, S, cur, i + 1);
            cur.pop_back();
        }
    }
    vector<vector<int> > subsets(vector<int> &S) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(S.begin(), S.end());
        vector<vector<int> > re;
        vector<int> cur;
        re.push_back(cur);
        subR(re, S, cur, 0);
        return re;
    }
};
class Solution {
public:
    void subR2(vector<vector<int> > &re, vector<int> &S, vector<int> &cur, int index) {
        int i, j, k;
        if(index == S.size()) {
            return;
        }
        for(i = index; i < S.size(); ++i) {
            if(i > index && S[i] == S[i - 1]) {
                continue;
            } else {
                cur.push_back(S[i]);
                re.push_back(cur);
                subR2(re, S, cur, i + 1);
                cur.pop_back();
            }
        }
    }
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > re;
        vector<int> cur;
        re.push_back(cur);
        sort(S.begin(), S.end());
        subR2(re, S, cur, 0);
        return re;
    }
};
class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        unordered_map<string, int> m, m2;
        unordered_map<string, int>::iterator it;
        vector<int> re;
        int i, j, k, len = L[0].size(), n = L.size();
        for(i = 0; i < L.size(); ++i) {
            ++m[L[i]];
        }
        for(i = 0; i <= (int)S.length() - n * len; ++i) {
		//UNSIGNED INT MAY CAUSE ERROR WHEN DOING SUBSTRATION OPERATION!!!
            it = m.find(S.substr(i, len));
            if(it != m.end()) {
                m2 = m;
                m2[it->first]--;
                for(j = 1; j < n; ++j) {
                    it = m2.find(S.substr(i + len * j, len));
                    if(it == m2.end() || it->second == 0) {
                        break;
                    } else {
                        --(it->second);
                    }
                }
                if(j == n) {
                    re.push_back(i);
                }
            }
        }
        return re;
    }
};
class Solution {
public:
    deque<int> getAvailableValues(vector<vector<char> > &board, pair<int, int> cur) {
        vector<bool> f(10, true);
        int i, j, x, y;
        for(i = 0; i < 9; ++i) {
            if(board[cur.first][i] != '.') {
                f[board[cur.first][i] - '0'] = false;
            }
            if(board[i][cur.second] != '.') {
                f[board[i][cur.second] - '0'] = false;
            }
        }
        x = cur.first / 3 * 3; y = cur.second / 3 * 3;
        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 3; ++j) {
                if(board[x + i][y + j] != '.') {
                    f[board[x + i][y + j] - '0'] = false;
                }
            }
        }
        deque<int> re;
        for(i = 1; i <= 9; ++i) {
            if(f[i]) {
                re.push_back(i);
            }
        }
        return re;
    }
    void solveSudoku(vector<vector<char> > &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<pair<int, int>, deque<int> > m;
        map<pair<int, int>, deque<int> >::iterator it;
        vector<pair<int, int> > emptyCells;
        int i, j, k;
        for(i = 0; i < 9; ++i) {
            for(j = 0; j < 9; ++j) {
                if(board[i][j] == '.') {
                    emptyCells.push_back(make_pair(i,j));
                }
            }
        }
        k = 0;
        pair<int, int> cur;
        while(k < emptyCells.size()) {
            cur = emptyCells[k]; 
            it = m.find(cur);
    		if(k == 0) {
				int safd = 1;
			}
            if(it == m.end()) {
                m[cur] = getAvailableValues(board, cur);
                it = m.find(cur);
            }
            if(it->second.size() == 0) {
                m.erase(it);
                --k;
                board[cur.first][cur.second] = '.';
            } else {
                board[cur.first][cur.second] = it->second.front() + '0';
                it->second.pop_front();
                ++k;
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
        ListNode *nhead = head, *frontEnd = NULL, *pre = NULL, *cur, *tmp;
        cur = head;
        while(cur && cur->next) {
            tmp = cur->next->next;
            cur->next->next = cur;
            pre = cur->next;
            cur->next = tmp;
            if(frontEnd != NULL) {
                frontEnd->next = pre;
            } else {
                nhead = pre;
            }
            frontEnd = cur;
            cur = cur->next;
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
    bool isSymmetric(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(root == NULL) {
            return true;
        }
        queue<TreeNode*> q;
        TreeNode *t1, *t2;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()) {
            t1 = q.front(); q.pop();
            t2 = q.front(); q.pop();
            if(t1 == NULL && t2 == NULL) {
                continue;
            } else if(t1 == NULL || t2 == NULL) {
                return false;
            }
            if(t1->val != t2->val) {
                return false;
            }
            q.push(t1->left);
            q.push(t2->right);
            q.push(t1->right);
            q.push(t2->left);
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
        string line;
        vector<string> space;
        int i, j, k, begin = 0, curLen = words[0].length(), cnt = 1, t;
        for(i = 1; i < words.size(); ++i) {
            if(curLen + words[i].length() + cnt > L) {
                line = words[begin];
                if(cnt == 1) {
                    line.append(L - curLen, ' ');
                } else {
                    space.assign(cnt - 1, " ");
                    k = L - (curLen + cnt - 1);
                    t = 0;
                    for(j = 0; j < k; ++j) {
                        space[(t++) % (cnt - 1)].push_back(' ');
                    }
                    for(j = 1; j < cnt; ++j) {
                        line += space[j - 1] + words[begin + j];
                    }
                }                
                re.push_back(line);
                begin = i; cnt = 1; curLen = words[i].length();
            } else {
                ++cnt;
                curLen += words[i].length();
            }
        }
        line = words[begin];
        for(i = 1; i < cnt; ++i) {
            line += ' ' + words[begin + i]; 
        }
        line.append(L - line.length(), ' ');
        re.push_back(line);
        return re;
    }
};
class Solution {
public:
    int trap(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j, k, left = 0, right = n - 1, re = 0, h;
        while(left < right) {
            h = min(A[left], A[right]);
            while(left < right && A[left] <= h) {
                re += h - A[left++];
            }
            while(left < right && A[right] <= h) {
                re += h - A[right--];
            }
        }
        return re;
    }
};
class Solution {
public:
    int trap(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int l = 0, r = n - 1, h, re = 0;
        while(l < r) {
            h = min(A[l], A[r]);
            while(l < r && A[l] <= h) re += h - A[l++];
            while(l < r && A[r] <= h) re += h - A[r--];
        }
        return re;
    }
};
class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> f(triangle.size(), 0);
        int i, j, k, re = INT_MAX;
        for(i = 0; i < triangle.size(); ++i) {
            if(i != 0) {
                f[i] = triangle[i][i] + f[i - 1];
            }
            for(j = i - 1; j > 0; --j) {
                f[j] = triangle[i][j] + min(f[j - 1], f[j]);
            }            
            f[0] += triangle[i][0];
        }
        for(j = 0; j < triangle.size(); ++j) {
            re = min(re, f[j]);
        }
        return re;
    }
};
class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        unordered_map<int, int> m;
        unordered_map<int, int>::iterator it;
        int i, j, k;
        vector<int> re;
        for(i = 0; i < numbers.size(); ++i) {
            k = numbers[i];
            it = m.find(target - k);
            if(it != m.end()) {
                re.push_back(it->second);
                re.push_back(i + 1);
                return re;
            } else {
                m[k] = i + 1;
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
        if(n == 1) {
            return 1;
        }
        int i, re = 1;
        for(i = 1; i < n; ++i) {
            re = (4 * i + 2) * re / (i + 2);
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
    vector<TreeNode *> gR(int start, int end) {
        vector<TreeNode *> re;
        if(start > end) {
            re.push_back(NULL);
            return re;
        }
        if(start == end) {
            re.push_back(new TreeNode(start));
            return re;
        }
        int i, j, k;
        vector<TreeNode*> lv, rv;
        TreeNode *cur;
        for(i = start; i <= end; ++i) {
            lv = gR(start, i - 1);
            rv = gR(i + 1, end);
            for(j = 0; j < lv.size(); ++j) {
                for(k = 0; k < rv.size(); ++k) {
                    cur = new TreeNode(i);
                    cur->left = lv[j];
                    cur->right = rv[k];
                    re.push_back(cur);
                }
            }
        }
        return re;
    }
    vector<TreeNode *> generateTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<TreeNode *> re = gR(1, n);
        return re;
    }
};
class Solution {
public:
    int uniquePaths(int m, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > f;
        int i, j, k;
        for(i = 0; i < m; ++i) {
            f.push_back(vector<int>(n, 1));
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
        vector<vector<int> > f;
        int i, j, k, m = obstacleGrid.size(), n = obstacleGrid[0].size();
        for(i = 0; i < m; ++i) {
            f.push_back(vector<int>(n, 1));
        }
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        for(i = 0; i < m; ++i) {
            for(j = 0; j < n; ++j) {
                if(i == 0 && j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = 0;
                    if(obstacleGrid[i][j] == 0) {
                        if(i > 0) {
                            f[i][j] += f[i - 1][j];
                        }
                        if(j > 0) {
                            f[i][j] += f[i][j - 1];
                        }
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
        while(*s == ' ') {
            ++s;
        }
        if(*s == '+' || *s == '-') {
            ++s;
        }
        bool flag = false, after;
        while(*s >= '0' && *s <= '9') {
            ++s;
            flag = true;
        }
        if(*s == NULL) {
            return flag;
        } else if(*s == '.') {
            ++s;
            after = false;
            while(*s >= '0' && *s <= '9') {
                ++s;
                after = true;
            }
            if(!(after || flag)) return false;
            flag = true;
        }
        if(*s == 'e') {
            if(!flag) return false;
            ++s;
            if(*s == '+' || *s == '-') {
                ++s;
            }
            flag = false;
            while(*s >= '0' && *s <= '9') {
                ++s;
                flag = true;
            }
            if(!flag) return false;
        }
        while(*s == ' ') {
            ++s;
        }
        return *s == NULL;
    }
};
class Solution {
public:
    bool isValid(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        stack<char> st;
        int i, j, k;
        for(i = 0; i < s.length(); ++i) {
            if(s[i] == '(' || s[i] == '[' || s[i] == '{') {
                st.push(s[i]);
            } else {
                if(st.empty()) {
                    return false;
                }
                char ch;
                switch(s[i]) {
                    case ')': ch = '('; break;
                    case ']': ch = '['; break;
                    case '}': ch = '{'; break;
                }
                if(st.top() != ch) {
                    return false;
                }
                st.pop();
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
        int i, j, k, t1, t2;
        vector<bool> f;
        for(i = 0; i < 9; ++i) {
            f.assign(10, true);
            for(j = 0; j < 9; ++j) {
                if(board[i][j] != '.') {
                    k = board[i][j] - '0';
                    if(!f[k]) {
                        return false;
                    }
                    f[k] = false;
                }
            }
        }
        for(i = 0; i < 9; ++i) {
            f.assign(10, true);
            for(j = 0; j < 9; ++j) {
                if(board[j][i] != '.') {
                    k = board[j][i] - '0';
                    if(!f[k]) {
                        return false;
                    }
                    f[k] = false;
                }
            }
        }
        for(t1 = 0; t1 < 9; t1 += 3) {
            for(t2 = 0; t2 < 9; t2 += 3) {
                f.assign(10, true);
                for(i = 0; i < 3; ++i) {
                    for(j = 0; j < 3; ++j) {
                        if(board[t1 + i][t2 + j] != '.') {
                            k = board[t1 + i][t2 + j] - '0';
                            if(!f[k]) {
                                return false;
                            }
                            f[k] = false;
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
    bool inorder(TreeNode *root, TreeNode *&pre) {
        if(root == NULL) {
            return true;
        }
        if(!inorder(root->left, pre)) {
            return false;
        }
        if(pre != NULL && pre->val >= root->val) {
            return false;
        }
        pre = root;
        return inorder(root->right, pre);
    }
    bool isValidBST(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        TreeNode *pre = NULL;
        return inorder(root, pre);
    }
};
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i;
        bool star = false, stopForLoop;
        while(true) {
            stopForLoop = false;
            for(i = 0; s[i]; ++i) {
                switch(p[i]) {
                case '?': break;
                case '*':
                    star = true;
                    s += i; p += i;
                    while(*p == '*') ++p;
                    if(*p == NULL) return true;
                    stopForLoop = true;
                    break;
                default:
                    if(s[i] != p[i]) {
                        if(star) {++s; stopForLoop = true;}
                        else return false;
                    }
                }
                if(stopForLoop) break;
            }
            if(!stopForLoop) break;
        }
        while(p[i] == '*') ++i;
        return p[i] == NULL;
    }
};
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(*p == NULL) return *s == NULL;
        if(*s == NULL) {
            while(*p == '*') {++p;}
            return *p == NULL;
        }
        if(*p == '?' || *s == *p) return isMatch(s + 1, p + 1);
        else if(*p == '*') return isMatch(s, p + 1) || isMatch(s + 1, p);
        return false;
    }
};
class Solution {
public:
    bool dfs(vector<vector<char> > &board, string &word, set<pair<int, int> > &dict,
    pair<int, int> cur, int index){
        if(index == word.length()) {
            return true;
        }
        int i, j, k;
        int move[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        pair<int, int> pos;
        for(i = 0; i < 4; ++i) {
            pos = make_pair(cur.first + move[i][0], cur.second + move[i][1]);
            if(pos.first >= 0 && pos.first < board.size()
            && pos.second >= 0 && pos.second < board[0].size()) {
                if(board[pos.first][pos.second] == word[index] && dict.find(pos) == dict.end()) {
                    dict.insert(pos);
                    if(dfs(board, word, dict, pos, index + 1)) {return true;}
                    dict.erase(pos);
                }
            }
        }
        return false;
    }
    bool exist(vector<vector<char> > &board, string word) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int i, j;
        set<pair<int, int> > dict;
        for(i = 0; i < board.size(); ++i) {
            for(j = 0; j < board[0].size(); ++j) {
                if(board[i][j] == word[0]) {
                    dict.clear();
                    dict.insert(make_pair(i, j));
                    if(dfs(board, word, dict, make_pair(i, j), 1)) {
                        return true;
                    }
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
        vector<vector<char> > v;
        int i, j, k, t, len = s.length();
        string re;
        if(len == 0) return re;
        for(i = 0; i < nRows; ++i) {
            v.push_back(vector<char>(len, ' '));
        }
        i = 0; j = 0; t = 0; k = 0;
        while(true) {
            for(i = 0; i < nRows && k < len; ++i) {
                v[i][j] = s[k++];
            }
            if(k == len) break;
            ++j;
            for(i = nRows - 2; i >= 1 && k < len; --i) {
                v[i][j] = s[k++];
            }
            if(k == len) break;
            if(nRows > 2) ++j;
        }
        for(k = 0; k < nRows; ++k) {
            for(i = 0; i <= j; ++i) {
                if(v[k][i] != ' ') re.push_back(v[k][i]);
            }
        }
        return re;
    }
};