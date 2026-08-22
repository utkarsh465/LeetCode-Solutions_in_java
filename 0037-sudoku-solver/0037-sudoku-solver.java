class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        // Find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // Try numbers 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {

                            // Put the number
                            board[row][col] = num;

                            // Recursively solve remaining board
                            if (solve(board)) {
                                return true;
                            }

                            // Wrong choice -> backtrack
                            board[row][col] = '.';
                        }
                    }

                    // No number worked
                    return false;
                }
            }
        }

        // No empty cell -> Sudoku solved
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == num) {
                return false;
            }

            // Check column
            if (board[i][col] == num) {
                return false;
            }

            // Check 3 x 3 box
            int boxRow = (row / 3) * 3 + i / 3;
            int boxCol = (col / 3) * 3 + i % 3;

            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        return true;
    }
}