class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= current[1]){
                //overlap -> merge
                current[1] = Math.max(current[1], intervals[i][1]); 
            }else {
                // No overlap -> push current
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}