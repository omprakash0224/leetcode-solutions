class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Adjacency list aur indegree array initialize karo
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        //Step 2: Build the graph
        for(int[] pair : prerequisites){
            int course = pair[0];
            int preReq = pair[1];
            adj.get(preReq).add(course);
            inDegree[course]++;
        }

        //Step 3: 0 inDegree wale courses ko queue mai add krdo
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        //Step 4: Kahn's Algo
        int processedCourses = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            processedCourses++;

            for(int neighbor : adj.get(curr)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return processedCourses == numCourses;
    }
}