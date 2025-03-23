package Recursion.Backtracking;

public class queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nqueens(board, 4));
    }

    public static int nqueens(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            return 1;
        }
        return 1;
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
