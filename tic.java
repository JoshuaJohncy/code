import java.util.Scanner;

public class tic 
{

  public static void main(String[] args) {
    // Define game board as a 3x3 character array
    char[][] board = new char[3][3];
    // Initialize board with empty spaces
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }

    // Scanner for user input
    Scanner scanner = new Scanner(System.in);
    // Current player (X starts)
    char currentPlayer = 'X';

    while (true) {
      // Print the game board
      printBoard(board);

      // Get player move
      int row = getPlayerMove(scanner, currentPlayer);
      int col = getPlayerMove(scanner, currentPlayer);

      // Validate and update board
      if (isValidMove(board, row, col)) {
        board[row][col] = currentPlayer;
      } else {
        System.out.println("Invalid move. Try again.");
        continue;
      }

      // Check for winner
      if (hasWinner(board, currentPlayer)) {
        System.out.println("Congratulations! Player " + currentPlayer + " wins!");
        break;
      }

      // Check for tie
      if (isBoardFull(board)) {
        System.out.println("It's a tie!");
        break;
      }

      // Switch player
      currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }

    scanner.close();
  }

  // Print the game board
  public static void printBoard(char[][] board) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  // Get player move (row and column)
  public static int getPlayerMove(Scanner scanner, char player) {
    System.out.println("Player " + player + ", enter a row (1-3): ");
    int row = scanner.nextInt() - 1;
    System.out.println("Player " + player + ", enter a column (1-3): ");
    int col = scanner.nextInt() - 1;
    return row;
  }

  // Validate player move
  public static boolean isValidMove(char[][] board, int row, int col) {
    return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
  }

  // Check for winner
  public static boolean hasWinner(char[][] board, char player) {
    // Check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
        return true;
      }
    }

    // Check columns
    for (int i = 0; i < 3; i++) {
      if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
        return true;
      }
    }

    // Check diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }

    return false;
  }

  // Check if board is full
  public static boolean isBoardFull(char[][] board) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }
}
