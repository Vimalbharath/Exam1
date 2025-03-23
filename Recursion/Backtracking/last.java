package Recursion.Backtracking;

public class last {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true },
                { true, true, true },
                { true, true, true } };
        allpath(board, board.length, board[0].length, "");
    }

    public static void allpath(boolean[][] board, int row, int col, String path) {
        if (row == 1 && col == 1) {
            System.out.println(path);

            return;
        }
        if (!board[row - 1][col - 1]) {
            return;
        }
        board[row - 1][col - 1] = false;

        if (row > 1) {
            allpath(board, row - 1, col, path + "D");
        }
        if (row < 3) {
            allpath(board, row + 1, col, path + "U");
        }
        if (col > 1) {
            allpath(board, row, col - 1, path + "R");
        }
        if (col < 3) {
            allpath(board, row, col + 1, path + "L");
        }
        board[row - 1][col - 1] = true;
        return;
    }
}
