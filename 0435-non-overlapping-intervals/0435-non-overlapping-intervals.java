class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removals = 0;  // Kitne intervals remove kiye
        int prevEnd = intervals[0][1];  // Pehle interval ka end time
        for(int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < prevEnd) {
                // Overlap detected - ek aur interval remove karo
                removals++;
            } else {
                // No overlap - prevEnd update karo
                prevEnd = intervals[i][1];
            }
        }
        return removals;
    }
}