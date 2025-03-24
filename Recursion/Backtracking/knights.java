package Recursion.Backtracking;

public class knights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[3][3];
        System.out.println(nknights(board, 0, 0, 5));
    }

    public static int nknights(boolean[][] board, int r, int c, int count) {
        if (count == 0) {
            display(board);
            return 1;
        }
        if (r == board.length - 1 && c == board.length) {
            return 0;
        }
        int result = 0;
        if (c == board.length) {
            return result + nknights(board, r + 1, 0, count);
        }
        if (isSafe(board, r, c)) {
            board[r][c] = true;
            result = result + nknights(board, r, c + 1, count - 1);
            board[r][c] = false;
        }
        return result + nknights(board, r, c + 1, count);
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K" + " ");
                } else {
                    System.out.print("X" + " ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
