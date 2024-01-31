import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.
    char[][] board = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
    // Task 2: Call the function printBoard();
    printBoard(board);
    // askUser(board);
    int win;
    for (int i = 0; i < 9; i++) {
      if (i % 2 != 0) {
        System.out.println("Turn: O");
        int[] response = askUser(board);
        board[response[0]][response[1]] = 'O';
        System.out.println("\n");
        printBoard(board);
        System.out.println("\n\n");
        win = checkWin(board);
        if (Math.abs(win) == 3) {
          System.out.println("\n\n O WINS!!");
          System.exit(0);
        }
      } else {
        System.out.println("Turn: X");
        int[] response = askUser(board);
        board[response[0]][response[1]] = 'X';
        System.out.println("\n");
        printBoard(board);
        System.out.println("\n\n");
        win = checkWin(board);
        if (Math.abs(win) == 3) {
          System.out.println("\n\n X WINS!!");
          System.exit(0);
        }
      }
    }

    scan.close();
  }

  public static void printBoard(char[][] array) {

    for (int i = 0; i < array.length; i++) {
      System.out.println("");
      for (int j = 0; j < array[i].length; j++) {
        System.out.print("  " + array[i][j]);
      }
    }
    System.out.println("\n");
  }

  public static int[] askUser(char[][] board) {
    int[] escolha = new int[2];
    while (true) {
      System.out.println("Choose a spot:");
      System.out.print("Row: ");
      escolha[0] = scan.nextInt();
      System.out.print("Columm: ");
      escolha[1] = scan.nextInt();

      if (board[escolha[0]][escolha[1]] == '_') {
        System.out.println("\nEnd Turn\n\n");
        break;
      } else {
        System.out.println("Spot Taken");
      }

    }

    return escolha;
  }

  public static int checkWin(char[][] board) {
    int rows = checkRows(board);

    // Math.abs returns the absolute value of a given number, removing any negative
    // sign.
    if (Math.abs(rows) == 3)
      return rows; // If the block of code consists of only one line, you can omit the curly
                   // braces.

    int columns = checkColumns(board);
    if (Math.abs(columns) == 3)
      return columns;

    int leftDiagonal = checkLeft(board);
    if (Math.abs(leftDiagonal) == 3)
      return leftDiagonal;

    int rightDiagonal = checkRight(board);
    if (Math.abs(rightDiagonal) == 3)
      return rightDiagonal;

    return 1;
  }

  public static int checkRows(char[][] board) {
    int count = 0;

    for (int i = 0; i < board.length; i++) {
      count = 0;
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count += 1;
        } else if (board[i][j] == 'O') {
          count -= 1;
        } else {
          continue;
        }
        if (Math.abs(count) == 3) {
          return count;
        }
      }
    }

    return count;
  }

  public static int checkColumns(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      count = 0;
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == 'X') {
          count += 1;
        } else if (board[j][i] == 'O') {
          count -= 1;
        } else {
          continue;
        }
        if (Math.abs(count) == 3) {
          return count;
        }
      }
    }

    return count;
  }

  public static int checkLeft(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] == 'X') {
        count += 1;
      } else if (board[i][i] == 'O') {
        count -= 1;
      } else {
        continue;
      }
    }

    return count;
  }

  public static int checkRight(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[(2 - i)][i] == 'X') {
        count += 1;
      } else if (board[(2 - i)][i] == 'O') {
        count -= 1;
      } else {
        continue;
      }
    }
    return count;
  }

}
