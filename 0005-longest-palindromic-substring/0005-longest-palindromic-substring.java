class Solution {
    private int start = 0;
    private int maxLen = 1;
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        for (int i = 0; i < n; i++) {
            // Odd length palindrome
            expandAroundCenter(s, i, i);

            // Even length palindrome
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }
    private void expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right - left + 1 > maxLen){
                start = left;
                maxLen = right - left + 1;
            }
            left--;
            right++;
        }
    }
}