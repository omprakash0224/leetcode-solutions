class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                // Assign based on current depth parity, then increase depth
                ans[i] = depth % 2;
                depth++;
            } else {
                // Closing bracket matches the current level, decrease depth first
                depth--;
                ans[i] = depth % 2;
            }
        }

        return ans;
    }
}