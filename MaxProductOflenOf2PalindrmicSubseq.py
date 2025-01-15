# Time Complexity: O(3^n)
class Solution:
    def maxProduct(self, s: str) -> int:
        n,pal = len(s),{}

        for mask in range(1,1<<n):
            subseq=""
            for i in range(n):
                if mask & (1<<i):
                    subseq+=s[i]
                if subseq==subseq[::-1]:
                    pal[mask] = len(subseq)

        res=0
        masks = list(pal.keys())

        for i in range(len(masks)):
            for j in range(i + 1, len(masks)):
                if masks[i] & masks[j] == 0: 
                    res = max(res, pal[masks[i]] * pal[masks[j]])

        return res
