class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        // Each entry: u -> list of [v, weight]
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        // Step 2: Distance array initialized to infinity
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: PriorityQueue storing [time, node], min-heap by time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        // Step 4: Process shortest paths
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int u = curr[1];

            // If we found a longer path than already recorded, skip
            if (currTime > dist[u]) {
                continue;
            }

            // Relaxation of adjacent edges
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                if (currTime + weight < dist[v]) {
                    dist[v] = currTime + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        // Step 5: Find maximum time to reach any node
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Unreachable node exists
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}