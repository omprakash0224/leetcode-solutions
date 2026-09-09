class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = i;
        }

        for(int mid=0; mid<n; mid++){
            //odd
            expandAroundCenter(s, mid, mid, dp);
            //even
            expandAroundCenter(s, mid, mid+1, dp);
        }
        return dp[n-1];
    }
    private void expandAroundCenter(String s, int left, int right, int[] dp){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            if(left == 0){
                dp[right] = 0;
            }else{
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}