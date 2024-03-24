package frontend;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * Handles the logic of determining button placement given
 * the total number of buttons.
 */
public class ButtonLayout {
    /**
     * Builds the layout of the buttons given the total.
     * Attempts to organize them in a square if possible, but favors
     * taller rectangles rather than wider.
     * @param buttonCount The total number of buttons.
     * @return A list of integers, each representing how many elements exist in each row.
     */
    public static List<Integer> getLayout(Integer buttonCount) {
        List<Integer> layout = new ArrayList<Integer>();

        // Calculate the optimal number of columns and rows
        int columns = (int)Math.sqrt(buttonCount);
        int rows = (int)Math.ceil((double)buttonCount / columns);

        // Build the layout itself
        for(int i = 0; i < rows - 1; i++) {
            layout.add(columns);
        }
        layout.add(buttonCount - columns * (rows - 1));

        return layout;
    }
}
