#Time Complexity: O(nlogn)
class Solution(object):
    def maxSubsequence(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        index = [(num, i) for i, num in enumerate(nums)]
        
        index.sort(key=lambda x: x[0], reverse=True)
        
        topk = index[:k]
        
        topk.sort(key=lambda x: x[1])
        
        return [num for num, _ in topk]

