class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long totalSum = 0;
                    Queue<int[]> queue = new ArrayDeque<>();

                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];

                        totalSum += grid[r][c];

                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }

                    if (totalSum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}