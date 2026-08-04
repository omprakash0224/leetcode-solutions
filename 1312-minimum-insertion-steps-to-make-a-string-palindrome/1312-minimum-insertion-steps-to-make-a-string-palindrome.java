class Solution {
    private int[][] memo;
    
    public int minInsertions(String s) {
        int n = s.length();
        memo = new int[n][n];
        
        // Initialize memoization table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(s, 0, n - 1);
    }
    private int solve(String s, int i, int j) {
        // Base Case: Substring length <= 1 is already a palindrome
        if (i >= j) {
            return 0;
        }

        // Return cached result
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Match case
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = solve(s, i + 1, j - 1);
        }

        // Mismatch case: 1 insertion + min of (move left pointer OR move right pointer)
        int takeLeft  = solve(s, i + 1, j);
        int takeRight = solve(s, i, j - 1);

        return memo[i][j] = 1 + Math.min(takeLeft, takeRight);
    }
}