class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            freqMap.put(currentNum, freqMap.getOrDefault(currentNum, 0) + 1);

            while (freqMap.get(currentNum) > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}