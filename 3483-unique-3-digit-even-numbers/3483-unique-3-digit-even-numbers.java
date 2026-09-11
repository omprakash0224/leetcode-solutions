class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // Iterate through all 3-digit even numbers (100 to 998, step by 2)
        for (int num = 100; num < 1000; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] cur = new int[10];
            cur[d1]++;
            cur[d2]++;
            cur[d3]++;

            // Check if the current number's digits can be formed from the input array
            if (cur[d1] <= freq[d1] && cur[d2] <= freq[d2] && cur[d3] <= freq[d3]) {
                count++;
            }
        }

        return count;
    }
}