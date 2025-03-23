package Recursion.Backtracking;

import java.util.Arrays;

public class last {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true },
                { true, true, true },
                { true, true, true } };
        int[][] way = new int[board.length][board[0].length];
        allpath(board, board.length, board[0].length, "", way, 1);

    }

    public static void allpath(boolean[][] board, int row, int col, String path, int[][] way, int count) {
        if (row == 1 && col == 1) {
            System.out.println(path);
            way[row - 1][col - 1] = count;
            for (int[] nums : way) {
                System.out.println(Arrays.toString(nums));
            }
            return;
        }
        if (!board[row - 1][col - 1]) {
            return;
        }
        board[row - 1][col - 1] = false;
        way[row - 1][col - 1] = count;
        if (row > 1) {
            allpath(board, row - 1, col, path + "D", way, count + 1);
        }
        if (row < 3) {
            allpath(board, row + 1, col, path + "U", way, count + 1);
        }
        if (col > 1) {
            allpath(board, row, col - 1, path + "R", way, count + 1);
        }
        if (col < 3) {
            allpath(board, row, col + 1, path + "L", way, count + 1);
        }
        board[row - 1][col - 1] = true;
        way[row - 1][col - 1] = 0;
        return;
    }
}
