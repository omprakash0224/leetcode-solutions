class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0; // Start with node 0 at cost 0
        
        boolean[] inMST = new boolean[n];
        int totalCost = 0;
        
        for (int step = 0; step < n; step++) {
            int u = -1;
            
            // Step 1: Find unvisited node with minimum distance to current MST
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && (u == -1 || minDist[i] < minDist[u])) {
                    u = i;
                }
            }
            
            // Step 2: Add node u to MST
            inMST[u] = true;
            totalCost += minDist[u];
            
            // Step 3: Update minimum distance for all remaining unvisited neighbors
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) 
                             + Math.abs(points[u][1] - points[v][1]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }
        
        return totalCost;
    }
}