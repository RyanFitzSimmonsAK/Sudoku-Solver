/**
 * Object that contains the basic information of a single cell on a Sudoku board.
 */
public class Cell {
    /**
     * The number placed in this Sudoku cell.
     */
    int value;

    /**
     * The numbers that could fit in a cell, given the current board state.
     */
    int[] available;

    /**
     * @param value The number placed in this Sudoku cell, provided as an ASCII code.
     */
    public Cell(int value) {
        /* Character.getNumericalValue is used to convert the ASCII code into an integer. */
        this.value = Character.getNumericValue(value);
        this.available = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
