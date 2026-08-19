class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Adjacency List build karo
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
        }

        // Step 2: State array initialize karo (0 = Unvisited, 1 = Visiting, 2 = Visited)
        int[] state = new int[numCourses];

        // Step 3: Har component ke liye DFS run karo
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adj, state)) {
                    return false; // Cycle mil gayi, impossible to finish
                }
            }
        }

        return true;
    }
    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        // Current node ko active recursion stack me mark karo
        state[node] = 1;

        for (int neighbor : adj.get(node)) {
            // Agar neighbor active stack me hai -> Back-edge (Cycle)
            if (state[neighbor] == 1) {
                return true;
            }
            // Agar neighbor unvisited hai, explore karo
            if (state[neighbor] == 0) {
                if (hasCycle(neighbor, adj, state)) {
                    return true;
                }
            }
            // state[neighbor] == 2 wale ko skip karenge kyunki wo safe hai
        }

        // Exploration complete, node ko completely visited mark karo
        state[node] = 2;
        return false;
    }
}