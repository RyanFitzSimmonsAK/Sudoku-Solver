import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * An algorithm that solves Sudoku puzzles using backtracking.
 * @author Ryan FitzSimmons
 */
public class SudokuSolver {
    /**
     * The board object.
     */
    private static Board board;

    /**
     * The boxes generated from the current board state.
     */
    private static ArrayList<ArrayList<Cell>> boxes;


    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        board = new Board(NYTimesInput.scrape("hard"));
        boxes = board.generateBoxes();

        SolvingAlgorithm.solve(board, boxes);
        System.out.println(board);

        Output.outputCompletedSolve(board);
    }
}
