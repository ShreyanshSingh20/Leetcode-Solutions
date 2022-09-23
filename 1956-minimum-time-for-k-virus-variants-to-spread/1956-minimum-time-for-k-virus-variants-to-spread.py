class Solution:
    def minDayskVariants(self, points: List[List[int]], k: int) -> int:
        res = math.inf
        for i in range(1,101):
            for j in range(1,101):
                dists = sorted(abs(i2-i)+abs(j2-j) for i2,j2 in points)
                res = min(res, dists[k-1])
        return res
        