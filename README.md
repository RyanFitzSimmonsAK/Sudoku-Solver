# Sudoku-Solver
A Sudoku Solver using a backtracking algorithm with recursion.

The Output class is able to execute the keyboard controls needed to input a completed Sudoku board onto sites like sudoku.com and the NYT.
The NYTimesInput class is able to pull a puzzle directly from the NYT website.

The combination of those two classes means that you can run this and it will completely do a NYT puzzle.

# Using It
In SudokuSolver.java, replace "NYTimesInput.scrape("hard"));" with your puzzleCode (example of the format found in Board.java).
Comment out the line that says "Output.outputCompletedSolve(board);"
Run main.

If you do want to solve a NY Times puzzle, instead of the above, just replace "hard" with your intended difficulty (easy, medium, hard).  Open the puzzle on the NY Times website, click the top left cell in puzzle, and run the solver.  Tab back to the NY Times website, and it will input the solution for you.
