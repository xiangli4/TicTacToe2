import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private final int BOARD_SIZE;
    private int[][] board;
    final int EMPTY;
    static final int O = 0;
    static final int X = 1;

    public Board() {
        BOARD_SIZE = 3;
        EMPTY = -BOARD_SIZE;
        board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    Board(Integer[][] board) {
        /*
        This is called a "deep copy"
        Since arrays are objects, if I were to just say this.board = board
        I would be copying the reference to the parameter and putting it in my class
        If I were to then change the parameter in the outer scope changes would show here
        Conversely if I change the board here it would affect the parameter in the outer scope
        By copying each int individually I copy the values, rather than the reference
        */
        BOARD_SIZE = board[0].length;
        EMPTY = -BOARD_SIZE;
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == null) {
                    this.board[i][j] = EMPTY;
                } else {
                    this.board[i][j] = board[i][j];
                }
            }
        }
    }

    private boolean isFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    int winner() {
        int diagSum = 0;
        int antiDiagSum = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                rowSum += board[i][j];
                colSum += board[j][i];

                if (i + j == board.length - 1) {
                    antiDiagSum += board[i][j];
                }
            }

            diagSum += board[i][i];

            if (rowSum == 0 || colSum == 0) {
                return O;
            } else if (rowSum == BOARD_SIZE || colSum == BOARD_SIZE) {
                return X;
            }
        }

        if (diagSum == 0 || antiDiagSum == 0) {
            return O;
        } else if (diagSum == BOARD_SIZE || antiDiagSum == BOARD_SIZE) {
            return X;
        }

        return EMPTY;
    }

    private String whichPlayer(int value) {
        if (value == O) {
            return "O";
        } else if (value == X){
            return "X";
        } else {
            return " ";
        }
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        boolean shouldQuit = false;
        int whoseTurn = X;

        while (!isFull() && !shouldQuit) {
            System.out.println(whichPlayer(whoseTurn) + "'s turn!");
            System.out.println(
                "Enter the X and Y coordinates of your next move, e.g. 0 2 or 1 1, or 'quit' to exit.");
            String move = input.nextLine();
            if (move.equalsIgnoreCase("quit")) {
                shouldQuit = true;
            } else {
                int xCoord = Character.getNumericValue(move.charAt(0));
                int yCoord = Character.getNumericValue(move.charAt(2));
                board[xCoord][yCoord] = whoseTurn;

                int winner = winner();
                if (winner != EMPTY) {
                    System.out.println(whichPlayer(winner) + " is the winner!");
                    shouldQuit = true;
                } else {
                    whoseTurn = (whoseTurn + 1) % 2; // Flips between 0 and 1
                }
            }

            System.out.println();
            System.out.println(this.toString());
            System.out.println();
        }

        if (isFull()) {
            System.out.println("It's a draw!");
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.append(" ");
                result.append(whichPlayer(board[i][j]));
                result.append(" ");
                if (j != 2) {
                    result.append("|");
                }
            }

            if (i != 2) {
                result.append("\n");
                result.append("---|---|---");
                result.append("\n");
            }
        }

        return result.toString();
    }

}
