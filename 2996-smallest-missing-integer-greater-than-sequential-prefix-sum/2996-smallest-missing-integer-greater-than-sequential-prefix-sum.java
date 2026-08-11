class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        
        // Step 1: build sequential prefix sum
        int i = 1;
        while (i < nums.length && nums[i] == nums[i-1] + 1) {
            prefixSum += nums[i];
            i++;
        }
        
        // Step 2: find smallest missing integer > prefixSum
        int target = prefixSum;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        while (set.contains(target)) {
            target++;
        }
        
        return target;
    }
}