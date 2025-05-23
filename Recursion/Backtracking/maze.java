package Recursion.Backtracking;

public class maze {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true },
                { true, false, true },
                { true, true, true } };
        System.out.println(allpath(board));
    }

    public static int allpath(boolean[][] board) {
        return allpath(board, board.length, board[0].length, "", 0);
    }

    public static int allpath(boolean[][] board, int row, int col, String path, int count) {
        if (row == 1 && col == 1) {
            System.out.println(path);
            return 1;
        }
        if (!board[row - 1][col - 1]) {
            return 0;
        }
        int down = 0;
        int right = 0;
        int diagnol = 0;
        if (row > 1) {
            down = allpath(board, row - 1, col, path + "D", count);
        }
        if (row > 1 && col > 1) {
            diagnol = allpath(board, row - 1, col - 1, path + "S", count);
        }
        if (col > 1) {
            right = allpath(board, row, col - 1, path + "R", count);
        }
        return down + right + diagnol;
    }
}
