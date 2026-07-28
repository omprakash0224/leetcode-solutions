class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<n; i++){
            // remove out-of-window index
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            // remove smaller elements
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            // record max
            if(i >= k-1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}