class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path, res);
        return res;
    }
    private void dfs(int start, int[] nums, List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            dfs(i+1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }
}