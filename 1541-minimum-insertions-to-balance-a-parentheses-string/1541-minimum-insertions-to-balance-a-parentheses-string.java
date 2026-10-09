class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; // Tracks the number of unmatched '('
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                // Check if the current ')' is followed by another ')' to form "))"
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    // Only a single ')' was found, insert another ')'
                    insertions++;
                }

                // Balance with an open '(' if available; otherwise insert '('
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++;
                }
            }
        }

        // Each remaining unmatched '(' needs "))" (2 insertions each)
        insertions += openCount * 2;

        return insertions;
    }
}