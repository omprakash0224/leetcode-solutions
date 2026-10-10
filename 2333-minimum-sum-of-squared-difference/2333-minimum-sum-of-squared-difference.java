class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long totalDiff = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = (long) k1 + k2;
        // If we have enough operations to reduce all differences to 0
        if (totalDiff <= k) {
            return 0;
        }

        // Count frequencies of each difference value up to maxDiff (<= 10^5)
        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }

        // Greedily reduce the largest differences first
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) continue;

            if (k >= count[d]) {
                // We can decrement all elements of value `d` to `d - 1`
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                // Partially decrement as many as k allows
                count[d] -= (int) k;
                count[d - 1] += (int) k;
                k = 0;
            }
        }

        // Calculate the sum of squares
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                ans += (long) count[d] * (long) d * d;
            }
        }

        return ans;
    }
}