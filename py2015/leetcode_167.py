__author__ = 'zd987'
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        low = 0
        high = len(num) - 1
        while(low < high):
            sum = num[low] + num[high]
            if sum == target:
                return (low + 1, high + 1)
            elif sum > target:
                high -= 1
            else:
                low += 1
        return (-1, -1)