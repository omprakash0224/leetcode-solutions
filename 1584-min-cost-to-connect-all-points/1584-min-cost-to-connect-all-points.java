class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        
        // PriorityQueue store karega: [cost, nodeIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Node 0 se shuru karte hain, cost = 0
        pq.offer(new int[]{0, 0});
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            
            // Agar node pehle se MST ka part hai to skip karein
            if (inMST[u]) {
                continue;
            }
            
            // MST mein include karein
            inMST[u] = true;
            totalCost += cost;
            edgesUsed++;
            
            // Unvisited neighbors ka distance calculate karke PQ mein push karein
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) 
                             + Math.abs(points[u][1] - points[v][1]);
                    pq.offer(new int[]{dist, v});
                }
            }
        }
        
        return totalCost;
    }
}