import java.util.ArrayList;

/**
 * Object that generates the 2D array used to manipulate the cells, and provides helper methods tied to the board state.
 */
public class Board {
    /**
     * A 2D arrayList where each element is a cell.
     */
    ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();

    /**
     * Which row is being modified during board creation
     */
    int row = 0;

    /**
     * Constructor that fills in the ArrayList with Cell objects.
     * @param puzzleCode A string representation of a Sudoku board, similar to a FEN from Chess.
     * A 0 represents an empty cell, a number represents a provided hint, and a slash represents a new row in the board.
     */
    public Board(String puzzleCode) {
        /* Creates the first row in the board. */
        board.add(new ArrayList<Cell>());

        /* Iterates through the puzzleCode, procedurally filling out the board. */
        for (int n = 0; n < puzzleCode.length(); n++) {

            if (puzzleCode.charAt(n) == '/') {
                row += 1;
                board.add(new ArrayList<Cell>());
            }

            else {
                board.get(row).add(new Cell(puzzleCode.charAt(n)));
                }
            }
        }

    /**
     * Method that takes the current board state, and returns a transposed version of the board, such that each row of the array is a Sudoku box.
     * @return A 2D array where each row of the arrow is a Sudoku box.
     */
    public ArrayList<ArrayList<Cell>> generateBoxes() {
        ArrayList<ArrayList<Cell>> boxes = new ArrayList<ArrayList<Cell>>();

        /* This loop works with three lines at a time, and creates three boxes each pass. */
        for (int n = 0; n < 9; n += 3) {

            /* In each of these loops, n is the set of three boxes it's working with at once, and k is an individual box within that set. */
            boxes.add(new ArrayList<Cell>());
            for (int k = n; k < n + 3; k++) {
                boxes.get(n).addAll(board.get(k).subList(0, 3));
            }

            boxes.add(new ArrayList<Cell>());
            for (int k = n; k < n + 3; k++) {
                boxes.get(n + 1).addAll(board.get(k).subList(3, 6));
            }

            boxes.add(new ArrayList<Cell>());
            for (int k = n; k < n + 3; k++) {
                boxes.get(n + 2).addAll(board.get(k).subList(6, 9));
            }
        }
        return boxes;
    }

    /**
     * toString method to print out the board state.
     * @return A string representation of the board state.
     */
    public String toString() {
        String boardString = "";

        for (int n = 0; n < board.size(); n++) {
            boardString += String.valueOf(board.get(n));
            boardString += "\n";
        }

        return boardString;
        }
    }
