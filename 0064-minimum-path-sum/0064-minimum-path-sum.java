class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return minPathSum(grid, dp, grid.length, grid[0].length, 0, 0);
    }
    private int minPathSum(int[][] grid, Integer[][] dp, int m, int n, int i, int j) {
        if (i == m-1 && j == n-1) {
            return grid[i][j]; // base case
        }

        if (dp[i][j] != null) {
            return dp[i][j]; // memoization check
        }

        int downSum = Integer.MAX_VALUE;
        if (i+1 < m) {
            downSum = grid[i][j] + minPathSum(grid, dp, m, n, i+1, j);
        }

        int rightSum = Integer.MAX_VALUE;
        if (j+1 < n) {
            rightSum = grid[i][j] + minPathSum(grid, dp, m, n, i, j+1);
        }

        return dp[i][j] = Math.min(downSum, rightSum);
    }
}