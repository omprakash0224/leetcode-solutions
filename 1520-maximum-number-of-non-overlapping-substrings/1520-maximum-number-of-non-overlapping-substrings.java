class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // 1. Record first and last occurrence for each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // 2. Expand intervals starting from each unique character's first occurrence
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int left = first[i];
            int right = last[i];
            boolean valid = true;

            for (int j = left; j <= right; j++) {
                int c = s.charAt(j) - 'a';
                // If a character inside has an earlier start, this substring cannot start at `left`
                if (first[c] < left) {
                    valid = false;
                    break;
                }
                right = Math.max(right, last[c]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // 3. Classic interval scheduling (sort by end time)
        intervals.sort(Comparator.comparingInt(a -> a[1]));

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (l > prevEnd) {
                result.add(s.substring(l, r + 1));
                prevEnd = r;
            }
        }

        return result;
    }
}