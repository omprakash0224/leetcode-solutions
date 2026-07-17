class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // row + col
        Set<Integer> diag2 = new HashSet<>(); //row-col
        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }
    private void backtrack(int row, int n, char[][] board, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, List<List<String>> result){
        if(row == n){
            result.add(construct(board));
            return;
        }

        for(int col=0; col < n; col++){
            if(cols.contains(col) || diag1.contains(row+col) || diag2.contains(row-col)){
               continue; 
            }

            //place queen
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row+col);
            diag2.add(row-col);

            backtrack(row+1, n, board, cols, diag1, diag2, result);

            //remove queen
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row+col);
            diag2.remove(row-col);
        }
    }
    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] row : board){
            result.add(new String(row));
        }
        return result;
    }
}