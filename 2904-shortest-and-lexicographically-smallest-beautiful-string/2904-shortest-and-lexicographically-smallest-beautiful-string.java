class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int count1 = 0;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count1++;
            }

            while (count1 == k) {
                // Leading zeros ko strip out karenge to make it the shortest valid window
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);
                
                // Result comparison
                if (ans.isEmpty() || current.length() < ans.length()) {
                    ans = current;
                } else if (current.length() == ans.length() && current.compareTo(ans) < 0) {
                    ans = current;
                }

                // Window shrink karke aage badho
                left++;
                count1--;
            }
        }

        return ans;
    }
}