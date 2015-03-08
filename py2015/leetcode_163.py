__author__ = 'zd987'
class Solution:
    # @param A, a list of integers
    # @param lower, an integer
    # @param upper, an integer
    # @return a list of strings
    def rangeStr(self, lower, upper):
        if lower == upper:
            return "%d" % lower
        else:
            return "%d->%d" % (lower, upper)
    def findMissingRanges(self, A, lower, upper):
         re = []
         for a in A:
             if lower > upper:
                 break
             if a < lower:
                 continue
             elif a == lower:
                 lower += 1
             elif a > lower and a < upper:
                 re.append(self.rangeStr(lower, a - 1))
                 lower = a + 1
             elif a == upper:
                 if upper > lower:
                    re.append(self.rangeStr(lower, upper - 1))
                    lower = upper + 1
             else:
                 re.append(self.rangeStr(lower, upper))
                 lower = upper + 1
         if lower <= upper:
             re.append(self.rangeStr(lower, upper))
         return re