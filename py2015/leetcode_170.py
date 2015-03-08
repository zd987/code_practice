__author__ = 'zd987'
class TwoSum:
    # initialize your data structure here
    def __init__(self):
        self.d = {}
    # @return nothing
    def add(self, number):
        if number in self.d:
            self.d[number] = 2
        else:
            self.d[number] = 1

    # @param value, an integer
    # @return a Boolean
    def find(self, value):
        for key in self.d.keys():
            remainder = value - key
            if remainder == key:
                if self.d[key] == 2:
                    return True
            elif remainder in self.d:
                return True
        return False

if __name__ == '__main__':
    sol = TwoSum()
    sol.add(3)
    sol.add(2)
    sol.add(1)
    print sol.find(2)
    print sol.find(3)
    print sol.find(4)
    print sol.find(5)
    print sol.find(6)