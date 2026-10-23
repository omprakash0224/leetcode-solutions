class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1; // -1 represents all 1-bits in two's complement
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                k &= nums[i];
            }
        }
        
        // If the array is already sorted, k remains -1, so return 0
        return k == -1 ? 0 : k;
    }
}