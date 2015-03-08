__author__ = 'zd987'
class Solution:
    # @param s, a string
    # @return a list of strings
    def findRepeatedDnaSequences(self, s):
        d = {}
        li = []
        for i in range(0, len(s) - 9):
            cs = s[i:i + 10]
            if cs in d:
                cnt = d[cs]
                if cnt == 1:
                    li.append(cs)
                    d[cs] = 2
            else:
                d[cs] = 1
        return li

if __name__ == "__main__":
    s = Solution()
    print s.findRepeatedDnaSequences("")