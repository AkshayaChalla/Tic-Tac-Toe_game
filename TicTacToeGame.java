import java.util.Scanner;

public class TicTacToeGame {
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        boolean gameWon = false;
        int totalMoves = 0;

        Scanner scanner = new Scanner(System.in);
        printBoard();

        while (!gameWon && totalMoves < 9) {
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                totalMoves++;
                printBoard();

                if (checkWinner(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else if (totalMoves == 9) {
                    System.out.println("It's a draw!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    private static boolean checkWinner(int row, int col) {
        return (checkRow(row) || checkCol(col) || checkDiagonals());
    }

    private static boolean checkRow(int row) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer);
    }

    private static boolean checkCol(int col) {
        return (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer);
    }

    private static boolean checkDiagonals() {
        return ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer));
    }
}