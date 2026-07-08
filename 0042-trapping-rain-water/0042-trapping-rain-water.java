class Solution {
    public int trap(int[] height) {
        // optimized two pointer approach
        int n = height.length;
        if (height == null || n == 0) {
            return 0;
        }
        int left = 0, right = n-1, leftmax = 0, rightmax = 0, water = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftmax){
                    leftmax = height[left];
                }else {
                    water += leftmax - height[left];
                }
                left++;
            }else {
                if(height[right] >= rightmax){
                    rightmax = height[right];
                }else {
                    water += rightmax - height[right]; 
                }
                right--;
            }
        }
        return water;    

    }
}