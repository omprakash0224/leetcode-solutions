class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            int minPrev = Integer.MAX_VALUE;
            
            // Check previous steps j - 1, j - 2, j - 3
            for (int k = 1; k <= 3; k++) {
                int i = j - k;
                if (i >= 0) {
                    // Cost from i to j: dp[i] + (j - i)^2
                    minPrev = Math.min(minPrev, dp[i] + k * k);
                }
            }
            
            // Add the cost of reaching step j (costs is 0-indexed in Java)
            dp[j] = minPrev + costs[j - 1];
        }

        return dp[n];
    }
}