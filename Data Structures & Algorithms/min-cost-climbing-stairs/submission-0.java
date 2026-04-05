class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] res = new int[n + 2];

        for(int i = 3; i <= n + 1; i++){
            res[i] = Math.min(res[i-1] + cost[i-2], res[i-2] + cost[i-3]);
        }

        // 0 0 0 0 0

        // i =3
        // 0 0 0 

        return res[n + 1];
    }
}
