class Solution {
    private Boolean[][][] memo;
    private int m, n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Total path length must be even to form balanced parentheses
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Start must be '(' and end must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        // Maximum balance possible is (m + n) / 2
        int maxOpen = (m + n) / 2;
        memo = new Boolean[m][n][maxOpen + 1];

        return dfs(grid, 0, 0, 0, maxOpen);
    }
    private boolean dfs(char[][] grid, int r, int c, int open, int maxOpen) {
        // Update current open parenthesis count
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }

        // Invalid prefix or impossible to balance
        if (open < 0 || open > maxOpen) {
            return false;
        }

        // Reached destination: balance must be exactly 0
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }

        // Check memoized result
        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(grid, r + 1, c, open, maxOpen);
        }

        // Move Right
        if (!found && c + 1 < n) {
            found = dfs(grid, r, c + 1, open, maxOpen);
        }

        return memo[r][c][open] = found;
    }    
}