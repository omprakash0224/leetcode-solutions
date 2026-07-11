class Solution {
    class Job {
        int start, end, profit;
        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = start.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(start[i], end[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int incl = jobs[i].profit;
            int prev = binarySearch(jobs, i);
            if (prev != -1) incl += dp[prev];
            dp[i] = Math.max(incl, dp[i-1]);
        }
        return dp[n-1];
    }
    private static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid+1].end <= jobs[index].start) low = mid + 1;
                else return mid;
            } else high = mid - 1;
        }
        return -1;
    }
}