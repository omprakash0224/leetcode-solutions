class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k+1];
        int moves = 0;

        while(dp[k] < n){
            moves++;
            for(int egg = k; egg >= 1; egg--){
                dp[egg] = dp[egg] + dp[egg - 1] + 1;
            }
        }
        return moves;
    }
}