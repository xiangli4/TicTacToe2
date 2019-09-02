import java.util.Scanner;

public class Board {
    private int[][] board = new int[3][3];
    private static final int EMPTY = -1;
    private static final int O = 0;
    private static final int X = 1;

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
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

                whoseTurn = (whoseTurn + 1) % 2; // Flips between 0 and 1
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
