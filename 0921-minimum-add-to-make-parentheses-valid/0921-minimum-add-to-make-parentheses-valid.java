class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int additionsNeeded = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    // Match with an existing unmatched '('
                    openCount--;
                } else {
                    // Unmatched ')', requires an opening bracket '('
                    additionsNeeded++;
                }
            }
        }

        // Total additions = unmatched ')' + remaining unmatched '('
        return additionsNeeded + openCount;
    }
}