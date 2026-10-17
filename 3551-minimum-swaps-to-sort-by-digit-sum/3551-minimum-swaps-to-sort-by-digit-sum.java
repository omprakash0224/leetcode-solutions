class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Element structure holding digit sum, value, and original index
        Element[] arr = new Element[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Element(getDigitSum(nums[i]), nums[i], i);
        }

        // Sort based on:
        // 1. Digit sum (ascending)
        // 2. Value as a tiebreaker (ascending)
        Arrays.sort(arr, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.val, b.val);
        });

        // visited[i] tracks whether the element at index i has been placed in its cycle
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // Already visited or already in the correct position
            if (visited[i] || arr[i].origIndex == i) {
                continue;
            }

            // Find the size of the permutation cycle
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr].origIndex;
                cycleSize++;
            }

            // A cycle of size k requires (k - 1) swaps
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
    private int getDigitSum(int val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    private static class Element {
        int digitSum;
        int val;
        int origIndex;

        Element(int digitSum, int val, int origIndex) {
            this.digitSum = digitSum;
            this.val = val;
            this.origIndex = origIndex;
        }
    }
}