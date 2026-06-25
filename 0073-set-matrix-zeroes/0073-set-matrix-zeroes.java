class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // no of rows
        int n = matrix[0].length; // no of cols

        //row and col marker array
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // first pass: mark rows and columns that need to be zeroed
        for(int i=0; i < m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //second pass : set cells to zero based on markers
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}