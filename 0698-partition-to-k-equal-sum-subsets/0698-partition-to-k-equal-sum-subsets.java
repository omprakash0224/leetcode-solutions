class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % k != 0) return false;
        
        int target = totalSum / k;
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[n - 1] > target) return false;
        
        boolean[] visited = new boolean[n];
        
        return backtrack(nums, visited, 0, 0, 0, target, k);
    }
    private boolean backtrack(int[] nums, boolean[] visited, int startIndex, int currentBucket, int currentSum, int target, int k) {
        if (currentBucket == k - 1) {
            return true;
        }
        if (currentSum == target) {
            return backtrack(nums, visited, 0, currentBucket + 1, 0, target, k);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i]) continue;
            if (currentSum + nums[i] > target) continue;
            visited[i] = true;
            if (backtrack(nums, visited, i + 1, currentBucket, currentSum + nums[i], target, k)) {
                return true;
            }
            visited[i] = false;
            if (currentSum == 0) return false;
        }
        
        return false;
    }
}