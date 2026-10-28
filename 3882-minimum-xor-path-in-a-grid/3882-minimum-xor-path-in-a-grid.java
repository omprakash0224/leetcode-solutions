class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX_XOR = 1024;

        // dp[j][x] = true if XOR value x is achievable
        // at the current row's column j.
        boolean[][] dp = new boolean[n][MAX_XOR];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                boolean[] curr = new boolean[MAX_XOR];

                if (i == 0 && j == 0) {
                    curr[grid[i][j]] = true;
                } else {
                    // From the cell above
                    if (i > 0) {
                        for (int x = 0; x < MAX_XOR; x++) {
                            if (dp[j][x]) {
                                curr[x ^ grid[i][j]] = true;
                            }
                        }
                    }

                    // From the cell on the left
                    if (j > 0) {
                        for (int x = 0; x < MAX_XOR; x++) {
                            if (dp[j - 1][x]) {
                                curr[x ^ grid[i][j]] = true;
                            }
                        }
                    }
                }

                dp[j] = curr;
            }
        }

        // Find the minimum achievable XOR at the destination
        for (int x = 0; x < MAX_XOR; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}