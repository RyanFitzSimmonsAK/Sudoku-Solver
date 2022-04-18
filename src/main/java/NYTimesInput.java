import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Class that connects to the NYT daily Sudoku puzzle, and returns the puzzleCode for the difficulty selected.
 */
public class NYTimesInput {

    /**
     * @param difficulty The Sudoku puzzle selected.
     * @return The puzzleCode for the aforementioned Sudoku puzzle.
     * @throws IOException
     */
    public static String scrape(String difficulty) throws IOException {
        /**
         * The puzzleCode that will eventually be returned.
         */
        String puzzleCode = "";

        /**
         * The URL to be connected to.
         */
        String searchUrl = "https://www.nytimes.com/puzzles/sudoku/" + URLEncoder.encode(difficulty, "UTF-8");

        /**
         * Connect to the URL, and return the HTML for the section that contains the game data.
         */
        Document document = Jsoup.connect(searchUrl).get();
        String div = document.getElementById("js-hook-pz-moment__game").html();

        /**
         * Substring that contains only the exact game data.
         */
        String gameData = div.substring(360);

        /**
         * Navigate to the section that contains the puzzle for the difficulty selected.
         */
        int index = gameData.indexOf((difficulty));
        String data = gameData.substring(index);

        /**
         * Navigates specifically to the puzzle data.
         */
        index = data.indexOf(("\"puzzle\":["));
        String puzzleData = data.substring(index);

        /**
         * Grab the puzzle data.
         */
        String puzzleString = puzzleData.substring(9, 172);

        /**
         * Convert the puzzle into a character array, then iterate through it to make it match the puzzleCode format.
         */
        char[] characterArray = puzzleString.toCharArray();
        int rowCount = 0;

        for (char ch : characterArray) {
            if (ch == ',' || ch == '[' || ch == ']') {
                ;
            }
            else {
                puzzleCode += ch;
                rowCount += 1;

                if (rowCount == 9) {
                    rowCount = 0;
                    puzzleCode += '/';
                }
            }
        }

        /**
         * Slice off the last slash from the puzzleCode, and return it.
         */
        return puzzleCode.substring(0, puzzleCode.length() - 1);
    }
}