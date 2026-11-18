class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int k = n -1;
        while(left <= right){
            int leftVal = nums[left];
            int rightVal = nums[right];
            int leftSqr = leftVal * leftVal;
            int rightSqr = rightVal * rightVal;
            if(leftSqr > rightSqr){
                res[k] = leftSqr;
                left++;
            } else {
                res[k] = rightSqr;
                right--;
            }
            k--;
        } 
        return res;
    }
}