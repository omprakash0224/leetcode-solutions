class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: k == n (Only 1 subarray exists, return the max element)
        if (k == n) {
            int maxVal = -1;
            for (int num : nums) {
                maxVal = Math.max(maxVal, num);
            }
            return maxVal;
        }

        // Count the frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Case 2: k == 1 (Return the largest element with frequency 1)
        if (k == 1) {
            int maxVal = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    maxVal = Math.max(maxVal, entry.getKey());
                }
            }
            return maxVal;
        }

        // Case 3: 1 < k < n (Only nums[0] and nums[n - 1] can appear in 1 subarray)
        int ans = -1;
        if (freq.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }
        if (freq.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}