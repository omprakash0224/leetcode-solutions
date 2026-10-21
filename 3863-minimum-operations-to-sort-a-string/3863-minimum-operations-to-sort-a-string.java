class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        char min = 'z', max = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && c < s.charAt(i - 1)) sorted = false;
            if (c < min) min = c;
            if (c > max) max = c;
        }

        if (sorted) return 0;
        if (n == 2) return -1;
        if (s.charAt(0) == min || s.charAt(n - 1) == max) return 1;

        // Returns 3 if `min` only exists at the last index and `max` only at the first index
        if (s.indexOf(min) == n - 1 && s.lastIndexOf(max) == 0) return 3;

        return 2;
    }
}