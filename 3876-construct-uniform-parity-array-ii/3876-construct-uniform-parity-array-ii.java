class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;
        boolean hasEven = false;
        
        for (int x : nums1) {
            minVal = Math.min(minVal, x);
            if (x % 2 != 0) {
                hasOdd = true;
            } else {
                hasEven = true;
            }
        }
        
        // If all elements are already odd or all are already even
        if (!hasOdd || !hasEven) {
            return true;
        }
        
        // If there is a mix, it is only possible if the minimum element is odd
        return minVal % 2 != 0;
    }
}