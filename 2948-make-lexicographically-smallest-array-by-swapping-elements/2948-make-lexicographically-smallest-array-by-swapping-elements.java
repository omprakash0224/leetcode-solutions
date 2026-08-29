class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i][0] = nums[i];
            paired[i][1] = i;
        }

        Arrays.sort(paired, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int i = 0;

        while (i < n) {
            int j = i;
            List<Integer> originalIndices = new ArrayList<>();
            
            while (j < n && (j == i || paired[j][0] - paired[j - 1][0] <= limit)) {
                originalIndices.add(paired[j][1]);
                j++;
            }

            Collections.sort(originalIndices);

            for (int k = 0; k < originalIndices.size(); k++) {
                int targetIndex = originalIndices.get(k);
                int smallestValue = paired[i + k][0];
                result[targetIndex] = smallestValue;
            }

            i = j;
        }

        return result;
    }
}