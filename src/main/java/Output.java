import java.awt.*;

public class Output {

    /**
     * A class that takes a completed Sudoku board, and executes the keyboard controls that fill out that board on online Sudoku websites like sudoku.com and NYT.
     * @param board The completed board.
     * @throws AWTException
     * @throws InterruptedException
     */
    public static void outputCompletedSolve(Board board) throws AWTException, InterruptedException {

        /**
         * Robot library to facilitate keyboard output.
         */
        Robot robot = new Robot();

        /**
         * Row and column keep track of the current location in the Sudoku board.
         */
        int row = 0;
        int column = 0;

        while (true) {

            /* Keycode 96 is 0, and it adds the cell value.  */
            robot.keyPress(96 + board.board.get(row).get(column).value);
            column += 1;

            /* Keycode 39 is Right.  */
            robot.keyPress(39);
            Thread.sleep(10);

            /* Condition for ending the loop.  */
            if (column == 8 && row == 8) {
                robot.keyPress(96 + board.board.get(row).get(column).value);
                break;
            }

            /* Condition for moving to a new row. */
            if (column == 9) {
                column = 0;
                row += 1;

                /* Keycode 37 is Left. */
                for (int n = 0; n < 9; n++) {
                    robot.keyPress(37);
                    Thread.sleep(10);
                }
                /* Keycode 40 is Down.  */
                robot.keyPress(40);
                Thread.sleep(10);
            }
        }
    }
}
