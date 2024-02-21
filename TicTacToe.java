package byt;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        return board[row][col] == ' ';
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        while (!gameWon) {
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();
                if (checkWin(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameWon = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private static boolean checkWin(int row, int col) {
        // Check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }
        // Check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
