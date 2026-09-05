class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // leftMax[i] stores the maximum value in nums from index 0 to i
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        
        // rightMin[i] stores the minimum value in nums from index i to n - 1
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        
        // Find the first index satisfying the stability condition
        for (int i = 0; i < n; i++) {
            if (leftMax[i] - rightMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}