package Recursion.Backtracking;

public class maze {
    public static void main(String[] args) {
        boolean[][] board = { { false, false, false },
                { false, false, false },
                { false, false, false } };
        System.out.println(allpath(board));
    }

    public static int allpath(boolean[][] board) {
        return allpath(board, board.length, board[0].length, "", 0);
    }

    public static int allpath(boolean[][] board, int row, int col, String path, int count) {
        if (row == 1 || col == 1) {
            System.out.println(path);
            return 1;
        }
        int down = allpath(board, row - 1, col, path + "D", count);
        int right = allpath(board, row, col - 1, path + "R", count);
        return down + right;
    }
}
