import java.util.Scanner;

public class ConnectFour {
    // Print board with the assigned array from the user
    public static void printBoard(char[][]array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                System.out.print(array[array.length - 1 - i][j] + " ");
            }
            System.out.println();
        }
    }

    // Initialize board with '-' using the assigned array from the user
    public static void initializeBoard(char[][]array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                array[i][j] = '-';
            }
        }
    }

    // Insert a chip from either player with its designated chipType
    public static int insertChip(char[][]array, int col, char chipType) {
        // If row is taken
        for (int i = 0; i < array.length; ++i) {
            if (array[i][col] == 'x' || array[i][col] == 'o') {
                continue; // Jump to the next iteration
            }
            // If row is not taken
            else {
                array[i][col] = chipType; // Insert chipType to the place with row i and column col
            }
            return i; // Return the row of the inserted chip
        }
        // If a column is full return array.length
        // But this will never be achieved in this program
        return array.length;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        // Initialize two counting variable
        int count1 = 0, count2 = 0;

        // Check for winner horizontally
        // Check from row first
        for (int i = 0; i <= row; ++i) {
            for (int j = 0; j <= col; ++j) {
                if (array[i][j] == chipType) {
                    count1 += 1; // Count1 + 1 if the array in the iteration is char chipType
                }
                else {
                    count1 = 0;
                }
            }
        }

        // Check the count for horizontal
        // If the horizontal count == 4, there's a winner
        if (count1 == 4) {
            return true;
        }

        // Check for winner vertically
        // Check from column first
        for (int j = 0; j <= col; ++j) {
            for (int i = 0; i <= row; ++i) {
                    if (array[i][j] == chipType) {
                        count2 += 1;
                    }
                    else {
                        count2 = 0;
                    }
                }
            }

        // Check the count for vertical
        // If the vertical count == 4, there's a winner
        if (count2 == 4) {
            return true;
        }
        // Return false otherwise
        return false;
    }

    // Check if the board is full or not
    public static boolean checkFullBoard (char[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                // If there's still '-'
                // Return false
                if (array[i][j] == '-') {
                    return false;
                }
            }
        }
        // Otherwise return true
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user to input height and length of the board
        System.out.print("What would you like the height of the board to be? ");
        int height = sc.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int length = sc.nextInt();

        // Generate a 2D array based on the two variables
        char[][]board = new char [height][length];
        // Initialize and print the board at the beginning of the game
        initializeBoard(board);
        printBoard(board);

        // Player 1 uses 'x', player 2 uses 'o'
        System.out.println("\nPlayer 1: x");
        System.out.println("Player 2: o");

        // Continue the game if the board is not full
        while (true) {
            // For player 1
            System.out.print("Player 1: Which column would you like to choose? ");
            int col1 = sc.nextInt(); // Record the current column
            int row1 = insertChip(board, col1, 'x'); // Record the current row
            printBoard(board); // Print board after the two actions above

            // Terminate if player 1 win the game
            if (checkIfWinner(board, col1, row1, 'x') == true) {
                System.out.println("\nPlayer 1 won the game!");
                break;
            }

            // For player 2
            System.out.print("Player 2: Which column would you like to choose? ");
            int col2 = sc.nextInt();
            int row2 = insertChip(board, col2, 'o');
            printBoard(board);

            // Terminate if player 2 win the game
            if (checkIfWinner(board, col2, row2, 'o') == true) {
                System.out.println("\nPlayer 2 won the game!");
                break;
            }

            // If board is full and checkIfWinner for player 1 and 2 stays false
            // This is a draw and the game finishes
            if (checkFullBoard(board) == true){
                System.out.println("\nDraw. Nobody wins.");
                break;
            }
        }
    }
}
