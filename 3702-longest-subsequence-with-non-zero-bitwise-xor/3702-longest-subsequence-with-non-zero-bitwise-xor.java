class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        for (int num : nums) {
            totalXor ^= num;
        }
        
        if (totalXor != 0) {
            return nums.length;
        } else {
            boolean allZero = true;
            for (int num : nums) {
                if (num != 0) {
                    allZero = false;
                    break;
                }
            }
            return allZero ? 0 : nums.length - 1;
        }
    }
}