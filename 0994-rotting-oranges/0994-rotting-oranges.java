class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        int mins = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] pos = q.poll();
                for(int[] d : dirs){
                    int x = pos[0]+d[0], y = pos[1]+d[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                } 
            }
            mins++;
        }
        return fresh == 0 ? mins : -1;
    }
}