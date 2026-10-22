class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        boolean inc = true, dec = true;
        int idx0 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) idx0 = i;
            if (nums[(i + 1) % n] != (nums[i] + 1) % n) inc = false;
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) dec = false;
        }

        if (!inc && !dec) return -1;

        int ans = Integer.MAX_VALUE;
        if (inc) {
            ans = Math.min(ans, Math.min(idx0, (n - idx0) % n + 2));
        }
        if (dec) {
            ans = Math.min(ans, Math.min(n - idx0, (idx0 + 1) % n + 1));
        }

        return ans;
    }
}