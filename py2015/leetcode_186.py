__author__ = 'zd987'
class Solution:
    # @param s, a list of 1 length strings, e.g., s = ['h','e','l','l','o']
    # @return nothing
    def reverseWords(self, s):
        self.reverse(s, 0, len(s) - 1)
        pre = 0
        for i in range(0, len(s)):
            if s[i] == ' ':
                self.reverse(s, pre, i - 1)
                pre = i + 1
        if pre < len(s):
            self.reverse(s, pre, len(s) - 1)

    def reverse(self, s, start, end):
        while(start < end):
            tmp = s[start]
            s[start] = s[end]
            s[end] = tmp
            start +=1
            end -= 1


if __name__ == "__main__":
    s = Solution()
    ls = list("hello world!")
    s.reverseWords(ls)
    print ls