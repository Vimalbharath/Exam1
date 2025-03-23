package Recursion.Backtracking;

import java.util.Arrays;

public class invert {
    public static void main(String[] args) {
        boolean[][] board = { { true, true, true },
                { true, true, true },
                { true, true, true } };
        int[][] way = new int[board.length][board[0].length];
        allpath(board, board.length, board[0].length, "", way, 1);

    }

    public static void allpath(boolean[][] board, int row, int col, String path, int[][] way, int count) {
        if (row == board.length - 1 && col == board[0].length - 1) {
            System.out.println(path);
            way[row][col] = count;
            for (int[] nums : way) {
                System.out.println(Arrays.toString(nums));
            }
            return;
        }
        if (!board[row][col]) {
            return;
        }
        board[row][col] = false;
        way[row][col] = count;
        if (row < board.length - 1) {
            allpath(board, row + 1, col, path + "D", way, count + 1);
        }
        if (row > 0) {
            allpath(board, row - 1, col, path + "U", way, count + 1);
        }
        if (col < board[0].length - 1) {
            allpath(board, row, col + 1, path + "R", way, count + 1);
        }
        if (col > 0) {
            allpath(board, row, col - 1, path + "L", way, count + 1);
        }
        board[row][col] = true;
        way[row][col] = 0;
        return;
    }
}
