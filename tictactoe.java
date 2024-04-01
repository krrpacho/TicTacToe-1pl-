import java.util.Random;
import java.util.Scanner;

public class tictactoe {

    private static final char PLAYER_X = 'X';
    private static final char COMPUTER_O = 'O';

    private static final char PLAYER_O = 'O';
    private static final char COMPUTER_X = 'X';

    

    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String player;
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Choose symbol: 'X' or 'O' ");
        player = scanner.next(); // Assign player based on user input
        printBoard();
    
        while (true) {
            
        
        if (player.equals("X")) {
            playPlayerMoveX();
            printBoard();
    
            if (checkWin(PLAYER_X)) {
                System.out.println("Congratulations! You win!");
                break;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }
    
            playComputerMoveO();
            printBoard();
    
            if (checkWin(COMPUTER_O)) {
                System.out.println("Computer wins!");
                break;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }
        } else if (player.equals("O")) {
            playComputerMoveX();
            printBoard();
    
            if (checkWin(COMPUTER_X)) {
                System.out.println("Computer wins!");
                break;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }
    
            playPlayerMoveO();
            printBoard();
    
            if (checkWin(PLAYER_O)) {
                System.out.println("Congratulations! You win!");
                break;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }
        }  
    }
    }


    

    private static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
        System.out.println();
    }

    private static void playPlayerMoveX() {
        System.out.println("Your move (row and column):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (isValidMove(row, col)) {
            board[row][col] = PLAYER_X;
        } else {
            System.out.println("Invalid move. Try again.");
            playPlayerMoveX();
        }
    }

    private static void playPlayerMoveO() {
        System.out.println("Your move (row and column):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (isValidMove(row, col)) {
            board[row][col] = PLAYER_O;
        } else {
            System.out.println("Invalid move. Try again.");
            playPlayerMoveO();
        }
    }


    private static void playComputerMoveO() {
        System.out.println("Computer's move:");
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));

        board[row][col] = COMPUTER_O;
    }

    private static void playComputerMoveX() {
        System.out.println("Computer's move:");
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));

        board[row][col] = COMPUTER_X;
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // There is an empty cell, game is not a draw
                }
            }
        }
        return true; // All cells are filled, game is a draw
    }
}

