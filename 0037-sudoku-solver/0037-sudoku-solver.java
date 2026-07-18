class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) return true;

                            board[row][col] = '.'; // backtrack
                        }
                    }

                    return false; // no valid number
                }
            }
        }
        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        // row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3x3 box check
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);

        for (int i = 0; i < 9; i++) {
            if (board[startRow + i / 3][startCol + i % 3] == num)
                return false;
        }

        return true;
    }
}