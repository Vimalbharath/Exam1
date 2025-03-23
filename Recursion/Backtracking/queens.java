package Recursion.Backtracking;

public class queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nqueens(board, 0));
    }

    public static int nqueens(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            return 1;
        }
        int count = 0;
        for (int c = 0; c < board.length; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = true;
                count = count + nqueens(board, r + 1);
                board[r][c] = false;
            }
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int r, int c) {
        while (c > 0) {
            if (board[r][c]) {

                return false;
            }

            c--;
        }
        return true;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            // System.out.println(3);
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("X" + " ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
