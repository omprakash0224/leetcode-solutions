class Solution {
    public int countCommas(int n) {
       if (n < 1000) {
            return 0;
        }
        // Every number from 1000 up to n has at least 4 digits and at most 6 digits (for n <= 10^5)
        // Thus, each such number contributes exactly 1 comma.
        return n - 1000 + 1;
    }
}