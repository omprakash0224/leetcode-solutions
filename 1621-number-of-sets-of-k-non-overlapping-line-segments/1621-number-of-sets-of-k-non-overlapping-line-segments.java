class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[k + 1][2];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            int[][] nextDp = new int[k + 1][2];
            for (int j = 0; j <= k; j++) {
                nextDp[j][0] = (dp[j][0] + dp[j][1]) % MOD;

                nextDp[j][1] = dp[j][1];
                if (j > 0) {
                    int startNew = (dp[j - 1][0] + dp[j - 1][1]) % MOD;
                    nextDp[j][1] = (nextDp[j][1] + startNew) % MOD;
                }
            }
            dp = nextDp;
        }

        return (dp[k][0] + dp[k][1]) % MOD;
    }
}