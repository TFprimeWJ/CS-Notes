class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numbers = set(nums)
        max_length = 0
        
        while(numbers):
            m = n = numbers.pop()
            length = 1
            while(m-1 in numbers):
                numbers.remove(m-1)
                m -= 1
                length += 1
            while(n+1 in numbers):
                numbers.remove(n+1)
                n += 1
                length += 1
            max_length = max(max_length, length)
        
        return max_length
                
            