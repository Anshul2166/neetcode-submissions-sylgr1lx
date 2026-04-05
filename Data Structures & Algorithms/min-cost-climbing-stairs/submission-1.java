class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] res = new int[n + 1];

        for(int i = 2; i <= n; i++){
            res[i] = Math.min(res[i-1] + cost[i-1], res[i-2] + cost[i-2]);
        }

        // 0 0 0 0 0

        // i =3
        // 0 0 0 

        return res[n];
    }
}
