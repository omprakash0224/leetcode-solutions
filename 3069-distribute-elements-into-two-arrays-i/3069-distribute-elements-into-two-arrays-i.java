class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Initial assignment
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Process elements from index 2 to n - 1
        for (int i = 2; i < n; i++) {
            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);

            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Merge arr1 and arr2 into result array
        int[] result = new int[n];
        int index = 0;

        for (int val : arr1) {
            result[index++] = val;
        }
        for (int val : arr2) {
            result[index++] = val;
        }

        return result;
    }
}